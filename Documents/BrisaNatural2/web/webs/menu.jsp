<%@page import="java.util.List"%>
<%@page import="bn.model.DetallePedido"%>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://kit.fontawesome.com/3297378b0c.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="../styles/css.css">
        <link rel="stylesheet" type="text/css" href="../styles/login.css">
        <link rel="stylesheet" type="text/css" href="../styles/loginREG.css">
        <link rel="icon" type="image/png" href="../resources/icon.png">
        <title>Brisa Natural</title>
    </head>
    <body>
        <header class="menu">
            <div class="top">
                <div class="logo">
                    <a href="../index.jsp"><img src="../resources/logo.png"></a>
                </div>
                <div class="find-bar">
                    <form>
                        <a href="javascript:{}" onclick="document.getElementById('my_form').submit();"><i class="fa-solid fa-magnifying-glass"></i></a>
                        <input type="" name="" placeholder="¿Qué buscas hoy?">
                    </form>
                </div>
                <div class="user">
                    <div class="icon-user">
                        <i class="fa-regular fa-user fauser"></i>
                    </div>
                    <div class="user-text">
                        <p>Cuenta 	|</p>
                    </div>
                    <div class="login">
                        <div class="triangulo"></div>
                        <div class="cuerpo">
                            <div class="form-log">
                                <h1>Iniciar sesión</h1>
                                <form action="<%=request.getContextPath()%>/loginservlet" method="post">
                                    <div class="fake_placeholder username">
                                        <label>
                                            <input type="text" name="username" required placeholder="Usuario">
                                        </label>		
                                    </div>
                                    <div class="fake_placeholder passw">
                                        <label>
                                            <input type="password" name="password" required placeholder="Contraseña">

                                        </label>
                                    </div>
                                    <input class="ingreso" type="submit" value="Ingresar">
                                    <br>
                                    <p class="no-cuenta">¿Aún no tienes cuenta?
                                        <a class="link-buttom label-black" href="#">  Registrate Ahora</a>
                                    </p>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <%
                        Integer cantidad = 0;
                        try {
                            HttpSession sesion =request.getSession();
                            
                            List<DetallePedido> list = (List<DetallePedido>) sesion.getAttribute("listCarrito");
                             
                            if(list != null){
                                cantidad = list.size();
                            }
                        }catch (Exception e) {
                            out.print("Error de conexion" + e);
                        }
                %>

                <div class="cart">
                    <a href="../webs/carrito.jsp" style="text-decoration:none; color:#D9BA91;">
                        <%= "("+ cantidad + ")" %><i class="fa-solid fa-cart-shopping"></i></a>
                    <span class="number"></span>
                </div>
            </div>
            <hr>
            <div class="bottom">
                <ul>
                    <li><a href="../index.jsp">Inicio</a></li>
                    <li><a href="../webs/tienda.jsp">Tienda</a></li>
                    <li><a href="../webs/nosotros.jsp">Nosotros</a></li>
                    <li><a href="../webs/faq.jsp">Preguntas Frecuentes</a></li>
                </ul>
            </div>	
        </header>

            <script type="text/javascript" src="../scripts/scroll.js"></script>
            <script type="text/javascript" src="../scripts/usermenu.js"></script>
            <script type="text/javascript" src="../scripts/logREG.js"></script>
           
    </script>
            <script type="text/javascript">
        $('#Registro1').click(function(){
            $.ajax({
                url: "webs/Login.jsp",
                success: function(data){
                    setTimeout(function(){
                        $('#login1').html(data);
                    });
                }
            });
        });
    </script>
    </body>
</html>