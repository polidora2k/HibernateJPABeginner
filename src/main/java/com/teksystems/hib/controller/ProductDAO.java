package com.teksystems.hib.controller;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.teksystems.hib.entity.Product;

public class ProductDAO {
	private SessionFactory factory;
	private Session session;
	private Transaction t;
	
	public List<Product> findProduct() {
		init();
		
		String hql = "FROM Product";
		TypedQuery<Product> query = session.createQuery(hql, Product.class);
		List<Product> results = query.getResultList();
		
		close();
		
		return results;
	}
	
	public Product findProductByProductCode(String code) {
		init();
		
		String hql = "FROM Product WHERE productCode = :code";
		TypedQuery<Product> query = session.createQuery(hql, Product.class);
		query.setParameter("code", code);
		Product e = query.getSingleResult();
		
		close();
		
		return e;
	}
	
	public void update(Product Product) {
		init();
		
		session.merge(Product);
		
		close();
	}
	
	public void insert(Product Product) {
		init();
		
		session.save(Product);
		
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
