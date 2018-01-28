package com.ram.service;

import java.sql.SQLException;
import java.util.List;

import com.ram.bean.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees()throws SQLException;
}
