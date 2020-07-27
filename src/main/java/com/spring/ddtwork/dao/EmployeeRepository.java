package com.spring.ddtwork.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ddtwork.model.*;

public interface EmployeeRepository extends JpaRepository<EmployeeBean, Integer>
{
	EmployeeBean findById(int id);
	List<EmployeeBean> findAll();
}
