package com.spring.ddtwork.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.ddtwork.dao.IEmployeeDao;
import com.spring.ddtwork.model.*;

@Service
public class EmployeeService {

	@Autowired
	@Qualifier("empDao1")
	// @Qualifier("custDao2")
	private IEmployeeDao dao;

	public IEmployee getEmployeeById(int id) {
		return dao.findByEmployeeId(id);
	}

	public List<IEmployee> getAllEmployees() {
		return dao.findAllEmployees();
	}

	public void addEmployee(IEmployee employee) {
		dao.createEmployee(employee);
	}

	public void removeEmployee(int Id) {
		dao.deleteEmployee(Id);
	}

	public void updateEmployee(IEmployee employee) {
		dao.updateEmployee(employee);
	}
}
