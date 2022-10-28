package com.tnsif.OneToOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
        cfg.configure("Hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Question q1= new Question();
        q1.setQuestionId(343);
        q1.setQuestion("What is Java?");
        
        Answer a1 = new Answer();
        a1.setAnswerId(1212);
        a1.setAnswer("Java is a programming language.");
        a1.setQuestion(q1);
        q1.setAnswer(a1);
        
        Question q2= new Question();
        q2.setQuestionId(344);
        q2.setQuestion("What is Collections Framework?");
        
        Answer a2 = new Answer();
        a2.setAnswerId(1213);
        a2.setAnswer("An API to work with java Objects.");
        a2.setQuestion(q2);
        q2.setAnswer(a2);

        
        Session session = factory.openSession();
        
        session.beginTransaction();
        session.save(q1);
        session.save(a1);
        session.save(q2);
        session.save(a2);
        session.getTransaction().commit();
           
        session.close();
        factory.close();
		
	}

}
