package fr.cogip.cybercogip;

import fr.cogip.cybercogip.data.CustomerRepository;
import fr.cogip.cybercogip.entities.Address;
import fr.cogip.cybercogip.entities.Customer;
import fr.cogip.cybercogip.entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.Callable;

@SpringBootApplication
public class CogipApplication {

	public static void main(String[] args) {
		SpringApplication.run(CogipApplication.class, args);
	}


	public CommandLineRunner demo(CustomerRepository repo) {
		return (arg) -> {

			Customer customer1 = new Customer();
			customer1.setFirstName("sando");
			customer1.setLastName("mangara");
			customer1.setEmail("sando@yahoo.fr");
			customer1.setInvoiceAddress(new Address("2 rue", "Georges clemenceaux", "3500", "France"));
			customer1.setShippingAddress(new Address("2 rue", "Georges clemenceaux", "3500", "France"));
			customer1.setPhoneNumber("9");


			// Save into DB
			repo.save(customer1);
		};


	}

}
