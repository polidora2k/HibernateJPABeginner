package com.teksystems.hib.controller.labs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//import com.teksystems.hib.model.User;

public class CreateUserTable {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		//User uone = new User();
		t.commit();
		System.out.println("successfully created user table");
		factory.close();
		session.close();
		
	}
}
