<?php

// $cedula es una variable..... con "$" se establecen las variables
$cedula =  $_REQUEST["cedula"];
$nombre =  $_REQUEST["nombre"];
$apellido1 =  $_REQUEST["apellido1"];
$apellido2 =  $_REQUEST["apellido2"];
$sexo =  $_REQUEST["sexo"];
$iddistrito =  $_REQUEST["iddistrito"];
$direccion =  $_REQUEST["direccion"];



$user="postgres";
$password = "www.july.com";
$dbname = "matricula";
$port = "5432";
$host = "localhost";

$strconn = "host = $host port=$port dbname = $dbname user = $user password= $password";
$conn = pg_connect($strconn) or die("{estado: 0}");


$query="insert into personas values('$cedula','$nombre','$apellido1',"
        . "'$apellido2','$sexo',$iddistrito,'$direccion')";


$result = pg_query($conn,$query) or die ("{estado: 0 }");

echo "{'estado:1'}";

/*
echo $cedula;
echo $nombre;
echo $apellido1;
echo $apellido2;
echo $sexo;
echo $iddistrito;
echo $direccion;
*/


echo $query;

pg_close($conn);