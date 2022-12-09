//package com.mypractice.oauth.server.oauthserver;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//@Slf4j
//public record LoggerAspect() {
//    @Before("execution(* com.mypractice.oauth.server.oauthserver..*(..)))")
//    public void logBeforeAllMethodCall(JoinPoint joinPoint) throws Throwable {
//
//        log.info("=====Spring Boot AOP Before Advice Example ");
//        log.info("=====Started with method "
//                + joinPoint.getSignature().getName()); // Method Name
//    }
//
//    @After("execution(* com.mypractice.oauth.server.oauthserver..*(..)))")
//    public void logAfterAllMethodCall(JoinPoint joinPoint) throws Throwable {
//
//        log.info("Spring Boot AOP After Advice Example ");
//        log.info("======Completed execution of method "
//                + joinPoint.getSignature().getName()); // Method Name
//    }
//}
