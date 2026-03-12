package com.creditagricole.risques.batch.writer;

import com.creditagricole.risques.entity.Credit;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class CreditItemWriter {

    @Bean
    public FlatFileItemWriter<Credit> creditWriter() {

        FlatFileItemWriter<Credit> writer = new FlatFileItemWriter<>();

        writer.setResource(new FileSystemResource("credits.txt"));

        writer.setLineAggregator(credit ->
                credit.getId() + ";" +
                        credit.getMontant() + ";" +
                        credit.getTypeCredit() + ";" +
                        credit.getStatut()
        );

        return writer;
    }
}