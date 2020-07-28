package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		//create session Factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {			
			int studentId = 3;
			
			//start a transaction
			session.beginTransaction();
			
			
			//retrieve student based on primary key id 
			System.out.println("\n Getting student with id :" + studentId);
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Get complete "+ myStudent);
			
			//update Student name
			System.out.println("Updating Student...");
			myStudent.setFirstName("Orxan");
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update all students email
			System.out.println("update all students email...");
			session.createQuery("update Student set email ='@sabah.edu.az'")
			.executeUpdate();
			
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			System.out.println("DONE!");
			
		} finally {
			// TODO: handle finally clause
			factory.close();
		}

	}

}
