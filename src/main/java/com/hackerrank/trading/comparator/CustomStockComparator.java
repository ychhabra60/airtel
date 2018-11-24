package com.hackerrank.trading.comparator;

import com.hackerrank.trading.model.Stock;

import java.util.Comparator;

public class CustomStockComparator implements Comparator<Stock> {
    public int compare(Stock a,Stock b)
    {
        return a.getSymbol().compareTo(b.getSymbol());
    }
}
