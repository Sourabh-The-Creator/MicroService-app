package com.sourabh.microservice.order.Model;

import jdk.jfr.DataAmount;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String contactNumber;
    private Date orderDate;
    private Double totalAmount;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<OrderItem> orderItems = new ArrayList<>();

}

