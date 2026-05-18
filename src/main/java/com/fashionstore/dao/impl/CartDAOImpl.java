package com.fashionstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fashionstore.dao.CartDAO;
import com.fashionstore.model.Cart;
import com.fashionstore.util.DBConnection;

public class CartDAOImpl implements CartDAO {

    // ================= CREATE =================
    @Override
    public boolean createCart(Cart cart) {

        boolean status = false;

        String sql = "INSERT INTO cart (user_id) VALUES (?)";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, cart.getUserId());

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
    public Cart getCartByUserId(int userId) {

        Cart cart = null;

        String sql = "SELECT * FROM cart WHERE user_id = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cart = new Cart();
                cart.setCartId(rs.getInt("cart_id"));
                cart.setUserId(rs.getInt("user_id"));
                cart.setCreatedAt(rs.getTimestamp("created_at"));
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cart;
    }

    @Override
    public Cart getCartById(int cartId) {

        Cart cart = null;

        String sql = "SELECT * FROM cart WHERE cart_id = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cartId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cart = new Cart();
                cart.setCartId(rs.getInt("cart_id"));
                cart.setUserId(rs.getInt("user_id"));
                cart.setCreatedAt(rs.getTimestamp("created_at"));
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cart;
    }

    // ================= DELETE =================
    @Override
    public boolean deleteCart(int cartId) {

        boolean status = false;

        String sql = "DELETE FROM cart WHERE cart_id = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cartId);

            int rows = ps.executeUpdate();
            status = rows > 0;

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}