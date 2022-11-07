package com.teksystems.hib.controller.labs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.teksystems.hib.entity.labs.User;

public class FindingUser {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		int USER_ID = 2;
		User u = session.load(User.class, USER_ID);
		System.out.println("Fullname: " + u.getFullname());
		System.out.println("Email: " + u.getEmail());
		System.out.println("password: " + u.getPassword());

		// Close resources
		tx.commit();
		factory.close();
		session.close();
	}
}
