package com.hypersrot.shoppingapp.repository;

import com.hypersrot.shoppingapp.modals.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
