<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Bootsrap/css/bootstrap.css">
        <link rel="stylesheet" href="custom/css/main.css">
        <title>JSP Page</title>
    </head>
    <% 
        String Dui = (String) request.getAttribute("DUI");
        String Apellido = (String) request.getAttribute("APELLIDO");
        String Nombre = (String) request.getAttribute("NOMBRE");
    %>
    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-10 p-4 custom-back">
                    <h1>Actualizar</h1>
                    <form action="recibir.do" method="post">
                        <div class="form-group clearfix">
                            <label for="txtDui" class="form-control-label">Dui :</label><br>
                            <div class="col-11 float-left">
                                <input type="hidden" id="dui" name="dui" value="<%= Dui%>">
                                <input type="text" maxlength="10" class="form-control" name="txtDui" id="txtDui" value="<%= Dui%>" readonly>
                            </div>
                            <div class="col-sm-1 float-right">
                                <input type="button" id="editar" class="btn btn-warning" onclick="editarDui();" value="Editar">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="txtApellidos" class="form-control-label" >Apellidos :</label>
                            <div class="col-sm-12">
                                <input type="hidden" id="apellido" value="<%= Apellido%>">
                                <input type="text" class="form-control" name="txtApellidos" id="txtApellidos" value="<%= Apellido %>">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="txtNombre" class="form-control-label" >Nombre :</label>
                            <div class="col-sm-12">
                                <input type="hidden" id="nombre" value="<%= Nombre%>">
                                <input type="text" class="form-control" name="txtNombre" id="txtNombre" value="<%= Nombre %>">
                            </div>
                        </div>
                        <input type="hidden" name="accion" value="actualizar">
                        <button class="btn btn-success" type="submit">Actualizar</button>
                    </form>
                </div>
            </div>
        </div>
      
    </body>
</html>
