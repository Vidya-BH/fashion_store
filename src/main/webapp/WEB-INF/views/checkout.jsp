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
<title>Checkout</title>

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

.left {
    flex: 2;
}

.right {
    flex: 1;
    background: #1e293b;
    padding: 20px;
    border-radius: 10px;
}

input, textarea {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    border-radius: 5px;
}

.btn {
    background: cyan;
    padding: 10px;
    border: none;
    width: 100%;
    cursor: pointer;
}

/* Payment */
.payment-options label {
    display: block;
    margin-bottom: 10px;
}

/* Back button */
.back-cart-btn {
    display: block;
    text-align: center;
    margin-top: 15px;
    padding: 10px;
    background: #334155;
    color: white;
    text-decoration: none;
    border-radius: 6px;
}
</style>

</head>
<body>

<h1 style="padding-left:40px;">Checkout</h1>

<div class="container">

<!-- LEFT SIDE -->
<div class="left">

<form method="post" action="<%=request.getContextPath()%>/placeOrder">

    <h2>Shipping Address</h2>

    <input type="text" name="name" placeholder="Full Name" required>
    <input type="text" name="phone" placeholder="Phone" required>
    <textarea name="address" placeholder="Address" required></textarea>

    <h2>Payment Method</h2>

    <div class="payment-options">
        <label><input type="radio" name="payment" value="cod" checked> Cash on Delivery</label>
        <label><input type="radio" name="payment" value="upi"> UPI</label>
        <label><input type="radio" name="payment" value="card"> Credit / Debit Card</label>
    </div>

    <button type="submit" class="btn">Place Order</button>

</form>

</div>

<!-- RIGHT SIDE -->
<div class="right">

<h2>Order Summary</h2>

<% if (cartItems != null && !cartItems.isEmpty()) {
    for(Product p : cartItems) {
        total += p.getPrice();
%>

    <p><%=p.getProductName()%> - ₹ <%= String.format("%.0f", p.getPrice()) %></p>

<%  }
   } else { %>

    <p>Your cart is empty</p>

<% } %>

<hr>

<h3>Total: ₹ <%= String.format("%.0f", total) %></h3>


<a href="<%=request.getContextPath()%>/cart" class="back-cart-btn">
    ← Back to Cart
</a>

</div>

</div>

</body>
</html>