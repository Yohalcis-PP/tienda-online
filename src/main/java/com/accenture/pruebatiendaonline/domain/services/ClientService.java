package com.accenture.pruebatiendaonline.domain.services;


import com.accenture.pruebatiendaonline.domain.ClientDTO;
import com.accenture.pruebatiendaonline.domain.repository.IClientRepository;
import com.accenture.pruebatiendaonline.domain.services.interfaces.IClientService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {
    private IClientRepository _clientRepository;

    public ClientService(IClientRepository clientRepository) {
        this._clientRepository = clientRepository;
    }

    public List<ClientDTO> getAll() {
        return _clientRepository.getAll();
    }

    public Optional<ClientDTO> getClient(int clientId){
        return _clientRepository.getClient(clientId);
    }

    public ClientDTO save(ClientDTO client){
        return _clientRepository.save(client);
    }

    public boolean delete(int clientId){
        try{
            _clientRepository.delete(clientId);
            return true;
        }catch(EmptyResultDataAccessException e){
            return false;
        }
    }

    public ClientDTO update(ClientDTO client){
        return  _clientRepository.save(client);
    }

}
