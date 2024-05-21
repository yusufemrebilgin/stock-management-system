package com.example.stockmanagement.service;

import com.example.stockmanagement.config.ProductPricingConfig;
import com.example.stockmanagement.repository.ProductRepository;
import com.example.stockmanagement.entity.Product;
import com.example.stockmanagement.exception.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Slf4j
@Service
public class ProductService {

    private static final Random RAND = new Random();

    // Constants for product code pattern
    private static final int CATEGORY_CODE_LENGTH = 2;
    private static final int PRODUCT_NAME_CODE_LENGTH = 3;

    private final ProductRepository productRepository;
    private final ProductPricingConfig productPricingConfig;
    private final CategoryService categoryService;
    private final StockManagerService stockManagerService;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductPricingConfig productPricingConfig,
                          CategoryService categoryService, StockManagerService stockManagerService) {
        this.productRepository = productRepository;
        this.productPricingConfig = productPricingConfig;
        this.categoryService = categoryService;
        this.stockManagerService = stockManagerService;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    public void save(Product product) {
        // Given form values: id (for update form), name, category (id), quantity, cost_price
        // Required cols: id, code, name, category, quantity, cost_p, sale_p, created, modified
        LocalDateTime now = LocalDateTime.now();

        if (product.getId() == null) {
            product.setId(0L);
            product.setCode(generateUniqueProductCode(product));
            product.setCreatedAt(LocalDateTime.now());
        } else {
            Product existingProduct = findById(product.getId());
            if (!existingProduct.getName().equals(product.getName())) {
                // If the name has changed, generate a new unique product code
                product.setCode(generateUniqueProductCode(product));
            } else {
                product.setCode(existingProduct.getCode());
            }
            product.setCreatedAt(existingProduct.getCreatedAt());
        }
        product.setSalePrice(calculateSalePrice(product.getCostPrice()));
        product.setModifiedAt(now);

        stockManagerService.update(productRepository.save(product), true);
        log.info("Saved product: {}", product);
    }

    public void deleteById(Long id) {
        stockManagerService.update(findById(id), false);
        productRepository.deleteById(id);
    }

    private String generateUniqueProductCode(Product product) {
        // Code Pattern:
        // [first 2 letter of category]-[4 digit rand num]-[first 3 letter of name][2 digit rand num]
        String code;
        String categoryName = categoryService.getCategoryNameById(product.getCategory().getId());
        String categoryCode = generateCodePrefix(categoryName, CATEGORY_CODE_LENGTH);
        String productNameCode = generateCodePrefix(product.getName(), PRODUCT_NAME_CODE_LENGTH);

        do {
            String twoDigitRandom = generateRandomNumber(2);
            String threeDigitRandom = generateRandomNumber(3);
            code = String.format("%s-%s-%s%s", categoryCode, twoDigitRandom, productNameCode, threeDigitRandom);
        } while (productRepository.existsByCode(code));

        return code;
    }

    private double calculateSalePrice(double costPrice) {
        double taxRate = productPricingConfig.getTaxRate();
        double profitMargin = productPricingConfig.getProfitMargin();

        return costPrice * (1 + taxRate) * (1 + profitMargin);
    }

    private String generateCodePrefix(String input, int length) {
        return input.substring(0, Math.min(length, input.length())).toUpperCase(Locale.ENGLISH);
    }

    private String generateRandomNumber(int digit) {
        return String.format("%0" + digit + "d", RAND.nextInt((int) Math.pow(10, digit)));
    }

}
