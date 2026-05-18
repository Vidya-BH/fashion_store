<%@ page import="java.util.*, com.fashionstore.model.Product" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
List<Product> cartItems = (List<Product>) request.getAttribute("cartItems");
double total = 0;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/style.css">

<style>
body {
    background: #0f172a;
    color: white;
    font-family: Arial;
}

.container {
    display: flex;
    gap: 20px;
    padding: 40px;
}

.cart-left {
    flex: 3;
}

.cart-item {
    display: flex;
    justify-content: space-between;
    background: #1e293b;
    padding: 20px;
    margin-bottom: 15px;
    border-radius: 10px;
}

.cart-item img {
    width: 80px;
}

.cart-details {
    flex: 2;
}

.summary {
    flex: 1;
    background: #1e293b;
    padding: 20px;
    border-radius: 10px;
    height: fit-content;
}

.btn {
    background: cyan;
    color: black;   /* 🔥 THIS LINE ADDED */
    border: none;
    padding: 10px 15px;
    border-radius: 5px;
    cursor: pointer;
}
</style>

</head>
<body>

<h1 style="padding-left:40px;">Your Shopping Cart</h1>

<div class="container">

<!-- LEFT -->
<div class="cart-left">

<% if (cartItems != null && !cartItems.isEmpty()) { %>

    <% for(Product p : cartItems) { 
        total += p.getPrice();
    %>

    <div class="cart-item">

        <!-- IMAGE FIX -->
        <img src="<%=request.getContextPath()%><%= (p.getImageUrl() != null && p.getImageUrl().startsWith("/") 
        ? p.getImageUrl() 
        : "/assets/images/" + p.getImageUrl()) %>">

        <div class="cart-details">
            <h3><%=p.getProductName()%></h3>
            <p>Brand: <%=p.getBrand()%></p>

            <!-- ₹ FIX -->
            <p>&#8377; <%= String.format("%.0f", p.getPrice()) %></p>
        </div>

        <div>
            <!-- ₹ FIX -->
            <p>&#8377; <%= String.format("%.0f", p.getPrice()) %></p>
        </div>

    </div>

    <% } %>

<% } else { %>

    <h2>Your cart is empty 😢</h2>

<% } %>

</div>

<!-- RIGHT -->
<div class="summary">

    <h2>Order Summary</h2>

    <!-- ₹ FIX -->
    <p>Total: &#8377; <%= String.format("%.0f", total) %></p>

    <a href="<%=request.getContextPath()%>/checkout">
        <button class="btn">Proceed to Checkout</button>
    </a>

    <br><br>

    <a href="<%=request.getContextPath()%>/products" style="color:white;">
        Continue Shopping
    </a>

</div>

</div>

</body>
</html>