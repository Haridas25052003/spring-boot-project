package com.demo;

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
		Employee e=new Employee ();
		e.setName("haridas");
		e.setCompany("tcs");
		e.setDesignation("java develoer");
		e.setSalary(12000);
		System.out.println(ed.insertEmployee(e));
	}

}
