package com.challenge2.Services;

import com.challenge2.Entity.Clients;
import com.challenge2.Entity.Products;
import com.challenge2.Repository.clientRepository;
import com.challenge2.Repository.productRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class clientService {
    @Autowired
    private clientRepository repository ;

    public List<Clients> getAllClients() {
        return repository.findAll();
    }

    public Clients getClientById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + id));
    }

    public Clients createClient(Clients clients) {
        return repository.save(clients);
    }

    public Clients updateClient(int id, Clients clients) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Client not found with id: " + id);
        }
        clients.setId(id);
        return repository.save(clients);
    }

    public void deleteClient(int id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Client not found with id: " + id);
        }
        repository.deleteById(id);
    }

    public byte[] generateClientReport() {
        List<Clients> clients = repository.findAll();

        String reportContent = "Sample client report content";
        return reportContent.getBytes();
    }
}
