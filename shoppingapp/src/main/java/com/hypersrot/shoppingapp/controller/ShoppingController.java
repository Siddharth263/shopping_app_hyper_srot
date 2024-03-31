package com.hypersrot.shoppingapp.controller;

import com.hypersrot.shoppingapp.modals.Coupon;
import com.hypersrot.shoppingapp.modals.Order;
import com.hypersrot.shoppingapp.modals.Product;
import com.hypersrot.shoppingapp.service.CouponService;
import com.hypersrot.shoppingapp.service.OrderService;
import com.hypersrot.shoppingapp.service.ProductService;
import com.hypersrot.shoppingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {


    private final ProductService productService;
    private final UserService userService;
    private final OrderService orderService;
    private final CouponService couponService;

    @Autowired
    public ShoppingController(ProductService productService, UserService userService, OrderService orderService, CouponService couponService) {
        this.productService = productService;
        this.userService = userService;
        this.orderService = orderService;
        this.couponService = couponService;
    }

    @GetMapping("/inventory")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.showAllProducts());
    }

    @GetMapping("/fetchCoupons")
    public ResponseEntity<List<Coupon>> getCoupons() {
        List<Coupon> coupons = couponService.getAllCoupons();
        return ResponseEntity.ok(coupons);
    }

    @GetMapping("/{userId}/orders/{ordersId}")
    public ResponseEntity<Order> getOrderOfUser(@PathVariable Integer userId, @PathVariable Integer orderId) {
        try{
            Order order = userService.getOrderOfUsers(userId, orderId);
            return ResponseEntity.ok(order);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<Set<Order> > getAllOrders(@PathVariable Integer userId) {
        try {
            Set<Order> list = userService.getAllOrders(userId);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PostMapping("/{userId}/orders")
    public ResponseEntity<String> placeOrder(@PathVariable Integer userId, @RequestParam("qty") int quantity,
                                                  @RequestParam("coupon") String coupon) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(orderService.placeOrder(userId, quantity, coupon));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @PostMapping("/{userId}/{orderId}/pay")
<<<<<<< HEAD
    public ResponseEntity<String> makePayment(@PathVariable Integer userId, @PathVariable Integer orderId, @RequestParam("amount") Double amount) {
=======
    public ResponseEntity<String> makePayment(@PathVariable Integer userId, @PathVariable Integer orderId, @RequestParam("amount") Integer amount) {
>>>>>>> 58a629aba6cce99d2583d13359768c7b3bb7d53f
        try {
            return ResponseEntity.ok(orderService.makePayment(userId, orderId, amount));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
