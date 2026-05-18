package com.fashionstore.dao;

import java.util.List;
import com.fashionstore.model.Category;

public interface CategoryDAO {

    // ================= CREATE =================
    boolean addCategory(Category category);

    // ================= READ =================
    Category getCategoryById(int categoryId);
    List<Category> getAllCategories();

    // ================= UPDATE =================
    boolean updateCategory(Category category);

    // ================= DELETE =================
    boolean deleteCategory(int categoryId);
}