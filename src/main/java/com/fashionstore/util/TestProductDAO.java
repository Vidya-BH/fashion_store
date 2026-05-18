package com.fashionstore.util;

import java.util.List;

import com.fashionstore.dao.impl.ProductDAOImpl;
import com.fashionstore.model.Product;

public class TestProductDAO {

    public static void main(String[] args) {

        ProductDAOImpl dao = new ProductDAOImpl();

        // ================= GET ALL PRODUCTS =================
        System.out.println("=== ALL PRODUCTS ===");
        List<Product> list = dao.getAllProducts();

        for (Product p : list) {
            System.out.println(
                p.getProductId() + " | " +
                p.getProductName() + " | " +
                p.getPrice()
            );
        }

        // ================= FILTER BY CATEGORY =================
        System.out.println("\n=== MEN CATEGORY PRODUCTS ===");
        List<Product> menList = dao.getProductsByCategory(1);

        for (Product p : menList) {
            System.out.println(p.getProductName());
        }

        // ================= PRICE FILTER =================
        System.out.println("\n=== PRICE BETWEEN 500 - 1500 ===");
        List<Product> priceList = dao.getProductsByPriceRange(500, 1500);

        for (Product p : priceList) {
            System.out.println(p.getProductName() + " - " + p.getPrice());
        }

        // ================= SEARCH =================
        System.out.println("\n=== SEARCH 'T-Shirt' ===");
        List<Product> searchList = dao.searchProducts("T-Shirt");

        for (Product p : searchList) {
            System.out.println(p.getProductName());
        }
    }
}