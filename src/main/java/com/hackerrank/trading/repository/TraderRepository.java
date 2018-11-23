package com.hackerrank.trading.repository;

import com.hackerrank.trading.model.Trader;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraderRepository extends JpaRepository<Trader, Long> {
    Long deleteByEmail(String email);
    
    Boolean existsByEmail(String email);
    
    Optional<Trader> findByEmail(String email);
}
