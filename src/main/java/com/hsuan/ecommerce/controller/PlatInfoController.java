package com.hsuan.ecommerce.controller;

import com.hsuan.ecommerce.dto.response.BaseInfoResponse;
import com.hsuan.ecommerce.service.PlatBaseInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PlatInfoController extends BaseController {


    public PlatInfoController(PlatBaseInfoService platBaseInfoService) {
        super(platBaseInfoService);
    }

    @GetMapping("/plat/info")
    public ResponseEntity<BaseInfoResponse> getPlatBaseInfo() {
        BaseInfoResponse baseInfoResponse = platBaseInfoService.getPlantBaseInfo();
        return ResponseEntity.ok(baseInfoResponse);
    }

    @RequestMapping("/about")
    public String about() {
        return "About the Spring boot project!";
    }
}
