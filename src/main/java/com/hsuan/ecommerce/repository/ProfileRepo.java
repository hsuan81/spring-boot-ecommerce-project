package com.hsuan.ecommerce.repository;

import com.hsuan.ecommerce.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Profile, Integer> {
    Profile findByUserId(Integer userId);
}
