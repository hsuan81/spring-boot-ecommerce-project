package com.hsuan.ecommerce.controller;

import com.hsuan.ecommerce.common.Constant;
import com.hsuan.ecommerce.common.Util;
import com.hsuan.ecommerce.dto.response.ApiResponse;
import com.hsuan.ecommerce.dto.MultiProduct;
import com.hsuan.ecommerce.dto.response.ProductAndBidListResponse;
import com.hsuan.ecommerce.dto.ProductsAndPageInfo;
import com.hsuan.ecommerce.model.Product;
import com.hsuan.ecommerce.service.InvestService;
import com.hsuan.ecommerce.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    private final ProductService service;
//    private final InvestService investService;


    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
//        this.investService = investService;
    };

    @GetMapping("/products")
    public ResponseEntity<ApiResponse> getAllProducts() {
        List<Product> products = service.getProducts();
        ApiResponse body = new ApiResponse(products);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<ApiResponse> getProduct(@PathVariable int id) {
        Product product = service.getProductById(id);
        ApiResponse body = new ApiResponse();

        if (product != null) {
            body.setData(product);
            return new ResponseEntity<>(body, HttpStatus.OK);
        }
        else {
            body.setMsg("No data found.");
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/products")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody Product product) {
        ApiResponse body = new ApiResponse();
        try {
            Product added = service.addProduct(product);
            body.setData(added);
            return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (Exception ex) {
            body.setMsg(ex.toString());
            return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
        }
    }

    @PutMapping("/products/{prodId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("prodId") Integer prodId, @RequestBody Product product) {
        ApiResponse body = new ApiResponse();
        Product prodExists = service.getProductById(prodId);
        if (prodExists != null) {
            Product updated = service.updateProduct(product);
            body.setData(updated);
            return new ResponseEntity<>(body, HttpStatus.OK);
        } else {
            body.setMsg("Product not found.");
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/products/{prodId}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("prodId") Integer prodId) {
        ApiResponse body = new ApiResponse();
        Product prodExists = service.getProductById(prodId);
        if (prodExists != null) {
            try {
                service.deleteProduct(prodId);
                body.setMsg(String.format("Product Id %h deleted", prodId));
                return new ResponseEntity<>(body, HttpStatus.OK);
            } catch (Exception ex) {
                body.setMsg(prodExists.toString());
                return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
            }
        }
        body.setMsg("Product not found.");
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

//    @GetMapping("product/index")
//    public ResponseEntity<ApiResponse> getProductIndex() {
//        MultiProduct multiProduct = service.queryIndexPageProducts();
//        ApiResponse body = new ApiResponse();
//        if (multiProduct != null) {
//            body.setData(multiProduct);
//            return new ResponseEntity<>(body, HttpStatus.OK);
//        }
//        else {
//            body.setMsg("No data found.");
//            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @GetMapping("product/list")
//    public ResponseEntity<ApiResponse> getProductByType(@RequestParam("type") Integer pType, @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "1") Integer pageSize) {
//        ApiResponse body = new ApiResponse();
//        if (Constant.ProductType.isProductType(pType)) {
//            pageNo = Util.defaultPageNo(pageNo);
//            pageSize = Util.defaultPageSize(pageSize);
//            ProductsAndPageInfo result = new ProductsAndPageInfo();
//            Integer num = service.queryRecordNumsByType(pType);
//            if (num > 0) {
//                result = service.queryByTypeLimit(pType, pageNo, pageSize);
//                body.setData(result);
//            }
//            return new ResponseEntity<>(body, HttpStatus.OK);
//        }
//        body.setMsg("Product type is invalid.");
//        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
//    }
//
//    @GetMapping("/product/info")
//    public  ResponseEntity<ApiResponse> getProductDetail(@RequestParam("prodId") Integer prodId, @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "1") Integer pageSize) {
//        ApiResponse body = new ApiResponse();
//        Product product = service.getProductById(prodId);
//        if (product != null) {
//            ProductAndBidListResponse result = investService.queryBidListByProductId(prodId, pageNo, pageSize);
//            body.setData(result);
//            return new ResponseEntity<>(body, HttpStatus.OK);
//        } else {
//            body.setMsg("Product not found");
//            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
//        }
//
//    }
}
