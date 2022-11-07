package com.teksystems.hib.controller.labs;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.teksystems.hib.entity.labs.User;

public class FindUser_HQL {
	public void findUser() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM User";
		Query<User> query = session.createQuery(hql, User.class);
		List<User> results = query.getResultList();
		for (User u : results) {
			System.out.println("User Id: " + u.getId() + "|" + " Full name:" + u.getFullname() + "|" + "Email: "
					+ u.getEmail() + "|" + "password" + u.getPassword());
		}
	}

	public void findUserSelect() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		/* ------------ Example of HQL to get all the records------- */
		String hql = "SELECT u FROM User u";
		Query<User> query = session.createQuery(hql, User.class);
		List<User> list = query.getResultList();

		for (User u : list) {
			System.out.println("User Id: " + u.getId() + "|" + " Full name:" + u.getFullname() + "|" + "Email: "
					+ u.getEmail() + "|" + "password" + u.getPassword());

		}
	}

	public void getRecordbyId() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "SELECT U FROM User U WHERE U.id < 5 ORDER BY U.id DESC";
		Query<User> query = session.createQuery(hql, User.class);
		List<User> list = query.getResultList();
		for (User u : list) {
			System.out.println("User Id: " + u.getId() + "|" + " Full name:" + u.getFullname() + "|" + "Email: "
					+ u.getEmail() + "|" + "password" + u.getPassword());
		}
	}

	public void getmaxSalary() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "SELECT Max(U.salary) FROM User U";
		Query<Double> query = session.createQuery(hql, Double.class);
		double maxSalary = query.getSingleResult();
		System.out.println("Maximum Price:" + maxSalary);

	}

	public void NamedQueryExample() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "FROM User u WHERE u.id = :id";
		TypedQuery<User> query = session.createQuery(hql, User.class);
		query.setParameter("id", 2);
		List<User> result = query.getResultList();
		for (User u : result) {
			System.out.println("User Id: " + u.getId() + "|" + " Full name:" + u.getFullname() + "|" + "Email: "
					+ u.getEmail() + "|" + "password" + u.getPassword());
		}
	}
}
