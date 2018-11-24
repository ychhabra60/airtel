package com.hackerrank.trading.service;

import com.hackerrank.trading.dto.AddMoneyTraderDTO;
import com.hackerrank.trading.dto.UpdatedTraderDTO;
import com.hackerrank.trading.model.Trader;
import java.util.List;

public interface TraderService {
    boolean deleteTraderById(Long id);
    boolean deleteTraderByEmail(String email);
    
    boolean registerTrader(Trader trader);
    
    Trader getTraderById(Long id);
    Trader getTraderByEmail(String email);
    List<Trader> getAllTraders();
    
    boolean updateTrader(UpdatedTraderDTO trader);
    boolean addMoney(AddMoneyTraderDTO trader);
}
