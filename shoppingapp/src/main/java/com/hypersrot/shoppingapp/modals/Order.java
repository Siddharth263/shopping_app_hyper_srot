package com.hypersrot.shoppingapp.modals;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;
    private Boolean couponApplied;
<<<<<<< HEAD
    private Double amount;
    private Boolean is_paid = false;
=======
    private Integer amount;
>>>>>>> 58a629aba6cce99d2583d13359768c7b3bb7d53f


    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
