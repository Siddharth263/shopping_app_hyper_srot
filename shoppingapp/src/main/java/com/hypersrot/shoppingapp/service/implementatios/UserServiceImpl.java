package com.hypersrot.shoppingapp.service.implementatios;

import com.hypersrot.shoppingapp.exceptions.OrderException;
import com.hypersrot.shoppingapp.exceptions.UserException;
import com.hypersrot.shoppingapp.modals.Order;
import com.hypersrot.shoppingapp.modals.User;
import com.hypersrot.shoppingapp.repository.OrderRepo;
import com.hypersrot.shoppingapp.repository.UserRepo;
import com.hypersrot.shoppingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final OrderRepo orderRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, OrderRepo orderRepo) {
        this.userRepo = userRepo;
        this.orderRepo = orderRepo;
    }

    @Override
    public Order getOrderOfUsers(Integer userId, Integer orderId) throws UserException, OrderException {
        Optional<Order> orderCheck = orderRepo.findById(orderId);
        Order order = orderCheck.orElseThrow(() -> new OrderException("Invalid order id"));

        if (!Objects.equals(order.getUser().getId(), userId)) {
            throw new UserException("Order does not belong to this User.");
        }
        return order;
    }

    @Override
    public Set<Order> getAllOrders(Integer userId) throws UserException {
        List<Order> orderCheck = orderRepo.findAll();
        Set<Order> userOrders = new HashSet<>();
        for (Order order : orderCheck) {
            if (Objects.equals(order.getUser().getId(), userId)) userOrders.add(order);
        }

        if(userOrders.size() <= 0)
            throw new OrderException("No orders found for this user");

        return userOrders;
    }
}
