package com.shopping.dao;

import com.shopping.entity.Product;

import java.util.List;

/**
 * Created by 14437 on 2017/3/1.
 */
public interface ProductDao {
    Product getProduct(int id);

    Product getProduct(String name);

    void addProduct(Product product);

    boolean deleteProduct(int id);

    boolean updateProduct(Product product);

    List<Product> getProductsByKeyWord(String searchKeyWord);

    List<Product> getProductsByType(int type);

    List<Product> getAllProduct();
}
