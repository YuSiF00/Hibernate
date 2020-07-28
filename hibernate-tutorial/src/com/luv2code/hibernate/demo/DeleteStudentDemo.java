package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		//create session Factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {			
			int studentId = 5;
			
			//start a transaction
			session.beginTransaction();
			
			
			//retrieve student based on primary key id 
			System.out.println("\nGetting student with id :" + studentId);
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Get complete "+ myStudent);
			
				//delete Student version 1
			//System.out.println("Deleting Student id: "+ studentId);
			//session.delete(myStudent);
			
				//delete Student version 2
			System.out.println("Deleting Student id: "+ studentId);
			session.createQuery("delete from Student where id = 5").executeUpdate();
			
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			
			
			System.out.println("DONE!");
			
		} finally {
			// TODO: handle finally clause
			factory.close();
		}

	}

}
