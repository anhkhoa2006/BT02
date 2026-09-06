<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Trang chủ</title></head>
<body>
    <h2>Đăng nhập thành công!</h2>
    <p>Xin chào: <b>${sessionScope.username}</b></p>
    
    <hr>
    <h3>Menu Chức năng:</h3>
    <ul>
        <li><a href="${pageContext.request.contextPath}/admin/categories">Quản lý Danh mục (Categories)</a></li>
        <li><a href="${pageContext.request.contextPath}/">Về trang chủ (Đăng xuất)</a></li>
    </ul>
</body>
</html>