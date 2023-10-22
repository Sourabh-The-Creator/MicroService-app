package com.sourabh.microservice.order.Controller;

import com.sourabh.microservice.order.Model.OrderItem;
import com.sourabh.microservice.order.Service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/{id}")
    public OrderItem getOrderItemById(@PathVariable Long id) {
        return orderItemService.getOrderItemById(id);
    }

    @PostMapping
    public void createOrderItem(@RequestBody OrderItem orderItem) {
        orderItemService.saveOrderItem(orderItem);
    }

    @PutMapping("/{id}")
    public void updateOrderItem(@PathVariable Long id, @RequestBody OrderItem orderItem) {
        orderItem.setId(id);
        orderItemService.saveOrderItem(orderItem);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
    }
}

