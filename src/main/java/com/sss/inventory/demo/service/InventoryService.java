package com.sss.inventory.demo.service;

import com.sss.inventory.demo.domain.Inventory;

import java.util.Set;
/*
This class serve the purpose of service layer, will interact with DAO layer
 */
public interface InventoryService {

    boolean createInventory(int categoryId, int subCategoryId, int inventoryId, String inventoryName, long qty) throws Exception;

    boolean updateInventoryQty(int inventoryID, long currentQty, long newQty) throws Exception;

    Set<Inventory> getAllInventory() throws Exception;

    Inventory getInventory(int inventoryId) throws Exception;
}
