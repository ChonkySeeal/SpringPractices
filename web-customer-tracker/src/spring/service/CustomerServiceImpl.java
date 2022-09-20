package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.CustomerDAO;
import spring.entity.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public List<Customer> getCustomers() {

		return customerDAO.getCustomers();
	}

	@Override
	public void saveCustomers(Customer customer) {

		customerDAO.saveCustomers(customer);

	}

	@Override
	public Customer getCustomer(int theId) {

		return customerDAO.getCustomer(theId);
	}

	@Override
	public void deleteCustomer(int theId) {

		customerDAO.deleteCustomer(theId);
	}

	@Override
	public List<Customer> searchCustomers(String searchname) {

		return customerDAO.searchCustomers(searchname);
	}

}
