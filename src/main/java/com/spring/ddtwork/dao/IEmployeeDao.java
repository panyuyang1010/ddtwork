package com.spring.ddtwork.dao;

import java.util.List;

import com.spring.ddtwork.model.IEmployee;

/*
 * 制定EmployeeDao 的介面
 */
public interface IEmployeeDao 
{
	IEmployee findByEmployeeId(int Id);			// 查詢單筆
	List<IEmployee> findAllEmployees();			// 查詢多筆
	void createEmployee(IEmployee employee);	// 新增單筆
	void deleteEmployee(int Id);		// 刪除單筆
	void updateEmployee(IEmployee employee);
}
