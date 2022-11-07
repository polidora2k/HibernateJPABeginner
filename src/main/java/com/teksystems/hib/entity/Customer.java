package com.teksystems.hib.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@Column(name = "customerNumber")
	private Integer id;

	@Column(name = "customerName")
	private String name;

	private String contactLastName;

	private String contactFirstName;

	private String phone;

	private String addressLine1;

	private String addressLine2;

	private String city;

	private String state;

	private String postalCode;

	private String country;

	@ManyToOne
	@JoinColumn(name = "salesRepEmployeeNumber", nullable = false)
	private Employee salesRepEmployeeNumber;

	@Column(columnDefinition = "decimal")
	private Double creditLimit;
}
