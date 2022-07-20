package persistence;

import java.util.List;
import java.util.Optional;

import model.Customer;

public interface CustomerDAO {

	void save(Customer c);

	Optional<Customer> findByID(int id);

	void delete(int id);

	List<Customer> findAll();

}
