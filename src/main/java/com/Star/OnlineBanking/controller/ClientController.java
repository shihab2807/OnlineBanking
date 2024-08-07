package com.Star.OnlineBanking.controller;

import com.Star.OnlineBanking.entity.Client;
import com.Star.OnlineBanking.entity.Email;
import com.Star.OnlineBanking.entity.Phone;
import com.Star.OnlineBanking.service.ClientService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public Client createClient(@Valid @RequestBody Client client) {
        return clientService.createClient(client);
    }

    @GetMapping("/username/{username}")
    public Client getClientByUsername(@PathVariable String username) {
        return clientService.findByUsername(username);
    }

    @PostMapping("/{clientId}/phones")
    public Client addPhone(@PathVariable Long clientId, @Valid @RequestBody Phone phone) {
        return clientService.addPhone(clientId, phone);
    }

    @PutMapping("/{clientId}/phones/{phoneId}")
    public Client updatePhone(@PathVariable Long clientId, @PathVariable Long phoneId, @Valid @RequestBody Phone newPhone) {
        return clientService.updatePhone(clientId, phoneId, newPhone);
    }

    @DeleteMapping("/{clientId}/phones/{phoneId}")
    public Client deletePhone(@PathVariable Long clientId, @PathVariable Long phoneId) {
        return clientService.deletePhone(clientId, phoneId);
    }

    @PostMapping("/{clientId}/emails")
    public Client addEmail(@PathVariable Long clientId, @Valid @RequestBody Email email) {
        return clientService.addEmail(clientId, email);
    }

    @PutMapping("/{clientId}/emails/{emailId}")
    public Client updateEmail(@PathVariable Long clientId, @PathVariable Long emailId, @Valid @RequestBody Email newEmail) {
        return clientService.updateEmail(clientId, emailId, newEmail);
    }

    @DeleteMapping("/{clientId}/emails/{emailId}")
    public Client deleteEmail(@PathVariable Long clientId, @PathVariable Long emailId) {
        return clientService.deleteEmail(clientId, emailId);
    }
}
