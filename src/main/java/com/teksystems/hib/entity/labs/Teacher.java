package com.teksystems.hib.entity.labs;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEACHER")
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tit;
	private String salary;
	private String Teachername;

	public Teacher(int tit, String salary, String teachername) {
		super();
		this.tit = tit;
		this.salary = salary;
		Teachername = teachername;
	}

	public Teacher() {
	}

	public int getTit() {
		return tit;
	}

	public void setTit(int tit) {
		this.tit = tit;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getTeachername() {
		return Teachername;
	}

	public void setTeachername(String teachername) {
		Teachername = teachername;
	}
}