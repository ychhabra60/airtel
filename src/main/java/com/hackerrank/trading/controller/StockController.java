package com.hackerrank.trading.controller;

import com.hackerrank.trading.model.Stock;
import com.hackerrank.trading.service.StockService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/trading/stocks")
public class StockController {
    @Autowired
    private StockService stockService;

    @RequestMapping(value = "/{symbol}", method = RequestMethod.GET)

    public ResponseEntity getStockBySymbol(@PathVariable String symbol) {
        Stock stock=stockService.getStockBySymbol(symbol);
        if(stock!=null)
            return new ResponseEntity(stock,HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }
}
