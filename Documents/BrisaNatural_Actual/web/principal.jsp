<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objSesion=request.getSession(false);
    String user=(String)objSesion.getAttribute("user");
    if(user.equals("")){
        response.sendRedirect("webs/login.jsp");
    }
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=user%> | Brisa Natural</title>
        <link rel="icon" type="image/png" href="./resources/icon.png"/>
    </head>
    <body>
        <h1>Bienvenido usuario <%out.println(user); %>!!!</h1>
        <a href="iniciar?accion=salir">Cerrar Sesión</a>
        <a href="index.jsp">VOLVER A LA PÁGINA PRINCIPAL.</a>
        <a href="ControladorProducto?accion=listar" > Administrar Productos </a>
    </body>
</html>
