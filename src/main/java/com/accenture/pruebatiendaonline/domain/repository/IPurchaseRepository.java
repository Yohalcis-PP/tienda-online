package com.accenture.pruebatiendaonline.domain.repository;

import com.accenture.pruebatiendaonline.domain.PurchaseDTO;

import java.util.List;
import java.util.Optional;

public interface IPurchaseRepository {

    List<PurchaseDTO> getAll();
    Optional<PurchaseDTO> getPurchase(int purchaseId);
    Optional<List<PurchaseDTO>> getPurchaseByClient(String clientId);
    PurchaseDTO save(PurchaseDTO purchase);
    void delete(int purchaseId);

}
