package com.web.springWithMultipleDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.springWithMultipleDB.entity.Employee;
import com.web.springWithMultipleDB.repository.IEmployeeDAO;


@Service
public class EmployeeService {
	
	@Autowired
	private IEmployeeDAO employeeDAO;
	
	public synchronized boolean addPerson(Employee employee){
	      
		if(employeeDAO.employeeExists(employee.getEmployeename())){
			return false;
		}else{
			employeeDAO.addEmployee(employee);
	    	   return true;
		}	       
		}
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.getAllEmployees();
	}
	
	public Employee getEmployeeById(Long employeeId){
		return employeeDAO.getEmployeeById(employeeId);
	}
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		 employeeDAO.updateEmployee(employee);
	}
}
