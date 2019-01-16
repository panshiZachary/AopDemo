package com.example.aopdemo.aspect;

import android.util.Log;

import com.example.aopdemo.annomation.BehaviorTrace;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by Zachary
 * on 2019/1/15.
 */
@Aspect
public class BehaviorTraceAspect {

    // 1 .定义切面规则
    @Pointcut("execution(@com.example.aopdemo.annomation.BehaviorTrace * * (..))")
    public void methodAnnotatedWithBehaviorTrace(){

    }
    // 2. 对切面的内容进行处理
    @Around("methodAnnotatedWithBehaviorTrace()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        String className = methodSignature.getDeclaringType().getSimpleName();
        String metnodName = methodSignature.getName();
        String value = methodSignature.getMethod().getAnnotation(BehaviorTrace.class).value();

        // 统计时间
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long duration = System.currentTimeMillis() - start;

        Log.d("Zachary",className+"类，执行了"+metnodName+"方法的"+value+"功能,耗时"+duration);
        return proceed;

    }
}
