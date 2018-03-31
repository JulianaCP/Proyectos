<?php


    $name = $_REQUEST['name'];
    $lastName = $_REQUEST['lastname'];
    $age = $_REQUEST['age'];
    echo "CON REQUEST: Welcome <strong>" . $name . " " . $lastName . "</strong> with " . $age . " years old";
    

    echo "<br><br>";

    if($_SERVER["REQUEST_METHOD"] == "GET"){
        $name = $_GET['name'];
        $lastName  = $_GET['lastname'];
        $age = $_GET['age'];
        echo "CONT GET: Welcome <strong>" . $name . " " . $lastName . "</strong> with " . $age . " years old";
        echo "<br><br>";
    }
    else{
        $name = $_POST['name'];
        $lastName  = $_POST['lastname'];
        $age = $_POST['age'];
        echo "CONT POST: Welcome <strong>" . $name . " " . $lastName . "</strong> with " . $age . " years old";
    }
?>