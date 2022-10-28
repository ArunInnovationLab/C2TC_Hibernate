package com.tnsif.OneToMany;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Question question= new Question();
        question.setQuestionId(343);
        question.setQuestion("What is Java?");
        
        Answer answer = new Answer();
        answer.setAnswerId(1212);
        answer.setAnswer("Java is a programming language.");
        answer.setQuestion(question);
        
        Answer answer2 = new Answer();
        answer2.setAnswerId(1213);
        answer2.setAnswer("Java is object oriented pl.");
        answer2.setQuestion(question);
        
        question.setAnswers(Arrays.asList(answer,answer2));
        
        Session session = factory.openSession();
        
        session.beginTransaction();
        session.save(question);
        session.save(answer);
        session.save(answer2);
        
//        Question question = (Question)session.get(Question.class, 343);
//        System.out.println(question.getQuestion());
//        
//        for (Answer a : question.getAnswers()) {
//        	System.out.println(a.getAnswer());
//        }
        session.getTransaction().commit();
           
        session.close();
        factory.close();
		
	}

}
