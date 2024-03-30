package com.hypersrot.shoppingapp.service.implementatios;

import com.hypersrot.shoppingapp.modals.Coupon;
import com.hypersrot.shoppingapp.repository.CouponRepo;
import com.hypersrot.shoppingapp.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    private final CouponRepo couponRepo;

    @Autowired
    public CouponServiceImpl(CouponRepo couponRepo) {
        this.couponRepo = couponRepo;
    }

    @Override
    public List<Coupon> getAllCoupons() {
        return couponRepo.findAll();
    }
}
