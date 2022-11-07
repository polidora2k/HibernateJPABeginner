package com.teksystems.HibernateJPABeginner;

import com.teksystems.hib.controller.EmployeeDAO;
import com.teksystems.hib.entity.Employee;

public class App {
	public static void main(String[] args) {		
//		ProductDAO pdao = new ProductDAO();
//		System.out.println(pdao.findProductByProductCode("S10_1678"));
	
		
		//OrderDAO oc = new OrderDAO();
		EmployeeDAO edao = new EmployeeDAO();
		Employee e = edao.findEmployeeByCustomerNumber(103);
		System.out.println(e);
//		
//		for (Customer c : e.getCustomers()) {
//			System.out.println(c);
//		}
//		
//		System.out.println(e.getManager());\
		
//		ProductLineDAO pldao = new ProductLineDAO();
//		ProductLine pl = pldao.findProductLineByProductLine("Planes");
//		System.out.println(pl);
		
//		Order order = new Order();
//		order.setOrderDate(new Date());
//		order.setShippedDate(new Date());
//		order.setRequiredDate(new Date());
//		order.setStatus("Shipped");
//		order.setComments("Testing Auto Increments");
//		
//		oc.insert(order);
//		Order o = oc.findOrderByOrderNumber(10100);
//		System.out.println(o);
//		
//		o.setStatus("Shipped");
//		oc.save(o);
//		List<Order> orders = oc.findOrderByStatus("Cancelled");
//		
//		for (Order o: orders) {
//			System.out.println(o);
//		}
//		
//		
//		Order o = new Order();
//		o.getId();
		
		
		
//		ProductController pc = new ProductController();
//		pc.findProduct();
		
		// FindUser_HQL u = new FindUser_HQL();
		// u.findUser();
		// u.findUserSelect();
		// u.getRecordbyId();
		// u.getmaxSalary();

		// EmployeeController e = new EmployeeController();
		// e.createEmployeeTable();
		// e.findEmployeeByname();
		// e.findEmployeeById();
		// e.showOfficeCodes_AsDepartment();
	}
}
