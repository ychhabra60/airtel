package com.hackerrank.trading.comparator;

import com.hackerrank.trading.model.Trader;

import java.util.Comparator;

public class CustomTraderComparator implements Comparator<Trader> {
    public int compare(Trader a,Trader b)
    {
        if(a.getId()<b.getId())return -1;
        return 1;
    }
}
