package com.ram.bean;

import java.io.Serializable;
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int empNo;
	private String eName;
	private double sal;

	public Employee() {
	}

	public Employee(int eid, String name, double salary) {
		super();
		this.empNo = eid;
		this.eName = name;
		this.sal = salary;
	}

	public int getEid() {
		return empNo;
	}

	public void setEid(int eid) {
		this.empNo = eid;
	}

	public String getName() {
		return eName;
	}

	public void setName(String name) {
		this.eName = name;
	}

	public double getSalary() {
		return sal;
	}

	public void setSalary(double salary) {
		this.sal = salary;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + empNo + ", name=" + eName + ", salary=" + sal + "]";
	}

}
