<%@ page import="java.util.List" %>
<%@ page import="com.fashionstore.model.Product" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Products</title>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/products.css">
    
</head>
<body>

<jsp:include page="/WEB-INF/views/partials/navbar.jsp" />

<!-- 🔥 NEW HEADER SECTION -->
<div class="products-hero">

    <h1>Explore Our Fashion Collection</h1>

    <p>
        Browse products, apply filters, and discover styles that match your taste.
    </p>

</div>

<div class="main-container">
<!-- 🔥 FILTER TOGGLE BUTTON -->

   
    <!-- 🔹 FILTER SIDEBAR -->
    <div class="sidebar">
        <h2>Filters</h2>

        <form action="<%=request.getContextPath()%>/products" method="get">

            <label>Search</label>
            <input type="text" name="keyword" placeholder="Search products">

            <label>Category</label>
            <label>Category</label>
<select name="categoryId">
    <option value="">All Categories</option>
    <option value="1">Men</option>
    <option value="2">Women</option>
    <option value="3">Kids</option>
    <option value="4">Footwear</option>
    <option value="5">Accessories</option>
</select>

            <div class="price-box">
                <div>
                    <label>Min Price</label>
                    <input type="number" name="minPrice" placeholder="0">
                </div>

                <div>
                    <label>Max Price</label>
                    <input type="number" name="maxPrice" placeholder="5000">
                </div>
            </div>

            <label>Sort By</label>
            <select name="sort">
                <option value="">Default</option>
                <option value="low">Price: Low to High</option>
                <option value="high">Price: High to Low</option>
            </select>

            <div style="display:flex; gap:10px;">
    <button class="btn">Apply</button>

    <button type="button" class="clear-btn"
        onclick="window.location.href='<%=request.getContextPath()%>/products'">
        Clear
    </button>
</div>

        </form>
    </div>

    <!-- 🔹 PRODUCTS SECTION -->
    <div class="products-section">

        <div class="header">
            <h2>Products</h2>
        </div>

        <div class="product-grid">

            <%
                List<Product> products = (List<Product>) request.getAttribute("products");

                if (products != null && !products.isEmpty()) {
                    for (Product p : products) {
            %>

           <div class="card">

    <img src="<%=request.getContextPath()%>/assets/images/<%=p.getImageUrl()%>" alt="product">

    <div class="card-body">
        <h3><%=p.getProductName()%></h3>
        <p class="brand"><%=p.getBrand()%></p>
        <p class="price">&#8377; <%= String.format("%.0f", p.getPrice()) %></p>

        <a href="<%=request.getContextPath()%>/productDetails?productId=<%=p.getProductId()%>" 
           class="btn">
           View Details
        </a>
    </div>

</div>

            <%
                    }
                } else {
            %>

            <p>No products found</p>

            <%
                }
            %>

        </div>

    </div>

</div>

<jsp:include page="/WEB-INF/views/partials/footer.jsp" />

</body>
</html>