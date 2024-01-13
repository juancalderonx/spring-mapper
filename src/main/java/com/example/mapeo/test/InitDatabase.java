package com.example.mapeo.test;

import com.example.mapeo.dto.GetProduct;
import com.example.mapeo.entity.Product;
import com.example.mapeo.mapper.ProductMapper;
import com.example.mapeo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitDatabase {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public InitDatabase(
            ProductRepository productRepository,
            ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Bean
    public CommandLineRunner testProductMapperCommand() {
        return args -> {
            List<Product> products = productRepository.findAll();

            System.out.println("PRODUCTS");
            products.forEach(System.out::println);

            System.out.println("GET PRODUCTS DTO");
            List<GetProduct> productsDto = productMapper.toGetProducts(products);
            productsDto.forEach(System.out::println);

            System.out.println("MAPPED PRODUCTS");
            List<Product> mappedProducts = productMapper.toEntities(productsDto);
            mappedProducts.forEach(System.out::println);
        };
    }
}
