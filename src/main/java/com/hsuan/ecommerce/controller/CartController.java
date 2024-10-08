package com.hsuan.ecommerce.controller;

import com.hsuan.ecommerce.dto.response.ApiResponse;
import com.hsuan.ecommerce.model.Cart;
import com.hsuan.ecommerce.model.CartItem;
import com.hsuan.ecommerce.service.CartItemService;
import com.hsuan.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private final CartItemService itemService;

    @Autowired
    public CartController(CartService cartService, CartItemService itemService) {
        this.cartService = cartService;
        this.itemService = itemService;
    }



    @GetMapping("/cart/{cartId}")
    public ResponseEntity<ApiResponse> getCart(@PathVariable(name = "cartId") Integer cartId) {
        ApiResponse body = new ApiResponse();
        Cart cart = cartService.getCartById(cartId);
        if (cart != null) {
            body.setData(cart);
            return new ResponseEntity<>(body, HttpStatus.OK);
        }
        body.setMsg("Cart not found");
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/cart/{userId}")
    public ResponseEntity<ApiResponse> createCart(@PathVariable(name = "userId") Integer userId) {
        ApiResponse body = new ApiResponse();
        try {
            Cart created = cartService.createCart(userId);
            body.setData(created);
            return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (Exception ex) {
            body.setMsg(ex.toString());
            return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
        }
    }

    @PutMapping("/cart/{cartId}/product/{prodId}")
    public ResponseEntity<ApiResponse> modifyCartItemAmount(@PathVariable(name = "cartId") Integer cartId, @PathVariable(name = "prodId") Integer prodId, @RequestBody Integer quantity) {
        ApiResponse body = new ApiResponse();
        Cart cart = cartService.getCartById(cartId);
        if (cart == null) {
            body.setMsg("Cart not found");
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
        CartItem item = itemService.getCartItemOfCartById(cartId, prodId);
        if (item == null) {
            body.setMsg("Cart Item not found");
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
        CartItem updatedItem = itemService.updateQuantity(item.getId(), quantity);
        body.setData(updatedItem);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @DeleteMapping("/cart/{cartId}/cartItem/{cartItemId}")
    public ResponseEntity<ApiResponse> removeCartItemFromCart(@PathVariable(name = "cartId")Integer cartId, @PathVariable(name = "cartItemId") Integer cartItemId) {
        ApiResponse body = new ApiResponse();
        // check existence of cart
        Cart cart = cartService.getCartById(cartId);
        if (cart == null) {
            body.setMsg("Cart not found");
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
        // check existence of cart item
        CartItem item = itemService.getItemById(cartItemId);
        // remove item if existing
        if (item == null) {
            body.setMsg("Cart Item not found");
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
        cartService.removeCartItem(cartId, cartItemId);
        body.setMsg("Cart item deleted");
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
