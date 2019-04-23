package com.example.demo.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: CaiZiLin
 * @Date: 2019/4/22 18:02
 */
@Configuration
@Aspect
public class ControllerAspect {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    @Pointcut("execution(* com.example.demo.web.*.*(..))")
    public void executeService() {

    }

    @Before("executeService()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info("方法名:" + methodSignature.getMethod().getName() + " 参数列表:" + ArrayToParameterString(methodSignature.getParameterNames(), joinPoint.getArgs()));
    }

    private String ArrayToParameterString(String[] parameterNames, Object[] parameterValues) {
        StringBuffer sb = new StringBuffer();
        if (parameterNames != null && parameterNames.length > 0) {
            for (int i = 0; i < parameterNames.length; i++) {
                sb.append(parameterNames[i]);
                sb.append(":");
                sb.append(parameterValues[i]);
                sb.append(";");
            }
        }
        return sb.toString();
    }
}
