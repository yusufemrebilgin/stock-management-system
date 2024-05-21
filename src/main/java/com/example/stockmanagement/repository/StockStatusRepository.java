package com.example.stockmanagement.repository;

import com.example.stockmanagement.entity.StockStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockStatusRepository extends JpaRepository<StockStatus, Integer> {


}
