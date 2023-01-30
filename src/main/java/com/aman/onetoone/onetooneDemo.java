package com.aman.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class onetooneDemo {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Question q1 = new Question();
		q1.setQuest_id(1);
		q1.setQuestion("what is java?");
		
		
		Answer a1 = new Answer();
		a1.setAns_id(1);
		a1.setAnswer("java is a programming language");
		a1.setQuestion(q1);
		
		q1.setAnswer(a1);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
//		save the objects to the database
		
		session.save(q1);
		session.save(a1);
		
		
		tx.commit();
		
//		fetching the data
		
		Question q_details = (Question) session.get(Question.class, 1);
		System.out.println(q_details.getQuest_id() + " " + q_details.getQuestion() + " " + q_details.getAnswer().getAnswer());
		session.close();
		factory.close();
	}

}
