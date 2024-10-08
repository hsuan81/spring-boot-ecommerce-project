package com.hsuan.ecommerce.controller;

import com.hsuan.ecommerce.service.PlatBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseController {
    protected final PlatBaseInfoService platBaseInfoService;

    @Autowired
    public BaseController(PlatBaseInfoService platBaseInfoService) {
        this.platBaseInfoService = platBaseInfoService;
    }
}
