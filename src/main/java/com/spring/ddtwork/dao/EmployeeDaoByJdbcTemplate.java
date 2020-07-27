package com.spring.ddtwork.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.ddtwork.model.*;

@Repository("empDao2")	
public class EmployeeDaoByJdbcTemplate implements IEmployeeDao
{
	@Autowired   
	private JdbcTemplate jdbcTemplate;
    
	@Override
	public IEmployee findByEmployeeId(int Id)
	{
		String sql = "SELECT * FROM EMPLOYEE WHERE ID = ?";

		return (IEmployee) jdbcTemplate.queryForObject(
				sql, 						// SQL 陳述
				new Object[]{Id}, 			// 所需要的引數
				new EmployeeRowMapper()		
		);
	}
	
	@Override
	public List<IEmployee> findAllEmployees() {
		// 這裡採用另一種方式，將 Resultset 自行撰寫 private method 轉換至 Model 物件
		return jdbcTemplate.query("select * from Employee", (resultSet, i) -> {
            return transferToEmployees(resultSet);
        });
	}
	
	@Override
	public void createEmployee(IEmployee employee) {
        String insertSql = "insert into EMPLOYEE (name, phone) values (?, ?)";

        // update() 方法通用於 INSERT, UPDATE, DELETE SQL 
        jdbcTemplate.update(insertSql, employee.getEmployeeName(), 
        		employee.getEmployeePhone());
	}
	
	@Override
	public void deleteEmployee(int empId) {
        String deleteSql = "delete from EMPLOYEE where id = ?";

        jdbcTemplate.update (deleteSql, empId);
	}
	
	// 自行撰寫 Resultset -> Model 的轉換 (transform) 邏輯
    private IEmployee transferToEmployees(ResultSet resultSet) throws SQLException {
    	IEmployee employee = new EmployeeModel();
    	employee.setEmployeeID(resultSet.getInt("id"));
    	employee.setEmployeeName(resultSet.getString("name"));
    	employee.setEmployeePhone(resultSet.getString("phone"));
        
        return employee;
    }

	@Override
	public void updateEmployee(IEmployee employee) {
		// TODO Auto-generated method stub
		
	}
}
