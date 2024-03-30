package com.hypersrot.shoppingapp.repository;

import com.hypersrot.shoppingapp.modals.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
}
