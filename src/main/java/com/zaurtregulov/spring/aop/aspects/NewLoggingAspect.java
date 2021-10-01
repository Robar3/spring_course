package com.zaurtregulov.spring.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object targetMethodResult = null;
        System.out.println("aroundReturnBookLoggingAspect : В библиотеку пытаются вернуть книгу");

        try {
          targetMethodResult = proceedingJoinPoint.proceed();}
        catch (Exception e){
            System.out.println("aroundReturnBookLoggingAspect: было поймано исключение "+ e);
        throw e;
        }
        System.out.println("aroundReturnBookLoggingAspect : В библиотеку умпешно вернули книгу");
        return targetMethodResult;
    }
}
