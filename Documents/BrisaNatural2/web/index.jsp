<%@page import="java.util.List"%>
<%@page import="bn.model.DetallePedido"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://kit.fontawesome.com/3297378b0c.js" crossorigin="anonymous"></script>
        <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="./styles/css.css">
        <link rel="icon" type="image/png" href="./resources/icon.png">
        <title>Brisa Natural</title>
    </head>
    <body class="index-body">
        <a name="top">
            <header class="menu">
                <div class="top">
                    <div class="logo">
                        <a href="index.jsp"><img src="./resources/logo.png"></a>
                    </div>
                    <div class="find-bar">
                        <form>
                            <a href="javascript:{}" onclick="document.getElementById('my_form').submit();"><i class="fa-solid fa-magnifying-glass"></i></a>
                            <input type="" name="" placeholder="¿Qué buscas hoy?">
                        </form>
                    </div>

                    <div class="user" >
                        <div class="icon-user" id="Registro1">
                            <i class="fa-regular fa-user fauser"></i>
                        </div>
                        <div class="user-text">
                            <p>Cuenta 	|</p>
                        </div>
                        <div class="login">
                            <div class="triangulo"></div>

                            <!--login-->
                            <div class="cuerpo" id="login1">
                                
                            </div>
                            <!------->

                        </div>
                    </div>
                    <%
                        Integer cantidad = 0;
                        try {
                            HttpSession sesion = request.getSession();

                            List<DetallePedido> list = (List<DetallePedido>) sesion.getAttribute("listCarrito");

                            if (list != null) {
                                cantidad = list.size();
                            }
                        } catch (Exception e) {
                            out.print("Error de conexion" + e);
                        }
                    %>
                    <div class="cart">
                        <a href="./webs/carrito.jsp" style="text-decoration:none; color:#D9BA91;">
                            <%= "(" + cantidad + ")"%><i class="fa-solid fa-cart-shopping"></i></a>
                        <span class="number"></span>
                    </div>
                </div>
                <hr>
                <div class="bottom">
                    <ul>
                        <li><a href="index.jsp">Inicio</a></li>
                        <li><a href="./webs/tienda.jsp">Tienda</a></li>
                        <li><a href="./webs/nosotros.jsp">Nosotros</a></li>
                        <li><a href="./webs/faq.jsp">Preguntas Frecuentes</a></li>
                    </ul>
                </div>	
            </header>


            <!--INICIO-->

            <div class="banner">
                <img src="./resources/banner.png">
            </div>

            <div class="carrusel">
                <div class="slide">
                    <div class="slide-img">
                        <img src="./resources/propiedades.png">
                    </div>
                    <p class="slide-title">Jabones Naturales</p>
                </div>
                <div class="slide">
                    <div class="slide-img">
                        <img src="./resources/tematicos.jpg">
                    </div>
                    <p class="slide-title">Jabones Temáticos</p>
                </div>
                <div class="slide">
                    <div class="slide-img">
                        <img src="./resources/shampoos.jpg">
                    </div>
                    <p class="slide-title">Shampoos</p>
                </div>
                <div class="slide">
                    <div class="slide-img">
                        <img src="./resources/velas.jpg">
                    </div>
                    <p class="slide-title">Velas de Soja</p>
                </div>
                <div class="slide">
                    <div class="slide-img">
                        <img src="./resources/desodorantes.png">
                    </div>
                    <p class="slide-title">Desodorantes</p>
                    <a name="form"></a>
                </div>
            </div>

            <hr>

            <!--FORMULARIO-->	

            <div class="contactanos">
                <form class="form-contacto" action="contacto" method="post">
                    <center><p>Contacto</p></center>
                    <div class="form-sides">
                        <div class="form-left">
                            <input type="text" name="fname" placeholder="Coloque sus nombres." required><span class="validity"></span>
                            <input type="text" name="pname" placeholder="Coloque sus apellidos." required><span class="validity"></span>
                            <input type="text" maxlength="8" minlength="8" name="dni" placeholder="Coloque su documento de identidad." required><span class="validity"></span>
                            <input type="tel" maxlength="9" minlength="9" name="telefono" placeholder="Coloque su número de celular." required><span class="validity"></span>
                            <input type="email" name="correo" placeholder="Coloque su correo." required><span class="validity"></span>
                        </div>
                        <div class="form-right">
                            <textarea placeholder="Escriba aquí su mensaje." required name="mensaje"></textarea>
                            <input type="submit" name="submit">
                        </div>
                    </div>
                </form>
            </div>

            <div class="btn-arriba" id="myBtn" >
                <a href="#top" class="arribaa"><i class="fa-solid fa-circle-up"></i></a>
                <a href="https://api.whatsapp.com/send?phone=51961749664&text=Me%20interesa%20m%C3%A1s%20informaci%C3%B3n%20de%20los%20pedidos" class="arribaa" target="_blank"><i class="fa-brands fa-whatsapp"></i></a>
                <a href="https://www.facebook.com/brisanatural.cosmetica/" class="arribaa" target="_blank"><i class="fa-brands fa-facebook"></i></a>
            </div>


            <footer class="footer">
                <center><p>Noticias</p></center>
                <div class="noticias">
                    <form class="form-suscripcion" method="post" action="suscripcion">
                        <input type="email" name="correo" class="namei" placeholder="Ingresa tu correo." required><input type="submit" name="submit" class="submiti" value="Suscríbete">
                    </form>
                </div>
                <div class="footer-text">
                    <span><i class="fa-solid fa-location-dot"></i> Los Parques de Piura Iera Etapa - Piura - Piura - Perú</span>
                    <span><i class="fa-solid fa-phone-volume"></i> +51 969-969-969</span>
                    <span><i class="fa-solid fa-envelope"></i> brisanatural@gmail.com</span>
                </div>
            </footer>

            <script type="text/javascript" src="./scripts/scroll.js"></script>
            <script type="text/javascript" src="./scripts/usermenu.js"></script>
           
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


