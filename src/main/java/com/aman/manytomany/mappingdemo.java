package com.aman.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class mappingdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory =  cfg.buildSessionFactory();
		
		Emp e1 = new Emp();
		e1.setEid(1);
		e1.setName("muhamamd ali");
		
		Emp e2 = new Emp();
		e2.setEid(2);
		e2.setName("khan sahab");
		
		Project p1 = new Project();
		p1.setPid(1);
		p1.setName("website");
		
		Project p2 = new Project();
		p2.setPid(2);
		p2.setName("testing");
		
		
		List <Emp> employees_list = new ArrayList<Emp>();
		employees_list.add(e1);
		employees_list.add(e2);
		
		List <Project> project_list = new ArrayList<Project> ();
		project_list.add(p1);
		project_list.add(p2);
		
		
//		adding employyes to projects
		e1.setProjs(project_list);
		e2.setProjs(project_list);
		
		//adding projects to employyes
		p2.setEmps(employees_list);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		
		tx.commit();
		

		session.close();
		
		
		factory.close();
	}

}
