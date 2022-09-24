package spring.dao;

import java.util.List;

import spring.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomers(Customer customer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String searchname);
}
