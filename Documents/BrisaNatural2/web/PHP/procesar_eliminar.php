<?php

include ("conexion.php");

$usuario=$_GET['username'];

$eliminar="DELETE FROM usuarios WHERE username='$usuario'";

$resultado=mysqli_query($conexion,$eliminar);

if($resultado){
	header("Location: ../Login.php");
}
else{
	echo"<script>alert('No se pudo Eliminar'); window.history.go(-1);</script>";
}

?>