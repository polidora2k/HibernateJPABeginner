package com.teksystems.hib.controller.labs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.teksystems.hib.entity.labs.User;

public class UpdatingUser {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		User u = new User();
		u.setId(3);
		u.setEmail("mhaseeb@perscholas");
		u.setFullname("M haseeb");
		u.setPassword("123456");
		session.merge(u);
		session.getTransaction().commit();
		session.close();
	}
}
