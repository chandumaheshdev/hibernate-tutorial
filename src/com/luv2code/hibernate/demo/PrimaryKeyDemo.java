package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory 
		
				SessionFactory factory= new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
			
			//create session
				Session session= factory.getCurrentSession();
				
				try{
					 
					//create a three  student object
					System.out.println("Creating a new student object....");
					Student tempStudent1=new Student("john","snow","john@Danerys.com");
					Student tempStudent2=new Student("tirion","shae","tirion@shae.com");
					Student tempStudent3=new Student("melisandre","baratheon","melisandr@baratheon.com");
					
					//start a transaction 
					session.beginTransaction();
					
					//save the student object 
					
					System.out.println("Saving the student....");
					
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					//commit the transaction
					
					session.getTransaction().commit();
					
					System.out.println("done!");
					
				}
			finally{
				factory.close();
			}


	}

}
