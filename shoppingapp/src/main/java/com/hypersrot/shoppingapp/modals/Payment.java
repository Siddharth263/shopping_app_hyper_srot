package com.hypersrot.shoppingapp.modals;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "com.hypersrot.shoppingapp.customAnnotation.CustomIdGenerator")
    @Column(name = "transaction_id")
    private String id;

    @OneToOne
    private User user;

    @OneToOne
    private Order order;
    private String status;
    private String description;
}
