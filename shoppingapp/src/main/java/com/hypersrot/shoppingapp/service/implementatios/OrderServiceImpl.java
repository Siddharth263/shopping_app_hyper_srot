package com.hypersrot.shoppingapp.service.implementatios;

import com.hypersrot.shoppingapp.modals.Coupon;
import com.hypersrot.shoppingapp.modals.Order;
import com.hypersrot.shoppingapp.modals.Product;
import com.hypersrot.shoppingapp.modals.User;
import com.hypersrot.shoppingapp.repository.CouponRepo;
import com.hypersrot.shoppingapp.repository.OrderRepo;
import com.hypersrot.shoppingapp.repository.ProductRepo;
import com.hypersrot.shoppingapp.repository.UserRepo;
import com.hypersrot.shoppingapp.service.OrderService;
import com.hypersrot.shoppingapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;
    private final UserRepo userRepo;
    private final CouponRepo couponRepo;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo, UserRepo userRepo, CouponRepo couponRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
        this.couponRepo = couponRepo;
        this.productRepo = productRepo;
    }

    @Override
    public String placeOrder(Integer userId, Integer quantity, String couponCode) throws Exception {
        Optional<Product> productCheck = productRepo.findById(1);
        Product product = productCheck.orElseThrow(() -> new Exception("Product not found"));

        if (quantity > product.getQuantity()) throw new Exception("Not enough quantity present");

        Optional<User> userCheck = userRepo.findById(userId);
        User user = userCheck.orElseThrow(() -> new Exception("Invalid UserId"));

        Coupon coupon = couponRepo.findByCode(couponCode);
        if (user.hasAppliedCoupon(coupon))
            throw new Exception("Coupon has already been applied by the user with id: " + userId + ", coupon used: " + couponCode);

        Order order = new Order();

        order.setProduct(product);
        order.setUser(user);
        order.setQuantity(quantity);
        order.setCoupon(coupon);
        order.setCouponApplied(true);

        orderRepo.save(order);

        return "Order placed successfully with orderId: " + order.getId() + ", please make payment";
    }

    @Override
    public String makePayment(Integer userId, Integer orderId, Integer amount) throws Exception {
        Integer finalAmount;
        Optional<Order> orderCheck = orderRepo.findById(orderId);

        Order order = orderCheck.orElseThrow(() -> new Exception("Incorrect order id"));

        Optional<User> userCheck = userRepo.findById(userId);
        User user = userCheck.orElseThrow(() -> new Exception("Invalid UserId"));

        if(order.getCouponApplied()) {
            Integer dis = order.getCoupon().getDiscount();
            finalAmount = amount - (dis * amount)/100;
        } else finalAmount = amount;



    }
}
