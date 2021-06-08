package fr.cogip.cybercogip.controllers;

import fr.cogip.cybercogip.models.Customer;
import fr.cogip.cybercogip.models.Order;
import fr.cogip.cybercogip.models.User;
import fr.cogip.cybercogip.repositories.CustomerRepository;
import fr.cogip.cybercogip.repositories.OrderRepository;
import fr.cogip.cybercogip.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private CustomerRepository customerRepo;
    private UserRepository userRepo;
    OrderRepository orderRepo;

    @Autowired
    public OrderController(OrderRepository orderRepo, CustomerRepository customerRepo, UserRepository userRepo) {
        this.orderRepo = orderRepo;
        this.customerRepo = customerRepo;
        this.userRepo = userRepo;
    }

    // GET all
    @GetMapping("/list")
    public String orderList(Model model) {
        List<Order> orders = orderRepo.findAll();
        model.addAttribute("orders", orders);
        return "order/orderList";
    }

    // GET one
    @GetMapping("/{ref}")
    public String showOrderByRef(@PathVariable("ref") String reference, @ModelAttribute("order") Order order,
            Model model) {
        Order selection = orderRepo.findByReference(reference);
        model.addAttribute("order", selection);
        return "order/getOrder";
    }

    // GET add_order
    @GetMapping("/add_order")
    public String newOrder(@ModelAttribute("order") Order order, Model model) {
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        List<Customer> customers = customerRepo.findAll();
        model.addAttribute("customers", customers);
        return "order/addForm";
    }

    // POST add_order ###############" fonctionnel mais penser à faire une vérif
    @PostMapping("/add_order")
    public String addOrder(@Valid @ModelAttribute("order") Order order, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "user/user-add-form";
        }

        order.setDateOfCreation(LocalDateTime.now());
        order.setUser(userRepo.findById(order.getUser().getId()).get());
        order.setCustomer(customerRepo.findById(order.getCustomer().getId()).get());

        System.out.println("user = " + order.getUser() + "| customer = " + order.getCustomer());
        StringBuilder sb = new StringBuilder();
        sb.append(order.getCustomer().getName().substring(0, 3).toUpperCase()).append('-')
                .append(order.getUser().getUsername().substring(0, 3).toUpperCase()).append('-')
                .append(String.valueOf(order.getDateOfCreation().getYear()).substring(2));
        if (order.getDateOfCreation().getMonth().getValue() < 10) {
            sb.append('0');
        }
        sb.append(order.getDateOfCreation().getMonth().getValue());
        if (order.getDateOfCreation().getDayOfMonth() < 10) {
            sb.append('0');
        }
        sb.append(order.getDateOfCreation().getDayOfMonth());
        if (order.getDateOfCreation().getHour() < 10) {
            sb.append('0');
        }
        sb.append(order.getDateOfCreation().getHour());
        order.setReference(sb.toString());

        orderRepo.save(order);

        return "redirect:/orders/list";
    }

}
