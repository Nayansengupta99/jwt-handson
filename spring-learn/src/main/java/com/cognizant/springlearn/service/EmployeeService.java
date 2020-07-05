package com.cognizant.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeDao employeeDao;

	public EmployeeService() {
		LOGGER.debug("Hey there, this is EmployeeService");
	}

	public List<Employee> getallEmployee() {
		return employeeDao.getallEmployee();
	}

	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		employeeDao.deleteEmployee(id);
	}
	
	public Employee getOneEmployee(int id) throws EmployeeNotFoundException {
		return employeeDao.getOneEmployee(id);
	}
}