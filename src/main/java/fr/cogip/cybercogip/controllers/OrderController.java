package fr.cogip.cybercogip.controllers;

import fr.cogip.cybercogip.models.Order;
import fr.cogip.cybercogip.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    OrderRepository orderRepo;

    @Autowired
    public OrderController(OrderRepository orderRepo) {
    this.orderRepo = orderRepo;
    }

    //GET all
    @GetMapping("/list")
    public String orderList(Model model){
        List<Order> orders = orderRepo.findAll();
        model.addAttribute("orders", orders);
        return "order/orderList";
    }
    //GET one
    @GetMapping("/{ref}")
    public String showOrderByRef(@PathVariable("ref") String reference,
                                 @ModelAttribute("order") Order order,
                                 Model model) {
        Order selection = orderRepo.findByReference(reference);
        model.addAttribute("order", selection);
        return "order/getOrder";
    }

    // GET add_order
    @GetMapping("/add_order")
    public String newOrder(@ModelAttribute("order") Order order){
        return "order/addForm";
    }


    //POST add_order  ###############" non fonctionnel
    @PostMapping("/add_order")
    public String addOrder(@Valid @ModelAttribute("order") Order order, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/orders/add_order";
        }
        orderRepo.save(order);
        return "redirect:/orders/list";
    }

}

