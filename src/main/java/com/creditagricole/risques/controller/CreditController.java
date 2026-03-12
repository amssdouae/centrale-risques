package com.creditagricole.risques.controller;

import com.creditagricole.risques.entity.Credit;
import com.creditagricole.risques.service.CreditService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credits")
@CrossOrigin("*")
public class CreditController {

    private final CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping
    public List<Credit> getCredits() {
        return creditService.getAllCredits();
    }

    @PostMapping
    public Credit createCredit(@RequestBody Credit credit) {
        return creditService.createCredit(credit);
    }
}