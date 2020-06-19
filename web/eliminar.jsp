<%-- 
    Document   : eliminar
    Created on : 06-18-2020, 07:02:27 PM
    Author     : Ernesto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Bootsrap/css/bootstrap.css">
        <link rel="stylesheet" href="custom/css/main.css">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
        String dui = (String) request.getAttribute("DUI");
        String nombre = (String) request.getAttribute("NOMBRE");
        String apellido = (String) request.getAttribute("APELLIDO");
        %>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-6 custom-back">
                    <div class="card">
                      <div class="card-header">
                        Eliminar
                      </div>
                      <div class="card-body">
                        <h5 class="card-title">Nombre: <%= nombre %></h5>
                        <p class="card-text">
                            <h6>Apellido: <%=apellido%></h4>
                            <h6>Dui: <%=dui%></h4>
                        </p>
                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete">
                            Eliminar
                            </button>
                            <a href="mostrar.do" class="btn btn-primary">Regresar</a>
                      </div>
                    </div>

                    
                    
        <script src="Bootsrap/js/jquery-3.2.1.min.js"></script>
        <script src="Bootsrap/js/bootstrap.min.js"></script>
    </body>
</html>
