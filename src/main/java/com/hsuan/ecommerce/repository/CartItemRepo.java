package com.hsuan.ecommerce.repository;

import com.hsuan.ecommerce.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CartItemRepo extends JpaRepository<CartItem, Integer> {

    @Query("SELECT c FROM CartItem c WHERE c.id = :cartItemId AND c.cart.id = :cartId")
    Optional<CartItem> findByIdAndCartId(@Param("cartItemId") Integer cartItemId, @Param("cartId") Integer cartId);
}
