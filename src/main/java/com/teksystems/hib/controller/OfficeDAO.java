package com.teksystems.hib.controller;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.teksystems.hib.entity.Office;

public class OfficeDAO {
	private SessionFactory factory;
	private Session session;
	private Transaction t;
	
	public List<Office> findOffice() {
		init();
		
		String hql = "FROM Office";
		TypedQuery<Office> query = session.createQuery(hql, Office.class);
		List<Office> results = query.getResultList();
		
		close();
		
		return results;
	}
	
	public Office findOfficeByOfficeCode(String officeCode) {
		init();
		
		String hql = "FROM Office WHERE officeCode = :code";
		TypedQuery<Office> query = session.createQuery(hql, Office.class);
		query.setParameter("code", officeCode);
		Office e = query.getSingleResult();
		
		close();
		
		return e;
	}
	
	public void update(Office Office) {
		init();
		
		session.merge(Office);
		
		close();
	}
	
	public void insert(Office Office) {
		init();
		
		session.save(Office);
		
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
