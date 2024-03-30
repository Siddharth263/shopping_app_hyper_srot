package com.hypersrot.shoppingapp.service;

import com.hypersrot.shoppingapp.modals.Order;

public interface OrderService {
    String placeOrder(Integer userId, Integer quantity, String coupon) throws Exception;

    String makePayment(Integer userId, Integer orderId, Double amount) throws Exception;
}
