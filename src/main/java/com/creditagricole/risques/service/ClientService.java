package com.creditagricole.risques.service;

import com.creditagricole.risques.entity.Client;
import com.creditagricole.risques.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client client) {
        Client existing = getClientById(id);

        existing.setNom(client.getNom());
        existing.setPrenom(client.getPrenom());
        existing.setCin(client.getCin());
        existing.setAdresse(client.getAdresse());
        existing.setTypeClient(client.getTypeClient());

        return clientRepository.save(existing);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}