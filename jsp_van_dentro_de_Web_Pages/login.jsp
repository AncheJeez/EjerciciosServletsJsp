<%-- 
    Document   : login
    Created on : 12 dic 2025, 0:28:12
    Author     : AndJe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    
    <form action="LoginServlet" method="post">
        <label>Usuario:</label>
        <input type="text" name="username" required><br><br>
        
        <label>Password:</label>
        <input type="password" name="password" required><br><br>
        
        <input type="submit" value="Iniciar sesión">
    </form>
    
    <%-- Mostrar mensaje de error si existe --%>
    <c:if test="${not empty error}">
        <p style="color:red">${error}</p>
    </c:if>
</body>
</html>

