<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ page import="modelo.Evaluacion, modelo.NotaAlumno" %>
<%
    Evaluacion e = (Evaluacion) request.getAttribute("evaluacion");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Resultados</title>
    <style>
        .barra {
            height: 20px;
            background-color: steelblue;
            margin: 5px;
        }
    </style>
</head>
<body>

<h1>Resultados de la evaluación</h1>

<!-- Tabla -->
<table border="1">
    <tr>
        <th>Apellidos</th>
        <th>Nombre</th>
        <th>Nota</th>
    </tr>

    <% for (NotaAlumno a : e.getAlumnosOrdenados()) { %>
        <tr>
            <td><%= a.getApellido() %></td>
            <td><%= a.getNombre() %></td>
            <td><%= a.getNota() %></td>
        </tr>
    <% } %>

</table>

<h3>Total alumnos: <%= e.totalAlumnos() %></h3>
<h3>Nota media: <%= e.getMedias() %></h3>

<hr>

<h2>Gráfica de frecuencias (0-1, 1-2, ..., 9-10)</h2>

<%
    int[] frec = e.getFrecuencias();
    for (int i = 0; i < frec.length; i++) {
%>
    <div>
        <strong><%= i %> - <%= i+1 %>:</strong>
        <div class="barra" style="width: <%= frec[i] * 30 %>px;"></div>
    </div>
<%
    }
%>

<br><br>
<a href="formularioAlumnos.jsp">Añadir otro alumno</a>

</body>
</html>