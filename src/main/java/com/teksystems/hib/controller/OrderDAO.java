package com.teksystems.hib.controller;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.teksystems.hib.entity.Order;

public class OrderDAO {
	private SessionFactory factory;
	private Session session;
	private Transaction t;
	
	public List<Order> findOrder() {
		init();
		
		String hql = "FROM Order";
		TypedQuery<Order> query = session.createQuery(hql, Order.class);
		List<Order> results = query.getResultList();
		
		close();
		
		return results;
	}
	
	public Order findOrderByOrderNumber(Integer id) {
		init();
		
		String hql = "FROM Order WHERE id = :id";
		TypedQuery<Order> query = session.createQuery(hql, Order.class);
		query.setParameter("id", id);
		Order o = query.getSingleResult();
		
		close();
		
		return o;
	}
	
	public List<Order> findOrderByStatus(String status) {
		init();
		
		String hql = "FROM Order WHERE status = :status";
		TypedQuery<Order> query = session.createQuery(hql, Order.class);
		query.setParameter("status", status);
		List<Order> o = query.getResultList();
		
		close();
		
		return o;
	}
	
	public void update(Order order) {
		init();
		
		session.merge(order);
		
		close();
	}
	
	public void insert(Order order) {
		init();
		
		session.save(order);
		
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
