package com.learn.beanpostprocessor;

import com.learn.beanpostprocessor.annotation.RoutingSwitch;
import com.learn.beanpostprocessor.routingenum.RoutingEnum;
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
        return proxyFactory.getProxy();
    }

    static class VersionRoutingMethodInterceptor implements MethodInterceptor {

        //private String classSwitch;

        private Object beanOfVersionA;

        private Object beanOfVersionB;

        public VersionRoutingMethodInterceptor(Class targetClass, Map<String, Object> beans) {
            String interfaceName = StringUtils.uncapitalize(targetClass.getSimpleName());
            /*if (targetClass.isAnnotationPresent(RoutingSwitch.class)) {
                this.classSwitch = ((RoutingSwitch) targetClass.getAnnotation(RoutingSwitch.class)).value();
            }*/
            this.beanOfVersionA = beans.get(this.buildBeanName(interfaceName, true));
            this.beanOfVersionB = beans.get(this.buildBeanName(interfaceName, false));
        }

        private String buildBeanName(String interfaceName, boolean isSwitchOn) {
            return interfaceName + "Impl" + (isSwitchOn ? "V1" : "V2");
        }


        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            Method method = invocation.getMethod();
            String switchName = StringUtils.EMPTY;
            if (method.isAnnotationPresent(RoutingSwitch.class)) {
                switchName = method.getAnnotation(RoutingSwitch.class).value().name();
            }
            if (StringUtils.isBlank(switchName)) {
                throw new IllegalStateException("RoutingSwitch value is blank, method:" + method.getName());
            }

            return invocation.getMethod().invoke(getTargetBean(switchName), invocation.getArguments());
        }

        public Object getTargetBean(String switchName) {
            boolean switchOn = true;
            if (RoutingEnum.A.name().equals(switchName)) {
                switchOn = true;
            } else if (RoutingEnum.B.name().equals(switchName)) {
                switchOn = false;
            } else {
                //switchOn = FunctionSwitch.isSwitchOpened(switchName);
            }
            return switchOn ? beanOfVersionA : beanOfVersionB;
        }
    }
}
