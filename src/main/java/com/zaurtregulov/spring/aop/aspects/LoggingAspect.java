package com.zaurtregulov.spring.aop.aspects;

import com.zaurtregulov.spring.aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class LoggingAspect {

//    @Pointcut("execution(* com.zaurtregulov.spring.aop.UniLibrary.*(..))")
//    private void allMethodFromUniLibrary(){}
//
//    @Pointcut("execution(* com.zaurtregulov.spring.aop.UniLibrary.returnMagazine())")
//    private void returnMagazineFromUniLibrary(){}
//
//    @Pointcut("allMethodFromUniLibrary() && !returnMagazineFromUniLibrary()")
//    private void  allMethodWithoutReturnMagazineFromUniLibrary(){}
//
//    @Before("allMethodWithoutReturnMagazineFromUniLibrary()")
//    public void beforeAllMethodWithoutReturnMagazineFromUniLibrary(){
//        System.out.println("beforeAllMethodWithoutReturnMagazineFromUniLibrary: writing log #10");
//    }

//    @Pointcut("execution(* com.zaurtregulov.spring.aop.UniLibrary.get*())")
//    private void allGetMethodFromUniLibrary(){}
//
//    @Pointcut("execution(* com.zaurtregulov.spring.aop.UniLibrary.return*())")
//    private void allReturnMethodFromUniLibrary(){}
//
//    @Pointcut("allGetMethodFromUniLibrary()||allReturnMethodFromUniLibrary()")
//    private void allGetAndReturnMethodFromUniLibrary(){}
//
//    @Before("allGetMethodFromUniLibrary()")
//    public void beforeGetLoggingAdvice(){
//        System.out.println("beforeGetLoggingAdvice: writing log #1");
//    }
//
//    @Before("allReturnMethodFromUniLibrary()")
//    public void beforeReturnLoggingAdvice(){
//        System.out.println("beforeReturnLoggingAdvice: writing log #2");
//    }
//
//    @Before("allGetAndReturnMethodFromUniLibrary()")
//    public void beforeGetAndReturnLoggingAdvice(){
//        System.out.println("beforeGetAndReturnLoggingAdvice: writing log #3");
//    }




    @Before("com.zaurtregulov.spring.aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint){

        MethodSignature methodSignature =(MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod = " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() = " + methodSignature.getName());
        if (methodSignature.getName().equals("addBook")){
            Object[] arguments = joinPoint.getArgs();
            for (Object obj:arguments)
                if (obj instanceof Book){
                    Book myBook =(Book) obj;
                    System.out.println("???????????????????? ?? ?????????? :???????????????? ??????????: "+ myBook.getName() + ", ?????????? :"
                    + myBook.getAuthor() + ", ?????? ??????????????" + myBook.getYearOfPublication());
                }
            else if (obj instanceof String){
                    System.out.println("?????????? ?? ???????????????????? ?????????????????? "+ obj);
                }
        }

        System.out.println("beforeGetLoggingAdvice: ?????????????????????? ?????????????? ???????????????? ??????????/????????????");
        System.out.println("--------------------------------------------");
    }


}
