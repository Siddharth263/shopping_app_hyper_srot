package com.hypersrot.shoppingapp.repository;

import com.hypersrot.shoppingapp.modals.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
}
