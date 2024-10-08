package com.hsuan.ecommerce.controller;

import com.hsuan.ecommerce.common.Constant;
import com.hsuan.ecommerce.common.Util;
import com.hsuan.ecommerce.dto.response.ApiResponse;
import com.hsuan.ecommerce.model.Order;
import com.hsuan.ecommerce.model.Cart;
import com.hsuan.ecommerce.service.CartService;
import com.hsuan.ecommerce.service.OrderService;
import com.hsuan.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hsuan.ecommerce.model.User;

import java.util.List;

@RestController
public class OrderController {
    private OrderService orderService;
    private UserService userService;
    private CartService cartService;

    @Autowired
    public OrderController(OrderService orderService, UserService userService, CartService cartService) {
        this.orderService = orderService;
        this.userService = userService;
        this.cartService = cartService;
    }

    // Get all orders of a specified user
    @GetMapping("/orders/user/{userId}")
    public ResponseEntity<ApiResponse> getOrdersByUserId(@PathVariable(name = "userId") Integer userId, @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "1") Integer pageSize) {
        ApiResponse body = new ApiResponse();
        pageNo = Util.defaultPageNo(pageNo);
        pageSize = Util.defaultPageSize(pageSize);
        User user = userService.getUserById(userId);
        if (user == null) {
            body.setMsg("User not found");
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
        try {
            List<Order> orders = orderService.getOrdersByUserId(userId, pageNo, pageSize);
            body.setData(orders);
        } catch (Exception ex) {
            body.setMsg(ex.toString());
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    // Get a specified order
    @GetMapping("/orders/{orderId}")
    public ResponseEntity<ApiResponse> getOrderById(@PathVariable(name = "orderId") Integer orderId) {
        ApiResponse body = new ApiResponse();
        try {
            Order order = orderService.getOrderById(orderId);
            body.setData(order);
        } catch (Exception ex) {
            body.setMsg(ex.toString());
            return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping("/orders/user/{userId}/cart/{cartId}")
    public ResponseEntity<ApiResponse> createOrder(@PathVariable(name = "userId") Integer userId, @PathVariable(name = "cartId") Integer cartId) {
        ApiResponse body = new ApiResponse();
        User user = userService.getUserById(userId);
        Cart cart = cartService.getCartById(cartId);
        if (user == null) {
            body.setMsg("User not found");
        } else if (cart == null) {
            body.setMsg("Cart not found");
        } else {
            try {
                Order created = orderService.createOrder(userId, cartId);
                body.setData(created);
                return new ResponseEntity<>(body, HttpStatus.OK);
            } catch (Exception ex) {
                body.setMsg(ex.toString());
                return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
            }
        }
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

    }

    @PutMapping("/orders/order/{orderId}/status/{statusVal}")
    public ResponseEntity<ApiResponse> updateOrderStatus(@PathVariable(name = "orderId") Integer orderId, @PathVariable(name = "statusVal") Integer statusVal) {
        ApiResponse body = new ApiResponse();
        Order order = orderService.getOrderById(orderId);
        boolean isValidStatus = Constant.OrderStatus.isOrderStatus(statusVal);
        if (order == null) {
            body.setMsg("Order not found");
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        } else if (!isValidStatus) {
            body.setMsg("Invalid status value");
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }
        try {
            Order updated = orderService.updateOrderStatusById(orderId, statusVal);
            body.setData(updated);
            return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (Exception ex) {
            body.setMsg(ex.toString());
            return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
        }

    }

}
