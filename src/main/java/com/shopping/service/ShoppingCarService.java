package com.shopping.service;

import com.shopping.entity.ShoppingCar;

import java.util.List;

/**
 * Created by 14437 on 2017/3/3.
 */
public interface ShoppingCarService {
    ShoppingCar getShoppingCar(int userId, int productId);

    void addShoppingCar(ShoppingCar shoppingCar);

    boolean deleteShoppingCar(int userId,int productId);

    boolean updateShoppingCar(ShoppingCar shoppingCar);

    List<ShoppingCar> getShoppingCars(int userId);
}
