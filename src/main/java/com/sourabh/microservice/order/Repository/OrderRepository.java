package com.sourabh.microservice.order.Repository;

import com.sourabh.microservice.order.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderRepository extends JpaRepository<Order, Long> {
}