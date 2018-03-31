<!DOCTYPE html>
<html lang="en">
    <head>
        <title></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/style.css" rel="stylesheet">
    </head>

    <?php

        $users = array();
        

        $username = "";
        $password = "";

        if($_SERVER["REQUEST_METHOD"] == "POST"){
            $username = $_POST['username'];
            $password  = $_POST['password'];  
            
            validarUsuario();
        }

        function validarUsuario(){
            global $users,$username,$password;
            $len = count($users);
            $found =  false;
            for ($row=0; $row < $len; $row++) { 
                $user = $users[$row];
                if($user[0]==$username && $user[1]==$password){
                    $found = true;
                    break;
                }
            }
            if(!$found){
                echo "<strong>Login Error</strong>";
            }
            else{
                echo "<script>location.href='registro.php'</script>";
            }
        }
    ?>
    

    <body>
        <form name="login-form" method="post" action="login.php">
            Username: <input type="text" name="username" value= <?php echo $username ?> ><br>
            Password: <input type="text" name="password" value=<?php echo $password ?>><br>
            <input type="submit" value="Login">
            <a href="registro.php">Registro</a>
        </form>
    </body>
</html>