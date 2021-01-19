package com.sss.inventory.demo.service;

import com.sss.inventory.demo.dao.InventoryDao;
import com.sss.inventory.demo.dao.InventoryHolder;
import com.sss.inventory.demo.dao.SubCategoryHolder;
import com.sss.inventory.demo.domain.Inventory;
import com.sss.inventory.demo.domain.SubCategory;
import com.sss.inventory.demo.exception.CategoryMismatchException;
import com.sss.inventory.demo.exception.ConcurrentUpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
This class serve the purpose of service layer, will interact with DAO layer
 */

@Component
public class InventoryServiceImpl implements InventoryService{
    @Autowired
    private InventoryDao inventoryDao;

    Logger logger = Logger.getLogger(InventoryServiceImpl.class.getSimpleName());

    @Override
    public boolean createInventory(int categoryId, int subCategoryId, int inventoryId, String inventoryName, long qty) throws Exception{
        //TODO check in DB if item already exist, if already present then return false,
        //TODO check the category subcategory
        System.out.println("Sub cat at start " + SubCategoryHolder.getSubCategories());
        boolean result = false;
        // check if category exist before creating inventory
        SubCategory subCategory = SubCategoryHolder.getSubCategories().stream()
                .filter(subCategory1 -> subCategoryId == subCategory1.getSubCategoryId() && categoryId == subCategory1.getCategoryId())
                .findAny()
                .orElse(null);
        if (subCategory != null) {
            result = inventoryDao.createInventory(categoryId, subCategoryId, inventoryId, inventoryName, qty);
        } else {
            logger.log(Level.SEVERE, "Sub/category does not match");
            throw new CategoryMismatchException("Sub/category does not match");
        }


        return result;
    }

    @Override
    public boolean updateInventoryQty(int inventoryID, long currentQty, long newQty) throws Exception{
        Integer inventoryIdObj = inventoryID;
        //TODO there should be a lock on item to acquire before start of this processing
        //TODO check DB if curr qty matching, if matching then update with new qty and return true, false otherwise
        long qty = InventoryHolder.getInventoryQty(inventoryID);
        if(qty == currentQty) {
            return inventoryDao.updateQuantity(inventoryID, currentQty, newQty);
        }else{
            logger.log(Level.SEVERE, "qty mismatched, may be concurrent update");
            throw new ConcurrentUpdateException("qty mismatched, may be concurrent update");
        }
    }

    @Override
    public Set<Inventory> getAllInventory() {
        return inventoryDao.getAllInventory();
    }

    @Override
    public Inventory getInventory(int inventoryId) {
        return inventoryDao.getInventory(inventoryId);
    }
}
