package com.hackerrank.trading.service;

import com.hackerrank.trading.dto.AddMoneyTraderDTO;
import com.hackerrank.trading.dto.UpdatedTraderDTO;
import com.hackerrank.trading.model.Trader;
import com.hackerrank.trading.repository.TraderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("traderService")
public class TraderServiceImpl implements TraderService {
    @Autowired
    private TraderRepository traderRepository;
    
    @Override
    public void deleteTraderById(Long id) {
        traderRepository.deleteById(id);
    }
    
    @Override
    public void deleteTraderByEmail(String email) {
        traderRepository.deleteByEmail(email);
    }
    
    @Override
    public void registerTrader(Trader trader) {
        traderRepository.save(trader);
    }
    
    @Override
    public Trader getTraderById(Long id) {
        return traderRepository.findById(id).get();
    }
    
    @Override
    public Trader getTraderByEmail(String email) {
        return traderRepository.findByEmail(email).orElse(new Trader());
    }
    
    @Override
    public List<Trader> getAllTraders() {
        return traderRepository.findAll();
    }
    
    @Override
    public void updateTrader(UpdatedTraderDTO trader) {
        String name = trader.getName();
        String email = trader.getEmail();
        
        Trader existingTrader = traderRepository.findByEmail(email).get();
        
        existingTrader.setName(name);
        
        traderRepository.save(existingTrader);
    }
    
    @Override
    public void addMoney(AddMoneyTraderDTO trader) {
        String email = trader.getEmail();
        Float amount = trader.getAmount();
        
        Trader existingTrader = traderRepository.findByEmail(email).get();
        
        existingTrader.setBalance(amount + existingTrader.getBalance());
        
        traderRepository.save(existingTrader);
    }
}
