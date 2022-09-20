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

	@Override
	public void deleteCustomer(int theId) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("delete from Customer where id =:id");
		query.setParameter("id", theId);
		query.executeUpdate();

	}

	@Override
	public List<Customer> searchCustomers(String searchname) {

		Session session = sessionFactory.getCurrentSession();

		Query query = null;

		if (searchname != null && searchname.trim().length() > 0) {
			query = session.createQuery("from Customer where lower(firstName) like :name or lower(lastName) like :name",
					Customer.class);
			query.setParameter("name", "%" + searchname.toLowerCase() + "%");
		} else {
			query = session.createQuery("from Customer", Customer.class);
		}

		List<Customer> customers = query.getResultList();

		return customers;
	}

}
