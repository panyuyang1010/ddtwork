package com.spring.ddtwork.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class EmployeeBean implements IEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int employeeID;

	@Column(name = "name")
	private String employeeName;

	@Column(name = "phone")
	private String employeePhone;

	@Override
	public int getEmployeeID() {
		return employeeID;
	}

	@Override
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	@Override
	public String getEmployeeName() {
		return employeeName;
	}

	@Override
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public String getEmployeePhone() {
		return employeePhone;
	}

	@Override
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

}