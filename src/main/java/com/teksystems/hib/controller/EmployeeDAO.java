package com.teksystems.hib.controller;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.teksystems.hib.entity.Employee;

public class EmployeeDAO {
	private SessionFactory factory;
	private Session session;
	private Transaction t;
	
	public List<Employee> findEmployee() {
		init();
		
		String hql = "FROM Employee";
		TypedQuery<Employee> query = session.createQuery(hql, Employee.class);
		List<Employee> results = query.getResultList();
		
		close();
		
		return results;
	}
	
	public Employee findEmployeeByEmployeeNumber(Integer id) {
		init();
		
		String hql = "FROM Employee WHERE id = :id";
		TypedQuery<Employee> query = session.createQuery(hql, Employee.class);
		query.setParameter("id", id);
		Employee e = query.getSingleResult();
		
		close();
		
		return e;
	}
	
	public Employee findEmployeeByCustomerNumber(Integer customerNumber) {
		init();
		
		String hql = "SELECT e FROM Employee e JOIN Customer c ON e.employeeNumber = c.salesRepEmployeeNumber.employeeNumber WHERE c.id = :id";
		TypedQuery<Employee> query = session.createQuery(hql, Employee.class);
		query.setParameter("id", customerNumber);
		Employee e = query.getSingleResult();
		
		close();
		
		return e;
	}
	
	public void update(Employee Employee) {
		init();
		
		session.merge(Employee);
		
		close();
	}
	
	public void insert(Employee Employee) {
		init();
		
		session.save(Employee);
		
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
