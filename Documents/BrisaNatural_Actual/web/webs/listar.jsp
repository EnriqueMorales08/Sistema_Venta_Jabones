<%@page import="java.util.Iterator"%>
<%@page import="Crud.Producto"%>
<%@page import="java.util.List"%>
<%@page import="Crud.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrar Productos</title>
        <link rel="icon" type="image/png" href="./resources/icon.png"/>
    </head>
    <body>

    <center>
        
        <div>
            <center>
                <h1>Productos</h1>
                <br/>
                <form action="ControladorProducto" method="POST">

                    <input type="submit" name="accion" value="Listar"/>
                    <input type="submit" name="accion" value="Añadir"/>

                </form>
                <br/>
                <br/>
                <br/>
                <hr/>
                <table border="0" cellpadding="2">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Imagen</th>
                            <th>Título</th>
                            <th>Descripción</th>
                            <th>Gramos</th>
                            <th>Precio</th>
                            <th>Tipo de Piel</th>
                            <th>Categoría</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dato" items="${lista}">
                            <tr>
                                <td>${dato.id}</td>
                                <td><img src="ControladorIMG?id=${dato.id}" width="100" /></td>
                                <td>${dato.getTitulo()}</td>
                                <td>${dato.getDescripción()}</td>
                                <td>${dato.getGramos()}</td>
                                <td>${dato.getPrecio()}</td>
                                <td>${dato.getTipopiel()}</td>
                                <td>${dato.getCategoria()}</td>
                                <td>

                                    <form>

                                        <input type="submit" name="accion" value="Editar"/>
                                        <input type="submit" name="accion" value="Eliminar"/>

                                    </form>

                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <br/>
                <br/>
            </center>

        </div>
        
    </center>

    </body>
</html>
