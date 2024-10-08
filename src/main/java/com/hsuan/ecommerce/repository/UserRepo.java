package com.hsuan.ecommerce.repository;

import com.hsuan.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByPhone(String phone);
    User findByEmail(String email);
    User findByOktaUserId(String oktaUserId);
}
