package com.learn.beanpostprocessor;

import com.learn.beanpostprocessor.annotation.RoutingSwitch;
import com.learn.beanpostprocessor.util.RoutingVersion;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Map;

public class RoutingBeanProxyFactory {
    public static Object createProxy(Class targetClass, Map<String, Object> beans) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(targetClass);
        proxyFactory.addAdvice(new VersionRoutingMethodInterceptor(targetClass, beans));
        System.err.println(proxyFactory.getProxy());
        return proxyFactory.getProxy();
    }

    static class VersionRoutingMethodInterceptor implements MethodInterceptor {

        private String classSwitch;

        private Object beanOfSwitchOn;

        private Object beanOfSwitchOff;

        public VersionRoutingMethodInterceptor(Class targetClass, Map<String, Object> beans) {
            String interfaceName = StringUtils.uncapitalize(targetClass.getSimpleName());
            if (targetClass.isAnnotationPresent(RoutingSwitch.class)) {
                this.classSwitch = ((RoutingSwitch) targetClass.getAnnotation(RoutingSwitch.class)).value();
            }
            this.beanOfSwitchOn = beans.get(this.buildBeanName(interfaceName, true));
            this.beanOfSwitchOff = beans.get(this.buildBeanName(interfaceName, false));
            System.out.println(beanOfSwitchOn);
            System.out.println(beanOfSwitchOn);
        }

        private String buildBeanName(String interfaceName, boolean isSwitchOn) {
            System.err.println(interfaceName);
            return interfaceName + "Impl" + (isSwitchOn ? "V2" : "V1");
        }


        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            Method method = invocation.getMethod();
            String switchName = this.classSwitch;
            if (method.isAnnotationPresent(RoutingSwitch.class)) {
                switchName = method.getAnnotation(RoutingSwitch.class).value();
            }
            if (StringUtils.isBlank(switchName)) {
                throw new IllegalStateException("RoutingSwitch value is blank, method:" + method.getName());
            }

            return invocation.getMethod().invoke(getTargetBean(switchName), invocation.getArguments());
        }

        public Object getTargetBean(String switchName) {
            boolean switchOn = false;
            if (RoutingVersion.A.equals(switchName)) {
                switchOn = false;
            } else if (RoutingVersion.B.equals(switchName)) {
                switchOn = true;
            } else {
                //switchOn = FunctionSwitch.isSwitchOpened(switchName);
            }
            return switchOn ? beanOfSwitchOn : beanOfSwitchOff;
        }
    }
}
