package com.example.demoAPIwithHibernate.dao;

import java.util.List;

import com.example.demoAPIwithHibernate.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();

	public Employee findById(int id);

	public void save(Employee employee);

	public void deleteById(int id);

}
