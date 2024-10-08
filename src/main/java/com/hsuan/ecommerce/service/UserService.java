package com.hsuan.ecommerce.service;

import com.hsuan.ecommerce.common.Constant;
import com.hsuan.ecommerce.dto.UserRegistration;
import com.hsuan.ecommerce.model.Profile;
import com.hsuan.ecommerce.model.User;
import com.hsuan.ecommerce.repository.ProfileRepo;
import com.hsuan.ecommerce.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserService {
    private UserRepo userRepo;
    private ProfileRepo profileRepo;

    public UserService() {
    }

    @Autowired
    public UserService(UserRepo userRepo, ProfileRepo profileRepo) {
        this.userRepo = userRepo;
        this.profileRepo = profileRepo;
    }

    public User getUserByPhone(String phone) {
        User user = userRepo.findByPhone(phone);
        return user;
    }

    public User register(UserRegistration userRegister) {
        if (userRepo.findByPhone(userRegister.getPhone()) == null) {

            User registeredUser = new User(userRegister.getEmail(), userRegister.getPassword(), userRegister.getPhone());
            userRepo.save(registeredUser);
        }
        return null;
    }

    public User getUserById(Integer userId) {
        User user = userRepo.findById(userId).orElse(null);
        return user;
    }

    public User updateRoles(Integer userId, Set<Constant.Role> roles) {
        for (Constant.Role role: roles) {
            if (!Constant.Role.isRole(role)) {
                return null;
            }
        }
        User user = userRepo.findById(userId).orElse(null);
        if (user != null) {
            user.setRoles(roles);
            return userRepo.save(user);
        }
        return null;
    }

    public Profile updatePhone(Integer userId, String phone) {
        User user = userRepo.findById(userId).orElse(null);
        if (user != null) {
            Profile profile = profileRepo.findByUserId(userId);
            profile.setPhone(phone);
            Profile updated = profileRepo.save(profile);
            return updated;
        }
        return null;
    }

    public Profile updateAddress(Integer userId, String address) {
        User user = userRepo.findById(userId).orElse(null);
        if (user != null) {
            Profile profile = profileRepo.findByUserId(userId);
            profile.setPhone(address);
            Profile updated = profileRepo.save(profile);
            return updated;
        }
        return null;
    }
}
