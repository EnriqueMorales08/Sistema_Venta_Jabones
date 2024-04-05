<?php

require'conexionBD.php';

session_start();

$datos="SELECT FROM login";

$correo=$_POST['correo'];
$contraseña=$_POST['contraseña'];


$q="SELECT COUNT(*) as contar FROM login where correo ='$correo' and contraseña='$contraseña'";

$consulta= mysqli_query($conexion,$q);
$array= mysqli_fetch_array($consulta);

if ($array['contar']>0) {

	$_SESSION['correo']=$correo;
	header("location: ../principal.jsp");

}
else {
	echo (
	'<html>
	<body>
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script>
	Swal.fire({
	popup: "swal2-show",
  	backdrop: "swal2-backdrop-show",
  	icon: "error",
	text: "DATOS INCORRECTOS",
	confirmButtonText: "Aceptar",
	width: "27%",
	height:"20%",
	background: "#DCE4E5",
	backdrop: true,
	timerProgressBar: true,
	timer: 1000,
	toast: true,
	position: "up-center",
	confirmButtonColor: "#128CF1",
			});
	</script>
	<META HTTP-EQUIV="REFRESH" CONTENT="1;URL=../Login.php">
	</body>
	</html>');
}

?>