package com.sss.inventory.demo.dao;

import com.sss.inventory.demo.domain.Category;
import com.sss.inventory.demo.domain.Inventory;
import com.sss.inventory.demo.domain.SubCategory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Temp class to mimic data base behaviour
 */

public class SubCategoryHolder {
    static Set<SubCategory> subCategories = new HashSet<>();

        public static void init(){
            subCategories.clear();
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
        }

    public static Set<SubCategory> getSubCategories(){
        return subCategories;
    }

}
