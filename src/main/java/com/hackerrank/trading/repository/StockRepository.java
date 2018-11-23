package com.hackerrank.trading.repository;

import com.hackerrank.trading.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, String> {
}
