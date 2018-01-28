package com.ram.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.ram.bean.Employee;
import com.ram.dao.EmployeeDao;
import com.ram.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	ConnectionUtil connectionUtil;

	@SuppressWarnings("null")
	public List<Employee> getAllEmployees() throws SQLException {
		ArrayList<Employee> list = new ArrayList<>();
		@SuppressWarnings("static-access")
		Connection con = connectionUtil.getConnection();
		String query = "select EMPNO,ENAME,SAL from employee";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Employee employee = new Employee();
			employee.setEid(rs.getInt(1));
			employee.setName(rs.getString(2));
			employee.setSalary(rs.getDouble(3));
			list.add(employee);
		}
		con.close();
		return list;
	}

	public ResponseBuilder save(Employee employee) throws SQLException {
		int i = 0;
		int id = employee.getEid();
		String name = employee.getName();
		double sal = employee.getSalary();
		Connection con = connectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String insertTableSQL = "INSERT INTO EMPLOYEE" + "(EMPNO, ENAME, SAL) VALUES" + "(?,?,?)";

		try {
			preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setDouble(3, sal);
			i = preparedStatement.executeUpdate();

			System.out.println("Record is inserted into  table!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return Response.status(200, employee.toString());
	}

	public void update(Employee employee) throws SQLException {

		int id = employee.getEid();
		String name = employee.getName();
		double sal = employee.getSalary();
		Connection con = connectionUtil.getConnection();
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "UPDATE EMPLOYEE SET ENAME = ?,SAL=? WHERE EMPNO = ?";

		try {
			preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, name);
			preparedStatement.setDouble(2, sal);
			preparedStatement.setInt(3, id);
			preparedStatement.executeUpdate();

			System.out.println("Record is updated into  table!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (con != null) {
				con.close();
			}
		}

	}

	public int delete(int empno) throws SQLException {
		Connection con = connectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		int i = 0;

		String insertTableSQL = "DELETE FROM EMPLOYEE WHERE EMPNO = ?";

		try {
			preparedStatement = con.prepareStatement(insertTableSQL);

			preparedStatement.setInt(1, empno);
			i = preparedStatement.executeUpdate();

			System.out.println("Record is deleted into  table!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return i;

	}
}
