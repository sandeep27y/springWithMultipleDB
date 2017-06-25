package com.web.springWithMultipleDB.repository;

import java.util.List;

import com.web.springWithMultipleDB.entity.*;

public interface IEmployeeDAO {

	   List<Employee> getAllEmployees();
	   Employee getEmployeeById(Long employeeid);
	    void addEmployee(Employee employee);
	    void updateEmployee(Employee employee);
	    void deleteEmployee(Long employeeid);
	    boolean employeeExists(String username);
		
}
