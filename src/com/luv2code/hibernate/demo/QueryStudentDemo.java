package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory 
		
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
	
	//create session
		Session session= factory.getCurrentSession();
		
		try{
			
			
			//start a transaction 
			session.beginTransaction();
			
			//query students
			
			List<Student> theStudents=session.createQuery("from Student").getResultList();
			
			//display the students
			
			
			theStudents=session.createQuery("from Student s where s.lastName='snow'").getResultList();
			
			System.out.println("\n\n students who have the last name of snow");
			
			
			displayStudents(theStudents);
			
			//query students:last name ='Snow' or first name='John'
			
			theStudents=
					session.createQuery("from Student s where"
			+ " s.lastName= 'shae' OR s.firstName= 'tirion'").getResultList();
			//commit the transaction
			System.out.println("\n\n students who have the last name of shae or first name tirion");
			
			displayStudents(theStudents);
			//query students where email like %luv2code.com
			
			theStudents=session.createQuery("from Student s where "
					+" s.email LIKE '%sansa@lordbaelish.com'").getResultList();
			System.out.println("\n\n students who have the mail id sansa@lordbaelish.com ");
			
			displayStudents(theStudents);
			
			session.getTransaction().commit();
			
			System.out.println("done!");
			
		}
	finally{
		factory.close();
	}
	
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent: theStudents){
			
			System.out.println(tempStudent);
		}
	}

}
