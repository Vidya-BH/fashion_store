package com.fashionstore.dao;

import java.util.List;
import com.fashionstore.model.Order;

public interface OrderDAO {

    // ================= CREATE =================
    boolean placeOrder(Order order);

    // ================= READ =================
    Order getOrderById(int orderId);

    // Get all orders of a user
    List<Order> getOrdersByUserId(int userId);

    // ================= UPDATE =================
    boolean updateOrderStatus(int orderId, String status);

    // ================= DELETE =================
    boolean deleteOrder(int orderId);
}