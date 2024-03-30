package com.hypersrot.shoppingapp.repository;

import com.hypersrot.shoppingapp.modals.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepo extends JpaRepository<Coupon, Integer> {
    Coupon findByCode(String coupon);
}
