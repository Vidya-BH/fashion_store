<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>

    <!-- CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/auth.css">
</head>
<body>

<div class="auth-container">

    <div class="auth-box">

        <h2>Create Account</h2>

        <form action="<%=request.getContextPath()%>/register" method="post">

            <input type="text" name="name" placeholder="Full Name" required>

            <input type="email" name="email" placeholder="Email Address" required>

            <input type="password" name="password" placeholder="Password" required>

            <input type="text" name="phone" placeholder="Phone Number">

            <button type="submit">Register</button>

        </form>

        <p class="auth-link">
            Already have an account?
            <a href="<%=request.getContextPath()%>/login">Login</a>
        </p>

    </div>

</div>

</body>
</html>