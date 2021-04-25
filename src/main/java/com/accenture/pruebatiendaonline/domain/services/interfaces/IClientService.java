package com.accenture.pruebatiendaonline.domain.services.interfaces;

import com.accenture.pruebatiendaonline.domain.ClientDTO;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    public List<ClientDTO> getAll();
    public Optional<ClientDTO> getClient(int clientId);
    public ClientDTO save(ClientDTO client);
    public boolean delete(int clientId);
    public ClientDTO update(ClientDTO client);
}
