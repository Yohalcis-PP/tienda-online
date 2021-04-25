package com.accenture.pruebatiendaonline.domain.services.interfaces;

import com.accenture.pruebatiendaonline.domain.ProductDTO;
import com.accenture.pruebatiendaonline.domain.PurchaseItem;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    public Optional<ProductDTO> getProduct(int productId);
    public List<ProductDTO> getAll();
    public Optional<List<ProductDTO>> getProductByCategory(int categoryId);
    public ProductDTO save(ProductDTO product);
    public boolean delete(int productId);
    public ProductDTO update(ProductDTO product);
}
