package fr.cogip.cybercogip.controllers;

import java.util.List;

import javax.validation.Valid;

import org.aspectj.apache.bcel.generic.ClassGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    model.addAttribute("customers", customers);

    return "customers";
  }

  @GetMapping("/edit/{id}")
  public String showUpdateForm(@PathVariable("id") long id, Model model) {

    Customer customer = customerRepo.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    model.addAttribute("customer", customer);

    return "editCustomerForm";
  }

  @PostMapping("/addcustomer")
  public String addUser(@Valid Customer customer, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "addCustomerForm";
    }

    customerRepo.save(customer);
    return "redirect:/customers";
  }

  @GetMapping("/addcustomer")
  public String showAddCustomerForm(@Valid Customer customer, BindingResult result, Model model) {

    return "addCustomerForm";
  }

  @GetMapping("/{id}/orders")
  public String showListOrdersForOneCustomer(@PathVariable("id") long id, @Valid Customer customer,
      BindingResult result, Model model) {

    return "ordersListByCustomer";
  }

  @PostMapping("/update/{id}")
  public String updateCustomer(@PathVariable("id") long id, @Valid Customer customer, BindingResult result,
      Model model) {
    if (result.hasErrors()) {
      model.addAttribute("errors", result.getAllErrors());
      customer.setId(id);
      return "editCustomerForm";
    }

    customerRepo.save(customer);
    return "redirect:/customers";
  }

}
