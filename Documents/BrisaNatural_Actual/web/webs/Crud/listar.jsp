<%@page import="java.util.Iterator"%>
<%@page import="Crud.Producto"%>
<%@page import="java.util.List"%>
<%@page import="Crud.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrar Productos</title>
        <link rel="icon" type="image/png" href="./resources/icon.png"/>
    </head>
    <body>

        <div>
            <center>
                <h1>Productos</h1>
                <br/><a href="ControladorProducto?accion=add">Agregar Nuevo</a>
                <br/>
                <br/><br/>
                <table border="0" cellpadding="1">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Imagen</th>
                            <th>Nombre</th>
                            <th>Descripción</th>
                            <th>Gramos</th>
                            <th>Precio</th>
                            <th>Tipo de Piel</th>
                            <th>Categoría</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <%

                        ProductoDAO dao = new ProductoDAO();
                        List<Producto> list = dao.listar();
                        Iterator<Producto> ite = list.iterator();
                        Producto pro = null;
                        while (ite.hasNext()) {
                            pro = ite.next();

                    %>
                    <tbody>
                        <tr>
                            <td><%= pro.getId()%></td>
                            <td><%= pro.getImg()%></td>
                            <td><%= pro.getTitulo()%></td>
                            <td><%= pro.getDescripción()%></td>
                            <td><%= pro.getGramos()%></td>
                            <td><%= pro.getPrecio()%></td>
                            <td><%= pro.getTipopiel()%></td>
                            <td><%= pro.getCategoria()%></td>
                            <td>

                                <a href="#">Editar</a>
                                <a href="#">Remover</a>

                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
                    <br/>
                    <br/>
            </center>

        </div>

    </body>
</html>
