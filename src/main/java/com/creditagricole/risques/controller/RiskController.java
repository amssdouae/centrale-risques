package com.creditagricole.risques.controller;

import com.creditagricole.risques.repository.CreditRepository;
import com.creditagricole.risques.repository.PaymentIncidentRepository;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/risk")
public class RiskController {

    private final CreditRepository creditRepository;
    private final PaymentIncidentRepository PaymentincidentRepository;

    public RiskController(CreditRepository creditRepository,
                          PaymentIncidentRepository PaymentincidentRepository) {
        this.creditRepository = creditRepository;
        this.PaymentincidentRepository = PaymentincidentRepository;
    }

    @GetMapping("/{cin}")
    public Map<String,Object> getClientRisk(@PathVariable String cin){

        Map<String,Object> dashboard = new HashMap<>();

        int credits = creditRepository.findByClientCin(cin).size();
        int incidents = PaymentincidentRepository.findByCin(cin).size();

        dashboard.put("cin", cin);
        dashboard.put("credits", credits);
        dashboard.put("incidents", incidents);

        if(incidents > 2){
            dashboard.put("riskLevel","HIGH");
        }else{
            dashboard.put("riskLevel","NORMAL");
        }

        return dashboard;
    }
}