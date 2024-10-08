package com.hsuan.ecommerce.service;

import com.hsuan.ecommerce.common.Constant;
import com.hsuan.ecommerce.dto.MultiProduct;
import com.hsuan.ecommerce.dto.ProductsAndPageInfo;
import com.hsuan.ecommerce.model.Product;
import com.hsuan.ecommerce.repository.ProductRepo;
import com.hsuan.ecommerce.common.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepo repo;

//    List<Product> products = new ArrayList<>(Arrays.asList(new Product(101, "Iphone", 30000),
//            new Product(102, "Camera", 12000)));
    public ProductService() {}

    @Autowired
    public ProductService(ProductRepo repo) {
        this.repo = repo;
    }

    public List<Product> getProducts() {
        return repo.findAll();
    }

    public Product getProductById(int prodId) {
        return repo.findById(prodId).orElse(null);
    }

    // Query by product type, pagination supported
    public ProductsAndPageInfo queryByTypeLimit(Integer pType, Integer pageNo, Integer pageSize) {
        ProductsAndPageInfo productPageInfos = new ProductsAndPageInfo();
        if (Constant.ProductType.isProductType(pType)) {
            pageNo = Util.defaultPageNo(pageNo);
            pageSize = Util.defaultPageSize(pageSize);
            Pageable pageable = PageRequest.of(pageNo, pageSize);
            Page<Product> productInfos = repo.findByProductTypeOrderByReleaseTimeDesc(pType, pageable);
            if (productInfos.hasContent()) {
                productPageInfos.setProductList(productInfos.getContent());
            }
            productPageInfos.setPageSize(productInfos.getSize());
            productPageInfos.setPageNo(productInfos.getNumber());
            productPageInfos.setTotalPage(productInfos.getTotalPages());
            productPageInfos.setTotalRecord(productInfos.getTotalElements());
        }
        return productPageInfos;
    }

    public Integer queryRecordNumsByType(Integer pType) {
        Integer counts = 0;
        if (Constant.ProductType.isProductType(pType)) {
            counts = repo.countByProductType(pType);
        }
        return counts;
    }

    // Query for products on the index page
    public MultiProduct queryIndexPageProducts() {
        MultiProduct result = new MultiProduct();

        List<Product> newComerList = repo.findByProductTypeOrderByReleaseTimeDesc(Constant.ProductType.NEWCOMER.getValue(), PageRequest.of(0, 1)).getContent();
        List<Product> choiceList = repo.findByProductTypeOrderByReleaseTimeDesc(Constant.ProductType.CHOICE.getValue(), PageRequest.of(0, 3)).getContent();
        List<Product> retailList = repo.findByProductTypeOrderByReleaseTimeDesc(Constant.ProductType.RETAIL.getValue(), PageRequest.of(0, 3)).getContent();

        result.setNewComer(newComerList);
        result.setChoice(choiceList);
        result.setRetail(retailList);
        return result;
    }

    public Product addProduct(Product prod) {
        return repo.save(prod);
    }

    public Product updateProduct(Product prod) {
        return repo.save(prod);
    }

    public void deleteProduct(int prodId) {
        repo.deleteById(prodId);
    }
}
