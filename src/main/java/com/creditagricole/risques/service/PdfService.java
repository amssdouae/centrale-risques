package com.creditagricole.risques.service;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

@Service
public class PdfService {

    public void generateReport(String cin, String statut, int score) throws Exception {

        PdfWriter writer = new PdfWriter("rapport_solvabilite.pdf");

        Document document = new Document(new com.itextpdf.kernel.pdf.PdfDocument(writer));

        document.add(new Paragraph("Credit Risk Center Report"));

        document.add(new Paragraph("Client CIN : " + cin));
        document.add(new Paragraph("Solvency Score : " + score));
        document.add(new Paragraph("Status : " + statut));

        document.close();
    }

}