<style>
.navbar {
    position: fixed;
    top: 0;
    width: 100%;
    background: #020617;
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 10px 20px;   /* reduced padding */
    box-sizing: border-box;
    z-index: 1000;
}

/* LOGO */
.logo {
    color: white;
    font-size: 18px;
    font-weight: bold;
}

/* SEARCH */
.search-box form {
    display: flex;
    align-items: center;
}

.search-box input {
    padding: 6px 10px;
    border-radius: 20px;
    border: none;
    width: 160px;
}

.search-box button {
    margin-left: 5px;
    padding: 6px 10px;
    border-radius: 20px;
    border: none;
    background: #22d3ee;
    cursor: pointer;
}

/* NAV LINKS */
.nav-links {
    display: flex;
    gap: 10px;   /* 🔥 spacing fixed */
}

.nav-links a {
    color: white;
    text-decoration: none;
    font-size: 14px;
}

/* BODY SPACE */
body {
    padding-top: 60px;
}
</style>

<div class="navbar">

    <div class="logo">Fashion Store</div>

    <!-- 🔥 SEARCH WORKING -->
    <div class="search-box">
        <form action="<%=request.getContextPath()%>/products" method="get">
            <input type="text" name="keyword" placeholder="Search products...">
            <button type="submit">Go</button>
        </form>
    </div>

    <div class="nav-links">
        <a href="<%=request.getContextPath()%>/home">Home</a>
        <a href="<%=request.getContextPath()%>/products">Products</a>
        <a href="<%=request.getContextPath()%>/cart">Cart</a>
        <a href="<%=request.getContextPath()%>/login">Login</a>
    </div>

</div>