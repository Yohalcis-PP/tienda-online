package com.accenture.pruebatiendaonline.adapter.persistence.mapper;

import com.accenture.pruebatiendaonline.adapter.persistence.entity.Purchase;
import com.accenture.pruebatiendaonline.domain.PurchaseDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IPurchaseItemMapper.class})
public interface IPurchaseMapper {
    @Mappings({
            @Mapping(source = "purchaseId", target = "purchaseId"),
            @Mapping(source = "clientId", target = "clientId"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "paymentMethod", target = "paymentMethod"),
            @Mapping(source = "deliveryCharges", target = "deliveryCharges"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "grandTotal", target = "grandTotal"),
            @Mapping(source = "iva", target = "iva"),
            @Mapping(source = "comment", target = "comment"),
            @Mapping(source = "active", target = "active"),
            @Mapping(source = "products", target = "items")
    })
    PurchaseDTO toPurchaseDTO(Purchase Purchase);
    List<PurchaseDTO> toPurchasesDTO(List<Purchase> Purchases);
    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    Purchase toPurchase(PurchaseDTO purchaseDTO);

}
