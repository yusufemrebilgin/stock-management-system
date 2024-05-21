package com.example.stockmanagement.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource("classpath:values.properties")
@ConfigurationProperties(prefix = "product")
public class ProductPricingConfig {

    @Value("${product.tax-rate}")
    private double taxRate;

    @Value("${product.profit-margin}")
    private double profitMargin;

}
