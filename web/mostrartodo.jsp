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
        <link rel="stylesheet" href="Bootsrap/css/bootstrap.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h1 class="">Todos los registros</h1>
                    <a href="index.jsp" class="btn btn-info">Agregar</a>
                    <table class="table responsive-table">
                        <thead>
                            <tr>
                                <th data-field="id">No DUI</th>
                                <th data-field="name">Nombre</th>
                                <th data-field="price">Apellido</th>
                                <th data-field="price">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="listaTotal" items="${sessionScope.personas}">
                                <tr>
                                    <td>${listaTotal.getDui()}</td>
                                    <td>${listaTotal.apellidos}</td>
                                    <td>${listaTotal.nombre}</td>
                                    <td>
                                        <a class="btn btn-warning text-white" href="recibir.do?accion=edit&dui=${listaTotal.getDui()}">Editar</a>
                                        <a class="btn btn-danger" href="Eliminar.do?dui=${listaTotal.getDui()}">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    <script src="Bootsrap/js/jquery-3.2.1.min.js"></script>
    <script src="Bootsrap/js/bootstrap.min.js"></script>
    </body>
</html>
