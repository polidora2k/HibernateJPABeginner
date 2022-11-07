package com.teksystems.hib.controller;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.teksystems.hib.entity.ProductLine;

public class ProductLineDAO {
	private SessionFactory factory;
	private Session session;
	private Transaction t;

	public List<ProductLine> findProductLine() {
		init();

		String hql = "FROM ProductLine";
		TypedQuery<ProductLine> query = session.createQuery(hql, ProductLine.class);
		List<ProductLine> results = query.getResultList();

		close();

		return results;
	}

	public ProductLine findProductLineByProductLine(String line) {
		init();

		String hql = "FROM ProductLine WHERE productLine = :pl";
		TypedQuery<ProductLine> query = session.createQuery(hql, ProductLine.class);
		query.setParameter("pl", line);
		ProductLine pl = query.getSingleResult();

		close();

		return pl;
	}

	public void update(ProductLine ProductLine) {
		init();

		session.merge(ProductLine);

		close();
	}

	public void insert(ProductLine ProductLine) {
		init();

		session.save(ProductLine);

		close();
	}

	private void init() {
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
	}

	private void close() {
		t.commit();
		factory.close();
		session.close();
	}
}
