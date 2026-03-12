package com.creditagricole.risques;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CreditRiskCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditRiskCenterApplication.class, args);
    }

}