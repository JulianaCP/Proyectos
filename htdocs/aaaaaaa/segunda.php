<!--Juliana Campos Parajeles-->


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <?php

        if($_SERVER["REQUEST_METHOD"] == "POST"){
            $nombre = $_POST["nombre"];
            $apellido = $_POST["apellido"];
            $cedula = $_POST["cedula"];
            $edad =  $_POST["edad"];

            $variable = false;
            if($nombre == ""){
                echo "<p>el nombre esta vacio</p>";
                $variable = true;
            }
            if($apellido == ""){
                echo "<p>el apellido esta vacio</p>";
                $variable = true;
            }
            if($cedula == "" ){
                echo "<p>la cedula esta vacio</p>";
                $variable = true;
            }
            if($edad == ""){
                echo "<p>la edad esta vacio</p>";
                $variable = true;
            }
            if($variable == false){
                echo "<p>Bienvenido " . $nombre . " " . $apellido . " a nuestro sitio, el numero de cedula registrado es " 
                .  $cedula . " y tienes " . $edad. " de edad</p>";
            }

        }
    ?>

    <a href="index.php">Regresar</a>

    <script>
        function 
    </script>
</body>
</html>