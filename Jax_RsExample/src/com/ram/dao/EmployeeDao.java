package com.ram.dao;

import java.sql.SQLException;
import java.util.List;

import com.ram.bean.Employee;

public interface EmployeeDao {
	
	public List<Employee> getAllEmployees()throws SQLException;

}
