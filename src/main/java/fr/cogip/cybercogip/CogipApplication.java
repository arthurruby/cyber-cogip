package fr.cogip.cybercogip;

import fr.cogip.cybercogip.models.*;
import fr.cogip.cybercogip.models.enums.OrderStatus;
import fr.cogip.cybercogip.models.enums.ProductStatus;
import fr.cogip.cybercogip.models.enums.Role;
import fr.cogip.cybercogip.models.enums.Vat;
import fr.cogip.cybercogip.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
public class CogipApplication {

	public static void main(String[] args) {
		SpringApplication.run(CogipApplication.class, args);
	}

	// TODO Créer des AttributeEncryptors différents avec différentes clés pour
	// chaque model
	// TODO Créer une base de données esclave pour la redondance
	// TODO Créer une fonction d'anonymisation d'un client
	// TODO Gérer le login par formulaire
	// TODO Gestion des logs

	// Uncomment just once to populate the DB with a very small sample of data
	// @Bean
	public CommandLineRunner populateDb(CustomerRepository customerRepo, AddressRepository addressRepo,
			OrderRepository orderRepo, ProductRepository productRepo, CategoryRepository categoryRepo,
			UserRepository userRepo, OrderHasProductRepository orderHasProductRepo) {
		return (arg) -> {

			Address address1 = new Address();
			address1.setAddress1("5 rue du Troubadour");
			address1.setAddress2("2e gauche");
			address1.setCity("Rennes");
			address1.setZipCode("35000");
			address1.setCountry("France");
			address1 = addressRepo.save(address1);

			Customer customer1 = new Customer();
			customer1.setName("SOFRATEC & Associés");
			customer1.setEmail("contact@sofratec.fr");
			customer1.setAddress(address1);
			customer1.setPhoneNumber("0322987405");
			customer1 = customerRepo.save(customer1);

			Category category1 = new Category();
			category1.setLabel("Bureaux");
			category1 = categoryRepo.save(category1);

			Category category2 = new Category();
			category2.setLabel("Fauteuils de bureau");
			category2 = categoryRepo.save(category2);

			Product product1 = new Product();
			product1.setName("Blörnberg");
			product1.setDescription("Un magnifique bureau d'angle suédois");
			product1.setCategory(category1);
			product1.setPrice(new BigDecimal("799.99"));
			product1.setStock(5);
			product1.setVatRate(Vat.REGULAR);
			product1.setStatus(ProductStatus.AVAILABLE);
			product1 = productRepo.save(product1);

			Product product2 = new Product();
			product2.setName("Fauteuil Recaro Sport+");
			product2.setDescription("Un fauteuil de bureau de compétition");
			product2.setCategory(category2);
			product2.setPrice(new BigDecimal("195.50"));
			product2.setStock(10);
			product2.setVatRate(Vat.REGULAR);
			product2.setStatus(ProductStatus.AVAILABLE);
			product2 = productRepo.save(product2);

			User user1 = new User();
			user1.setFirstName("Jean-Michel");
			user1.setLastName("Doudoux");
			user1.setEmail("jm.DOudoux@cogip.fr");
			user1.setUsername("dooDOo");
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2A, 31);
			user1.setPassword(passwordEncoder.encode("P@ssword!"));
			user1.setRole(Role.ADMIN);
			user1 = userRepo.save(user1);

			User user2 = new User();
			user2.setFirstName("Jean-Christian");
			user2.setLastName("Ranu");
			user2.setEmail("jc.ranu@cogip.fr");
			user2.setUsername("ranu");
			user2.setPassword(passwordEncoder.encode("P@ssword!"));
			user2.setRole(Role.ACCOUNTING);
			user2 = userRepo.save(user2);

			Order order1 = new Order();
			order1.setDateOfCreation(LocalDateTime.now());
			order1.setStatus(OrderStatus.PENDING);
			order1.setCustomer(customer1);
			order1.setUser(user1);
			order1.setReference();
			order1 = orderRepo.save(order1);

			OrderHasProduct orderHasProduct1 = new OrderHasProduct();
			orderHasProduct1.setOrder(order1);
			orderHasProduct1.setProduct(product1);
			orderHasProduct1.setPrice(product1.getPrice());
			orderHasProduct1.setQuantity(2);
			orderHasProductRepo.save(orderHasProduct1);

			OrderHasProduct orderHasProduct2 = new OrderHasProduct();
			orderHasProduct2.setOrder(order1);
			orderHasProduct2.setProduct(product2);
			orderHasProduct2.setPrice(product2.getPrice());
			orderHasProduct2.setQuantity(3);
			orderHasProductRepo.save(orderHasProduct2);
		};
	}
}
