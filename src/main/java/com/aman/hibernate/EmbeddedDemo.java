package com.aman.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddedDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			
			Student student1 = new Student();
			student1.setId(109);
			student1.setName("ali");
			student1.setCity("karachi");
			Certificate certi = new Certificate("app dev", "2 months");
			student1.setCertificate(certi);
			
			Session  session = factory.openSession();
			Transaction tx = session.beginTransaction();
			
//			save objects
			session.save(student1);
			
			tx.commit();
			session.close();
			factory.close();
			
			
			
	}

}
