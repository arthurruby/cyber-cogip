<<<<<<< HEAD
package fr.cogip.cybercogip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @RequestMapping("/hello")
    public @ResponseBody String greeting() {
        return "Hello, World";
    }
}
=======
package fr.cogip.cybercogip.controllers;

import fr.cogip.cybercogip.models.Customer;
import fr.cogip.cybercogip.models.Product;
import fr.cogip.cybercogip.models.User;
import fr.cogip.cybercogip.repositories.*;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    private final UserRepository userRepository;
    private final CustomerRepository customerRepo;
    private final AddressRepository addressRepo;
    private final OrderRepository orderRepo;
    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;
    private final OrderHasProductRepository orderHasProductRepo;

    @Autowired
    public MainController(UserRepository userRepository, CustomerRepository customerRepo,
                          AddressRepository addressRepo, OrderRepository orderRepo, ProductRepository productRepo,
                          CategoryRepository categoryRepo, OrderHasProductRepository orderHasProductRepo) {
        this.userRepository = userRepository;
        this.customerRepo = customerRepo;
        this.addressRepo = addressRepo;
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
        this.orderHasProductRepo = orderHasProductRepo;
    }

    @GetMapping
    public String index(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);

        List<Customer> customers = customerRepo.findAll();
        model.addAttribute("customers", customers);

        List<Product> products = productRepo.findAll();
        model.addAttribute("products", products);

        return "index";
    }
}
>>>>>>> ab60738ea11d89979d064d7eda2d11c17eeeb60c
