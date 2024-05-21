package com.example.stockmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockStatus {

    @Id
    private Integer id;

    private int currentStockCapacity;

    private int previousStockCapacity;

    private int currentProductAmount;

    private int previousProductAmount;

    private double currentTotalValue;

    private double previousTotalValue;

    private double occupancyRate;

    private LocalDateTime updatedAt;

}
