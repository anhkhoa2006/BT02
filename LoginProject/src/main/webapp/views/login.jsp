<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Đăng nhập</title></head>
<body>
    <h2>Trang Đăng Nhập</h2>
    <form action="${pageContext.request.contextPath}/login" method="post">
        Username: <input type="text" name="username"><br/>
        Password: <input type="password" name="password"><br/>
        <input type="checkbox" name="remember" value="true"> Nhớ tài khoản <br/>
        <input type="submit" value="Login">
    </form>
</body>
</html>