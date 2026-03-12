package com.creditagricole.risques.webservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "bam-service", url = "http://localhost:8080/bam")
public interface BamClient {

    @PostMapping("/solvabilite")
    Map<String, Object> consulterSolvabilite(@RequestBody Map<String, String> request);

}