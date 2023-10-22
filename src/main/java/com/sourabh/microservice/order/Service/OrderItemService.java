package com.sourabh.microservice.order.Service;

import com.sourabh.microservice.order.Model.OrderItem;
import com.sourabh.microservice.order.Repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }

    public void saveOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}


