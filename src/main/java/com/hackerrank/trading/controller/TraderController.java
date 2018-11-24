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

    @RequestMapping(value = "/{email}" ,method = RequestMethod.DELETE)
    public ResponseEntity deleteTraderByEmail(@RequestParam("email") String email) {
        if(traderService.deleteTraderByEmail(email))
            return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getTraderById(@PathVariable Long id) {
        Trader trader = traderService.getTraderById(id);
        if(trader==null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(new TraderDTO(trader),HttpStatus.OK);
    }

    @RequestMapping(value = "/{email}" ,method = RequestMethod.GET)
    public ResponseEntity getTraderByEmail(@RequestParam("email") String email) {
        Trader trader = traderService.getTraderByEmail(email);
        if(trader==null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(new TraderDTO(trader),HttpStatus.OK);
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
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity addMoney(@RequestBody @Valid AddMoneyTraderDTO trader) {
        if(traderService.addMoney(trader))
            return new ResponseEntity((HttpStatus.OK));
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
