package com.github.sergio5990.hw2.case10;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class ProfilingBeanPostProcessor implements BeanPostProcessor {

    Map<String, Set<Method>> profilingMethods = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        for (Method declaredMethod : bean.getClass().getDeclaredMethods()) {
            if (declaredMethod.isAnnotationPresent(Profiling.class)) {
                profilingMethods.compute(beanName, (k, v) -> {
                    if (v == null) {
                        v = new HashSet<>();
                    }
                    v.add(declaredMethod);
                    return v;
                });
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (profilingMethods.containsKey(beanName)) {
            final Set<Method> methods = profilingMethods.get(beanName);
            ProxyFactory proxyFactory = new ProxyFactory(bean);
            proxyFactory.addAdvice(new MethodInterceptor() {
                @Override
                public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                    final Method method = methodInvocation.getMethod();
                    if (methods.contains(method)) {

                        final LocalDateTime before = LocalDateTime.now();
                        System.out.println("before method" + before);

                        final Object result = method.invoke(bean, methodInvocation.getArguments());

                        final LocalDateTime after = LocalDateTime.now();
                        System.out.println("after method" + after);

                        System.out.println("time:" + Duration.between(before, after).toMillis());
                    }
                    return method.invoke(bean, methodInvocation.getArguments());
                }
            });
            return proxyFactory.getProxy();
        }
        return bean;
    }
}
