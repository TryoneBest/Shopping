package com.shopping.service;

import com.shopping.entity.ShoppingRecord;

import java.util.List;

/**
 * Created by 14437 on 2017/3/3.
 */
public interface ShoppingRecordService {
    ShoppingRecord getShoppingRecord(int userId, int productId,String time);

    void addShoppingRecord(ShoppingRecord shoppingRecord);

    boolean deleteShoppingRecord(int userId,int productId);

    boolean updateShoppingRecord(ShoppingRecord shoppingRecord);

    List<ShoppingRecord> getShoppingRecordsByOrderStatus(int orderStatus);

    List<ShoppingRecord> getShoppingRecords(int userId);

    List<ShoppingRecord> getAllShoppingRecords();

    boolean getUserProductRecord(int userId,int productId);
}
