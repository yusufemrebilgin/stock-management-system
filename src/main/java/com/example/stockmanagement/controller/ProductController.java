package com.example.stockmanagement.controller;

import com.example.stockmanagement.entity.Product;
import com.example.stockmanagement.service.CategoryService;
import com.example.stockmanagement.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {


    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/form")
    public String showProductForm(Model model) {
        if (!model.containsAttribute("product")) {
            // Creating model attribute to binding form data
            model.addAttribute("product", new Product());
        }

        model.addAttribute("categories", categoryService.findAll());

        return "forms/product-form";
    }

    @GetMapping("/update")
    public String showUpdateForm(@RequestParam Long id, Model model) {
        // Getting the product from service
        Product product = productService.findById(id);
        // Set product in the model to pre-populate the form
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.findAll());

        return "forms/product-form";
    }

    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "forms/product-form";
        }

        // Saving product to database
        productService.save(product);

        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam Long id) {
        // Deleting the product from database
        productService.deleteById(id);

        return "redirect:/";
    }

}
