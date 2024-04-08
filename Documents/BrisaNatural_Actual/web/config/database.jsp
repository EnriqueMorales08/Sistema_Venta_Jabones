<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/webintegpf?user=root&password=");
    } catch (Exception e) {
        System.out.println("ERROR DE CONEXIÓN: "+e);
    }%>