package com.accenture.pruebatiendaonline.domain.services;

import com.accenture.pruebatiendaonline.domain.ProductDTO;
import com.accenture.pruebatiendaonline.domain.PurchaseItem;
import com.accenture.pruebatiendaonline.domain.repository.IProductRepository;
import com.accenture.pruebatiendaonline.domain.services.interfaces.IProductService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    private IProductRepository _productRepository;

    public ProductService(IProductRepository productRepository) {
        this._productRepository = productRepository;
    }

    public List<ProductDTO> getAll(){
     return _productRepository.getAll();
    }

    public Optional<ProductDTO> getProduct(int productId){
        return _productRepository.getProduct(productId);
    }

    public Optional<List<ProductDTO>> getProductByCategory(int categoryId){

        return _productRepository.getByCategory(categoryId);
    }

    public ProductDTO save(ProductDTO product){
        return _productRepository.save(product);
    }

    public boolean delete(int productId){
        try{
            _productRepository.delete(productId);
            return true;
        }catch(EmptyResultDataAccessException e){
            return false;
        }
    }

    public ProductDTO update(ProductDTO product){
      return  _productRepository.save(product);
    }

}
