
package com.cognizant.springlearn;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Skill {
	@NotNull
	@Min(1)
	@Max(9)
	int id;
	@NotNull
	@Size(min = 1, max = 30)
	String name;

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

	public Skill(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Skill() {
		super();
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + "]";
	}

}