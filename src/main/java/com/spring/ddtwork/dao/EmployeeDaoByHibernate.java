package com.spring.ddtwork.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.ddtwork.model.*;

@Repository("empDao1")
public class EmployeeDaoByHibernate implements IEmployeeDao {

	@Autowired // Spring Boot 會自動繫結 JPARepository 物件
	private EmployeeRepository employeeRepository;

	@Override
	public IEmployee findByEmployeeId(int Id) {
		EmployeeBean employee = employeeRepository.findById(Id);

		return (IEmployee) employee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IEmployee> findAllEmployees() {
		List<EmployeeBean> employees = employeeRepository.findAll();

		return (List<IEmployee>) (List<?>) employees;
	}

	@Override
	public void createEmployee(IEmployee employee) {

		employeeRepository.save(this.transfer(employee));
	}

	@Override
	public void deleteEmployee(int Id) {
		employeeRepository.deleteById(Id);
	}

	private EmployeeBean transfer(IEmployee employee) {
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmployeeName(employee.getEmployeeName());
		employeeBean.setEmployeePhone(employee.getEmployeePhone());

		return employeeBean;
	}

	@Override
	public void updateEmployee(IEmployee employee) {
		// TODO Auto-generated method stub

	}

}
