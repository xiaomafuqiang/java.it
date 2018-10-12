package net.htmlonline.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspectAnnotation {
    // 前置通知
    @Before("execution(* net.htmlonline.aop.annotation.OrderDaoImpl.save(..))")
    public void before(JoinPoint joinpoint) {
        System.out.println("before..." + joinpoint);
    }

    // 后置通知
    @AfterReturning(value = "execution(* net.htmlonline.aop.annotation.OrderDaoImpl.delete(..))", returning = "result")
    public void afterReturning(Object result) {
        System.out.println("after returning..." + result);
    }

    // 环绕通知
    @Around("execution(* net.htmlonline.aop.annotation.OrderDaoImpl.delete(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知...");
        Object proceed = joinPoint.proceed();

        System.out.println("环绕后通知..." + proceed + "++");
        return proceed;
    }

    // 异常抛出
    // @AfterThrowing(value = "execution(* net.htmlonline.aop.annotation.OrderDaoImpl.find(..))", throwing = "throwable")
    @AfterThrowing(value = "MyAspectAnnotation.pointId()", throwing = "throwable")
    public void afterThrowing(Throwable throwable) {
        System.out.println("异常抛出通知..." + throwable.getMessage());
    }

    // 最终通知
    // @After("execution(* net.htmlonline.aop.annotation.OrderDaoImpl.find(..))")
    // @After("net.htmlonline.aop.annotation.MyAspectAnnotation.pointId()")
    @After("MyAspectAnnotation.pointId()")
    public void after() {
        System.out.println("最终通知...");
    }


    // 配置切入点 id -ref
    @Pointcut("execution(* net.htmlonline.aop.annotation.OrderDaoImpl.find(..))")
    public void pointId() {}
}
