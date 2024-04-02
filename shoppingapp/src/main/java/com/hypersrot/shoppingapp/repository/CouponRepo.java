package com.hypersrot.shoppingapp.repository;

import com.hypersrot.shoppingapp.modals.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CouponRepo extends JpaRepository<Coupon, Integer> {
    Optional<Coupon> findByCode(String coupon);
}
