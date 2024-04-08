<%@page import="java.util.Base64"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../webs/menu.jsp" flush="true"/>
<jsp:include page="../config/database.jsp" flush="true"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../styles/store.css">
        <title>JSP Page</title>
    </head>
    <body>
    <center>            
        <h1 class="tienda-title">Catálogo de Productos</h1>
        <div class="content-tienda">
            <%
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/webintegpf?user=root&password=");
                    Statement sta = con.createStatement();
                    ResultSet rs = sta.executeQuery("select*from productos");
                    Base64.Decoder decoder = Base64.getDecoder();
                    Base64.Encoder encoder = Base64.getEncoder();
                    while (rs.next()) {
            %>
            <div class="product-tienda" id="<%=rs.getString(1)%>">
                <div class="img-producto">
                    <div class="cortainproduct">
                        <div class="groupcortain">
                            <p class="precioproduct"> S/.<%=rs.getString(6)%> </p>
                            <form action="Carrito_Servlet" method="GET">
                                <input type="text" name="idproduct" value="<%=rs.getString(1)%>" hidden="true"/>
                                <input type="submit" value="COMPRAR" class="btncomprar"/>
                            </form>
                        </div>
                    </div>
                    <img src="data:image/png;base64, <%=encoder.encodeToString(rs.getBytes(2))%>"></div>
                <h3><%=rs.getString(3)%></h3>
            </div>
            <% }
                } catch (Exception e) {
                    out.print("Error de conexion" + e);
                }%>

        </div></center>
    <script type="text/javascript" src="../scripts/scroll.js"></script>
</body>
</html>
<jsp:include page="../webs/footer.jsp" flush="true"/>

