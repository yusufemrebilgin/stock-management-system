package com.example.stockmanagement.controller;

import com.example.stockmanagement.constants.TableConstants;
import com.example.stockmanagement.dto.StockStatusDTO;
import com.example.stockmanagement.entity.Product;
import com.example.stockmanagement.helper.ThymeleafFieldAccessor;
import com.example.stockmanagement.service.ProductService;
import com.example.stockmanagement.service.StockManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final ProductService productService;
    private final StockManagerService stockManagerService;
    private final ThymeleafFieldAccessor fieldAccessor;

    @Autowired
    public HomeController(ProductService productService, StockManagerService stockManagerService,
                          ThymeleafFieldAccessor fieldAccessor) {
        this.productService = productService;
        this.stockManagerService = stockManagerService;
        this.fieldAccessor = fieldAccessor;
    }

    @GetMapping("/")
    public String index(Model model) {
        // Getting products from database for data table
        List<Product> products = productService.findAll();

        // Getting stock status dto from database
        StockStatusDTO stockStatusDTO = stockManagerService.getStockStatusDTO();

        // Adding attributes to Spring model
        model.addAttribute("products", products);
        model.addAttribute("stockStatusDTO", stockStatusDTO);

        // Attributes for dynamic data-table initialization
        model.addAttribute("fieldAccessor", fieldAccessor);
        model.addAttribute("productHeaders", TableConstants.PRODUCT_HEADERS);
        model.addAttribute("productFields", TableConstants.PRODUCT_FIELDS);

        return "index";
    }

}
