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

        $nombre = "";
        $apellido = "";
        $edad = 0;
        $username = "";
        $password = "";

        $users = array();


        if($_SERVER["REQUEST_METHOD"] == "POST"){
            $nombre = $_POST['nombre'];
            $apellido = $_POST['apellido'];
            $edad = $_POST['edad'];
            $username = $_POST['username'];
            $password  = $_POST['password'];  
            
            if($nombre == "" || $apellido == "" || $edad == "" || $username == "" || $password == ""){
                echo "<strong>Datos vacios</strong>";
            }
            else{
                $user = array($nombre,$apellido,$edad,$username,$password);
                insertUser($user);
            }

            
        }
        function insertUser($user){
            global $users;
            var_dump($users);
            array_push($users,$user);
            echo "User was added succesfully! Please go to Login";
            echo "<a href='login.php'>Login</a><br>";
            var_dump($users);
        }

    ?>

    <h2>Registro</h2>

    <form name="registro-form" method="post" action="registro.php">
        Nombre: <input type="text" name="nombre" value= <?php echo $nombre ?> ><br>
        Apellido: <input type="text" name="apellido" value=<?php echo $apellido ?>><br>
        Edad: <input type="number" name="edad" value=<?php echo $edad ?>><br>
        Username: <input type="text" name="username" value= <?php echo $username ?> ><br>
        Password: <input type="text" name="password" value=<?php echo $password ?>><br>
        <input type="submit" value="Registro">
    </form>
</body>
</html>