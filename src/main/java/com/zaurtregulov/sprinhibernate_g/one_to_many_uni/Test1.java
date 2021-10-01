package com.zaurtregulov.sprinhibernate_g.one_to_many_uni;




import com.zaurtregulov.sprinhibernate_g.one_to_many_uni.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory =
                new Configuration().configure("hibernate.cfg.xml").
                        addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class).
                        buildSessionFactory();
        Session session = null;
try {

//    session = factory.getCurrentSession();
//
//    Department dep = new Department("HR",500,1500);
//    Employee emp1 = new Employee("Oleg","Ivanov",800);
//    Employee emp2 = new Employee("Andrey","Sidorov",1000);
//    dep.addEmployToDepartment(emp1);
//    dep.addEmployToDepartment(emp2);
//    session.beginTransaction();
//    session.save(dep);
//    session.getTransaction().commit();
//    System.out.println("done");


//    session = factory.getCurrentSession();
//
//    session.beginTransaction();
//    Employee employee = session.get(Employee.class,1);
//    System.out.println(employee);
//    System.out.println(employee.getDepartment());
//    session.getTransaction().commit();
//    System.out.println("done");
//**********************************************
     session = factory.getCurrentSession();

    session.beginTransaction();
    Department department = session.get(Department.class,3);
    session.delete(department);
    session.getTransaction().commit();
    System.out.println("done");
}
finally {
    session.close();
    factory.close();
        }
    }
}
