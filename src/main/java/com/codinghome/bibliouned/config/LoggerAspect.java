package com.codinghome.bibliouned.config;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {
	Logger log = Logger.getLogger(LoggerAspect.class.getSimpleName());
	
	@Before("execution(* com.codinghome.bibliouned.controller.* (..))")
	public void logBefore(JoinPoint point){
		log.info(point.getSignature().getName() + " called with parameters " + Arrays.toString(point.getArgs()));
	}
	
	@AfterReturning(pointcut="execution(* com.codinghome.bibliouned.controller.* (..))",returning="returnString")
	public void logAfter(JoinPoint point, String returnString){
		log.info(point.getSignature().getName() + " returned " + returnString);
	}
}
