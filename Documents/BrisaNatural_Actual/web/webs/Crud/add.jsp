<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div>
            <center>
            <h1>Agregar Producto</h1>
            <form action="ControladorProducto">
                
                <label for="Img"> Imagen: </label><br/>
                <input id="Img" type="file" required="true" name="Img" /> <br/>
                
                <label for="Titulo"> Title: </label><br/>
                <input id="Titulo" type="text" required="true" name="Titulo" placeholder="Nombre de mi Producto" maxlength="150" minlength="3" /><br/>
                
                <label for="Descripcion"> Descripción: </label><br/>
                <input id="Descripcion" type="text" required="true" name="Descripcion" placeholder="Descripción de mi Producto" maxlength="650" minlength="10" /><br/>
                
                <label for="Gramos"> Cantidad de Gramos: </label><br/>
                <input id="Gramos" type="text" required="true" name="Gramos" placeholder="100 gr" maxlength="10" minlength="4" /><br/>
                
                <label for="Precio" > Precio: </label><br/>
                <input id="Precio" type="number" required="true" name="Precio" step="0.01" min="0.00" max="1000.00" /> <br/>
                
                <label for="TipoPiel"> Tipo de Piel: </label><br/>
                <input id="TipoPiel" type="text" required="true" name="TipoPiel" maxlength="35" placeholder="ejm: Piel Grasa, Piel Seca, Para Mujeres ..." /> <br/>
                
                <label for="Categoria"> Categoria del Producto: </label><br/>
                <input id="Categoria" type="text" required="true" name="Categoria" maxlength="35" placeholder="ejm: Jabones Naturales, Jabones Temáticos, Shampoos ..."/><br/>

                <input type="submit" value="Añadir Producto" name="accion"/>
                
            </form>
            </center>
        </div>
        
    </body>
</html>
