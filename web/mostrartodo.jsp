<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : mostrartodo
    Created on : 27-may-2020, 23:16:53
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Todos los registros!</h1>
    <c:forEach var="listaTotal" items="${sessionScope.personas}">
        <label for="dui">Dui</label>
        ${listaTotal.dui}<br>
        <label for="apellidos">Apellido</label>
        ${listaTotal.apellidos}<br>
        <label for="nombre">Nombre</label>
        ${listaTotal.nombre}<br>
        <br>
        <hr>
    </c:forEach>
    </body>
</html>
