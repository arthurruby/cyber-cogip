package fr.cogip.cybercogip.controllers;

import java.util.List;

import javax.validation.Valid;

import fr.cogip.cybercogip.models.Product;
import fr.cogip.cybercogip.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {

        this.productRepository = productRepository;

    }
    //afficher la page general pour les produits

    @GetMapping
    public String index(Model model) {

        List<Product> products= productRepository.findAll();
        model.addAttribute("products",products);

        return "products";
    }
    //display product add form

    @GetMapping("add-product")
    public String showAddProductForm(@Valid Product product, BindingResult result, Model model) {

        return "add-product-form";
    }
    //execute save of a product
    @PostMapping("/add-product")
    public String addProduct(@Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-product-form";
        }

        productRepository.save(product);
        return "redirect:/products";
    }

   // show/ display edit/update product form

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("product", product);

        return "update-product-form";
    }
    // execute modifications of a product
    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable("id") Long id, @Valid Product product, BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            product.setId(id);
            return "update-product-form";
        }

        productRepository.save(product);
        return "redirect:/products";
    }

}
