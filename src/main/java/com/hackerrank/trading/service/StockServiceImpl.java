package com.hackerrank.trading.service;

import com.hackerrank.trading.comparator.CustomStockComparator;
import com.hackerrank.trading.model.Stock;
import com.hackerrank.trading.repository.StockRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("stockService")
@Transactional
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;
    
    @Override
    public Stock getStockBySymbol(String symbol) {
        Optional<Stock> st=stockRepository.findById(symbol);
        if(st.isPresent())
        return st.get();
        return null;
    }
    
    @Override
    public List<Stock> getAllStocks() {
        List<Stock> st=stockRepository.findAll();
        Collections.sort(st,new CustomStockComparator());
        return st;
    }
}
