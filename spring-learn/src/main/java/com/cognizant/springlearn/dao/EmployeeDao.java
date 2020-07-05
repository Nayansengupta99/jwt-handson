package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Repository
public class EmployeeDao {
	public static List<Employee> EMPLOYEE_LIST = new ArrayList<Employee>();

	public EmployeeDao() {
		ApplicationContext apx = new ClassPathXmlApplicationContext("employee.xml");
		EMPLOYEE_LIST = (ArrayList<Employee>) apx.getBean("employeeList");
	}

	public List<Employee> getallEmployee() {
		return EMPLOYEE_LIST;
	}

	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		Employee emp = null;
		for (Employee e : EMPLOYEE_LIST) {
			if (e.getId() == id) {
				emp = e;
				EMPLOYEE_LIST.remove(emp);
				break;
			}
		}
		if (emp == null)
			throw new EmployeeNotFoundException();
	}

	public Employee getOneEmployee(int id) throws EmployeeNotFoundException {
		for (Employee e : EMPLOYEE_LIST) {
			if (e.getId() == id) {
				return e;
			}
		}
		throw new EmployeeNotFoundException();
	}

}