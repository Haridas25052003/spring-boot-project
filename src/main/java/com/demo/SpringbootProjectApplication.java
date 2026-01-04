package com.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.demo.dao.EmployeeDao;
import com.demo.model.Employee;

@SpringBootApplication
public class SpringbootProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringbootProjectApplication.class, args);
		
		EmployeeDao ed=context.getBean(EmployeeDao.class);
//		Employee e=new Employee ();
//		e.setName("haridas");
//		e.setCompany("tcs");
//		e.setDesignation("java develoer");
//		e.setSalary(12000);
//		System.out.println(ed.insertEmployee(e));
		
//		System.out.println(ed.deleteEmployeeById(2));
		
//		Employee e1=ed.findEmployeeById(3);
//		System.out.println(e1);
		
//		List<Employee> list=ed.findEmployee();
//		for(Employee e1:list)
//			System.out.println(e1);
		
		Employee e=ed.findEmployeeById(3);
		e.setName("shane watson");
		System.out.println(ed.updateEmployee(e));
		
		
		
		
		
	}
}
