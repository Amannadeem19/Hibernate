package com.aman.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	private int pid;
	private String name;
	@ManyToMany(mappedBy = "projs")
	private List<Emp> emps;
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(int pid, String name, List<Emp> emps) {
		super();
		this.pid = pid;
		this.name = name;
		this.emps = emps;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Emp> getEmps() {
		return emps;
	}
	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	
	
}
