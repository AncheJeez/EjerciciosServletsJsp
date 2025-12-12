<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="http://jakarta.ee/jstl/core" %>--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
     <body>
        <h1>Formulario Alumno</h1>
        <br><br><br>
        <form action="Ejercicio2" method="post">
            <label>Nombre</label>
            <input for="nombre" type="text" name="nombre" required="">
            <br>
            <label>Apellido</label>
            <input for="apellido" type="text" name="apellido" required="">
            <br>
            <label>Nota</label>
            <input for="nota" type="number" name="nota" required="">
            <br>
            <br>
            <input type="submit" value="Iniciar Sesion">
        </form>
    </body>
</html>
