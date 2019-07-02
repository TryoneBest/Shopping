package com.shopping.service;

import com.shopping.entity.Product;
import com.shopping.utils.Response;

import java.util.List;

/**
 * Created by 14437 on 2017/3/2.
 */
public interface ProductService {
    Product getProduct(int id);

    Product getProduct(String name);

    void addProduct(Product product);

    Response deleteProduct(int id);

    boolean updateProduct(Product product);

    List<Product> getProductsByKeyWord(String searchKeyWord);

    List<Product> getProductsByType(int type);

    List<Product> getAllProduct();
}
