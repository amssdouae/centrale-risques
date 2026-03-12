package com.creditagricole.risques.service;

import com.creditagricole.risques.dto.ConsultationRequest;
import com.creditagricole.risques.entity.SolvencyConsultation;
import com.creditagricole.risques.repository.SolvencyConsultationRepository;
import com.creditagricole.risques.webservice.BamClient;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ConsultationService {

    private final SolvencyConsultationRepository repository;
    private final BamClient bamClient;
    private final PdfService pdfService;

    public ConsultationService(SolvencyConsultationRepository repository,
                               BamClient bamClient,
                               PdfService pdfService) {
        this.repository = repository;
        this.bamClient = bamClient;
        this.pdfService = pdfService;
    }

    public String consulterSolvabilite(ConsultationRequest consultationRequest) {

        Map<String, String> request = new HashMap<>();

        if (consultationRequest.getCin() != null) {
            request.put("cin", consultationRequest.getCin());
        }

        if (consultationRequest.getIce() != null) {
            request.put("ice", consultationRequest.getIce());
        }

        Map<String, Object> response = bamClient.consulterSolvabilite(request);

        String statut = (String) response.get("statut");
        int score = (int) response.get("score");

        SolvencyConsultation consultation = new SolvencyConsultation();

        consultation.setId(System.currentTimeMillis());
        consultation.setCin(consultationRequest.getCin());
        consultation.setIce(consultationRequest.getIce());
        consultation.setDateConsultation(new Date());
        consultation.setResultat(statut);

        repository.save(consultation);

        try {
            pdfService.generateReport(consultationRequest.getCin(), statut, score);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statut;
    }
}