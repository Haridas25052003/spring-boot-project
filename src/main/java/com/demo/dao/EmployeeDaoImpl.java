package com.demo.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.demo.model.Employee;
import com.demo.util.EmployeeRowMapper;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate j;
    
    @Override
    public int insertEmployee(Employee e) {
        String sql = "INSERT INTO employee (name, company, designation, salary) VALUES (?, ?, ?, ?)";
        return j.update(sql, e.getName(), e.getCompany(), e.getDesignation(), e.getSalary());
    }

    @Override
    public int deleteEmployeeById(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        return j.update(sql, id);
    }

    @Override
    public Employee findEmployeeById(int id) {
        String sql = "SELECT id, name, company, designation, salary FROM employee WHERE id = ?";
        // Use query to avoid EmptyResultDataAccessException if ID doesn't exist
        List<Employee> list = j.query(sql, new EmployeeRowMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<Employee> findEmployee() {
        String sql = "SELECT id, name, company, designation, salary FROM employee";
        return j.query(sql, new EmployeeRowMapper());
    }

    @Override
    public int updateEmployee(Employee e) {
        String sql = "UPDATE employee SET name = ?, company = ?, designation = ?, salary = ? WHERE id = ?";
        return j.update(sql, e.getName(), e.getCompany(), e.getDesignation(), e.getSalary(), e.getId());
    }
}