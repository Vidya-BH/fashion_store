package com.fashionstore.util;

import java.sql.Connection;

public class DBTest {

    public static void main(String[] args) {

        Connection conn = DBConnection.getConnection();

        if (conn != null) {
            System.out.println("🎉 TEST SUCCESS");
        } else {
            System.out.println("❌ TEST FAILED");
        }
    }
}