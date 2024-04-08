<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objSesion = request.getSession(false);
    String user = (String) objSesion.getAttribute("user");
    if (user.equals("")) {
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=user%> | Brisa Natural</title>
        <link rel="icon" type="image/png" href="../resources/icon.png"/>
        <link rel="stylesheet" type="text/css" href="../styles/user.css">
    </head>
    <body>
    <center>
        <h1>¡¡¡ Bienvenido usuario <%out.println(user); %>!!!</h1><br/><br/>
        <form action="../ControladorProducto" method="POST">

            <input type="submit" name="accion" value="Listar" class="btn"/>

        </form>
        <form action="../iniciar">

            <input type="submit" name="accion" value="Salir" class="btn"/>

        </form>
    </center>
</body>
</html>
