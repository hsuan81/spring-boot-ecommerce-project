package com.hsuan.ecommerce.service;

import com.hsuan.ecommerce.model.Cart;
import com.hsuan.ecommerce.model.CartItem;
import com.hsuan.ecommerce.model.User;
import com.hsuan.ecommerce.repository.CartItemRepo;
import com.hsuan.ecommerce.repository.CartRepo;
import com.hsuan.ecommerce.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class CartService {
    private CartRepo cartRepo;
    private UserRepo userRepo;
    private CartItemRepo cartItemRepo;

    public CartService() {
    }

    @Autowired
    public CartService(CartRepo cartRepo, UserRepo userRepo, CartItemRepo cartItemRepo) {
        this.cartRepo = cartRepo;
        this.userRepo = userRepo;
        this.cartItemRepo = CartService.this.cartItemRepo;
    }

    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Cart getCartById(Integer cartId) {
        return cartRepo.findById(cartId).orElse(null);
    }

    @Transactional
    public Cart createCart(Integer userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Cart cart = new Cart();
        cart.setUser(user);
        cart.setTotalPrice(0);
        cart.setItems(new ArrayList<CartItem>());
        return cartRepo.save(cart);
    }

    public void removeCartItem(Integer cartId, Integer cartItemId) {
        Cart cart = cartRepo.findById(cartId).orElseThrow(() -> new IllegalArgumentException("Cart not found"));
        CartItem cartItem = cartItemRepo.findByIdAndCartId(cartItemId, cartId)
                .orElseThrow(() -> new IllegalArgumentException("CartItem does not exist in this Cart"));

        cart.getItems().remove(cartItem);
        int totalPrice = cart.getItems().stream()
                .mapToInt(item -> item.getPrice() * item.getQuantity())
                .sum();
        cart.setTotalPrice(totalPrice);
        cartRepo.save(cart);
        cartItemRepo.delete(cartItem);
    }
}
