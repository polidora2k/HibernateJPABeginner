package com.teksystems.hib.controller;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.teksystems.hib.entity.Customer;

public class CustomerDAO {
	private SessionFactory factory;
	private Session session;
	private Transaction t;
	
	public List<Customer> findCustomers() {
		init();
		
		String hql = "FROM Customer";
		TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
		List<Customer> results = query.getResultList();
		
		close();
		
		return results;
	}
	
	public Customer findCustomerByCustomerNumber(Integer id) {
		init();
		
		String hql = "FROM Customer WHERE id = :id";
		TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
		query.setParameter("id", id);
		Customer c = query.getSingleResult();
		
		close();
		
		return c;
	}
	
	public List<Customer> findCustomerBySalesRep(Integer salesRepId) {
		init();
		
		String hql = "FROM Customer WHERE salesRepEmployeeNumber = :id";
		TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
		query.setParameter("id", salesRepId);
		List<Customer> c = query.getResultList();
		
		close();
		
		return c;
	}
	
	public void update(Customer Customer) {
		init();
		
		session.merge(Customer);
		
		close();
	}
	
	public void insert(Customer Customer) {
		init();
		
		session.save(Customer);
		
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
