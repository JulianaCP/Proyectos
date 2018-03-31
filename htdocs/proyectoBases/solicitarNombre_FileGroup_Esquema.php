
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<?php

		include('connection.php');




		$selectFileGroup = "select name from sys.filegroups";

		$selectEsquema= "select SCHEMA_NAME from INFORMATION_SCHEMA.SCHEMATA";



	?>
	

	<style type="text/css">
		#centro{
			align-position:center;
			padding-left: 35%;
			padding-right: 35%;
			padding-top: 1%;


		}
		.labelDatos{
		    display: block;
		    font-size: 1.4em;
		    font-weight: bold;
		}
		.labelTitulo{
		    display: block;
		    font-size: 2em;
		    font-weight: bold;
		    color: #184C1E;
		    margin-left: 90px;
		}
		#centroDiv {
		    border-radius: 5px;
		    background-color: #f2f2f2;
		    padding: 20px;
		}
		.cuadros {
		    width: 100%;
		    padding: 12px 20px;
		    margin: 8px 0;
		    display: inline-block;
		    border: 1px solid #ccc;
		    border-radius: 4px;
		    box-sizing: border-box;
		}

		#boton{
			width: 100%;
		    background-color: #4CAF50;
		    color: white;
		    padding: 14px 20px;
		    margin: 8px 0;
		    border: none;
		    border-radius: 4px;
		    cursor: pointer;
		}

		#boton:hover{
			background-color: #45a049;
		}
		#botonAtras{
			background-color: #4CAF50; /* Green */
		    border: none;
		    color: white;
		    padding: 15px 32px;
		    text-align: center;
		    text-decoration: none;
		    display: inline-block;
		    font-size: 16px;
		    margin: 4px 2px;
		    cursor: pointer;
		    -webkit-transition-duration: 0.4s; /* Safari */
		    transition-duration: 0.4s;
		}
		#botonAtras:hover{
			box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
		}

	</style>

</head>
<body >

	<form name="devolverseMenu" method="post" action="menu.php">
		<input id="botonAtras" type="submit"  value='Atras' ></input>


	</form>

	<form name="formObtener_nombre_esquema_fileGroup" method="post" action="agregarColumnas.php">
		


		<div id="centro">
			<label class="labelTitulo" for="nombreTablaVar">  Creacion Tabla</label><br><br>

			<div id="centroDiv">
				
				<label class="labelDatos" for="nombreTablaVar">Nombre Tabla: </label><br>
				<input class="cuadros" value="" id="nombreTablaVar" name="nombreTabla" type="text" >
				 


			
				<br><br><br>
				<label  class="labelDatos">Nombre FileGroup:</label><br>
		      	<select class="cuadros" name="nombreFileGroupSelected">
			        <?php


			        	$registrosFileGroup = sqlsrv_query( $conn, $selectFileGroup );

						if( $registrosFileGroup == false) {
					    	die( print_r( sqlsrv_errors(), true) );
						}

						while( $filaFileGroup = sqlsrv_fetch_array( $registrosFileGroup, SQLSRV_FETCH_ASSOC) ) {
						      $comboBoxFileGroup="<option value='".$filaFileGroup['name']."'>".$filaFileGroup['name']."</option>";
						      echo $comboBoxFileGroup	;

						}

						sqlsrv_free_stmt( $registrosFileGroup);
			        	
			        ?>
		      	</select>

		      	<br><br><br>

				<label class="labelDatos">Nombre Esquema:</label><br>
		      	<select class="cuadros" name="nombreSchemaSelected">
			        <?php


			        	$registrosEsquema = sqlsrv_query( $conn, $selectEsquema );

						if( $registrosEsquema == false) {
					    	die( print_r( sqlsrv_errors(), true) );
						}

						while( $filaEsquema = sqlsrv_fetch_array( $registrosEsquema, SQLSRV_FETCH_ASSOC) ) {
						      $comboBoxEsquema="<option value='".$filaEsquema['SCHEMA_NAME']."'>".$filaEsquema['SCHEMA_NAME']."</option>";
						      echo $comboBoxEsquema	;

						}

						sqlsrv_free_stmt( $registrosEsquema);
			        	
			        ?>
		      	</select><br><br><br>
					

				<input id="boton" type="submit"  value='Continuar' ></input>	


			</div>
			
			
				

		</div>

	</form>





       

</body>
</html>

