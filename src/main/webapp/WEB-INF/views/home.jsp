<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fashion Store</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/home.css">

<!-- ICONS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>

<body>

<jsp:include page="/WEB-INF/views/partials/navbar.jsp" />

<!-- HERO -->
<section class="hero">

    <div class="hero-left">
        <span class="tag"> New Season Collection</span>

        <h1>Discover Your Style <br> with Fashion Store</h1>

        <p>Explore premium fashion trends for men, women, kids and more.</p>

        <!-- HERO BUTTON -->
<a href="<%=request.getContextPath()%>/products" class="btn">
    Shop Now
</a>
    </div>

    <div class="hero-right">
        <div class="hero-box">Trendy Fashion Collection</div>
    </div>

</section>

<!-- 🔥 CATEGORY SECTION -->
<!-- CATEGORY -->
<section class="category">

    <h2>Shop by Category</h2>

    <div class="category-grid">

        <!-- MEN -->
        <div class="cat-card">
            <i class="fa-solid fa-shirt"></i>
            <h3>Men</h3>
            <p>Fashion products for men</p>
            <a href="<%=request.getContextPath()%>/products?categoryId=1" class="explore-btn">
                Explore
            </a>
        </div>

        <!-- WOMEN -->
        <div class="cat-card">
            <i class="fa-solid fa-person-dress"></i>
            <h3>Women</h3>
            <p>Fashion products for women</p>
            <a href="<%=request.getContextPath()%>/products?categoryId=2" class="explore-btn">
                Explore
            </a>
        </div>

        <!-- KIDS -->
        <div class="cat-card">
            <i class="fa-solid fa-child"></i>
            <h3>Kids</h3>
            <p>Fashion products for kids</p>
            <a href="<%=request.getContextPath()%>/products?categoryId=3" class="explore-btn">
                Explore
            </a>
        </div>
        <div class="cat-card">
            <i class="fa-solid fa-shoe-prints"></i>
            <h3>Footwear</h3>
            <p>Fashion footwear collection</p>
            <a href="<%=request.getContextPath()%>/products?categoryId=4" class="explore-btn">
                Explore
            </a>
        </div>

        <!-- ACCESSORIES -->
        <div class="cat-card">
            <i class="fa-solid fa-bag-shopping"></i>
            <h3>Accessories</h3>
            <p>Fashion accessories collection</p>
            <a href="<%=request.getContextPath()%>/products?categoryId=5" class="explore-btn">
                Explore
            </a>
        </div>
        

    </div>

</section>

</body>
</html>