package com.hypersrot.shoppingapp.config;

import com.hypersrot.shoppingapp.modals.Product;
import com.hypersrot.shoppingapp.repository.ProductRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {
    private final ProductRepo productRepo;

    @Autowired
    public ProductConfig(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @PostConstruct
    public void init() {
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Table");
        product1.setQuantity(10000);
        product1.setPrice(1000.0);

        productRepo.save(product1);
    }
}
