package com.accenture.pruebatiendaonline.adapter.persistence;

import com.accenture.pruebatiendaonline.adapter.persistence.crud.IClientCrudRepository;
import com.accenture.pruebatiendaonline.adapter.persistence.entity.Client;
import com.accenture.pruebatiendaonline.adapter.persistence.mapper.IClientMapper;
import com.accenture.pruebatiendaonline.domain.ClientDTO;
import com.accenture.pruebatiendaonline.domain.repository.IClientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepositoryImpl implements IClientRepository {
    private IClientCrudRepository clientCrudRepository;
    private IClientMapper mapper;

    public ClientRepositoryImpl(IClientCrudRepository clientCrudRepository, IClientMapper mapper) {
        this.clientCrudRepository = clientCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ClientDTO> getAll() {
        List<Client> Clients = (List<Client>) clientCrudRepository.findAll();
        return mapper.toClientsDTO(Clients);
    }

    @Override
    public Optional<ClientDTO> getClient(int clientId) {
       return clientCrudRepository.findById(clientId).map(client -> mapper.toClientDTO(client));
    }

    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        Client client = mapper.toClient(clientDTO);
        return mapper.toClientDTO(clientCrudRepository.save(client));
    }

    @Override
    public void delete(int clientId) {
        clientCrudRepository.deleteById(clientId);
    }
}
