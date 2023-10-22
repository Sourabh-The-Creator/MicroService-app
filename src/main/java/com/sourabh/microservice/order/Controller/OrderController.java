package com.sourabh.microservice.order.Controller;

import com.sourabh.microservice.order.Model.Order;
import com.sourabh.microservice.order.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping(value = "/place-order")
    public void createOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
    }

    @PutMapping("/update/{id}")
    public void updateOrder(@PathVariable Long id, @RequestBody Order order) {
        Order existingOrder = orderService.getOrderById(id);
        if (existingOrder != null) {
            order.setId(id);
            orderService.saveOrder(order);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}


