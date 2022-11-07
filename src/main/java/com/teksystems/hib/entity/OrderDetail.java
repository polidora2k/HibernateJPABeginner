package com.teksystems.hib.entity;

import java.io.Serializable;

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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "orderdetails")
public class OrderDetail implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name="orderNumber", nullable=false)
	private Order orderNumber;
	
	@Id
	@ManyToOne
	@JoinColumn(name="productCode", nullable=false)
	private Product productCode;
	
	private Integer quantityOrdered;
	
	@Column(columnDefinition = "decimal")
	private Double priceEach;
	
	@Column(columnDefinition = "smallint")
	private Integer orderLineNumber;
	
}
