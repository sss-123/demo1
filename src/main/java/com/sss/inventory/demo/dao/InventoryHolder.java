package com.sss.inventory.demo.dao;

import com.sss.inventory.demo.domain.Inventory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Temp class to mimic data base behaviour
 */

public class InventoryHolder {
    static Set<Inventory> inventories = new HashSet<>(32);

    public static boolean addInventory(Inventory inventory){
        inventories.add(inventory);
        return true;
    }

    public static Set<Inventory> getInventories(){
        return inventories;
    }

    public static boolean updateInventoryQty(int id, long newQty){
        Inventory inventory = inventories.stream()
                .filter(inventory1 -> id == inventory1.getItemId())
                .findAny()
                .orElse(null);
        if(inventory == null)
                return false;
        inventory.setQuantity(newQty);
        inventories.add(inventory);
        return true;
    }

    public static long getInventoryQty(int id){
        Inventory inventory = inventories.stream()
                .filter(inventory1 -> id == inventory1.getItemId())
                .findAny()
                .orElse(null);
        if(inventory == null)
            return 0;
        return inventory.getQuantity();
    }

    public static Inventory getInventory(int id){
        Inventory inventory = inventories.stream()
                .filter(inventory1 -> id == inventory1.getItemId())
                .findAny()
                .orElse(null);
        return inventory;
    }

    public static void init(){
        inventories.clear();
        inventories.add(new Inventory(111, 1111, "Italian Pizza", 10));
        inventories.add(new Inventory(120, 1112, "Adidas Running Shoes", 100));
    }


}
