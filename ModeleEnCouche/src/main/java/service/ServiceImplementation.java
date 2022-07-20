package service;

import java.util.List;
import java.util.Optional;

import model.Customer;
import persistence.CustomerDAO;
import persistence.MemoryCustomerDAO;

public class ServiceImplementation implements CustomerService {

	private CustomerDAO dao = new MemoryCustomerDAO();

	@Override
	public void addCustomer(Customer c) {
		if (c != null && c.getName() != null) {
			dao.save(c);
		}
	}

	@Override
	public Optional<Customer> validatedCustomer(int id) {
		Optional<Customer> optCustomer = dao.findByID(id);
		optCustomer.ifPresent(c -> c.setName(c.getName().toUpperCase()));
		return optCustomer;
	}

	@Override
	public List<Customer> getAllCustomer() {
		return dao.findAll();
	}

}
