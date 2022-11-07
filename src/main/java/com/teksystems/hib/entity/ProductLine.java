package com.teksystems.hib.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "productlines")
public class ProductLine {
	@Id
	private String productLine;
	private String textDescription;
	
	@Column(columnDefinition = "mediumtext")
	private String htmlDescription;
	@Column(columnDefinition = "mediumblob")
	private Byte[] image;

}
