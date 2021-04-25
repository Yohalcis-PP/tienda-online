package com.accenture.pruebatiendaonline.adapter.persistence.crud;

import com.accenture.pruebatiendaonline.adapter.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IProductCrudRepository extends CrudRepository<Product, Integer> {
    List<Product> findByCategoryIdOrderByNameAsc(int categoryId);

}
