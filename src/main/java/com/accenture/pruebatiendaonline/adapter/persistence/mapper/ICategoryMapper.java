package com.accenture.pruebatiendaonline.adapter.persistence.mapper;

import com.accenture.pruebatiendaonline.adapter.persistence.entity.Category;
import com.accenture.pruebatiendaonline.domain.CategoryDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ICategoryMapper {
    @Mappings({
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "description", target = "category")
    })
    CategoryDTO toCategory(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategory(CategoryDTO categoryDTO);

}
