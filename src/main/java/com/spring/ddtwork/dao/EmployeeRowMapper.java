package com.spring.ddtwork.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.spring.ddtwork.model.EmployeeModel;

public class EmployeeRowMapper implements RowMapper<EmployeeModel> {
	@Override
	public EmployeeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeModel employee = new EmployeeModel();

		employee.setEmployeeID(rs.getInt("id"));
		employee.setEmployeeName(rs.getString("name"));
		employee.setEmployeePhone(rs.getString("phone"));

		return employee;
	}
}
