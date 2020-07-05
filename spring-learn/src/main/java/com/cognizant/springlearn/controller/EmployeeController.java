package com.cognizant.springlearn.controller;

import java.util.List;

import javax.servlet.annotation.HttpMethodConstraint;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.service.EmployeeService;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@RestController
@RequestMapping("employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/")
	public List<Employee> getallEmployee() {
		return employeeService.getallEmployee();
	}

	@GetMapping("/{id}")
	public Employee getOneEmployee(@PathVariable int id) throws EmployeeNotFoundException {
		return employeeService.getOneEmployee(id);
	}

	@PutMapping("/")
	public Employee updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
		for (Employee e : EmployeeDao.EMPLOYEE_LIST) {
			if (e.getId() == employee.getId()) {
				e.setName(employee.getName());
				e.setSalary(employee.getSalary());
				e.setDateOfBirth(employee.getDateOfBirth());
				e.setDept(employee.getDept());
				e.setSkill(employee.getSkill());
				return employee;
			}
		}
		throw new EmployeeNotFoundException();
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException {
		employeeService.deleteEmployee(id);
	}

}