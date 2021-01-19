package com.sss.inventory.demo.domain;

import java.util.Objects;

public class SubCategory {
    int categoryId;
    int subCategoryId;
    String subCategoryDescription;

    public SubCategory(int categoryId, int subCategoryId, String subCategoryDescription) {
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
        this.subCategoryDescription = subCategoryDescription;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getSubCategoryDescription() {
        return subCategoryDescription;
    }

    public void setSubCategoryDescription(String subCategoryDescription) {
        this.subCategoryDescription = subCategoryDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubCategory that = (SubCategory) o;
        return categoryId == that.categoryId && subCategoryId == that.subCategoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, subCategoryId);
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "categoryId=" + categoryId +
                ", subCategoryId=" + subCategoryId +
                ", subCategoryDescription='" + subCategoryDescription + '\'' +
                '}';
    }
}
