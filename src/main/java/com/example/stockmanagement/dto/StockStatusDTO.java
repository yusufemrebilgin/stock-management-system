package com.example.stockmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockStatusDTO {

    private double occupancyRate;
    private double occupancyRateChange;

    private int totalProductAmount;
    private double productAmountChangeRate;

    private double totalProductValue;
    private double totalProductValueChangeRate;

    private LocalDateTime updatedAt;

}
