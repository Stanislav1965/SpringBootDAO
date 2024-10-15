package ru.netology.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.model.Products;
import ru.netology.service.ProductService;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products/fetch-product")
    public List<Products> findAll(@RequestParam("name") String name) {
        return service.findAll(name);
    }
}
