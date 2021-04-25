package com.accenture.pruebatiendaonline.adapter.controllers;

import com.accenture.pruebatiendaonline.domain.ProductDTO;
import com.accenture.pruebatiendaonline.domain.services.interfaces.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/product")
public class ProductController {

    private final IProductService _productService;

    public ProductController(IProductService productService) {
        this._productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getAll() {
        return new ResponseEntity<>(_productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable("id") int productId) {
        return _productService.getProduct(productId).map(productDTO -> new ResponseEntity<>(productDTO, HttpStatus.OK))
                                                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductDTO>> getByCategory(@PathVariable("id") int id) {

        final Optional<List<ProductDTO>> products = _productService.getProductByCategory(id);

        if(products.isPresent() && !products.get().isEmpty()){
            return new ResponseEntity<>(products.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO product) {
        return new ResponseEntity<>(_productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId) {
         if(_productService.delete(productId)){
             return new ResponseEntity(HttpStatus.OK);
        }else{
             return new ResponseEntity(HttpStatus.NOT_FOUND);
         }
    }

    @PutMapping
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO product) {
        return new ResponseEntity<>(_productService.save(product), HttpStatus.OK);
    }
}
