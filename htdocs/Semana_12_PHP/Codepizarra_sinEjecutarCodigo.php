<?php
    $users = array("rojas","arias");
    array_push($users,"jose"); //agregar valores al arreglo

    /*
    atributos user:
        -id
        -username
        -password
        -nombre
        -apellido
    
    */
    $userTable = array(
        array(1,"user","pass","jose","arias"),
        array(2,"user2","pass2","jose2","arias2")
    );

    $userTableWithKey = array("id"=>1,"username"=>"username1","pass"=>"password","nombre"=>"jose","apellido"=>"arias");
    


    //imprimir
    print_r($users);
    var_dump($users);


?>