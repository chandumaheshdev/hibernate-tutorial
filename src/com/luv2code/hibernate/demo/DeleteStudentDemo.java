package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory 
		
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
	
	//create session
		Session session= factory.getCurrentSession();
		
		try{
			 
			int studentId=1;
				
			
			
			//now get a new session and start transaction 
			session =factory.getCurrentSession();
			
			session.beginTransaction();
			
			//retrieve student based on id
			System.out.println("\n Getting student with id:" +studentId);
			
			Student myStudent=session.get(Student.class,studentId);
			
			//delete the student
			//System.out.println("Delete the Student: "+myStudent);
			
			//session.delete(myStudent);
			
			// delete the student id=2
			System.out.println("Deleting Student id=2");
			
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			session.getTransaction().commit();
			
			
			System.out.println("done");
		}
	finally{
		factory.close();
	}
	
	}

}
