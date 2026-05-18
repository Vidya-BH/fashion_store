package com.fashionstore.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.fashionstore.dao.UserDAO;
import com.fashionstore.dao.impl.UserDAOImpl;
import com.fashionstore.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAOImpl();
        System.out.println("✅ LoginServlet Loaded");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 🔹 Open login page
        request.getRequestDispatcher("/WEB-INF/views/login.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            User user = userDAO.login(email, password);

            if (user != null) {
                // 🔥 SESSION
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

                System.out.println("✅ Login Success");

                // Redirect to products
                response.sendRedirect(request.getContextPath() + "/products");

            } else {
                System.out.println("❌ Invalid Login");

                request.setAttribute("error", "Invalid Email or Password");
                request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                       .forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("❌ Login Error");
        }
    }
}