package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.Employee;

@Repository
public class EmployeeDao {
	
	@Autowired
	private JdbcTemplate j;
	
	public int insertEmployee(Employee e) {
		String sql="insert into employee (name ,designation,company,salary) values (?,?,?,?)";
		
		return j.update(sql,new Object[] {e.getName(),e.getCompany(),e.getDesignation(),e.getSalary()});
	}

}
