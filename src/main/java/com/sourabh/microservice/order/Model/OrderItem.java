package com.sourabh.microservice.order.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "order_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "order_id")
    private Order order;

}

