package com.fashionstore.dao;

import java.util.List;
import com.fashionstore.model.CartItem;

public interface CartItemDAO {

    boolean addToCart(CartItem item);

    List<CartItem> getCartByUserId(int userId);

    boolean updateQuantity(int cartItemId, int quantity);

    boolean removeFromCart(int cartItemId);

    boolean clearCart(int userId);
}