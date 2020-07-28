package com.luv2code.hibernate.demo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		//create session Factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			//start a transaction
			session.beginTransaction();
			
			//query students 
			List<Student> theStudents = session.createQuery("from Student").list();
			
			//display students
			displayStudents(theStudents);
			
			//query Students lastname = 'memmedov'
			theStudents = session.createQuery("from Student s where s.lastName = 'Memmedov' ").list();
			
			//display students
			System.out.println("\n\nStudents who has last name 'Memmedov'");
			displayStudents(theStudents);
			
			
			//commit transaction
			session.getTransaction().commit();
			
		} finally {
			// TODO: handle finally clause
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
