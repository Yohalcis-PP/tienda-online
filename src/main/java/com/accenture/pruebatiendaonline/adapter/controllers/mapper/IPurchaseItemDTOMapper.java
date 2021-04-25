package com.accenture.pruebatiendaonline.adapter.controllers.mapper;

import com.accenture.pruebatiendaonline.adapter.controllers.dto.PurchaseDTO_Save;
import com.accenture.pruebatiendaonline.adapter.controllers.dto.PurchaseItemDTO_Save;
import com.accenture.pruebatiendaonline.domain.PurchaseItem;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IPurchaseItemDTOMapper {

    @Mappings({
            @Mapping(source = "productId", target = "productId"),
            @Mapping(source = "quantity", target = "quantity")

    })
    PurchaseItem toPurchaseItem(PurchaseItemDTO_Save purchaseItemDTO_save);

}
