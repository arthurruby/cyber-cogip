package fr.cogip.cybercogip.controllers;

import fr.cogip.cybercogip.models.Customer;
import fr.cogip.cybercogip.models.Product;
import fr.cogip.cybercogip.models.User;
import fr.cogip.cybercogip.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/logout")
    public String getLogoutPage(){
        return "index";
    }

    @GetMapping("/test")
    public String getTestPage(Model model){
        return "test-page";
    }

    @GetMapping("/test2")
    @PreAuthorize("hasAnyRole('ROLE_ACCOUNTING', 'ROLE_SALES', 'ROLE_MANAGEMENT')")
    public String getTestPage2(Model model){
        return "test-page";
    }
}