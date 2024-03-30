package com.hypersrot.shoppingapp.modals;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private Integer id;

    private String code;
    private int discount;

    @OneToMany(mappedBy = "coupon")
    private Set<Order> orders;

    @ManyToMany(mappedBy = "coupons")
    private Set<User> users;
}
