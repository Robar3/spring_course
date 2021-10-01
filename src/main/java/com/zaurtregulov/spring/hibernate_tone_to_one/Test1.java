package com.zaurtregulov.spring.hibernate_tone_to_one;


import com.zaurtregulov.spring.hibernate_tone_to_one.entity.Detail;
import com.zaurtregulov.spring.hibernate_tone_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory =
                new Configuration().configure("hibernate.cfg.xml").
                        addAnnotatedClass(Employee.class).addAnnotatedClass(Detail.class).
                        buildSessionFactory();
        Session session = null;
try {


//        Session session = factory.getCurrentSession();

        Employee employee = new Employee("Zaur","Tregulov","IT",500);
        Detail detail = new Detail("Baku","123456789","zaurtregulov@gmail.com");
        employee.setEmpDetails(detail);
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        System.out.println("done");

//    session = factory.getCurrentSession();
//
//    session.beginTransaction();
//    Employee emp = session.get(Employee.class,1);
//    System.out.println(emp.getEmpDetails());
//    session.getTransaction().commit();
//    System.out.println("done");

    session = factory.getCurrentSession();

    session.beginTransaction();
    Employee emp = session.get(Employee.class,2);
    session.delete(emp);
    session.getTransaction().commit();
    System.out.println("done");
}
finally {
    session.close();
    factory.close();
        }
    }
}
