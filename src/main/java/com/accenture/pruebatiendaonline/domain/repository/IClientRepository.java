package com.accenture.pruebatiendaonline.domain.repository;

import com.accenture.pruebatiendaonline.domain.ClientDTO;


import java.util.List;
import java.util.Optional;

public interface IClientRepository {
    List<ClientDTO> getAll();
    Optional<ClientDTO> getClient(int clientId);
    ClientDTO save(ClientDTO clientDTO);
    void delete(int clientId);
}
