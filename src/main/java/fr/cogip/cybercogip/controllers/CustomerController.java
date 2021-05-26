package fr.cogip.cybercogip.controllers;

import fr.cogip.cybercogip.data.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customperRepo;
    @GetMapping ("/customers")
    public String getAllCustomers(Model model){

        return "customers";
    }
    @GetMapping("/addCustomerForm")
    public String addCustomer(Model model){
        return "addCustomerForm";
    }
    @RequestMapping("/modifyCustomerForm")
    public String modifyCustomer(Model model){
        return "modifyCustomerForm";
    }
}
