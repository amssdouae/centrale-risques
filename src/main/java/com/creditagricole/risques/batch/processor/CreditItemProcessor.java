package com.creditagricole.risques.batch.processor;

import com.creditagricole.risques.entity.Credit;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CreditItemProcessor implements ItemProcessor<Credit, Credit> {

    @Override
    public Credit process(Credit credit) {

        if(credit.getMontant() <= 0){
            return null;
        }

        return credit;
    }
}