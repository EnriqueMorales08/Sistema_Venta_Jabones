<html>
<head>
	<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../styles/loginREG.css">
	<title>Formulario de registro</title>
	
</head>
<body class="body-log">
	<div id="login3">
	<div class="form-log" id="formulario">
		<h1>Registro</h1>
		<form method="post" >
			<div class="fake_placeholder username" action="../registrar">
				<label>
					<span><b>Nombre</b></span>	
					<input type="text" name="nombre" required>					
				</label>		
			</div>
			<div class="fake_placeholder username">
				<label>
					<span><b>Correo</b></span>	
					<input type="text" name="user" required>					
				</label>		
			</div>

			<div class=" formulario__grupo" id="grupo__password">
			<div class="fake_placeholder passw" >
				<label for="password" class="formulario__label">
					<span><b>Contraseña</b></span>
					<input id="password" type="password" class="formulario__input" name="password" required>
					<i class="formulario__validacion-estado fas fa-times-circle"></i>			
				</label>				
			</div>		
			</div>
			<div class=" formulario__grupo" id="grupo__password2">
			<div class="fake_placeholder passw">
				<label for="password2" class="formulario__label">
					<span><b>Confirmar contraseña</b></span>
					<input id="password2" type="password" class="formulario__input" name="password2" required>
					<i class="formulario__validacion-estado fas fa-times-circle"></i>					
				</label>				
			</div>	
			<p class="formulario__input-error"><i class="fas fa-exclamation-triangle"></i> Ambas contraseñas deben ser iguales.</p>
			</div>
			

	
			<input class="ingreso formulario__btn" type="submit" value="Registrarte">
			
			<br>
			<p class="no-cuenta">¿Ya estás registrado?
				<a id="Registro3" class="link-buttom label-black">  Inicia Sesión</a>
			</p>
		</form>
		
	</div>
</div>

	<script src="https://kit.fontawesome.com/2c36e9b7b1.js" crossorigin="anonymous"></script>
	<script src="../scripts/logREG.js"></script>

	<script type="text/javascript">
		$('#Registro3').click(function(){
			$.ajax({
				url: "Login_1.jsp",
				success: function(data){
					setTimeout(function(){
						$('#login3').html(data);
					});
				}
			});
		});
		
	</script>
        

</body>
</html>
