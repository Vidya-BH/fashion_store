package com.fashionstore.dao;

import java.util.List;
import com.fashionstore.model.OrderItem;

public interface OrderItemDAO {

    // ================= CREATE =================
    boolean addOrderItem(OrderItem item);

    // ================= READ =================
    List<OrderItem> getItemsByOrderId(int orderId);

    // ================= DELETE =================
    boolean deleteOrderItemsByOrderId(int orderId);
}