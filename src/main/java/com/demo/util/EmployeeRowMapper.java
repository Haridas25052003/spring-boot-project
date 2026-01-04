package com.demo.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>{
	
	public Employee mapRow(ResultSet rs,int rowNum) throws SQLException {
		Employee e=new Employee();
		e.setId(rs.getInt("id"));
		e.setName(rs.getString("name"));
		e.setCompany(rs.getString("company"));
		e.setDesignation(rs.getString("designation"));
		e.setSalary(rs.getDouble("salary"));
		
		return e;
	}

}
