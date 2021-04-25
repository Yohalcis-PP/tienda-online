package com.accenture.pruebatiendaonline.domain.services;

import com.accenture.pruebatiendaonline.adapter.persistence.entity.Purchase;
import com.accenture.pruebatiendaonline.domain.ProductDTO;
import com.accenture.pruebatiendaonline.domain.PurchaseDTO;
import com.accenture.pruebatiendaonline.domain.PurchaseItem;

import com.accenture.pruebatiendaonline.domain.repository.IPurchaseRepository;
import com.accenture.pruebatiendaonline.domain.services.interfaces.IProductService;
import com.accenture.pruebatiendaonline.domain.services.interfaces.IPurchaseService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService implements IPurchaseService {
    private IPurchaseRepository _purchaseRepository;
    private final IProductService _productService;

    public PurchaseService(IPurchaseRepository purchaseRepository, IProductService productService) {

        _purchaseRepository = purchaseRepository;
        _productService = productService;
    }

    public List<PurchaseDTO> getAll() {
        return _purchaseRepository.getAll();
    }

    public Optional<List<PurchaseDTO>> getPurchaseByClient(String clientId) {
        return _purchaseRepository.getPurchaseByClient(clientId);
    }

    public boolean delete(int purchaseId){
        PurchaseDTO purchaseDto = _purchaseRepository.getPurchase(purchaseId).get();

        if(!isDelete(purchaseDto.getDate(), LocalDateTime.now())){//Criterios de aceptación Historia 2.3

            var clientId = purchaseDto.getClientId();
            var penalty = purchaseDto.getTotal()*0.1;

            PurchaseDTO purchaseDTO = new PurchaseDTO();
            purchaseDTO.setTotal(penalty);
            purchaseDTO.setGrandTotal(penalty);
            purchaseDTO.setClientId(clientId);
            purchaseDTO.setComment("Multa por eliminar producto despues de 12 horas de comprado");
            purchaseDTO.setActive(true);
            List<PurchaseItem> purchases = new ArrayList<>();
            purchaseDTO.setItems(purchases);

            _purchaseRepository.save(purchaseDTO);
        }

        try{
            _purchaseRepository.delete(purchaseId);
            return true;
        }catch(EmptyResultDataAccessException e){
            return false;
        }

    }

    private List<PurchaseItem> totalProduct(List<PurchaseItem> purchaseItems){
        List<PurchaseItem> purchaseItemsLocal = new ArrayList<>();

        for(PurchaseItem purchaseItem: purchaseItems) {
            var product = _productService.getProduct(purchaseItem.getProductId()).get();
            purchaseItem.setTotal(product.getPrice() * purchaseItem.getQuantity());//Se calcula el total de ese item
            purchaseItemsLocal.add(purchaseItem);//se agrega a la list de compras
        }
        return purchaseItemsLocal;
    }

    private Double totalPurchase(List<PurchaseItem> purchaseItems){
        Double totalProducs = 0.0;

        for(PurchaseItem purchaseItem: purchaseItems){
            totalProducs +=purchaseItem.getTotal();
        }

        return totalProducs;
    }
    
    //Criterios de aceptacion Historia 2.1
    private PurchaseDTO managePurchase(PurchaseDTO purchase){
        List<PurchaseItem> purchaseItems = totalProduct(purchase.getItems());

        purchase.setItems(purchaseItems);//se modifica la compra para añadir datos restantes

        //Se calcula el total de la compra
        purchase.setTotal(totalPurchase(purchase.getItems()));

        //Criterio de aceptación 1, de historia 2.1
        if(purchase.getTotal()>70000 && purchase.getTotal()<=100000){
            purchase.setIva(purchase.getTotal()*0.19);
            purchase.setDeliveryCharges(10000.0);//Valor de domicilio asumido arbitrariamente

            // Criterio de aceptación 2, de historia 2.1
        }else if(purchase.getTotal()>100000){
            purchase.setIva(purchase.getTotal()*0.19);
            purchase.setDeliveryCharges(0.0);
            //Sin cretirios claros
        }else{
            purchase.setIva(purchase.getTotal()*0.19);
            purchase.setDeliveryCharges(10000.0);
        }

        purchase.setGrandTotal(purchase.getTotal()+ purchase.getIva()+ purchase.getDeliveryCharges());

        return purchase;
    }

    //Criterios de aceptacion Historia 2.2
    private boolean isEditable(PurchaseDTO purchaseDB, PurchaseDTO purchaseWeb ){
        LocalDateTime fechaAntigua = purchaseDB.getDate();
        LocalDateTime fechaActual =  purchaseWeb.getDate();

        long years = ChronoUnit.YEARS.between(fechaAntigua, fechaActual);
        long months = ChronoUnit.MONTHS.between(fechaAntigua, fechaActual);
        long days = ChronoUnit.DAYS.between(fechaAntigua, fechaActual);
        long hours = ChronoUnit.HOURS.between(fechaAntigua, fechaActual);
        long minutes = ChronoUnit.MINUTES.between(fechaAntigua, fechaActual);
        long seconds = ChronoUnit.SECONDS.between(fechaAntigua, fechaActual);

        if(years > 0|| months >0 || days > 0 || hours > 5){
            return false;
        }else if(hours==5 && (minutes >0 || seconds >0)){
            return false;
        }else{
            var totalDB = purchaseDB.getTotal();

            var itemsWeb = totalProduct(purchaseWeb.getItems());
            var totalWeb = totalPurchase(itemsWeb);

            return (totalWeb >= totalDB);
        }

    }

    //Criterios de aceptacion Historia 2.3
    private boolean isDelete(LocalDateTime fechaAntigua, LocalDateTime fechaActual){

        long years = ChronoUnit.YEARS.between(fechaAntigua, fechaActual);
        long months = ChronoUnit.MONTHS.between(fechaAntigua, fechaActual);
        long days = ChronoUnit.DAYS.between(fechaAntigua, fechaActual);
        long hours = ChronoUnit.HOURS.between(fechaAntigua, fechaActual);
        long minutes = ChronoUnit.MINUTES.between(fechaAntigua, fechaActual);
        long seconds = ChronoUnit.SECONDS.between(fechaAntigua, fechaActual);

        if(years > 0|| months >0 || days > 0 || hours > 12){
            return false;
        }else if(hours==12 && (minutes >0 || seconds >0)){
            return false;
        }else{
            return true;
        }

    }

    public PurchaseDTO save(PurchaseDTO purchase) {
        purchase.setComment("CompraCreada");
        purchase.setActive(true);
        return _purchaseRepository.save(managePurchase(purchase));
    }


    public PurchaseDTO update(PurchaseDTO purchase) {
        PurchaseDTO purchaseDto = _purchaseRepository.getPurchase(purchase.getPurchaseId()).get();

        boolean isEdit = isEditable(purchaseDto, purchase);//Criterios de aceptacion Historia 2.2
        if(isEdit){
            purchaseDto.setComment("CompraActualizada");
            var purchaseLocal = managePurchase(purchase);
            purchaseDto.setDate(purchaseLocal.getDate());
            purchaseDto.setPaymentMethod(purchaseLocal.getPaymentMethod());
            purchaseDto.setTotal(purchaseLocal.getTotal());
            purchaseDto.setIva(purchaseLocal.getIva());
            purchaseDto.setDeliveryCharges(purchaseLocal.getDeliveryCharges());
            purchaseDto.setGrandTotal(purchaseLocal.getGrandTotal());
            purchaseDto.setItems(purchaseLocal.getItems());
            return _purchaseRepository.save(purchaseDto);
        }else{
            return null;
        }
    }
}
