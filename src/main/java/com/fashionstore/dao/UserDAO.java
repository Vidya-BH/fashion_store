package com.fashionstore.dao;

import java.util.List;
import com.fashionstore.model.User;

public interface UserDAO {

    // Create
    boolean registerUser(User user);

    // Read
    User getUserById(int userId);
    User getUserByEmail(String email);
    List<User> getAllUsers();

    // Update
    boolean updateUser(User user);

    // Delete
    boolean deleteUser(int userId);

    // Authentication
    User login(String email, String password);
}