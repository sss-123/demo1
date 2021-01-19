package com.sss.inventory.demo.dao;

import com.sss.inventory.demo.domain.Inventory;

import java.util.List;
import java.util.Set;

public interface InventoryDao {

    Set<Inventory> getAllInventory();

    boolean updateQuantity(int inventoryId, long currentQty, long newQty);

    long getInventoryQty(int inventoryId);

    boolean createInventory(int categoryId, int subCategoryId, int inventoryId, String inventoryName, long qty);

    Inventory getInventory(int inventoryId);

}
