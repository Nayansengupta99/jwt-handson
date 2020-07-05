package com.cognizant.springlearn;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Employee {
	@NotNull
	@NumberFormat
	int id;
	@NotNull
	@Size(min = 1, max = 30)
	String name;
	@NotNull
	@Min(value = 1)
	double salary;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	Date dateOfBirth;
	@NotNull
	private Department dept;
	@NotNull
	private Skill skill;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Employee() {
		super();
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", dateOfBirth=" + dateOfBirth
				+ ", dept=" + dept + ", skill=" + getSkill() + "]";
	}

	public Employee(@NotNull int id, @NotNull @Size(min = 1, max = 30) String name, @NotNull @Min(1) double salary,
			Date dateOfBirth, @NotNull Department dept, @NotNull Skill skill) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dateOfBirth = dateOfBirth;
		this.dept = dept;
		this.setSkill(skill);
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}
}