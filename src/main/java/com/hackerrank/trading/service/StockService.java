package com.hackerrank.trading.service;

import com.hackerrank.trading.model.Stock;
import java.util.List;

public interface StockService {
    Stock getStockBySymbol(String symbol);
    List<Stock> getAllStocks();
}
