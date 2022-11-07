package com.teksystems.hib.controller;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.teksystems.hib.entity.Payment;

public class PaymentDAO {
	private SessionFactory factory;
	private Session session;
	private Transaction t;
	
	public List<Payment> findPayment() {
		init();
		
		String hql = "FROM Payment";
		TypedQuery<Payment> query = session.createQuery(hql, Payment.class);
		List<Payment> results = query.getResultList();
		
		close();
		
		return results;
	}
	
	public List<Payment> findPaymentByCustomerNumber(Integer customerNumber) {
		init();
		
		String hql = "FROM Payment WHERE customerNumber = :cn";
		TypedQuery<Payment> query = session.createQuery(hql, Payment.class);
		query.setParameter("cn", customerNumber);
		List<Payment> p = query.getResultList();
		
		close();
		
		return p;
	}
	
	public List<Payment> findPaymentByCheckNumber(String checkNumber) {
		init();
		
		String hql = "FROM Payment WHERE checkNumber = :cn";
		TypedQuery<Payment> query = session.createQuery(hql, Payment.class);
		query.setParameter("cn", checkNumber);
		List<Payment> p = query.getResultList();
		
		close();
		
		return p;
	}
	
	public void update(Payment Payment) {
		init();
		
		session.merge(Payment);
		
		close();
	}
	
	public void insert(Payment Payment) {
		init();
		
		session.save(Payment);
		
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
