package com.ram.resource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.ram.bean.Employee;
import com.ram.servceImpl.EmployeeServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Path("employee")
public class EmployeeResource {
	EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();

	@SuppressWarnings("unchecked")
	@GET
	@Path("/getAll")
	public List<Employee> getAllEmployees() throws SQLException {
		ArrayList<Employee> list = new ArrayList<>();
		list = (ArrayList<Employee>) employeeServiceImpl.getAllEmployees();
		return list;
	}

	@GET
	@Path("/get")
	@ApiOperation(value = "Find pet by ID", 
    notes = "Returns a single pet", 
    response = String.class
  )
	public String sayHi() throws SQLException {

		return "ramamohan";
	}

	@POST
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response save(String employee) throws SQLException, JSONException {
		boolean status = false;
		Employee employee1 = new Employee();
		JSONObject jsonObject = new JSONObject(employee);
		int id = (int) jsonObject.get("eid");
		String name = (String) jsonObject.get("name");
		double salary = (double) jsonObject.get("salary");
		employee1.setEid(id);
		employee1.setName(name);
		employee1.setSalary(salary);
		ResponseBuilder response = employeeServiceImpl.save(employee1);

		return response.entity(employee1).status(200).build();
	}

	@PUT
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response update(@QueryParam("empno") int empno, String employee) throws SQLException, JSONException {
		Employee employee1 = new Employee();
		JSONObject jsonObject = new JSONObject(employee);
		String name = (String) jsonObject.get("name");
		double salary = (double) jsonObject.get("salary");
		employee1.setEid(empno);
		employee1.setName(name);
		employee1.setSalary(salary);
		employeeServiceImpl.update(employee1);
		return Response.status(200).entity(employee1).build();
	}

	@DELETE
	public Response delete(@QueryParam("empno") int empno) throws SQLException {
		int i = employeeServiceImpl.delete(empno);
		int status = 0;
		if (i != 0) {
			status = 200;
		}
		return Response.status(status).entity("Sucessfully Record Removed From Table").build();
	}

}
