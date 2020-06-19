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

                    
                    <!-- Modal  -->
                    <div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="titulomodal" aria-hidden="true">
                      <div class="modal-dialog" role="document">
                        <div class="modal-content">
                          <div class="modal-header">
                            <h5 class="modal-title" id="titulomodal">Se eliminara a</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                              <span aria-hidden="true">&times;</span>
                            </button>
                          </div>
                          <div class="modal-body">
                            <%= nombre + " " + apellido%>
                          </div>
                          <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Yamete kudasai!!</button>
                            <form action="Eliminar.do" method="post">
                                <input type="hidden" name="txtDui" value="<%= dui%>">
                                <button type="submit"  class="btn btn-danger">Si, eliminar</button>
                            </form>
                          </div>
                        </div>
                      </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="Bootsrap/js/jquery-3.2.1.min.js"></script>
        <script src="Bootsrap/js/bootstrap.min.js"></script>
    </body>
</html>
