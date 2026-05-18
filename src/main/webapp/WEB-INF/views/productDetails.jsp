<%@ page import="java.util.*" %>
<%@ page import="com.fashionstore.model.Product" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    Product p = (Product) request.getAttribute("product");

    // 🔥 HANDLE ADD TO CART USING GET
    String action = request.getParameter("action");

    if ("add".equals(action) && p != null) {

        int quantity = Integer.parseInt(request.getParameter("quantity"));

        List<Product> cart = (List<Product>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        for (int i = 0; i < quantity; i++) {
            cart.add(p);
        }

        session.setAttribute("cart", cart);

        out.println("<script>alert('Item added to cart!');</script>");
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Details</title>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/productDetails.css">
</head>
<body>

<jsp:include page="/WEB-INF/views/partials/navbar.jsp" />

<div class="details-container">

<% if (p != null) { %>

    <!-- IMAGE -->
    <div class="image-section">
        <img 
            src="<%=request.getContextPath()%><%= (p.getImageUrl() != null && p.getImageUrl().startsWith("/") 
            ? p.getImageUrl() 
            : "/assets/images/" + p.getImageUrl()) %>" 
            alt="product">
    </div>

    <!-- DETAILS -->
    <div class="info-section">

        <h2><%=p.getProductName()%></h2>

        <p>Brand: <%=p.getBrand()%></p>

        <!-- ✅ ₹ SYMBOL FIX -->
        <p>&#8377; <%= String.format("%.0f", p.getPrice()) %></p>

        <p><%=p.getDescription()%></p>

        <!-- ADD TO CART -->
        <form method="get">

            <input type="hidden" name="productId" value="<%=p.getProductId()%>">
            <input type="hidden" name="action" value="add">

            <label>Quantity:</label>
            <input type="number" name="quantity" value="1" min="1">

            <br><br>

            <button type="submit">Add to Cart</button>

        </form>

        <br>

        <a href="<%=request.getContextPath()%>/products">← Back to Products</a>

    </div>

<% } else { %>

    <h2>Product not found</h2>

<% } %>

</div>

</body>
</html>