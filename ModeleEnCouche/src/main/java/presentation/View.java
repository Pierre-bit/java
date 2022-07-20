package presentation;

import java.util.List;

import model.Customer;
import service.CustomerService;
import service.ServiceImplementation;

public class View {

	public static void main(String[] args) {

		CustomerService service = new ServiceImplementation();

		Customer cus1 = new Customer("batman");
		Customer cus2 = new Customer("Robin");
		Customer cus3 = new Customer("joker");
		Customer cus4 = new Customer("joker");
		Customer cus5 = new Customer("joker");
		Customer cus6 = new Customer("joker");
		Customer cus7 = new Customer("joker");
		Customer cus8 = new Customer("joker");
		Customer cus9 = new Customer(null);

		service.addCustomer(cus1);
		service.addCustomer(cus2);
		service.addCustomer(cus3);
		service.addCustomer(cus4);
		service.addCustomer(cus5);
		service.addCustomer(cus6);
		service.addCustomer(cus7);
		service.addCustomer(cus8);
		service.addCustomer(cus9);
		
		List<Customer> allCustomer = service.getAllCustomer();
		
		
		allCustomer.forEach(c -> System.out.println(service.validatedCustomer(c.getId())));
		
//		service.validatedCustomer(2).ifPresent(c -> System.out.println(c));
		for (int i=0 ; i<=allCustomer.size(); i++)
		{
			service.validatedCustomer(i).ifPresent(c -> System.out.println(c));
		}
		//service.validatedCustomer().ifPresent(c -> System.out.println(c));
		System.out.println(service.validatedCustomer(80).isPresent());
		
	}

}
