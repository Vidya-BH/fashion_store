package com.fashionstore.dao.impl;

import java.sql.*;
import java.util.*;

import com.fashionstore.model.CartItem;
import com.fashionstore.util.DBConnection;

public class CategoryDAOImpl {

    // 🔥 ADD TO CART
    public void addToCart(int cartId, int productId, int quantity) {
        try {
            Connection con = DBConnection.getConnection();

            String check = "SELECT * FROM cart_item WHERE cart_id=? AND product_id=?";
            PreparedStatement ps = con.prepareStatement(check);
            ps.setInt(1, cartId);
            ps.setInt(2, productId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String update = "UPDATE cart_item SET quantity = quantity + ? WHERE cart_id=? AND product_id=?";
                PreparedStatement ups = con.prepareStatement(update);

                ups.setInt(1, quantity);
                ups.setInt(2, cartId);
                ups.setInt(3, productId);
                ups.executeUpdate();

            } else {
                String insert = "INSERT INTO cart_item(cart_id, product_id, quantity) VALUES (?, ?, ?)";
                PreparedStatement ins = con.prepareStatement(insert);

                ins.setInt(1, cartId);
                ins.setInt(2, productId);
                ins.setInt(3, quantity);
                ins.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔥 GET CART ITEMS
    public List<CartItem> getCartItems(int cartId) {
        List<CartItem> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM cart_item WHERE cart_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cartId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CartItem item = new CartItem();
                item.setProductId(rs.getInt("product_id"));
                item.setQuantity(rs.getInt("quantity"));
                list.add(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}