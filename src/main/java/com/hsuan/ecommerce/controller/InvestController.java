package com.hsuan.ecommerce.controller;

import com.hsuan.ecommerce.dto.response.ApiResponse;
import com.hsuan.ecommerce.dto.RankView;
import com.hsuan.ecommerce.service.BidInfoService;
import com.hsuan.ecommerce.service.InvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/invest")
public class InvestController {

    private final BidInfoService bidInfoService;
    private final InvestService investService;

    @Autowired
    public InvestController(BidInfoService bidInfoService, InvestService investService) {
        this.bidInfoService = bidInfoService;
        this.investService = investService;
    }

    @GetMapping("/rank")
    public ResponseEntity<ApiResponse> showInvestRank() {
        ApiResponse body = new ApiResponse();
        try {
            List<RankView> result = bidInfoService.queryInvestRank();
            body.setData(result);
            return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (Exception e) {
            body.setMsg(e.toString());
            return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
