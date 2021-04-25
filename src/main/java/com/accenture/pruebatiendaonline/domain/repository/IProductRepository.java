package com.accenture.pruebatiendaonline.domain.repository;


import com.accenture.pruebatiendaonline.domain.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {

    List<ProductDTO> getAll();
    Optional<List<ProductDTO>> getByCategory(int categoryId);
    Optional<ProductDTO> getProduct(int productId);
    ProductDTO save(ProductDTO productDTO);
    void delete(int productId);
}
