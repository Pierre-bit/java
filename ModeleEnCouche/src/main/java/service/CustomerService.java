package service;

import java.util.List;
import java.util.Optional;

import model.Customer;

public interface CustomerService {

	void addCustomer(Customer c);

	Optional<Customer> validatedCustomer(int id);

	List<Customer> getAllCustomer();

}
