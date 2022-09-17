package spring.service;

import java.util.List;

import spring.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomers(Customer customer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
}
