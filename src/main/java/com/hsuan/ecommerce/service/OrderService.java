package com.hsuan.ecommerce.service;

import com.hsuan.ecommerce.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    public List<Order> getOrdersByUserId(Integer userId, Integer pageNo, Integer pageSize) {
    }

    public Order getOrderById(Integer orderId) {
    }

    public Order createOrder(Integer userId, Integer cartId) {
    }

    public Order updateOrderStatusById(Integer orderId, Integer statusVal) {
    }
}
