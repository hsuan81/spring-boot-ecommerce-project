package com.hsuan.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hsuan.ecommerce.common.Constant;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="CLIENT")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Pattern(regexp = "^09\\d{8}$", message = "Phone number must be 10 digits and start with '09'")
    private String phone;

    @JsonIgnore
    private String oktaUserId;
//    private String loginPassword;

    private String name;

    private String email;

    private LocalDate addTime;

    private LocalDate lastLoginTime;

    private String headerImage;

    @OneToMany(mappedBy = "user")
    private List<BidInfo> bidInfos;

    @OneToMany(mappedBy = "user")
    private List<RechargeRecord> rechargeRecords;

    @OneToMany(mappedBy = "user")
    private List<IncomeRecord> incomeRecords;

    @ElementCollection(targetClass = Constant.Role.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @NotEmpty(message = "User must have at least one role")
    private Set<Constant.Role> roles;

    public User() {
    }

    public User(String phone, String oktaUserId, String email) {
        this.phone = phone;
        this.oktaUserId = oktaUserId;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOktaUserId() {
        return oktaUserId;
    }

    public void setOktaUserId(String oktaUserId) {
        this.oktaUserId = oktaUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDate addTime) {
        this.addTime = addTime;
    }

    public LocalDate getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDate lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getHeaderImage() {
        return headerImage;
    }

    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
    }

    public @NotEmpty(message = "User must have at least one role") Set<Constant.Role> getRoles() {
        return roles;
    }

    public void setRoles(@NotEmpty(message = "User must have at least one role") Set<Constant.Role> roles) {
        this.roles = roles;
    }

}
