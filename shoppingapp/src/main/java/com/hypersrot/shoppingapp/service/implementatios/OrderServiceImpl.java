package com.hypersrot.shoppingapp.service.implementatios;

import com.hypersrot.shoppingapp.modals.*;
import com.hypersrot.shoppingapp.repository.*;
import com.hypersrot.shoppingapp.service.OrderService;
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
    private final PaymentRepository paymentRepository;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo, UserRepo userRepo, CouponRepo couponRepo, ProductRepo productRepo, PaymentRepository paymentRepository) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
        this.couponRepo = couponRepo;
        this.productRepo = productRepo;
        this.paymentRepository = paymentRepository;
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

<<<<<<< HEAD
        Double amount = product.getPrice() - (coupon.getDiscount() * 1000)/100;
=======
        Integer amount = 1000 - (coupon.getDiscount() * 1000)/100;
>>>>>>> 58a629aba6cce99d2583d13359768c7b3bb7d53f

        Order order = new Order();
        order.setProduct(product);
        order.setUser(user);
        order.setQuantity(quantity);
        order.setCoupon(coupon);
        order.setCouponApplied(true);
        order.setAmount(amount);

        orderRepo.save(order);

        return "Order placed successfully with orderId: " + order.getId() + ", please make payment";
    }

    @Override
    public String makePayment(Integer userId, Integer orderId, Double amount) throws Exception {

        Optional<Order> orderCheck = orderRepo.findById(orderId);

        Order order = orderCheck.orElseThrow(() -> new Exception("Incorrect order id"));

        Optional<User> userCheck = userRepo.findById(userId);
        User user = userCheck.orElseThrow(() -> new Exception("Invalid UserId"));

        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setUser(user);

        if(!Objects.equals(amount, order.getAmount())) throw new Exception("Amount value is incorrect please enter correct value.");

        payment.setDescription("Amount has been paid for the order with id " + orderId + ".");

<<<<<<< HEAD
        order.setIs_paid(true);
        orderRepo.save(order);

=======
>>>>>>> 58a629aba6cce99d2583d13359768c7b3bb7d53f
        paymentRepository.save(payment);

        return payment.getDescription();
    }
}
