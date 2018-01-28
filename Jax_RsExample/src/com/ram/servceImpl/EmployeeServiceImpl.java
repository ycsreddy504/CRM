package com.ram.servceImpl;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.ram.bean.Employee;
import com.ram.dao.EmployeeDao;
import com.ram.daoImpl.EmployeeDaoImpl;
import com.ram.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

	public List<Employee> getAllEmployees() throws SQLException {

		return employeeDao.getAllEmployees();
	}

	public ResponseBuilder save(Employee employee) throws SQLException {
		return employeeDao.save(employee);

	}

	public void update(Employee employee) throws SQLException {
		employeeDao.update(employee);

	}

	public int delete(int empno) throws SQLException {
		int i=employeeDao.delete(empno);
		return i;

	}

}
