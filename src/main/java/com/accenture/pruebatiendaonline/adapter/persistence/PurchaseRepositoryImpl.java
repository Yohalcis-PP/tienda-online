package com.accenture.pruebatiendaonline.adapter.persistence;

import com.accenture.pruebatiendaonline.adapter.persistence.crud.IPurchaseCrudRepository;
import com.accenture.pruebatiendaonline.adapter.persistence.entity.Purchase;
import com.accenture.pruebatiendaonline.adapter.persistence.mapper.IPurchaseMapper;
import com.accenture.pruebatiendaonline.domain.PurchaseDTO;
import com.accenture.pruebatiendaonline.domain.repository.IPurchaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepositoryImpl implements IPurchaseRepository {


    private IPurchaseCrudRepository purchaseCrudRepository;
    private IPurchaseMapper mapper;

    public PurchaseRepositoryImpl(IPurchaseCrudRepository purchaseCrudRepository, IPurchaseMapper mapper) {
        this.purchaseCrudRepository = purchaseCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<PurchaseDTO> getAll() {
        return mapper.toPurchasesDTO((List<Purchase>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<PurchaseDTO> getPurchase(int purchaseId) {
        return purchaseCrudRepository.findById(purchaseId).map(purchase -> mapper.toPurchaseDTO(purchase));
    }

    @Override
    public Optional<List<PurchaseDTO>> getPurchaseByClient(String clientId) {
        return purchaseCrudRepository.findByClientId(clientId)
                .map(purchases -> mapper.toPurchasesDTO(purchases));
    }

    @Override
    public PurchaseDTO save(PurchaseDTO purchaseDTO) {
        Purchase purchase = mapper.toPurchase(purchaseDTO);
        purchase.getProducts().forEach(products -> products.setPurchase(purchase));

        return mapper.toPurchaseDTO(purchaseCrudRepository.save(purchase));
    }

    @Override
    public void delete(int purchaseId) {
        purchaseCrudRepository.deleteById(purchaseId);
    }
}
