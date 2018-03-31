<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1 style="color:red">My first PHP Page</h1><br><br>
    <?php 
        echo "<h1>example non key sensitive</h1>";
        //non key sensitive
        echo "Hello World<br>";
        Echo "Hello Word<br>";


        $name = "Hola";
        $edad = 15;


        // las funciones no son key sentive. Print() , PRINT() , pPrint() ... es lo mismo
        //las variables si son jey sentive. $NAME   es diferente de $NaMe

        echo "<h1>echo method</h1>";
        
        function printFunction(){
            echo "Hello World <br>";
        }
        

        printFunction();
        prinTFUNCTION();
        PRINTFunction();


        echo "<h1>ariables globales</h1>";

        $name = "Maria";
        function globalVariable(){
            // Para poder usar globales se debe
            global $name;
            $GLOBALS['name']; 
            echo "antes: $name <br>";
            $name = "Carlos";
            echo "despues:  $name <br>";
        }
        globalVariable();



        echo "<h2>Cancular operacion con variables globales</h2>";
    
        $x = 10;
        $y = 15;
        function calcular(){
            global $x,$y;
            echo "La variable x es:  $x <br>";

            ;
            echo "La variable y es: " . $GLOBALS['y'] . "<br>";
            

        }
        calcular();







        echo "<h1>static variable</h1>";

        function incremento($value){ //como ya se creo no se puede volver a crear, al ser estatica
            static $count = 0; //solo se le asigna una vez la memoria, al ser estatica es siempre la misma variable
            $count+=$value; //todo lo que se haga a la variable count, se ve reflejado a la misma variable
            echo $count . "<br>";
        }
        incremento(2);
        incremento(4);
        incremento(6);
        


        ?>


        
        
</body>
</html>