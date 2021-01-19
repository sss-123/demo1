package com.sss.inventory.demo.dao;

import com.sss.inventory.demo.domain.Inventory;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class InventoryDaoImpl implements InventoryDao{

    public Set<Inventory> getAllInventory(){
        Set<Inventory> resultSet = null;
        try{
            resultSet = InventoryHolder.getInventories();
        }catch (Exception e){
            //log DB or any issue
        }
        return resultSet;
    }

    public boolean updateQuantity(int inventoryId, long currentQty, long newQty){
        boolean result = false;
        try{
            result = InventoryHolder.updateInventoryQty(inventoryId, newQty);
        }catch (Exception e){
            //log DB or any issue
        }
        return result;
    }

    public long getInventoryQty(int inventoryId){
        long result = 0;
        try{
            result = InventoryHolder.getInventoryQty(inventoryId);
        }catch (Exception e){
            //log DB or any issue
        }
        return result;
    }

    public boolean createInventory(int categoryId, int subCategoryId, int inventoryId, String inventoryName, long qty){
        boolean result = false;
        try{
            result = InventoryHolder.addInventory(new Inventory(subCategoryId, inventoryId, inventoryName, qty));
        }catch (Exception e){
            e.printStackTrace();
            //log DB or any issue
        }
        return result;
    }

    @Override
    public Inventory getInventory(int inventoryId) {
        return InventoryHolder.getInventory(inventoryId);
    }
}
