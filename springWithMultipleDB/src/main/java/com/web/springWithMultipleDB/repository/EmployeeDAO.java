package com.web.springWithMultipleDB.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.web.springWithMultipleDB.entity.Employee;


@Transactional
@Repository
public class EmployeeDAO implements IEmployeeDAO{
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		String hql = "FROM Employee as e ORDER BY e.employeeid";
		List<Employee> employees=(List<Employee>)hibernateTemplate.find(hql);
		return employees;
	}

	public Employee getEmployeeById(Long employeeid) {
		String hql = "FROM Employee as E where E.employeeid=?";
		return hibernateTemplate.get(Employee.class, employeeid);
	}

	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("adding Employee");
		hibernateTemplate.save(employee);
		
	}

	public void updateEmployee(Employee employee) {
		Employee emp = getEmployeeById(employee.getEmployeeid());
		emp.setEmployeename(employee.getEmployeename());
		emp.setGender(employee.getGender());
		emp.setSalary(employee.getSalary());
		emp.setCompany(employee.getCompany());
		hibernateTemplate.update(emp);
	}

	public void deleteEmployee(Long employeeid) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	public boolean employeeExists(String username) {
		String hql = "FROM Employee as E where E.employeename=?";
		List<Employee> employees=(List<Employee>)hibernateTemplate.find(hql, username);
		return employees.size() > 0 ? true:false;
	}

}
