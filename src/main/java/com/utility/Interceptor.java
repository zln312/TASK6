package com.utility;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


    @Aspect
    @Component
    public class Interceptor {
        private static Logger logger = Logger.getLogger(com.utility.Interceptor.class);



        @Around("execution(* com.service.*.*(..)))")
        public Object aroud1(ProceedingJoinPoint joinPoint) throws Throwable {
            long start = System.currentTimeMillis();
//        joinPoint.getArgs()代表取得joinPoint（即目标方法）的入参
            Object object = joinPoint.proceed();
            long cost = System.currentTimeMillis() - start;
            logger.error(joinPoint.getSignature() + "——+++Services方法用时——" + cost + "毫秒");
            return object;
        }




        @Around("execution(* com.controller.*.*(..)))")
        public Object aroud3(ProceedingJoinPoint joinPoint) throws Throwable {
            long start = System.currentTimeMillis();
//        joinPoint.getArgs()代表取得joinPoint（即目标方法）的入参
            Object object = joinPoint.proceed();
            long cost = System.currentTimeMillis() - start;
            logger.error(joinPoint.getSignature() + "——+++Controller——方法用时——" + cost + "毫秒");
            return object;
        }
        @Around("execution(* com.cache.RedisUtil.*(..)))")
        public Object aroud4(ProceedingJoinPoint joinPoint) throws Throwable {
            long start = System.currentTimeMillis();
//        joinPoint.getArgs()代表取得joinPoint（即目标方法）的入参
            Object object = joinPoint.proceed();
            long cost = System.currentTimeMillis() - start;
            logger.error(joinPoint.getSignature() + "——+++Redis缓存——方法用时——" + cost + "毫秒");
            return object;
        }


    }
