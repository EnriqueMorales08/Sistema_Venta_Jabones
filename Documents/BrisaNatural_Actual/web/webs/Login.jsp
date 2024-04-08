<html>
<head>
	<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="styles/login.css">
</head>
<body class="body-log">
	 <div id="login2">
	<div class="form-log">
		<h1>Iniciar sesión</h1>
		<form method="post" action="iniciar">
			<div class="fake_placeholder username">
				<label>
					<span><b>Usuario</b></span>	
                    <input type="text" name="user" required>
					
				</label>		
			</div>
			<div class="fake_placeholder passw">
				<label>
					<span><b>Contraseña</b></span>
                    <input type="password" name="password" required>
				
				</label>
			</div>
                    <input class="ingreso" type="submit" value="Ingresar">
			<br>
			<p class="no-cuenta">¿Aún no tienes cuenta?
				<a id="Registro2" class="link-buttom label-black">  Registrate Ahora</a>
			</p>
		</form>
		
	</div>
</div>

	<script >
		const inputs = document.querySelectorAll( '.fake_placeholder input' );
		inputs.forEach( input => {
	//cuando entramos en el input 
	input.onfocus = ( ) => {
		//al elemento anterior (el span) le agregamos la clase que la reubica en top
		input.previousElementSibling.classList.add( 'reubicar' );
	}
	
	//cuando salimos del input
	input.onblur = ( ) => {
		//si no hay texto, le quitamos la clase reubicar, 
		//para que se superponga con el input
		if( input.value.trim( ).length == 0 )
		input.previousElementSibling.classList.remove( 'reubicar' );
	}
} );
	</script>
	<script type="text/javascript">
        $('#Registro2').click(function(){
            $.ajax({
                url: "webs/LoginREGISTRO.jsp",
                success: function(data){
                    setTimeout(function(){
                        $('#login2').html(data);
                    });
                }
            });
        });
    </script>

</body>
</html>
