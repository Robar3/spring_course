package com.zaurtregulov.spring.hibernate_tone_to_one;


import com.zaurtregulov.spring.hibernate_tone_to_one.entity.Detail;
import com.zaurtregulov.spring.hibernate_tone_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory =
                new Configuration().configure("hibernate.cfg.xml").
                        addAnnotatedClass(Employee.class).addAnnotatedClass(Detail.class).
                        buildSessionFactory();
        Session session = null;
try {


//        session = factory.getCurrentSession();
//
//        Employee employee = new Employee("Nilokay","Ivanov","HR",850);
//        Detail detail = new Detail("New-York","573845912","nikolay@gmail.com");
//        employee.setEmpDetails(detail);
//        detail.setEmployee(employee);
//        session.beginTransaction();
//        session.save(detail);
//        session.getTransaction().commit();
//        System.out.println("done");

    session = factory.getCurrentSession();

    session.beginTransaction();
    Detail detail = session.get(Detail.class,2);
    detail.getEmployee().setEmpDetails(null);
    session.delete(detail);
    session.getTransaction().commit();
    System.out.println("done");
}
finally {
    session.close();
    factory.close();
        }
    }
}
