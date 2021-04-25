package com.accenture.pruebatiendaonline.adapter.persistence.crud;

import com.accenture.pruebatiendaonline.adapter.persistence.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IPurchaseCrudRepository extends CrudRepository<Purchase, Integer> {
    Optional<List<Purchase>> findByClientId(String clientId);
}
