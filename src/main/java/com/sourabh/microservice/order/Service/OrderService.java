package com.sourabh.microservice.order.Service;

import com.sourabh.microservice.order.Model.Order;
import com.sourabh.microservice.order.Model.OrderItem;
import com.sourabh.microservice.order.Model.Product;
import com.sourabh.microservice.order.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order saveOrder(Order order) {

        return createOrder(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public List<OrderItem> getOrderItems(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        return optionalOrder.map(Order::getOrderItems).orElse(null);
    }

    public OrderItem addOrderItem(Long orderId, OrderItem orderItem) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            orderItem.setOrder(order);
            return orderRepository.save(order).getOrderItems().get(order.getOrderItems().size() - 1);
        }
        return null;
    }

    public Order createOrder(Order order) {
        List<OrderItem> orderItems = order.getOrderItems();
        Double totalAmount=0.0;
        for (OrderItem orderItem : orderItems) {
            Long productId = orderItem.getProduct().getId();
            Product product = restTemplate.getForObject("http://localhost:8080/api/products/" + productId, Product.class);
            orderItem.setProduct(product);
            orderItem.setOrder(order);
            totalAmount+=orderItem.getQuantity()*product.getPrice();
            order.setTotalAmount(totalAmount);
        }
        return orderRepository.save(order);
    }

}
