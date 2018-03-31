/**
 * Created by Juliana on 19/04/2017.
 */



var app = angular.module('mantenimientoApp',[]);

app.controller("editarController", function($scope,$http) {
    var userName = "Alvarado";

        
        var ur = "http://172.24.42.100:8090/Usuario/ObtenerInfo/" + userName;
        var nombreUsuarioOLD;
        $http({
            method: "GET",
            url: ur
        }).success(function (result) {
         
            $scope.nombreUsuarioVar = result.nombreUsuario;
            nombreUsuarioOLD = result.nombreUsuario;
            $scope.contrasenaVar = result.contrasena;
            $scope.nombreVar = result.nombreUsuario;
            $scope.apellido1Var = result.apellido1;
            $scope.apellido2Var = result.apellido2;
            $scope.correoVar = result.correo;
            $scope.telefonoVar = result.telefono;
            $scope.rolVar = result.rol;

        }).error(function(error){
            alert("No ");
        });
        //malo
        $scope.editarFun = function editarFun() {
            alert("entro");
            var permisoAdmin = "S";
            var nombreUsuario = $scope.nombreUsuarioVar;
            var contrasena = $scope.contrasenaVar;
            var nombre = $scope.nombreVar;
            var apellido1 = $scope.apellido1Var;
            var apellido2 = $scope.apellido2Var;
            var correo = $scope.correoVar;
            var telefono = $scope.telefonoVar;
            var rol = $scope.rolVar;
            alert("Datos -> nombreUsuario: " + nombreUsuario +"   contraseña: "+contrasena+ "   nombre: "+ nombre 
                +"    apellido1: " + apellido1+ "    apellido2: "+apellido2+"    correo: "+ correo+ "    telefono: "+ telefono
                + "    rol: "+rol  );


            var datos = "{ 'nombreUsuario' : '"+nombreUsuario+"','contraseña' :'" + contrasena
                + "', 'nombre' : '" + nombre + "', 'apellido1' : '" + apellido1 + "', 'apellido2' : '" + apellido2
                + "', 'correo' : '" + correo + "', 'telefono' : '" + telefono+ "', 'rol' : '" + rol+ "' }";

            var urEditar = "http://172.24.42.100:8090/Usuarios/actualizarUsuario/S/" + nombreUsuarioOLD;
            alert("url: " +urEditar);
            $http({
                method: "POST",
                url: urEditar,
                dataType: 'JSON',
                data: datos
            }).success(function (result) {
                alert("si modifico");
            }).error(function(error){
                alert("No modifico -> error: " +error);
            });
        };
    });




/*

funcion para ng- view    trabajando



* */