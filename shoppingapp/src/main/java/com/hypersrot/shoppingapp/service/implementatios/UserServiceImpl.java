package com.hypersrot.shoppingapp.service.implementatios;

import com.hypersrot.shoppingapp.modals.Order;
import com.hypersrot.shoppingapp.modals.User;
import com.hypersrot.shoppingapp.repository.UserRepo;
import com.hypersrot.shoppingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Order getOrderOfUsers(Integer userId, Integer orderId) throws Exception {
        Optional<User> userCheck = userRepo.findById(userId);
        if (userCheck.isEmpty()) {
            throw new Exception("Incorrect User Id");
        }

        User user = userCheck.get();

        for (Order order : user.getOrders()) {
            if (order.getId().equals(orderId)) {
                return order;
            }
        }

        throw new Exception("Invalid Order Id");
    }

    @Override
    public Set<Order> getAllOrders(Integer userId) throws Exception {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new Exception("Incorrect User Id"));

        Set<Order> orders = user.getOrders();
        if (orders.isEmpty()) {
            throw new Exception("No orders found for the user");
        }

        return orders;
    }
}
