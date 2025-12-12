<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Diccionario Online</title>
</head>
<body>
    <h1>Diccionario Online</h1>

    <form action="diccionario" method="post">
        <label for="termino">Introduce un término:</label>
        <input type="text" name="termino" id="termino" required>
        <input type="submit" value="Buscar">
    </form>

    <hr>

    <% if (request.getAttribute("resultado") != null) { %>
        <p><strong>Término:</strong> <%= request.getAttribute("termino") %></p>
        <p><strong>Definición:</strong> <%= request.getAttribute("resultado") %></p>
    <% } %>

</body>
</html>

