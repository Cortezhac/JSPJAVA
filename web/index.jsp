<%-- 
    Document   : index
    Created on : 26-may-2020, 18:05:15
    Author     : Admin
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
        <div class="container">
            <div class="row justify-content-center p-4">
                <div class="col-md4 p-1">
                    <h1 class="center">Registro de personas</h1>
                    <form action="recibir.do" method="POST">
                      <div class="form-group row">
                        <label for="txtDui" class="col-sm-2 col-form-label">Dui:</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" name="txtDui" id="txtDui" maxlength="10">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="txtApellidos" class="col-sm-2 col-form-label">Apellidos:</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" name="txtApellidos" id="txtApellidos">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="txtNombre" class="col-sm-2 col-form-label">Nombre:</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" name="txtNombre" id="txtNombre">
                        </div>
                      </div>
                      <div class="form-group row justify-content-center">
                        <div class="col-4">
                          <button type="submit" class="btn btn-primary">Registrar</button>
                        </div>
                      </div>
                    </form>
                    <div class="row justify-content-center">
                        <div class="col-md-4">
                            <a class="btn btn-info" href="mostrar.do">Registros</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <script src="Bootsrap/js/jquery-3.2.1.js" />
    <script src="Bootsrap/js/bootstrap.js" />
    </body>
</html>
