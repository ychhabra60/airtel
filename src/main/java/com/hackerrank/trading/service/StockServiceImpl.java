package com.hackerrank.trading.service;

import com.hackerrank.trading.model.Stock;
import com.hackerrank.trading.repository.StockRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("stockService")
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;
    
    @Override
    public Stock getStockBySymbol(String symbol) {
        return stockRepository.findById(symbol).get();
    }
    
    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
}
