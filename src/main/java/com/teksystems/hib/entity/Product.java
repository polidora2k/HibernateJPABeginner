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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "products")
public class Product {
	@Id
	private String productCode;
	
	private String productName;
	
	@ManyToOne
	@JoinColumn(name = "productLine", nullable = false)
	private ProductLine productLine; 
	
	private String productScale; 
	
	private String productVendor; 
	
	@Column(columnDefinition = "text")
	private String productDescription; 
	
	@Column(columnDefinition = "smallint")
	private Integer quantityInStock; 
	
	@Column(columnDefinition = "decimal")
	private Double buyPrice; 
	
	@Column(columnDefinition = "decimal")
	private Double MSRP;
}
