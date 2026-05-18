package com.fashionstore.dao;

import com.fashionstore.model.Cart;

public interface CartDAO {

    // ================= CREATE =================
    boolean createCart(Cart cart);

    // ================= READ =================
    Cart getCartByUserId(int userId);
    Cart getCartById(int cartId);

    // ================= DELETE =================
    boolean deleteCart(int cartId);
}