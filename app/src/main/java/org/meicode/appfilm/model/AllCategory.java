package org.meicode.appfilm.model;

import java.util.ArrayList;

public class AllCategory {
    String categoryTitle;
    Integer categoryId;
    private ArrayList<CategoryItem> CateItemm = null;

    public AllCategory(Integer categoryId, String categoryTitle, ArrayList<CategoryItem> cateItemm) {
        this.categoryTitle = categoryTitle;
        this.categoryId = categoryId;
        CateItemm = cateItemm;
    }

    public ArrayList<CategoryItem> getCateItemm() {
        return CateItemm;
    }

    public void setCateItemm(ArrayList<CategoryItem> cateItemm) {
        CateItemm = cateItemm;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
