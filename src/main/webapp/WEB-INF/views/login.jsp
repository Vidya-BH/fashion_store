<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/auth.css">
</head>
<body>

<div class="auth-container">

    <div class="auth-box">

        <h2>Login</h2>

        <!-- 🔴 ERROR MESSAGE -->
        <%
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
            <p style="color:red;"><%=error%></p>
        <%
            }
        %>

        <form action="<%=request.getContextPath()%>/login" method="post">

            <input type="email" name="email" placeholder="Email Address" required>

            <input type="password" name="password" placeholder="Password" required>

            <button type="submit">Login</button>

        </form>

        <p class="auth-link">
            Don't have an account?
            <a href="<%=request.getContextPath()%>/register">Register</a>
        </p>

    </div>

</div>

</body>
</html>