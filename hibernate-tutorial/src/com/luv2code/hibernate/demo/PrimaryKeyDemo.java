package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		
		//create session Factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				
				
		//create session
		Session session = factory.getCurrentSession();
				
		try {			
			//create 3 students objects
			System.out.println("Create 3 student objects... ");
			Student tempStudent1 = new Student("Cavidan","Abdullayev","cavidan5889@gmail.com");
			Student tempStudent2 = new Student("Kenan","Sultanov","kenansultnv@gmail.com");
			Student tempStudent3 = new Student("Adil","Kerimov","KerimovAdil99@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Savig the student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			//commit transaction
			session.getTransaction().commit();
			
		} finally {
			// TODO: handle finally clause
			factory.close();
		}

	}

}
