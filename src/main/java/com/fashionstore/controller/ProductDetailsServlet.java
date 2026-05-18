package com.fashionstore.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.fashionstore.dao.ProductDAO;
import com.fashionstore.dao.impl.ProductDAOImpl;
import com.fashionstore.model.Product;

@WebServlet("/productDetails")   // 🔥 URL mapping
public class ProductDetailsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ProductDAO productDAO;

    // 🔹 Initialize DAO
    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAOImpl();
        System.out.println("✅ ProductDetailsServlet Loaded");
    }

    // 🔹 Handle GET request
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // 1. Get productId from URL
            String idParam = request.getParameter("productId");

            if (idParam == null || idParam.isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/products");
                return;
            }

            int productId = Integer.parseInt(idParam);

            // 2. Fetch product from DB
            Product product = productDAO.getProductById(productId);

            if (product == null) {
                // If product not found
                request.setAttribute("error", "Product not found");
                request.getRequestDispatcher("/WEB-INF/views/products.jsp")
                       .forward(request, response);
                return;
            }

            // 3. Send product to JSP
            request.setAttribute("product", product);

            // 4. Forward to product details page
            request.getRequestDispatcher("/WEB-INF/views/productDetails.jsp")
                   .forward(request, response);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/products");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("❌ Error loading product details");
        }
    }
}