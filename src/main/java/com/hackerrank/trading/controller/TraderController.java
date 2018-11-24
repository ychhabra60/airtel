package com.hackerrank.trading.controller;

import com.hackerrank.trading.dto.AddMoneyTraderDTO;
import com.hackerrank.trading.dto.TraderDTO;
import com.hackerrank.trading.dto.UpdatedTraderDTO;
import com.hackerrank.trading.model.Trader;
import com.hackerrank.trading.service.TraderService;
import java.util.List;
import static java.util.stream.Collectors.toList;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/trading/traders")
public class TraderController {
    @Autowired
    private TraderService traderService;
    
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity registerTrader(@RequestBody @Valid Trader trader) {
        if(traderService.registerTrader(trader))
            return new ResponseEntity(HttpStatus.CREATED);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTraderById(@PathVariable Long id) {
        if(traderService.deleteTraderById(id))
            return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteTraderById(@RequestParam("email") String email) {
        if(traderService.deleteTraderByEmail(email))
            return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public TraderDTO getTraderById(@PathVariable Long id) {
        return new TraderDTO(traderService.getTraderById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public TraderDTO getTraderByEmail(@RequestParam("email") String email) {
        return new TraderDTO(traderService.getTraderByEmail(email));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TraderDTO> getAllTraders() {
        return traderService.getAllTraders()
                .stream()
                .map(TraderDTO::new)
                .collect(toList());
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity updateTrader(@RequestBody @Valid UpdatedTraderDTO trader) {
        if(traderService.updateTrader(trader))
        return new ResponseEntity((HttpStatus.OK));
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity addMoney(@RequestBody @Valid AddMoneyTraderDTO trader) {
        if(traderService.addMoney(trader))
            return new ResponseEntity((HttpStatus.OK));
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
