package com.sss.inventory.demo.domain;

import java.util.Objects;

public class Inventory {
    int subCategoryId;
    int itemId;
    String itemName;
    long quantity;

    public Inventory(int subCategoryId, int itemId, String itemName, long quantity) {
        this.subCategoryId = subCategoryId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public int getCategoryId() {
        return subCategoryId;
    }

    public void setCategoryId(int categoryId) {
        this.subCategoryId = categoryId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }



    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return subCategoryId == inventory.subCategoryId && itemId == inventory.itemId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subCategoryId, itemId);
    }

    @Override
    public String toString() {
        return "Item{" +
                "categoryId=" + subCategoryId +
                ", itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
