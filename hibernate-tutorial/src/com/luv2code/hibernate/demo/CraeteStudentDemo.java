package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CraeteStudentDemo {

	public static void main(String[] args) {

		//create session Factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {			
			//create a student object
			System.out.println("Create new student object... ");
			Student tempStudent = new Student("Yusif","Memmedov","yusifmemmedov553@gmail.com");
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Savig the student...");
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
		} finally {
			// TODO: handle finally clause
			factory.close();
		}

	}

}
