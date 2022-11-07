package com.teksystems.hib.entity;

import java.io.Serializable;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "payments")
public class Payment implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "customerNumber", nullable = false)
	private Customer customerNumber;
	
	@Id
	private String checkNumber;
	
	@Temporal(TemporalType.DATE)
	private Date paymentDate;
	
	@Column(columnDefinition = "decimal")
	private Double amount;
}
