package com.teksystems.hib.controller.labs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.teksystems.hib.entity.labs.User;

public class DeletingUser {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		User u = new User();
		u.setId(3);
		session.delete(u);
		tx.commit();
		session.close();
		factory.close();
	}
}
