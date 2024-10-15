package ru.netology;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.netology.model.Products;
import ru.netology.repository.ProductsRepository;

import java.util.List;

@SpringBootApplication
public class SpringBootDAOApplication implements CommandLineRunner {
    private final ProductsRepository productsRepository;

    public SpringBootDAOApplication(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDAOApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println();
        List<Products> productsList = productsRepository.findAll("alexey");
        for (Products product : productsList) {
            System.out.println(product.getName());
        }
    }
}
