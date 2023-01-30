package com.aman.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		get method and load method for fetching data
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		
		Session session = factory.openSession();
		
//		get- returns null if no object found in db or cache 
//		used - if you are not sure that object exists in db or not
		
		 Student student = (Student)session.get(Student.class, 101);
		
		 System.out.println(student);
		
//		 load - returns throws exception if no object is found in db or cache
//		 used - when sure object exists 
//		 lazy initialization   
		 Address ad = (Address)session.load(Address.class, 1);
		 System.out.println(ad.getStreet());
		session.close();
		factory.close();
		
	}

}
