package com.creditagricole.risques.batch.writer;

import com.creditagricole.risques.entity.Client;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class ClientItemWriter {

    @Bean
    public FlatFileItemWriter<Client> clientWriter() {

        FlatFileItemWriter<Client> writer = new FlatFileItemWriter<>();

        writer.setResource(new FileSystemResource("clients.txt"));

        writer.setLineAggregator(client ->
                client.getTypeClient() + ";" +
                        client.getCin() + ";" +
                        client.getNom() + ";" +
                        client.getPrenom() + ";" +
                        client.getAdresse()
        );

        return writer;
    }
}