package com.aman.onetomany;

import java.util.ArrayList;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aman.onetomany.Question;

public class onetomanyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Question q1 = new Question();
		q1.setQuest_id(1);
		q1.setQuestion("what is java?");
		
		Answer a1 = new Answer();
		a1.setAns_id(1);
		a1.setAnswer("java is a programming lanaguage");
		a1.setQuestion(q1);
		Answer a2  =new Answer();
		a2.setAns_id(2);
		a2.setAnswer("it is helpful in making softwares");
		a2.setQuestion(q1);

		List<Answer> ans_list = new ArrayList<Answer>();
		ans_list.add(a1);
		ans_list.add(a2);
		
		
//		adding answers to question
		q1.setAns(ans_list);
		
		
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		
//		save objects
		
//		session.save(q1);
//		session.save(a1);
//		session.save(a2);
		
		tx.commit();
		
		
//		fetching data
		Question quest_details = (Question) session.get(Question.class, 1);
		System.out.println(quest_details.getQuest_id());
		System.out.println(quest_details.getQuestion());
//		lazy fetching 
//		System.out.println(quest_details.getAns().size());
//		for(Answer a : quest_details.getAns()) {
//			System.out.println(a.getAnswer());
//		}
//		
		
		session.close();
		
		
		factory.close();

	}

}
