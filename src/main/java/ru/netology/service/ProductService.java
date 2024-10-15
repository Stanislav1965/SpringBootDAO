package ru.netology.service;

import org.springframework.stereotype.Repository;
import ru.netology.model.Products;
import ru.netology.repository.ProductsRepository;

import java.util.List;

@Repository
public class ProductService {
    private final ProductsRepository repository;

    public ProductService(ProductsRepository repository) {
        this.repository = repository;
    }

    public List<Products> findAll(String name) {
        return repository.findAll(name);
    }
}
