package com.teksystems.hib.controller;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.teksystems.hib.entity.OrderDetail;

public class OrderDetailDAO {
	private SessionFactory factory;
	private Session session;
	private Transaction t;
	
	public List<OrderDetail> findOrderDetail() {
		init();

		String hql = "FROM OrderDetail";
		TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
		
		close();
		
		return query.getResultList();
	}
	
	public List<OrderDetail> findOrderDetailByOrderNumber(Integer id) {
		init();

		String hql = "FROM OrderDetail WHERE orderNumber.id = :id";
		TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
		query.setParameter("id", id);
		
		close();
		
		return query.getResultList();
	}
	
	public void update(OrderDetail OrderDetail) {
		init();
		
		session.merge(OrderDetail);
		
		close();
	}
	
	public void insert(OrderDetail OrderDetail) {
		init();
		
		session.save(OrderDetail);
		
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
