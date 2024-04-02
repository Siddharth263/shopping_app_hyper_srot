package com.hypersrot.shoppingapp.service.implementatios;

import com.hypersrot.shoppingapp.exceptions.*;
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
    public String placeOrder(Integer userId, Integer quantity, String couponCode) throws ProductException, UserException, CouponException {
        Optional<Product> productCheck = productRepo.findById(1);
        Product product = productCheck.orElseThrow(() -> new ProductException("Product not found"));

        if (quantity > product.getQuantity()) throw new ProductException("Not enough quantity present");

        Optional<User> userCheck = userRepo.findById(userId);
        User user = userCheck.orElseThrow(() -> new UserException("Invalid UserId"));

        Optional<Coupon> c = couponRepo.findByCode(couponCode);
        Coupon coupon = c.orElseThrow(() -> new CouponException("Invalid Coupon Code"));
        if (user.hasAppliedCoupon(coupon))
            throw new CouponException("Coupon has already been applied by the user with id: " + userId + ", coupon used: " + couponCode);


        Double amount = product.getPrice() - (coupon.getDiscount() * 1000) / 100;

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
    public String makePayment(Integer userId, Integer orderId, Double amount) throws OrderException, UserException, PaymentException {

        Optional<Order> orderCheck = orderRepo.findById(orderId);

        Order order = orderCheck.orElseThrow(() -> new OrderException("Incorrect order id"));

        Optional<User> userCheck = userRepo.findById(userId);
        User user = userCheck.orElseThrow(() -> new UserException("Invalid UserId"));

        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setUser(user);

        if (!Objects.equals(amount, order.getAmount()))
            throw new PaymentException("Amount value is incorrect please enter correct value.");

        payment.setDescription("Amount has been paid for the order with id " + orderId + ".");

        order.setIs_paid(true);
        orderRepo.save(order);

        paymentRepository.save(payment);

        return payment.getDescription();
    }
}
