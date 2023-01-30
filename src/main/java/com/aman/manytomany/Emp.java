package com.aman.manytomany;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Emp {

	@Id
	private int eid;
	private String name;
	
	@ManyToMany
	@JoinTable(name="emp_learn",
	joinColumns = { @JoinColumn(name="eid")},
	inverseJoinColumns = {@JoinColumn(name="pid")})
	private List<Project> projs;

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(int eid, String name, List<Project> projs) {
		super();
		this.eid = eid;
		this.name = name;
		this.projs = projs;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjs() {
		return projs;
	}

	public void setProjs(List<Project> projs) {
		this.projs = projs;
	}
	
	
	
}
