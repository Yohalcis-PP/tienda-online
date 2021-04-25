package com.accenture.pruebatiendaonline.adapter.controllers;

import com.accenture.pruebatiendaonline.domain.ClientDTO;
import com.accenture.pruebatiendaonline.domain.services.interfaces.IClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final IClientService _clientService;

    public ClientController(IClientService clientService) {
        this._clientService = clientService;
    }

    @GetMapping()
    public ResponseEntity<List<ClientDTO>> getAll() {
        return new ResponseEntity<>(_clientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable("id") int clientId) {
        return _clientService.getClient(clientId).map(clientDTO -> new ResponseEntity<>(clientDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<ClientDTO> save(@RequestBody ClientDTO client) {
        return new ResponseEntity<>(_clientService.save(client), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ClientDTO> update(@RequestBody ClientDTO client) {
        return new ResponseEntity<>(_clientService.save(client), HttpStatus.OK);
    }
}
