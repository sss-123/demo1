package com.sss.inventory.demo;

import com.sss.inventory.demo.domain.Category;
import com.sss.inventory.demo.domain.Inventory;
import com.sss.inventory.demo.domain.SubCategory;

import java.util.ArrayList;
import java.util.List;

public class TestData {
    public List<Category> getAllCateries(){ // Assumed its fetched from DB at startup
        List<Category> categories = new ArrayList<>(32);

        categories.add(new Category(11, "FOOD"));
        categories.add(new Category(12, "CLOTHES"));
        categories.add(new Category(13, "ELECTRONICS"));
        categories.add(new Category(14, "FOOTWEAR"));

        return categories;
    }

    public List<SubCategory> getAllSubcategories(){ // Assumed its fetched from DB at startup
        List<SubCategory> subCategories = new ArrayList<>(128);
        subCategories.add(new SubCategory(11, 111, "PIZZA"));
        subCategories.add(new SubCategory(11, 112, "CAKE"));
        subCategories.add(new SubCategory(11, 113, "PASTA"));

        subCategories.add(new SubCategory(12, 114, "MAN TSHIRT"));
        subCategories.add(new SubCategory(12, 115, "LADY TSHIRT"));
        subCategories.add(new SubCategory(12, 116, "SKIRT"));

        subCategories.add(new SubCategory(13, 117, "LAPTOP"));
        subCategories.add(new SubCategory(13, 118, "DESKTOP"));

        subCategories.add(new SubCategory(14, 119, "MAN FORMAL SHOES"));
        subCategories.add(new SubCategory(14, 120, "MAN SPORT SHOES"));
        subCategories.add(new SubCategory(14, 121, "WOMAN SPORT SHOES"));

        return subCategories;
    }

    public List<Inventory> prepareInitialInventories(){ // Assumed its fetched from DB at startup
        List<Inventory> inventories = new ArrayList<>(1024);

        inventories.add(new Inventory(111, 1111, "Italian Pizza", 10));
        inventories.add(new Inventory(120, 1112, "Adidas Runnin Shoes", 100));

        return inventories;
    }
}
