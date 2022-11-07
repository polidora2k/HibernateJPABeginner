package com.teksystems.hib.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "orders")
public class Order {
	@Column(name = "orderNumber")
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	
	@Temporal(TemporalType.DATE)
	private Date requiredDate;
	
	@Temporal(TemporalType.DATE)
	private Date shippedDate;
	
	private String status;
	
	@Column(columnDefinition = "text")
	private String comments;
	
	@ManyToOne
	@JoinColumn(name = "customerNumber")
	private Customer customerNumber;
}
