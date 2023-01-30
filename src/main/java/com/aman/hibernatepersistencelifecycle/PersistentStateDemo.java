package com.aman.hibernatepersistencelifecycle;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aman.hibernate.Certificate;
import com.aman.hibernate.Student;

public class PersistentStateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Practical of states of objects
//		Transient
//		Persistent
//		detached
//		removed
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//creating student objects
		
		Student student = new Student();
		student.setId(120);
		student.setName("ali shahzad");
		student.setCity("Karachi");
		student.setCertificate(new Certificate("java course", "2 months"));
//		after this work the object is in student : transient state
		
		Session session = factory.openSession();
		Transaction tx =  session.beginTransaction();
		session.save(student);
		//now the object student : persistent state - data is in session,database
//		in the persistent state data can be set or updated and that updated one will be in the database
		student.setName("aman nadeem");
		
		tx.commit();		

		//		detached state- the state where the data is not in session
		session.close();
		
//		that name will not be in the database bcz it is not in the persistent state
		student.setName("muhammad");
		
		
//		for removed state convert the persistent state to remove state by:
//		session.delete(student);

		factory.close();
		

	}

}
