package com.hypersrot.shoppingapp.modals;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_coupon",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "coupon_id")
    )
    private Set<Coupon> coupons;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders;

    public Boolean hasAppliedCoupon(Coupon coupon) {
        return coupons != null && coupons.contains(coupon);
    }
}
