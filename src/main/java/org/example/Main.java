package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Laptop laptop = new Laptop();
        laptop.setLaptopId(701);
        laptop.setBrand("Acer");
        laptop.setRam("16");
        laptop.setModel("Game");
        //laptop.setStudent(student);

        Laptop laptop2 = new Laptop();
        laptop2.setLaptopId(702);
        laptop2.setBrand("Dell");
        laptop2.setRam("8");
        laptop2.setModel("Work");
        //laptop.setStudent(student);

        Laptop laptop3 = new Laptop();
        laptop3.setLaptopId(703);
        laptop3.setBrand("Macbook Air");
        laptop3.setRam("16");
        laptop3.setModel("Video Edit");

        Student student = new Student();
        student.setRollNo(1008);
        student.setsName("Pablo");
        student.setsAge(29);
        student.setLaptops(Arrays.asList(laptop, laptop2));

        Student student2 = new Student();
        student2.setRollNo(1009);
        student2.setsName("Steve");
        student2.setsAge(34);
        student2.setLaptops(Arrays.asList(laptop2, laptop3));

        Student student3 = new Student();
        student3.setRollNo(1010);
        student3.setsName("Bob");
        student3.setsAge(31);
        student3.setLaptops(List.of(laptop));

        laptop.setStudents(Arrays.asList(student, student3));
        laptop2.setStudents(Arrays.asList(student, student2));
        laptop3.setStudents(List.of(student2));

        SessionFactory sessionFactory = new Configuration().configure()
                                        .addAnnotatedClass(org.example.Student.class)
                                        .addAnnotatedClass(org.example.Laptop.class)
                                        .buildSessionFactory();


        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(student);
        session.persist(student2);
        session.persist(student3);
        session.persist(laptop);
        session.persist(laptop2);
        session.persist(laptop3);
        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}