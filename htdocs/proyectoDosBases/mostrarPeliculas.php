<!DOCTYPE html>
<html>
<head>

        <?php  
                

            $genero= $_GET["genero"];
            $idEstablecimiento = $_GET["establecimiento"];
            echo $idEstablecimiento;


            if ($genero == "N") {
              $queryNoEstreno = "select idpelicula,nombre from peliculas where estreno='no'";
              echo "1";
              $queryEstreno = "select p.idPelicula as idpelicula,p.nombre as nombre from peliculas as p inner join sala_Comercio as sc on(p.idPelicula = sc.idPelicula)
        inner join sala as s on(sc.idSala = s.idSala)
        where p.estreno = 'si' and sc.activo='S' and  s.idEstablecimiento = '". $idEstablecimiento ."'";
            }
            else{
                echo "2";
                $queryNoEstreno = "select idpelicula,nombre from peliculas where estreno='no' and genero = '".$genero."'";
                $queryEstreno = "select p.idPelicula as idpelicula,p.nombre as nombre from peliculas as p inner join sala_Comercio as sc on(p.idPelicula = sc.idPelicula)
        inner join sala as s on(sc.idSala = s.idSala)
        where p.estreno = 'si' and sc.activo='S' and genero = '".$genero."'";
            }

            
            $db_connection = pg_connect("host=localhost dbname=proyectobasesdos user=postgres password=www.july.com");

                
           
        ?>


    <style type="text/css">

        #centro{
            align-position:center;
            padding-left: 13%;
            padding-right: 13%;
            padding-top: 1%;       
        }
        #marcoPagina{
            text-align: center;
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
            padding-right: 23%;
            padding-left: 23%;
        }



    </style>


    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>
    <script type="text/javascript">
        


    </script>


</head>
<body>
    <nav>
        <div class="nav-wrapper">
            <a href="#" class="brand-logo">Logo</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a href="mostrarPeliculas.php?genero=<?php echo $genero?>&establecimiento=<?php echo $idEstablecimiento?>">Biblioteca</a></li>
                <li><a href="mostrarPeliculas.php">Opcion</a></li>
                <li><a href="mostrarPeliculas.php">Opcion</a></li>
                <li><a href="mostrarPeliculas.php">Opcion</a></li>
            </ul>
        </div>
    </nav><br><br>
    <div id="centro">
        <div id="marcoPagina">
             <h4>Listado Peliculas</h4><br><br>

            <div class="collection">
                <?php  
                    $resultEstreno = pg_query($queryEstreno) or die('La consulta fallo: ' . pg_last_error());
                    while($rowEstreno = pg_fetch_array($resultEstreno, null, PGSQL_ASSOC)){
                        $idEstreno=$rowEstreno["idpelicula"];
                        $nombreEstreno=$rowEstreno["nombre"];     
                ?>
                        <a class="collection-item" href="mostrarInfoPeliculasEstreno.php?id=<?php echo $idEstreno?>&genero=<?php echo $genero ?>&establecimiento=<?php echo $idEstablecimiento?>"><?php echo $nombreEstreno?></a>
                <?php
                        
                    }
                    

                    $resultNoEstreno = pg_query($queryNoEstreno) or die('La consulta fallo: ' . pg_last_error());
                    while($rowNoEstreno = pg_fetch_array($resultNoEstreno, null, PGSQL_ASSOC)){
                        $idNoEstreno=$rowNoEstreno["idpelicula"];
                        $nombreNoEstreno=$rowNoEstreno["nombre"];   

                ?>
                        <a class="collection-item" href="mostrarInfoPeliculasEstreno.php?id=<?php echo $idNoEstreno?>&genero=<?php echo $genero ?>&establecimiento=<?php echo $idEstablecimiento?>"><?php echo $nombreNoEstreno?></a>
                <?php
                        
                    }
                    pg_close( $db_connection);
                ?>
            </div>
        </div> 
    </div>   
</body>
</html>