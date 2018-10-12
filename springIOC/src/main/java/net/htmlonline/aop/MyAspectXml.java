package net.htmlonline.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspectXml {
    // 前置通知
    public void before(JoinPoint joinpoint) {
        System.out.println("before..." + joinpoint);
    }

    // 后置通知
    public void afterReturning(Object result) {
        System.out.println("after returning..." + result);
    }

    // 环绕通知
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知...");
        Object proceed = joinPoint.proceed();

        System.out.println("环绕后通知..." + proceed + "++");
        return proceed;
    }

    // 异常抛出
    public void afterThrowing(Throwable throwable) {
        System.out.println("异常抛出通知..." + throwable.getMessage());
    }
    // 最终通知
    public void after() {
        System.out.println("最终通知...");
    }
}
