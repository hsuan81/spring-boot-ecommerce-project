package com.hsuan.ecommerce.common;

public class Constant {

    public enum OrderStatus {
        CREATED(0), PAID(1), DELIVERED(2), COMPLETED(3), CANCELED(4);

        private final int value;

        OrderStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static OrderStatus fromValue(int value) {
            for (OrderStatus status : OrderStatus.values()) {
                if (status.value == value) {
                    return status;
                }
            }
            throw new IllegalArgumentException("Invalid value: " + value);
        }

        public static boolean isOrderStatus(Integer statusVal) {
            try {
                OrderStatus.fromValue(statusVal);
                return true;
            } catch (IllegalArgumentException e) {
                return false;
            }
        }

    }

    public enum Role {
        ADMIN(0), USER(1);

        private final int value;

        Role(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Role fromValue(int value) {
            for (Role role : Role.values()) {
                if (role.value == value) {
                    return role;
                }
            }
            throw new IllegalArgumentException("Invalid value: " + value);
        }

        public static boolean isRole(Role role) {
            int value = role.getValue();
            try {
                Role.fromValue(value);
                return true;
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
    }

    public enum ProductType {
        NEWCOMER(0), CHOICE(1), RETAIL(2);

        private final int value;

        ProductType(int value) {
            this.value = value;
        }

        // Getter method to retrieve the integer value associated with the enum constant
        public int getValue() {
            return value;
        }

        // Optional: You can add a static method to get the enum constant from the integer value
        public static ProductType fromValue(int value) {
            for (ProductType type : ProductType.values()) {
                if (type.value == value) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Invalid value: " + value);
        }

        public static boolean isProductType(Integer type) {
            try {
                ProductType.fromValue(type);
                return true;
            } catch (IllegalArgumentException e) {
                return false;
            }
        }



    }
}
