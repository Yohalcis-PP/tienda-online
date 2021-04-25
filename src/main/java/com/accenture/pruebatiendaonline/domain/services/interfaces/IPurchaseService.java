package com.accenture.pruebatiendaonline.domain.services.interfaces;

import com.accenture.pruebatiendaonline.domain.PurchaseDTO;

import java.util.List;
import java.util.Optional;

public interface IPurchaseService {
    public List<PurchaseDTO> getAll();
    public Optional<List<PurchaseDTO>> getPurchaseByClient(String clientId);
    public boolean delete(int purchaseId);
    public PurchaseDTO save(PurchaseDTO purchase);
    public PurchaseDTO update(PurchaseDTO purchase);
}
