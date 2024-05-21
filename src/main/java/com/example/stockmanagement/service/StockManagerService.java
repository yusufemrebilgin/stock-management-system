package com.example.stockmanagement.service;

import com.example.stockmanagement.repository.ProductRepository;
import com.example.stockmanagement.repository.StockStatusRepository;
import com.example.stockmanagement.dto.StockStatusDTO;
import com.example.stockmanagement.entity.Product;
import com.example.stockmanagement.entity.StockStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StockManagerService  {

    @Value("${stock.id}") private int stockId;
    @Value("${stock.capacity}") private int capacity;

    private final ProductRepository productRepository;
    private final StockStatusRepository stockStatusRepository;

    @Autowired
    public StockManagerService(ProductRepository productRepository, StockStatusRepository stockStatusRepository) {
        this.productRepository = productRepository;
        this.stockStatusRepository = stockStatusRepository;
    }

    public StockStatusDTO getStockStatusDTO() {
        Optional<StockStatus> stockStatus = stockStatusRepository.findById(stockId);
        return stockStatus.map(this::convertToDTO).orElseGet(() -> convertToDTO(initialize()));
    }

    private StockStatusDTO convertToDTO(StockStatus stockStatus) {
        StockStatusDTO dto = new StockStatusDTO();
        dto.setOccupancyRate(stockStatus.getOccupancyRate());
        dto.setOccupancyRateChange(calculateOccupancyRateChange(stockStatus));
        dto.setTotalProductAmount(stockStatus.getCurrentProductAmount());
        dto.setProductAmountChangeRate(calculateProductAmountRateChange(stockStatus));
        dto.setTotalProductValue(stockStatus.getCurrentTotalValue());
        dto.setTotalProductValueChangeRate(calculateTotalProductValueChangeRate(stockStatus));
        dto.setUpdatedAt(stockStatus.getUpdatedAt());

        return dto;
    }

    private double calculateOccupancyRateChange(StockStatus stockStatus) {
        return stockStatus.getOccupancyRate() - calculateOccupancyRate(stockStatus.getPreviousProductAmount());
    }

    private double calculateProductAmountRateChange(StockStatus stockStatus) {
        int curr = stockStatus.getCurrentProductAmount();
        int prev = stockStatus.getPreviousProductAmount();

        // If previous amount is zero stock may have just been initialized
        return (prev == 0) ? 0 : (curr - prev) / (double) prev * 100;
    }

    private double calculateTotalProductValueChangeRate(StockStatus stockStatus) {
        double curr = stockStatus.getCurrentTotalValue();
        double prev = stockStatus.getPreviousTotalValue();

        return (prev == 0) ? 0 : (curr - prev) / prev * 100;
    }

    private StockStatus initialize() {
        StockStatus stockStatus;
        List<Product> products = productRepository.findAll();
        if (!products.isEmpty()) {
            int productAmount = calculateTotalAmount(products);
            double totalValue = calculateTotalValue(products);
            stockStatus = StockStatus.builder()
                    .id(stockId)
                    .currentStockCapacity(capacity)
                    .previousStockCapacity(capacity)
                    .currentProductAmount(productAmount)
                    .previousProductAmount(productAmount)
                    .currentTotalValue(totalValue)
                    .previousTotalValue(totalValue)
                    .occupancyRate(calculateOccupancyRate(productAmount))
                    .updatedAt(LocalDateTime.now())
                    .build();
        } else {
            stockStatus = StockStatus.builder().id(stockId).updatedAt(LocalDateTime.now()).build();
        }

        return stockStatusRepository.save(stockStatus);
    }

    public void update(Product product, boolean isAdding) {
        log.info("Updating stock status");
        Optional<StockStatus> stockStatus = stockStatusRepository.findById(stockId);
        if (stockStatus.isEmpty()) {
            initialize();
        } else {
            StockStatus existingStock = stockStatus.get();
            if (capacity != existingStock.getCurrentStockCapacity()) {
                existingStock.setPreviousStockCapacity(existingStock.getCurrentStockCapacity());
                existingStock.setCurrentStockCapacity(capacity);
            }

            if (product != null) {
                int currentAmount = existingStock.getCurrentProductAmount();
                existingStock.setPreviousProductAmount(currentAmount);

                double currentValue = existingStock.getCurrentTotalValue();
                existingStock.setPreviousTotalValue(currentValue);

                if (isAdding) {
                    existingStock.setCurrentProductAmount(currentAmount + product.getQuantityInStock());
                    existingStock.setCurrentTotalValue(currentValue +
                            product.getSalePrice() * product.getQuantityInStock());
                } else {
                    existingStock.setCurrentProductAmount(currentAmount - product.getQuantityInStock());
                    existingStock.setCurrentTotalValue(currentValue -
                            product.getSalePrice() * product.getQuantityInStock());
                }

                existingStock.setOccupancyRate(calculateOccupancyRate(existingStock.getCurrentProductAmount()));
                existingStock.setUpdatedAt(LocalDateTime.now());
            }
            stockStatusRepository.save(existingStock);
        }
        log.info("Updated stock status");
    }

    private int calculateTotalAmount(List<Product> products) {
        return products.stream()
                .mapToInt(Product::getQuantityInStock)
                .sum();
    }

    private double calculateTotalValue(List<Product> products) {
        return products.stream()
                .mapToDouble(p -> p.getSalePrice() * p.getQuantityInStock())
                .sum();
    }

    private double calculateOccupancyRate(int productAmount) {
        return (double) productAmount / this.capacity * 100;
    }

}
