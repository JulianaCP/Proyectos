<!DOCTYPE html>
<html>
<head>

	<title></title>
	<?php

		include('connection.php');

		$nombreTablaNueva = $_POST["nombreTabla"];
		$nombreFileGroup = $_POST["nombreFileGroupSelected"];
		$nombreEsquema = $_POST["nombreSchemaSelected"];


		$verificacionNombreTabla = explode(' ', $nombreTablaNueva);

		if( count($verificacionNombreTabla) > 1){
			header("Location: http://localhost/proyectoBases/solicitarNombre_FileGroup_Esquema.php");
		}
		if($nombreTablaNueva == ""){
			header("Location: http://localhost/proyectoBases/solicitarNombre_FileGroup_Esquema.php");
		}






		$repetida=false;
		$queryTablasBase = "select name from sys.tables";
	
		$registrosTablasBase = sqlsrv_query( $conn, $queryTablasBase);

		while( $filaTablas = sqlsrv_fetch_array( $registrosTablasBase, SQLSRV_FETCH_ASSOC) ) {
		     if($filaTablas['name'] ==  $nombreTablaNueva){
		     	$repetida=true;
		     	break;
		     }

		}
		sqlsrv_free_stmt( $registrosTablasBase);


		if( $repetida == true){
			header("Location: http://localhost/proyectoBases/solicitarNombre_FileGroup_Esquema.php");
		}









	?>

	<script type="text/javascript">
		

		var listaAtributos = [];
		var listaTiposDatos = [];
		var listaNulos = [];
		var listaLlaves = [];


		function habilitar(){
			document.getElementById("cantidadMemoria").disabled = false;
		}
		function deshabilitar(){
			document.getElementById("cantidadMemoria").disabled = true;
		}

		function cargarDatosPaginaPasada(){

			document.getElementById("sendingNameTable").value = "<?php echo $nombreTablaNueva;?>";
			document.getElementById("sendingEsquemaTable").value = "<?php echo $nombreEsquema;?>";
			document.getElementById("sendingFileGroupTable").value = "<?php echo $nombreFileGroup;?>";

		}


		function addAttribute(){

			

	
			var permissionsCorrect = false;
			
		
			var nameAttributeTable;
			var dataTypeSelected;
			var amountMemory;
			var nullAttribute;
			var primaryKeyAttribute;
			var inputSenddingListAtttributes;



			//obtain the name of the attribute
			nameAttributeTable = document.getElementById("nameAttributeTable").value;


			//getting the dataType of the attibute
			elementsDataTypes=document.getElementsByName('tipoDato');
		    for(i=0;i<elementsDataTypes.length;i++) 
		        if (elementsDataTypes[i].checked) { 
		            dataTypeSelected = elementsDataTypes[i].value; 
		            break; 
	        }

	        // getting amount of memory necessary in the datatype
	        amountMemory = document.getElementById("cantidadMemoria").value;


	        //null statement
	    	elemenentsNullStatements=document.getElementsByName('nullType');
		    for(i=0;i<elemenentsNullStatements.length;i++) 
		        if (elemenentsNullStatements[i].checked) { 
		            nullAttribute = elemenentsNullStatements[i].value; 
		            break; 
	        }    
/*
	       	//mixing the amount of memory necessary and the datatype
	        if(amountMemory!=""){
	        	
	        }
*/
	    	elemenentsPrimary=document.getElementsByName('primaryKey');
		    for(i=0;i<elemenentsPrimary.length;i++) 
		        if (elemenentsPrimary[i].checked) { 
		            primaryKeyAttribute = elemenentsPrimary[i].value; 
		            break; 
	        }   

	        if(nameAttributeTable!=""){
	        	



	        	if(dataTypeSelected=="varchar" || dataTypeSelected=="char"){
	        		if(amountMemory!=""){
	        			dataTypeSelected = dataTypeSelected + "(" + amountMemory + ")";
	        			permissionsCorrect = true;
	        			
	        		}
	        	}


	        	else{
	        		
	        		permissionsCorrect = true;
	        	}


	        }


	         
	        if(permissionsCorrect==true){
	        	
		        listaAtributos.push(nameAttributeTable); //name
		        listaTiposDatos.push(dataTypeSelected); //data type
		        listaNulos.push(nullAttribute);  // null statement
		        listaLlaves.push(primaryKeyAttribute); // is primary key



              	var tableAttributesEditor = document.getElementById("tableAtributos");

 

              	var rowLenPosition = tableAttributesEditor.rows.length;
               	var rowOfTable = tableAttributesEditor.insertRow(rowLenPosition);

 

            	var lineNameAttribute = document.createElement("td");
		      	var textLineNameAttribute = document.createTextNode(nameAttributeTable);
		      	lineNameAttribute.appendChild(textLineNameAttribute);
		     	rowOfTable.appendChild(lineNameAttribute);

       

                var lineDataType = document.createElement("td");
		      	var textLineDataType = document.createTextNode(dataTypeSelected);
		      	lineDataType.appendChild(textLineDataType);
		     	rowOfTable.appendChild(lineDataType);        	
            
 
                var lineNullStatements = document.createElement("td");
		      	var textLineNullStatements = document.createTextNode(nullAttribute);
		      	lineNullStatements.appendChild(textLineNullStatements);
		     	rowOfTable.appendChild(lineNullStatements);   				

                var linePrimaryKey = document.createElement("td");
		      	var textLinePrimaryKey = document.createTextNode(primaryKeyAttribute);
		      	linePrimaryKey.appendChild(textLinePrimaryKey);
		     	rowOfTable.appendChild(linePrimaryKey);   	

                var lineAction = document.createElement("td");
		      	var elementLineAction = document.createElement("input");
		      	elementLineAction.type="button";
		      	elementLineAction.value="eliminar";


		      	elementLineAction.onclick = function(){eliminarFila(this.parentNode.parentNode.rowIndex)}
		      	
		      	lineAction.appendChild(elementLineAction);
		     	rowOfTable.appendChild(lineAction);   


		     	actualizarDatos();
  



	        }
		}
		function actualizarDatos(){

			varSendingAttributeList = listaAtributos.join(' ');
			inputSenddingListAtttributes = document.getElementById("sendingAttributeList");
			inputSenddingListAtttributes.value = varSendingAttributeList;	


			varSendingKeyList = listaLlaves.join(' ');
			inputSenddingListKeys = document.getElementById("sendingPrimaryKeyList");
			inputSenddingListKeys.value = varSendingKeyList;



			varSendingNullStatementList = listaNulos.join(' ');
			inputSenddingListNulls = document.getElementById("sendingNullist");
			inputSenddingListNulls.value = varSendingNullStatementList;


			varSendingDataTypeList = listaTiposDatos.join(' ');
			inputSenddingListdataTypes = document.getElementById("sendingDataTypeList");
			inputSenddingListdataTypes.value = varSendingDataTypeList;




		}

		function eliminarFila(i){
			
			
			listaAtributos.splice(i-1,1);
			listaLlaves.splice(i-1,1);
			listaTiposDatos.splice(i-1,1);
			listaNulos.splice(i-1,1);

			actualizarDatos();
    		document.getElementById("tableAtributos").deleteRow(i);
    		
		}


	</script>
	

	<style type="text/css">



		#tableAtributos{
			border: 2px solid #a1a1a1;
    		padding: 10px 25px;
    		border-radius: 25px;
    		background: #dddddd;
		}	


		td{
			border: 1px solid;
			padding: 10px 40px;

		}


		#seccionIzquierda{
			display: inline-block;
			align-position: left;
			padding-left: 1%;
			
			padding-top: 1%;
			float: left;
			width: 30%;
		}

		#seccionDerecha{
			display: inline-block;
			align-position: right;
			
			padding-left: 4%;
			padding-top: 10%;
			float: left;
			width: 65%;


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
		    margin-left: 15px;
		    
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

		.boton{
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
<body onload="cargarDatosPaginaPasada()">


	<form name="devolverseMenu" method="post" action="solicitarNombre_FileGroup_Esquema.php">
		<input id="botonAtras" type="submit" class="waves-effect waves-light btn" value='Atras' ></input><br><br>


	</form>


	<form name="crearTabla" method="POST" action="crearTabla.php">

		<div id="seccionIzquierda">
			<label class="labelTitulo">  Crear Atributos de Tablas</label><br><br>
			<div id="centroDiv">
				
				<label class="labelDatos">Nombre de la columna:</label><br>
				<input  class="cuadros" type="text"  id="nameAttributeTable" name="nameAttributeTableName" value="" placeholder="name column"><br><br><br>

				<label class="labelDatos">Tipo de Dato</label><br>
				<input onclick="deshabilitar()" type="radio" name="tipoDato" id="radioButtonInt" value="int">int<br>
			  	<input onclick="deshabilitar()" type="radio" name="tipoDato" id="radioButtonDouble" value="double">double<br>
				<input onclick="habilitar()" type="radio" name="tipoDato" id="radioButtonVarchar"  checked="checked" value="varchar">varchar<br>
				<input onclick="habilitar()" type="radio" name="tipoDato" id="radioButtonChar" value="char">char<br><br><br>
				<label class="labelDatos">Establecer cantidad de Memoria</label><br>
				

				<input type="text"  class="cuadros" id="cantidadMemoria" placeholder="amount memory" value=""><br><br><br>

				<label class="labelDatos">Atributo null?</label><br>
				<input type="radio" name="nullType" id="radioNull" value="si">si<br>
			  	<input type="radio" name="nullType" id="radioNotNull" value="no" checked="checked">no<br><br><br>


			  	<label class="labelDatos">Atributo Primary Key?</label><br>
				<input type="radio" name="primaryKey" id="radioNull" value="si">si<br>
			  	<input type="radio" name="primaryKey" id="radioNotNull" value="no" checked="checked">no<br><br><br><br>


			  	<input type="hidden" id="sendingAttributeList" name="sendingAttributeListName" value="">
				<input type="hidden" id="sendingNullist" name="sendingNullListName" value="">
				<input type="hidden" id="sendingPrimaryKeyList" name="sendingPrimaryKeyListName" value="">
				<input type="hidden" id="sendingDataTypeList" name="sendingDataTypeListName" value="">



				<input type="hidden" id="sendingNameTable" name="sendingNameTableName" value="">
				<input type="hidden" id="sendingEsquemaTable" name="sendingEsquemaTableName" value="">
				<input type="hidden" id="sendingFileGroupTable" name="sendingFileGroupTableName" value="">





				<input class="boton" type="button" onclick="addAttribute()" value='Agregar' ></input><br><br><br><br>



				
			



			</div>

			
			

		</div>


		<div id="seccionDerecha">
			
				<label class="labelDatos">Tabla: vision general</label><br><br>
				<table id="tableAtributos" >
					<tr>
					  <td><strong>Nombre Atributo</strong></td>
					  <td><strong>Tipo Dato</strong></td>
					  <td><strong>Null or not Null</strong></td>
					  <td><strong>primary key</strong></td>
					  <td><strong>Action</strong></td>
					</tr>
				</table>

				<br><br><br>


		</div>
			
		<input type="submit" class="boton" value='Aceptar' ></input>
	</form>
		



</body>
</html>