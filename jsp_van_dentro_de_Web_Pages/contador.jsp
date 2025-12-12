<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Contador de Visitas</title>
</head>
<body>
    <h1>Contador de visitas en esta sesión</h1>

    <p>Has visitado esta página <strong><%= request.getAttribute("contadorActual") %></strong> veces durante esta sesión.</p>

    <form action="contador" method="get">
        <button type="submit">Recargar página</button>
    </form>

    <form action="cerrarSesion" method="post">
        <button type="submit">Cerrar sesión</button>
    </form>
    
    <a href="/SimulacroExamen">Volver</a><br>
</body>
</html>

