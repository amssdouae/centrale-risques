package com.creditagricole.risques.controller;

import com.creditagricole.risques.dto.ConsultationRequest;
import com.creditagricole.risques.service.ConsultationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {

    private final ConsultationService service;

    public ConsultationController(ConsultationService service) {
        this.service = service;
    }

    @PostMapping
    public String consulter(@RequestBody ConsultationRequest request){

        return service.consulterSolvabilite(request);

    }
}