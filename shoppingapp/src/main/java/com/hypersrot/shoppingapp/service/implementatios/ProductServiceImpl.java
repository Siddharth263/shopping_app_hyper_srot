package com.hypersrot.shoppingapp.service.implementatios;

import com.hypersrot.shoppingapp.modals.Coupon;
import com.hypersrot.shoppingapp.modals.Product;
import com.hypersrot.shoppingapp.repository.ProductRepo;
import com.hypersrot.shoppingapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> showAllProducts() {
        return productRepo.findAll();
    }
}
