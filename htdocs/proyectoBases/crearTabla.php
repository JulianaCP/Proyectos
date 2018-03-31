<?php

		include('connection.php');


		

		$nameOfTable = $_POST["sendingNameTableName"];
		$schemaNameTable = $_POST["sendingEsquemaTableName"];
		$fileGroupNameTable = $_POST["sendingFileGroupTableName"];		



		$attributeListString = $_POST["sendingAttributeListName"];
		$nullListString = $_POST["sendingNullListName"];
		$keysListString = $_POST["sendingPrimaryKeyListName"];
		$dataTypeListString = $_POST["sendingDataTypeListName"];



		$varListaAtributosConSplit = explode(' ', $attributeListString);
		$varListaNullConSplit = explode(' ', $nullListString);
		$varListaKeysConSplit = explode(' ', $keysListString);
		$varDataTypeConSplit = explode(' ', $dataTypeListString);



		if( count($varListaAtributosConSplit) <= 0){
			header("Location: http://localhost/proyectoBases/solicitarNombre_FileGroup_Esquema.php");
		}


		$query = "create table " . $schemaNameTable . "." . $nameOfTable . "( ";

		
		$contraintPrimary = "";
		$primer = "false";
		for($i=0;$i<count($varListaKeysConSplit);$i++) {
			if($varListaKeysConSplit[$i] == "si"){

				if($primer=="true"){
					$contraintPrimary = $contraintPrimary . " , " .  $varListaAtributosConSplit[$i];
				}
				if($primer == "false"){
					$contraintPrimary = $contraintPrimary . " constraint PK" . $nameOfTable . $varListaAtributosConSplit[$i] . " Primary key (" . $varListaAtributosConSplit[$i];	
					$primer = "true";				
				}		
			}
		}			
	
		$contraintPrimary = $contraintPrimary . " )";		


		$primera = "false";
		for($i=0;$i<count($varListaAtributosConSplit);$i++) {
			if($primera =="true"){
				$query = $query . ", " . $varListaAtributosConSplit[$i] . " " . $varDataTypeConSplit[$i] . " ";


				if($varListaNullConSplit[$i] == "no"){

				 	$query = $query . "not null";		
				}
				if($varListaNullConSplit[$i] == "si"){
					$query = $query . "null";
				}
	
			}
			if($primera =="false"){
				$query = $query . $varListaAtributosConSplit[$i] . " " . $varDataTypeConSplit[$i] . " ";

				if($varListaNullConSplit[$i] == "no"){

				 	$query = $query . "not null";		
				}
				if($varListaNullConSplit[$i] == "si"){
					$query = $query . "null";
				}
				$primera = "true";		
			}


		



			
		}
	
		
		if($primer!="false"){
			$query = $query . ", " . $contraintPrimary;
		}
		$query = $query . ")" ;

		if($fileGroupNameTable == "PRIMARY"){
			" on " . $fileGroupNameTable;
		}
		


		echo $query;


		$ejecucionCreacionTabla = sqlsrv_query( $conn, $query );

		if( $ejecucionCreacionTabla == false) {
		   	die( print_r( sqlsrv_errors(), true) );
		}


		//menu
		//header("Location: http://localhost/proyectoBases/solicitarNombre_FileGroup_Esquema.php");
?>
