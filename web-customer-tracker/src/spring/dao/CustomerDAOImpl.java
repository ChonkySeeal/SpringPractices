package spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		Session session = sessionFactory.getCurrentSession();

		Query<Customer> query = session.createQuery("from Customer", Customer.class);

		List<Customer> customers = query.getResultList();

		return customers;

	}

	@Override
	public void saveCustomers(Customer customer) {

		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(customer);

	}

	@Override
	public Customer getCustomer(int theId) {
		Session session = sessionFactory.getCurrentSession();

		Customer customer = session.get(Customer.class, theId);

		return customer;
	}

}