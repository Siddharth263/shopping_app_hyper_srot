package com.hypersrot.shoppingapp.modals;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id")
    private Integer id;

    @OneToOne
    private User user;

    @OneToOne
    private Order order;
    private String status;
    private String description;
}
