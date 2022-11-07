package com.teksystems.hib.controller.labs;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.teksystems.hib.entity.Employee;

public class EmployeeController {

	public void findEmployeeByname() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
//------------  Hibernate Named Query   ------------- 
		TypedQuery<Employee> query = session.getNamedQuery("findEmployeeByName");
		query.setParameter("name", "Tom Thele");
		List<Employee> employees = query.getResultList();
		Iterator<Employee> itr = employees.iterator();
		while (itr.hasNext()) {
			Employee e = itr.next();
			System.out.println(e);
		}
		factory.close();
		session.close();
	}

	public void findEmployeeById() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
//------------  Hibernate Named Query   ------------- 
		TypedQuery<Object[]> query = session.getNamedQuery("get_Emp_name_by_id");
		query.setParameter("id", 3);
		List<Object[]> emName = query.getResultList();
		for (Object[] o : emName) {
			System.out.println("Employee name: " + o[0] + " | Employee Salary: " + o[1] + " | Emp Job Title: " + o[2]);
		}
		factory.close();
		session.close();
	}

	public void showOfficeCodes_AsDepartment() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
//------------  Hibernate Named Query   ------------- 
		TypedQuery<Object[]> query = session.getNamedQuery("empDepAlias");
		List<Object[]> list = query.getResultList();
		for (Object[] e : list) {
			System.out.println("OfficeCode: " + e[1] + " | Dep Name: " + e[3] + " | Employee Name: " + e[2]);
		}
		factory.close();
		session.close();
	}
}
