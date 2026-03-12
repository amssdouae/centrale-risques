package com.creditagricole.risques.service;

import com.creditagricole.risques.entity.Credit;
import com.creditagricole.risques.repository.CreditRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditService {

    private final CreditRepository creditRepository;

    public CreditService(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    public List<Credit> getAllCredits() {
        return creditRepository.findAll();
    }

    public Credit createCredit(Credit credit) {
        return creditRepository.save(credit);
    }
}