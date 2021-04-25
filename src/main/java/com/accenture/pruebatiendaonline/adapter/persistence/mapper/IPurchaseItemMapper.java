package com.accenture.pruebatiendaonline.adapter.persistence.mapper;

import com.accenture.pruebatiendaonline.adapter.persistence.entity.ProductPurchase;
import com.accenture.pruebatiendaonline.domain.PurchaseItem;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IPurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.productId", target = "productId"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "total", target = "total")
    })
    PurchaseItem toPurchaseItem(ProductPurchase product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.purchaseId", ignore = true)
    })
    ProductPurchase toProductPurchase(PurchaseItem item);
}
