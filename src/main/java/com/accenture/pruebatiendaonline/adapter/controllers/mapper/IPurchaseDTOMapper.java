package com.accenture.pruebatiendaonline.adapter.controllers.mapper;

import com.accenture.pruebatiendaonline.adapter.controllers.dto.PurchaseDTO_Save;
import com.accenture.pruebatiendaonline.adapter.controllers.dto.PurchaseDTO_Update;
import com.accenture.pruebatiendaonline.domain.PurchaseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IPurchaseItemDTOMapper.class})
public interface IPurchaseDTOMapper {
    @Mappings({
            @Mapping(source = "clientId", target = "clientId"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "paymentMethod", target = "paymentMethod"),
            @Mapping(source = "items", target = "items")
    })
    PurchaseDTO toPurchaseDTO(PurchaseDTO_Save Purchase_Save);

    @Mappings({
            @Mapping(source = "clientId", target = "clientId"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "paymentMethod", target = "paymentMethod"),
            @Mapping(source = "items", target = "items")
    })
    PurchaseDTO toPurchaseDTO(PurchaseDTO_Update Purchase_Update);
}
