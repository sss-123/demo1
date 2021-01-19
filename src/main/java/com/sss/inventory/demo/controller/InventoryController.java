package com.sss.inventory.demo.controller;

import com.sss.inventory.demo.dao.InventoryDao;
import com.sss.inventory.demo.domain.Inventory;
import com.sss.inventory.demo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;
/*
This class will serve as controller and respond to all http requests, will return json
Catch exception from service layer and change the same into response.
 */
@Controller
@RequestMapping("inventory")
public class InventoryController {

    @Autowired
    private InventoryDao inventoryDao;

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/{id}") // produces = "application/json")
    public String getInventory(@PathVariable int id) {
        // TODO return xxxx(id);
        return null;
    }

    public Set<Inventory> getAllInventory(){
        //TODO
        return null;
    }

    public boolean createInventory(int categoryId, int subCategoryId, int inventoryId, String inventoryName, long qty){
        //TODO
        //return  inventoryService.createInventory(categoryId, subCategoryId, inventoryId, inventoryName, qty);
        return false;
    }

    public boolean updateInventoryQty(int inventoryID, long currentQty, long newQty){
        //TODO
       // return inventoryService.updateInventoryQty(inventoryID, currentQty, newQty);
        return false;
    }

}
