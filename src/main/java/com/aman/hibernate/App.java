package com.aman.hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
//   Jboss framework class     build sessions which handle database connectivity,
//        crud operations and thread pooling 
        
        Configuration cfg =  new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
//        creating student
        
        Student student = new Student();
        student.setId(101);
        student.setName("muhammad aman");
        student.setCity("karachi");
        
        System.out.println(student);
        
        
//        creating object of address class
        
        Address addr = new Address();
        addr.setStreet("Street 1");
        addr.setCity("karachi");
        addr.setOpen(true);
        addr.setAddeddate(new Date());
        addr.setX(20321.1);
//        reading the image
       FileInputStream fi =  new FileInputStream("src/main/java/cvimage.jpeg");
       byte[] data = new  byte[fi.available()];
       fi.read(data);
       addr.setImage(data);
        
        
//        getting the session       
        Session session = factory.openSession();        
//        transaction begin
         Transaction tx = session.beginTransaction();
//        how to save the object into the database
         session.save(student);
         session.save(addr);
//         end transaction and commit it to the database
         tx.commit();
//         close the session
        session.close();
        
        System.out.println("done .,");
        
        		
        
//        System.out.println(factory);
//        System.out.println(factory.isClosed());
        

    }
}
