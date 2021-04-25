package com.accenture.pruebatiendaonline.adapter.persistence.crud;

import com.accenture.pruebatiendaonline.adapter.persistence.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface IClientCrudRepository extends CrudRepository<Client, Integer> {
}
