package com.hsuan.ecommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserRegistration {
    @NotNull(message = "Phone number cannot be null")
    @Pattern(regexp = "^09\\d{8}$", message = "Phone number must be 10 digits and start with '09'")
    private String phone;

    @NotNull(message = "Password is required")
    private String password;

    @NotNull(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    public UserRegistration() {
    }

    public @NotNull(message = "Phone number cannot be null") @Pattern(regexp = "^09\\d{8}$", message = "Phone number must be 10 digits and start with '09'") String getPhone() {
        return phone;
    }

    public void setPhone(@NotNull(message = "Phone number cannot be null") @Pattern(regexp = "^09\\d{8}$", message = "Phone number must be 10 digits and start with '09'") String phone) {
        this.phone = phone;
    }

    public @NotNull(message = "Password is required") String getPassword() {
        return password;
    }

    public void setPassword(@NotNull(message = "Password is required") String password) {
        this.password = password;
    }

    public @NotNull(message = "Email is required") @Email(message = "Invalid email format") String getEmail() {
        return email;
    }

    public void setEmail(@NotNull(message = "Email is required") @Email(message = "Invalid email format") String email) {
        this.email = email;
    }
}
