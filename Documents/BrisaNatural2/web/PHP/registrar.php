<?php

require'conexion.php';

session_start();
//recupera las variables
$usuario=$_POST['usuario'];
$clave=$_POST['clave'];


//sql
$sql="INSERT INTO usuarios VALUES('$usuario', '$clave')";
$ejecutar=mysqli_query($conexion, $sql);
if (!$ejecutar) {
	echo '<script language="javascript">alert("Ocurrió un error inesperado");</script>';
	header("location: ../Login.php");
}else{
	echo (
	'<html>
	<body>
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script>
	Swal.fire({
	popup: "swal2-show",
  	backdrop: "swal2-backdrop-show",
  	icon: "swal2-icon-show",
  	icons: "success",
	text: "Se ha registrado su usuario. intente iniciar sesion. Gracias",
	icon: "success",
	confirmButtonText: "Aceptar",
	width: "27%",
	height:"20%",
	background: "#DCE4E5",
	backdrop: true,
	timerProgressBar: true,
	timer: 2000,
	toast: true,
	position: "center",
	confirmButtonColor: "#128CF1",
			});
	</script>
	<META HTTP-EQUIV="REFRESH" CONTENT="2;URL=../Login.php">
	</body>
	</html>');
	
}
?>