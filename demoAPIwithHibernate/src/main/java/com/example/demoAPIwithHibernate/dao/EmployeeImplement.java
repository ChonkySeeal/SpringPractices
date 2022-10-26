package com.example.demoAPIwithHibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demoAPIwithHibernate.entity.Employee;

public class EmployeeImplement implements EmployeeDAO {

	private EntityManager entitymanager;

	@Autowired
	public EmployeeImplement(EntityManager theEntitymanager) {
		Session entitymanager = theEntitymanager.unwrap(Session.class);
	}

	@Override
	public List<Employee> findAll() {
		Session current = entitymanager.unwrap(Session.class);

		Query<Employee> query = current.createQuery("from Employee", Employee.class);
		List<Employee> employees = query.getResultList();

		return employees;
	}

	@Override
	public Employee findById(int id) {
		Session current = entitymanager.unwrap(Session.class);
		Employee employee = current.get(Employee.class, id);

		return employee;
	}

	@Override
	public void save(Employee employee) {
		Session current = entitymanager.unwrap(Session.class);

		current.saveOrUpdate(employee);

	}

	@Override
	public void deleteById(int id) {
		Session current = entitymanager.unwrap(Session.class);

		Query query = current.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();

	}

}
