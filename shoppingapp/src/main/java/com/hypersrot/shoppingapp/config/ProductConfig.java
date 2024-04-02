package com.hypersrot.shoppingapp.config;

import com.hypersrot.shoppingapp.modals.Coupon;
import com.hypersrot.shoppingapp.modals.Order;
import com.hypersrot.shoppingapp.modals.Product;
import com.hypersrot.shoppingapp.modals.User;
import com.hypersrot.shoppingapp.repository.CouponRepo;
import com.hypersrot.shoppingapp.repository.OrderRepo;
import com.hypersrot.shoppingapp.repository.ProductRepo;
import com.hypersrot.shoppingapp.repository.UserRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class ProductConfig {
    private final ProductRepo productRepo;
    private final CouponRepo couponRepo;
    private final UserRepo userRepo;
    private final OrderRepo orderRepo;

    @Autowired
    public ProductConfig(ProductRepo productRepo, CouponRepo couponRepo, OrderRepo orderRepo, UserRepo userRepo) {
        this.productRepo = productRepo;
        this.couponRepo = couponRepo;
        this.userRepo = userRepo;
        this.orderRepo = orderRepo;
    }

    @PostConstruct
    public void init() {
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Table");
        product1.setQuantity(10000);
        product1.setPrice(1000.0);

        Coupon c1 = new Coupon();
        c1.setCode("OFF5");
        c1.setDiscount(5);


        Coupon c2 = new Coupon();
        c2.setCode("OFF10");
        c2.setDiscount(10);

        Coupon c3 = new Coupon();
        c3.setCode("OFF15");
        c3.setDiscount(15);

        Coupon c4 = new Coupon();
        c4.setCode("OFF25");
        c4.setDiscount(25);



        User user1 = new User();
        user1.setName("User1");
        User user2 = new User();
        user2.setName("User2");
        c1.setUsers(Set.of(user1,user2));
        c3.setUsers(Set.of(user2));

        Order order1 = new Order();
        order1.setProduct(product1);
        order1.setUser(user1);
        order1.setCoupon(c1);
        order1.setQuantity(5);
        order1.setCouponApplied(true);
        order1.setAmount(4750.0);
        order1.setIs_paid(false);

        Order order2 = new Order();
        order2.setProduct(product1);
        order2.setUser(user1);
        order2.setQuantity(3);
        order2.setCoupon(null);
        order2.setAmount(2850.0);
        order2.setIs_paid(false);

        Order order3 = new Order();
        order3.setProduct(product1);
        order3.setUser(user2);
        order3.setQuantity(2);
        order3.setCoupon(c1);
        order3.setCouponApplied(true);
        order3.setAmount(1900.0);
        order3.setIs_paid(false);

        Order order4 = new Order();
        order4.setProduct(product1);
        order4.setUser(user2);
        order4.setQuantity(4);
        order4.setCoupon(c3);
        order4.setCouponApplied(true);
        order4.setAmount(3800.0);
        order4.setIs_paid(false);

        productRepo.save(product1);
        couponRepo.saveAll(Arrays.asList(c1, c2, c3, c4));
        userRepo.saveAll(Arrays.asList(user1, user2));
        orderRepo.saveAll(Arrays.asList(order1, order2, order3, order4));
    }
}
