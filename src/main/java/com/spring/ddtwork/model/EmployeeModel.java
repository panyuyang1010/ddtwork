package com.spring.ddtwork.model;

/*
 * POJO 類型的資料物件 (只有 setter/getter 方法)
 * 對應資料庫表格若為一對一，一般稱為 Model 物件
 * 資料物件若為組合多個表格的資料 (Join)，則稱為 
 * 資料傳遞物件 (DTO, Data Transfer Object)
 */
public class EmployeeModel implements IEmployee
{
	private int employeeID;
	private String employeeName;
	private String employeePhone;
	
	@Override
	public int getEmployeeID() {
		return employeeID;
	}
	@Override
	public void setEmployeeID(int custID) {
		this.employeeID = custID;
	}
	@Override
	public String getEmployeeName() {
		return employeeName;
	}
	@Override
	public void setEmployeeName(String custName) {
		this.employeeName = custName;
	}
	@Override
	public String getEmployeePhone() {
		return employeePhone;
	}
	@Override
	public void setEmployeePhone(String custPhone) {
		this.employeePhone = custPhone;
	}
}
