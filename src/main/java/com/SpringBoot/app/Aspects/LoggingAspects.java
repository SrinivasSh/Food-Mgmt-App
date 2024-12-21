package com.SpringBoot.app.Aspects;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspects {
	
	
	@Pointcut("execution( * com.SpringBoot.app.Controller.*.*(..))")
	public void controllerLayer()
	{
		
	}
	
	@Pointcut("execution( * com.SpringBoot.app.Service.*.*(..))")
	public void serviceLayer()
	{
		
	}
	
	
	
	@Before("controllerLayer()")
	public void GenerateStartTimeForController(JoinPoint info) {
		System.out.println("Start Time of the controller Layer:"+new Date().getTime() + " for " + info.getSignature().getName());
	}
	@Before("serviceLayer()")
	public void GenerateStartTimeForService(JoinPoint info) {
		System.out.println("Start Time of the Service Layer:"+new Date().getTime() + " for " + info.getSignature().getName());
	}
	
	@After("controllerLayer()")
	public void GenerateStopTimeForController(JoinPoint info) {
		System.out.println("Stop Time of the controller Layer:"+new Date().getTime() + " for " + info.getSignature().getName());
	}
	
	@After("serviceLayer()")
	public void GenerateStopTimeForService(JoinPoint info) {
		System.out.println("Stop Time of the Service Layer:"+new Date().getTime() + " for " + info.getSignature().getName());
	}
	
	

}
