package com.fashionstore.dao;

import java.util.List;
import com.fashionstore.model.Product;

public interface ProductDAO {

    // CREATE
    boolean addProduct(Product product);

    // READ
    Product getProductById(int productId);
    List<Product> getAllProducts();

    // FILTER
    List<Product> getProductsByCategory(int categoryId);

    // OPTIONAL (keep for future)
    List<Product> getProductsByPriceRange(double minPrice, double maxPrice);
    List<Product> searchProducts(String keyword);
    List<Product> filterProducts(int categoryId, double minPrice, double maxPrice);
    List<Product> filterProducts(Integer categoryId, Double minPrice, Double maxPrice, String keyword);
    // UPDATE
    boolean updateProduct(Product product);

    // DELETE
    boolean deleteProduct(int productId);
}