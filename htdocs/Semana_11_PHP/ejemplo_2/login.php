<!DOCTYPE html>
<html lang="en">
    <head>
        <title></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/style.css" rel="stylesheet">
    </head>

    <?php
        $username = "";
        $password = "";

        if($_SERVER["REQUEST_METHOD"] == "POST"){
            $username = $_POST['username'];
            $password  = $_POST['password'];         
            //if(empty(username))
        }
    ?>

    <body>
        <form name="login-form" method="post" action="login.php">
            Username: <input type="text" name="username" value= <?php echo $username ?> ><br>
            Password: <input type="text" name="password" value=<?php echo $password ?>><br>
            <input type="submit" value="Login">
        </form>
    </body>
</html>