package fr.cogip.cybercogip.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.cogip.cybercogip.models.Customer;
import fr.cogip.cybercogip.repositories.CustomerRepository;

@Controller
@RequestMapping("/customers")
public class CustomerController {

  private final CustomerRepository customerRepo;

  @Autowired
  public CustomerController(CustomerRepository customerRepo) {

    this.customerRepo = customerRepo;

  }

  @GetMapping
  public String index(Model model) {

    List<Customer> customers = customerRepo.findAll();
    model.addAttribute("customersList", customers);

    return "customersList";
  }
}
