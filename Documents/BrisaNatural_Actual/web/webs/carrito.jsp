<%@page import="java.util.List"%>
<%@page import="java.util.Base64"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="bn.model.DetallePedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../webs/menu.jsp" flush="true"/>
<jsp:include page="../config/database.jsp" flush="true"/><!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../styles/css.css">
        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">   
	<title>Carrito de compra</title>
</head>
<body >
    <br>
    <div class="container">
        <div class="row">
            <div class="col">
                <table class="table">
                <thead>
                    <tr class="table-warning" style="color: #00a37c;">
                        <th scope="col">Nombre</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Sub total</th>
                        <th scope="col">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        Double Total = 0d;
                        try {
                            HttpSession sesion =request.getSession();
                            
                            List<DetallePedido> list = (List<DetallePedido>) sesion.getAttribute("listCarrito");
                            
                            if(list == null || list.size() == 0){
                                 %>
                                 <tr style="font-weight: lighter;">
                                     <td>
                                        <p>No se ha agregado productos al carrito</p>
                                     </td>
                                 </tr>
                                <% 
                            }
                            if (list != null){
                            for (int i = 0; i < list.size(); i++){
                    %>
                    <tr style="font-weight: lighter;">
                        <th scope="col"><%= list.get(i).getTituloProducto() + "" %></th>
                        <th scope="col">S/ <%= list.get(i).getPrecio() + "" %></th>
                        <th scope="col">
                            <%= list.get(i).getCantidad() + "" %> 
                            &nbsp;
                            <form action="Carrito_Servlet" method="GET" style="display: inline;">
                                <input type="submit" class="buttonCarrito" value="+">
                                <input type="hidden" name="idprod1" value="<%= list.get(i).getIdProd()+ "" %>"/>
                                <input type="hidden" name="accion" value="aumentar"/>
                            </form>
                            &nbsp;
                            <form action="Carrito_Servlet" method="GET" style="display: inline;">
                                <input type="submit" class="buttonCarrito" value="-">
                                <input type="hidden" name="idprod2" value="<%= list.get(i).getIdProd()+ "" %>"/>
                                <input type="hidden" name="accion" value="quitar"/>
                            </form>
                        </th>
                        <th scope="col">S/ <%= list.get(i).getSubTotal() + "" %></th>
                        <th>
                            <form action="Carrito_Servlet" method="GET">
                                <input type="submit" class="buttonCarritoAccion" value="Eliminar">
                                <input type="hidden" name="accion" value="eliminar"/>
                                <input type="hidden" name="idproduct" value="<%= list.get(i).getIdProd()+ "" %>"/>
                            </form>
                        </th>
                    </tr>
                    <% 
                                Total = Total + list.get(i).getSubTotal();
                            }
                        }
                } catch (Exception e) {
                    out.print("Error de conexion" + e);
                }%>    
                </tbody>
                <tfoot>
                    <tr style="font-weight: lighter;">
                        <th colspan="3"></th>
                        <th scope="col">Total S/ <%= Total+"" %></th>
                        <th>
                            <form action="Carrito_Servlet" method="GET">
                                <input type="submit" name="comprar" class="buttonCarritoAccion" value="Comprar">
                                <input type="hidden" name="accion" value="comprar">
                            </form>
                        </th>
                    </tr>
                </tfoot>
            </table>
    
            </div>
        </div>
    </div>
    <br>
    <script type="text/javascript" src="../scripts/cascada.js"></script>
    <script type="text/javascript" src="../scripts/scroll.js"></script>

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>
</html>
<jsp:include page="../webs/footer.jsp" flush="true"/>