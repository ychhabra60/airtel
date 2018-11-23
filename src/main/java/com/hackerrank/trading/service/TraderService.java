package com.hackerrank.trading.service;

import com.hackerrank.trading.dto.AddMoneyTraderDTO;
import com.hackerrank.trading.dto.UpdatedTraderDTO;
import com.hackerrank.trading.model.Trader;
import java.util.List;

public interface TraderService {
    void deleteTraderById(Long id);
    void deleteTraderByEmail(String email);
    
    void registerTrader(Trader trader);
    
    Trader getTraderById(Long id);
    Trader getTraderByEmail(String email);
    List<Trader> getAllTraders();
    
    void updateTrader(UpdatedTraderDTO trader);
    void addMoney(AddMoneyTraderDTO trader);
}
