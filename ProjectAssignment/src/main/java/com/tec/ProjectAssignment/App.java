package com.tec.ProjectAssignment;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		
		  Session session = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Project.class).buildSessionFactory().openSession();
		  org.hibernate.Transaction tc=session.beginTransaction();

		  Employee employee=new Employee(); 
		 
 		  employee.setName("sujatha"); 
		  employee.setEmail("s@gmail.com"); 
		  Employee employee1=new Employee(); 
 		  employee.setName("salman");
		  employee.setEmail("salman@gmail.com"); 
		  Employee employee2=new Employee();
 		  employee.setName("chinnu");
		  employee.setEmail("chinnu@gmail.com");
		  
		  Project project=new Project(); 
 		  project.setName("railway Management system");
		  
		  Project project1=new Project();
 		  project1.setName("library management system");
		  //assigning employees to PROJECT
		 
		  List<Employee> Employees=new ArrayList<Employee>();
		  Employees.add(employee); 
		  Employees.add(employee1);
		  Employees.add(employee2);
		  
		  //assigning employees to project1
		  List<Project> project1Employees=new ArrayList<Project>(); 
		  project1Employees.add(project);
		  project1Employees.add(project1);
 
		  employee1.setProjects(project1Employees);
		  project.setEmployees(Employees);
		  
		 
		  
		  session.save(employee); 
		  session.save(employee1); 
		  session.save(employee2);
		  
		  session.save(project); 
		  session.save(project1);
		  
		  tc.commit();
		  
		  session.close();
		
      
    }
}
