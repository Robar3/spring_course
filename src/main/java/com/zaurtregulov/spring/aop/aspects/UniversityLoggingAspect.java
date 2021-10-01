package com.zaurtregulov.spring.aop.aspects;

import com.zaurtregulov.spring.aop.Student;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {

//    @Before("execution(* getStudents())")
//    public void beforeGetStudentLoggingAdvice(){
//        System.out.println("beforeGetStudentLoggingAdvice: Логируем получение списка студентов перед методом getStudents");
//    }
//    @AfterReturning(pointcut = "execution(* getStudents())",returning = "students")
//    public void afterReturningGetStudentLoggingAdvice(List<Student>students){
//
//        Student firstStudent = students.get(0);
//        String nameSurname = firstStudent.getNameStudent();
//        nameSurname = "Mr. "+ nameSurname;
//        firstStudent.setNameStudent(nameSurname);
//
//        double avgGrade = firstStudent.getAvgGrade();
//        avgGrade = avgGrade + 1;
//        firstStudent.setAvgGrade(avgGrade);
//        System.out.println("afterReturningGetStudentLoggingAdvice: Логируем получение списка студентов после работы метода getStudents");
//    }
//    @AfterThrowing(pointcut = "execution(* getStudents())",
//    throwing = "exception")
//    public void afterThrowingStudentLoggingAdvice(Throwable exception){
//        System.out.println("afterThrowingStudentLoggingAdvice: логируем выброс исключения "+  exception);
//    }

    @After("execution(* getStudents())")
    public void  afterGetStudentsLoggingAdvice(){
        System.out.println("afterGetStudentsLoggingAdvice: " +
                "логируем нормальное окончание метода или выброс исключения");
    }
}
