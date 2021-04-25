package com.accenture.pruebatiendaonline.adapter.persistence;

import com.accenture.pruebatiendaonline.adapter.persistence.crud.IProductCrudRepository;
import com.accenture.pruebatiendaonline.adapter.persistence.entity.Product;
import com.accenture.pruebatiendaonline.adapter.persistence.mapper.IProductMapper;
import com.accenture.pruebatiendaonline.domain.ProductDTO;
import com.accenture.pruebatiendaonline.domain.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    private IProductCrudRepository productCrudRepository;

    private IProductMapper mapper;

    public ProductRepositoryImpl(IProductCrudRepository productCrudRepository, IProductMapper mapper) {
        this.productCrudRepository = productCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return mapper.toProductsDTO(products);
    }

    @Override
    public Optional<List<ProductDTO>> getByCategory(int categoryId) {
        List<Product> products = productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProductsDTO(products));
    }

    @Override
    public Optional<ProductDTO> getProduct(int productId) {
        return productCrudRepository.findById(productId).map(producto -> mapper.toProductDTO(producto));
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = mapper.toProduct(productDTO);
        return mapper.toProductDTO(productCrudRepository.save(product));
    }

    @Override
    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }
}
