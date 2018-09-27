package com.learn.beanpostprocessor;

import com.learn.beanpostprocessor.annotation.RoutingSwitch;
import com.learn.beanpostprocessor.routingenum.RoutingEnum;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.framework.ProxyFactory;

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

        private Object beanOfVersionA;

        private Object beanOfVersionB;

        public VersionRoutingMethodInterceptor(Class targetClass, Map<String, Object> beans) {
            String interfaceName = StringUtils.uncapitalize(targetClass.getSimpleName());
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
            return invocation.getMethod().invoke(getTargetBean(switchName), invocation.getArguments());
        }

        public Object getTargetBean(String switchName) {
            boolean switchOn = true;
            if (RoutingEnum.A.name().equals(switchName)) {
                switchOn = true;
            } else if (RoutingEnum.B.name().equals(switchName)) {
                switchOn = false;
            }
            return switchOn ? beanOfVersionA : beanOfVersionB;
        }
    }
}
