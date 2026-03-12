package com.creditagricole.risques.batch.processor;

import com.creditagricole.risques.entity.Client;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ClientItemProcessor implements ItemProcessor<Client, Client> {

    @Override
    public Client process(Client client) {

        if(client.getNom() != null){
            client.setNom(client.getNom().toUpperCase());
        }

        return client;
    }
}