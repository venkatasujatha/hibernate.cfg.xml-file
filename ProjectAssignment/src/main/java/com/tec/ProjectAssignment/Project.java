package com.tec.ProjectAssignment;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Project 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name="pro_id")
	private int id;
	@Column(name="pro_name")
	private String name;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="employee_project",
	joinColumns =@JoinColumn(name="pro_idd"),
	inverseJoinColumns = @JoinColumn(name="emp_idd"))
	
	private List<Employee> employees;
	
	public Project(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}
