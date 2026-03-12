package com.creditagricole.risques.dto;

public class SolvencyResponse {

    private String statut;
    private double score;

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}