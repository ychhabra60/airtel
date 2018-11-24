package com.hackerrank.trading.service;

import com.hackerrank.trading.comparator.CustomTraderComparator;
import com.hackerrank.trading.dto.AddMoneyTraderDTO;
import com.hackerrank.trading.dto.UpdatedTraderDTO;
import com.hackerrank.trading.model.Trader;
import com.hackerrank.trading.repository.TraderRepository;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("traderService")
@Transactional
public class TraderServiceImpl implements TraderService {
    @Autowired
    private TraderRepository traderRepository;
    
    @Override
    public boolean deleteTraderById(Long id) {

        if(traderRepository.findById(id)!=null)
        {traderRepository.deleteById(id);return true;}
    return false;}
    
    @Override
    public boolean deleteTraderByEmail(String email)
    {
        if(traderRepository.findByEmail(email)!=null)
        {traderRepository.deleteByEmail(email);
            return true;}
        return false;
    }


    
    @Override
    public boolean registerTrader(Trader trader) {
        {trader.setCreated_at(new Timestamp(System.currentTimeMillis()));
        if(traderRepository.findByEmail(trader.getEmail())!=null)
        {traderRepository.save(trader);
        return true;}
        return false;}

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
       List<Trader> traders=traderRepository.findAll();
       Collections.sort(traders,new CustomTraderComparator());
       return traders;
    }
    
    @Override
    public boolean updateTrader(UpdatedTraderDTO trader) {
        String name = trader.getName();
        String email = trader.getEmail();
        Optional<Trader> tr=traderRepository.findByEmail(email);
        if(tr!=null&&tr.get()!=null)
        {Trader existingTrader = tr.get();
        existingTrader.setName(name);
        existingTrader.setModified_at(new Timestamp(System.currentTimeMillis()));
        traderRepository.save(existingTrader);
        return true;
    }
    return false;}
    
    @Override
    public boolean addMoney(AddMoneyTraderDTO trader) {
        String email = trader.getEmail();
        Float amount = trader.getAmount();
        Optional<Trader> tr=traderRepository.findByEmail(email);
        if(tr!=null&&tr.get()!=null)
        {Trader existingTrader =tr.get();
        
        existingTrader.setBalance(amount + existingTrader.getBalance());
        
        traderRepository.save(existingTrader);
        return true;
    }return false;}
}
