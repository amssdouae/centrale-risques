package com.creditagricole.risques.webservice;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/bam")
public class BamController {

    @PostMapping("/solvabilite")
    public Map<String, Object> getSolvabilite(@RequestBody Map<String, String> request){

        int score = 100;

        int incidents = new Random().nextInt(3);
        int credits = new Random().nextInt(5);
        int montantTotal = new Random().nextInt(300000);

        score -= incidents * 20;

        if(montantTotal > 200000){
            score -= 10;
        }

        score -= credits * 5;

        if(score < 0){
            score = 0;
        }

        String statut;

        if(score > 60){
            statut = "SOLVABLE";
        }else{
            statut = "RISKY";
        }

        Map<String, Object> response = new HashMap<>();

        response.put("score", score);
        response.put("statut", statut);
        response.put("incidents", incidents);
        response.put("credits", credits);

        return response;
    }

}