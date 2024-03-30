package com.hypersrot.shoppingapp.service;

import com.hypersrot.shoppingapp.modals.Order;

import java.util.List;
import java.util.Set;


public interface UserService {
    Order getOrderOfUsers(Integer userId, Integer OrderId) throws Exception;
    Set<Order> getAllOrders(Integer userId) throws Exception;
}
