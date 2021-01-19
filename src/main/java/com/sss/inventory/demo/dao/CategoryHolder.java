package com.sss.inventory.demo.dao;

import com.sss.inventory.demo.domain.Category;
import com.sss.inventory.demo.domain.Inventory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Temp class to mimic data base behaviour
 */
public class CategoryHolder {
    static Set<Category> categories = new HashSet<>(32);

        public static void init(){
            categories.clear();
            categories.add(new Category(11, "FOOD"));
            categories.add(new Category(12, "CLOTHES"));
            categories.add(new Category(13, "ELECTRONICS"));
            categories.add(new Category(14, "FOOTWEAR"));
        }

}
