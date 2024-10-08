package com.hsuan.ecommerce.controller;

import com.hsuan.ecommerce.common.Constant;
import com.hsuan.ecommerce.model.Profile;
import com.hsuan.ecommerce.dto.UserRegistration;
import com.hsuan.ecommerce.dto.response.ApiResponse;
import com.hsuan.ecommerce.model.User;
import com.hsuan.ecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    public ResponseEntity<ApiResponse> phoneExists(@RequestParam("phone") String phone) {
//        // validate phone format
//        ApiResponse body = new ApiResponse();
//        return new ResponseEntity<>(body, HttpStatus.OK);
//    }

    @PostMapping("/user/{userId}/update/phone")
    public ResponseEntity<ApiResponse> updateUserPhone(@PathVariable(name = "userId") Integer userId, @RequestParam("phone") String phone) {
        ApiResponse body = new ApiResponse();
        User user = userService.getUserById(userId);
        if (user != null) {
            Profile updatedProfile = userService.updatePhone(userId, phone);
            body.setData(updatedProfile);
            return new ResponseEntity<ApiResponse>(body, HttpStatus.OK);
        }
        body.setMsg("User not found.");
        return new ResponseEntity<ApiResponse>(body, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/user/{userId}/update/address")
    public ResponseEntity<ApiResponse> updateUserAddress(@PathVariable(name = "userId") Integer userId, @RequestParam("address") String address) {
        ApiResponse body = new ApiResponse();
        User user = userService.getUserById(userId);
        if (user != null) {
            Profile updatedProfile = userService.updateAddress(userId, address);
            body.setData(updatedProfile);
            return new ResponseEntity<ApiResponse>(body, HttpStatus.OK);
        }
        body.setMsg("User not found.");
        return new ResponseEntity<ApiResponse>(body, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/update/roles")
    public ResponseEntity<ApiResponse> updateUserRoles(@RequestBody Integer userId, @RequestBody Set<Constant.Role> roles) {
        ApiResponse body = new ApiResponse();
        User user = userService.getUserById(userId);
        if (user != null) {
            User updatedUser = userService.updateRoles(userId, roles);
            body.setData(updatedUser);
            return new ResponseEntity<>(body, HttpStatus.OK);
        }
        body.setMsg("User not found.");
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }


    // use auth controller to handle this
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRegistration userDTO) {
        try {
            userService.register(userDTO);
            return ResponseEntity.ok("User registered successfully");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
