package com.fashionstore.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.fashionstore.dao.UserDAO;
import com.fashionstore.dao.impl.UserDAOImpl;
import com.fashionstore.model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserDAO userDAO;

    // 🔹 INIT
    @Override
    public void init() throws ServletException {
        userDAO = new UserDAOImpl();
        System.out.println("✅ RegisterServlet Loaded");
    }

    // 🔹 OPEN REGISTER PAGE (GET)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/views/register.jsp")
               .forward(request, response);
    }

    // 🔹 HANDLE FORM SUBMIT (POST)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // 1. Get form values
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");

            // 2. Create User object
            User user = new User();
            user.setFullName(name);      // ✅ IMPORTANT (your model uses fullName)
            user.setEmail(email);
            user.setPassword(password);
            user.setPhone(phone);

            // Optional fields (safe default)
            user.setAddressLine1("");
            user.setAddressLine2("");
            user.setCity("");
            user.setState("");
            user.setPincode("");
            user.setCountry("");

            // 3. Save to DB
            boolean status = userDAO.registerUser(user);

            // 4. Redirect
            if (status) {
                System.out.println("✅ Registration Success");
                response.sendRedirect(request.getContextPath() + "/login");
            } else {
                System.out.println("❌ Registration Failed");
                request.setAttribute("error", "Registration Failed");
                request.getRequestDispatcher("/WEB-INF/views/register.jsp")
                       .forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("❌ Error during registration");
        }
    }
}