<!DOCTYPE html>
<html>
<head>
	<?php  



		$id=$_GET["id"];
		$generoTo=$_GET["genero"];
		$idEstablecimientoTo=$_GET["establecimiento"];
            
        $db_connection = pg_connect("host=localhost dbname=proyectobasesdos user=postgres password=www.july.com");
        $queryFoto="select img from imagenes where idpelicula = '" .$id ."' limit 1";

        $queryInfo="select * from peliculas where idpelicula = '" .$id . "'";

        $queryInfoSala = "select s.nombreSala as nombresalavar,h.horaInicio as horarioiniciovar,horaFinal as horariofinalvar,sc.fecha as fecha from sala_comercio as sc inner join sala as s on(sc.idSala = s.idSala)
	inner join horario as h on(sc.idHorario = h.idHorario) where sc.idPelicula = '".$id."'";





	?>

	    <style type="text/css">

        #centro{
            align-position:center;
            padding-left: 8%;
            padding-right: 8%;
            padding-top: 1%; 
            padding-bottom: 8%;      
        }
        #marcoPagina{
            text-align: center;
            border-radius: 5px;
            background-color: #f2f2f2;
            padding-top: 3%;
            padding-bottom: 2%;
            padding-right: 1%;
            padding-left: 8%;
           

            
        }
        #marcoPaginaColor{
        	padding-top: 5%;
        	padding-bottom: 5%;
        	background-color:#afafaf ;
        }
        #marcoImagen{
        	text-align: left;
        	padding-left: 2%;
        	padding-top: 1%;
        }
        #posicionTitulo{
        	text-align: center;
        }
        #informacion{
        	float: right;
        	padding-right: 15%;
        	width: 50%;
        }
        #sipnosis{
        	padding-top: 1%;
        }



    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>
</head>
<body>
	<?php  
		$resultFoto = pg_query($queryFoto) or die('La consulta fallo: ' . pg_last_error());
		$rowFoto = pg_fetch_array($resultFoto, null, PGSQL_ASSOC);
		$nombreFoto = $rowFoto["img"];
		pg_free_result($resultFoto);

		$resultPelicula = pg_query($queryInfo) or die('La consulta fallo: ' . pg_last_error());
		$rowPelicula = pg_fetch_array($resultPelicula, null, PGSQL_ASSOC);
		$nombrePelicula = $rowPelicula["nombre"];
		$genero = $rowPelicula["genero"];
		$idioma = $rowPelicula["idioma"];
		$subtitulada = $rowPelicula["subtitulada"];
		$fecha = $rowPelicula["fecha"];
		$director = $rowPelicula["director"];
		$sipnosis = $rowPelicula["sipnosis"];
		pg_free_result($resultPelicula);
	?>
    <nav>

        <div class="nav-wrapper">
            <a href="#" class="brand-logo">Logo</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a href="mostrarPeliculas.php?genero=<?php echo $generoTo?>&establecimiento=<?php echo $idEstablecimientoTo?>">Biblioteca</a></li>
                <li><a href="mostrarPeliculas.php">Opcion</a></li>
                <li><a href="mostrarPeliculas.php">Opcion</a></li>
                <li><a href="mostrarPeliculas.php">Opcion</a></li>
            </ul>
        </div>
    </nav><br><br>
    <div id="centro">
    	<h4 id="posicionTitulo">Descripcion Pelicula</h4><br><br>
        <div id="marcoPagina">
			<div id="marcoImagen">
	        		
				<img src="imagenes/<?php echo $nombreFoto?>" width="19%" height="19%">


				<div id="informacion">
					<table>
				        
				        <tr>
				          	<h5>Nombre:   <?php echo $nombrePelicula ?></h5>

				        </tr>
				        <tr>
				          	<h5>Genero:    <?php echo $genero ?></h5>

				        </tr>
				        <tr>
				          	<h5>Idioma:    <?php echo $idioma ?></h5>

				        </tr>
				        <tr>
				          	<h5>Subtitulos:   <?php echo $subtitulada ?></h5>

				        </tr>
				        <tr>
				          	<h5>Fecha :   <?php echo $fecha ?></h5>

				        </tr>
				        <tr>
				          	<h5>Director:   <?php echo $director ?></h5>

				        </tr>			      	
			      	</table><br>
				</div>
				<div id="sipnosis"></div>
					<table>
				      
				    	<tr>
				          	<h5>Sipnosis:</h5>

				          	</tr>
				          	<tr>
				          		<h5><?php echo $sipnosis ?></h5>

				        </tr>
				          			      	
			      	</table><br>

	        </div>

        	

            
			
        </div> 
    </div>  
	<div id="centro">
    	<h5 id="posicionTitulo">Especificacion de Horarios</h5><br><br>
        <div id="marcoPagina">
        	<table>
        		<thead>
          			<tr>
              			<th>Sala</th>
              			<th>Fecha</th>
              			<th>Inicio</th>
              			<th>Final</th>
          			</tr>
        		</thead>

		        <tbody>

	                <?php  
	                    $resultInfoSala = pg_query($queryInfoSala) or die('La consulta fallo: ' . pg_last_error());
	                    while($rowSala = pg_fetch_array($resultInfoSala, null, PGSQL_ASSOC)){
							$nombreSala = $rowSala["nombresalavar"];
							$fechaInicio = $rowSala["horarioiniciovar"];
							$fechaFinal = $rowSala["horariofinalvar"];
							$fecha = $rowSala["fecha"];
	                ?>
	                		<tr>
				            	<td><?php echo $nombreSala?></td>
				            	<td><?php echo $fechaInicio?></td>
				            	<td><?php echo $fechaFinal?></td>
				            	<td><?php echo $fecha?></td>
		          			</tr>
	                <?php
	                        
	                    }
	                    pg_close( $db_connection);
	                ?>

		        </tbody>
      		</table>
			
        </div> 
    </div> 

</body>
</html>