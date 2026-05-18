package com.fashionstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fashionstore.dao.ProductVariantDAO;
import com.fashionstore.model.ProductVariant;
import com.fashionstore.util.DBConnection;

public class ProductVariantDAOImpl implements ProductVariantDAO {

    // ================= CREATE =================
    @Override
    public boolean addVariant(ProductVariant variant) {

        boolean status = false;

        String sql = "INSERT INTO products_variants (product_id, size, stock_quantity) VALUES (?, ?, ?)";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, variant.getProductId());
            ps.setString(2, variant.getSize());
            ps.setInt(3, variant.getStockQuantity());

            int rows = ps.executeUpdate();
            status = rows > 0;

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // ================= READ =================
    @Override
    public ProductVariant getVariantById(int variantId) {

        ProductVariant variant = null;

        String sql = "SELECT * FROM products_variants WHERE variant_id = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, variantId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                variant = extractVariant(rs);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return variant;
    }

    @Override
    public List<ProductVariant> getVariantsByProductId(int productId) {

        List<ProductVariant> list = new ArrayList<>();

        String sql = "SELECT * FROM products_variants WHERE product_id = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, productId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(extractVariant(rs));
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public ProductVariant getVariantByProductAndSize(int productId, String size) {

        ProductVariant variant = null;

        String sql = "SELECT * FROM products_variants WHERE product_id = ? AND size = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, productId);
            ps.setString(2, size);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                variant = extractVariant(rs);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return variant;
    }

    // ================= UPDATE =================
    @Override
    public boolean updateVariant(ProductVariant variant) {

        boolean status = false;

        String sql = "UPDATE products_variants SET size=?, stock_quantity=? WHERE variant_id=?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, variant.getSize());
            ps.setInt(2, variant.getStockQuantity());
            ps.setInt(3, variant.getVariantId());

            int rows = ps.executeUpdate();
            status = rows > 0;

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public boolean updateStock(int variantId, int quantity) {

        boolean status = false;

        String sql = "UPDATE products_variants SET stock_quantity = ? WHERE variant_id = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, quantity);
            ps.setInt(2, variantId);

            int rows = ps.executeUpdate();
            status = rows > 0;

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // ================= DELETE =================
    @Override
    public boolean deleteVariant(int variantId) {

        boolean status = false;

        String sql = "DELETE FROM products_variants WHERE variant_id = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, variantId);

            int rows = ps.executeUpdate();
            status = rows > 0;

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // ================= COMMON =================
    private ProductVariant extractVariant(ResultSet rs) throws Exception {

        ProductVariant variant = new ProductVariant();

        variant.setVariantId(rs.getInt("variant_id"));
        variant.setProductId(rs.getInt("product_id"));
        variant.setSize(rs.getString("size"));
        variant.setStockQuantity(rs.getInt("stock_quantity"));

        return variant;
    }
}