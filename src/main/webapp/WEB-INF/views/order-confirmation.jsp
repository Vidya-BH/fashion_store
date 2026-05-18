<%@ page import="java.util.*, com.fashionstore.model.Product" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
String name = (String) request.getAttribute("name");
String phone = (String) request.getAttribute("phone");
String address = (String) request.getAttribute("address");
String payment = (String) request.getAttribute("payment");

List<Product> cartItems = (List<Product>) request.getAttribute("cartItems");

double total = 0;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmation</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/order-confirmation.css">
</head>
<body>

<div class="container">

    <h1>🎉 Order Confirmed!</h1>

    <!-- CUSTOMER DETAILS -->
    <div class="section">
        <h2>Customer Details</h2>

        <p><strong>Name:</strong> <%=name%></p>
        <p><strong>Phone:</strong> <%=phone%></p>
        <p><strong>Address:</strong> <%=address%></p>
        <p><strong>Payment:</strong> <%=payment%></p>
    </div>

    <!-- ORDER ITEMS -->
    <div class="section">
        <h2>Items</h2>

        <% if(cartItems != null && !cartItems.isEmpty()) {
            for(Product p : cartItems) {
                total += p.getPrice();
        %>

            <div class="item">
                <span><%=p.getProductName()%></span>
                <span>&#8377; <%= String.format("%.0f", p.getPrice()) %></span>
            </div>

        <%  }
           } else { %>

            <p>No items found</p>

        <% } %>

        <hr>

        <h3>Total: &#8377; <%= String.format("%.0f", total) %></h3>
    </div>

    <!-- BUTTON -->
    <a href="<%=request.getContextPath()%>/products" class="btn">
        Continue Shopping
    </a>

</div>

</body>
</html>