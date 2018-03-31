<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/style.css">
    <title>Document</title>
</head>
<body>
    <?php
        $nombre = "";
        $apellido =  "";
        if($_SERVER["REQUEST_METHOD"] == "POST"){
            $nombre = $_POST["nombre"];
            $apellido = $_POST["apellido"];
            echo "La persona: " . $nombre;
        }
    ?>
     
    <div id="marco">
        <form name="myForm" action="index.php" method="post">
            <strong>Registro</strong><br><br><br>
            Name: <input type="text" name="nombre"><br><br>
            Apellido: <input type="text" name="apellido"><br><br>
            <input type="submit">
        </form>
    </div>

</body>
</html>