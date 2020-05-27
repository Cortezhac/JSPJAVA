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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de personas</h1>
        <form action="recibir.do" method="POST">
            <label for="txtDui">Dui:</label>
            <input type="text" name="txtDui" maxlength="10" value="" />
            <br/>
            <label for="txtApellidos">Apellidos:</label>
            <input type="text" name="txtApellidos" value="" />
            <br/>
            <label for="txtNombre">Nombre:</label>
            <input type="text" name="txtApellidos" value="" />
            <br/>
            <input type="submit" value="Registrar nueva persona">
        </form>
    </body>
</html>
