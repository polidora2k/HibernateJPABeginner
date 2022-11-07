package com.teksystems.hib.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
	@Id
	private Integer employeeNumber;

	private String lastName;

	private String firstName;

	private String extension;

	private String email;

	@ManyToOne
	@JoinColumn(name = "officeCode", nullable = false)
	private Office office;
	
	@ManyToOne
	@JoinColumn(name = "reportsTo", nullable = true)
	private Employee manager;

	private String jobTitle;

	@Column(name = "VacationHours")
	private Integer vacationHours;
	
	@OneToMany(mappedBy = "salesRepEmployeeNumber", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Customer> customers;

	@Override
	public String toString() {
		return "Employee (employeeNumber=" + employeeNumber + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", extension=" + extension + ", email=" + email + ", office=" + office + ", manager=" + manager.getEmployeeNumber()
				+ ", jobTitle=" + jobTitle + ", vacationHours=" + vacationHours + ")";
	}
	
	
}