/**
 * Created by Juliana on 17/04/2017.
 */

angular.module('mantenimientoApp')
    .controller('editarCtrl', function($scope,$http,$routeParams) {
        var userName = $routeParams.userName;
        alert("valor param: "+userName);

        var ur = "http://172.24.41.206:8090/Usuario/ObtenerInfo/" + userName;
        var nombreUsuarioOLD;
        $http({
            method: "GET",
            url: ur
        }).success(function (result) {

            $scope.nombreUsuarioVar = result.nombreUsuario;
            nombreUsuarioOLD = result.nombreUsuario;
            $scope.contrasenaVar = result.contrasena;
            $scope.nombreVar = result.nombre;
            $scope.apellido1Var = result.apellido1;
            $scope.apellido2Var = result.apellido2;
            $scope.correoVar = result.correo;
            $scope.telefonoVar = result.telefono;
            $scope.rolVar = result.rol;

            alert("Datos Antes -> nombreUsuario: " + result.nombreUsuario +"   contraseña: "+result.contrasena+ "   nombre: "
                + result.nombre
                +"    apellido1: " + result.apellido1+ "    apellido2: "+result.apellido2+"    correo: "+ result.correo+ "    telefono: "+ result.telefono
                + "    rol: "+result.rol + "   old: " +nombreUsuarioOLD );

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



            var usuarioObjeto = $.param({nombreUsuario: nombreUsuario,contrasena: contrasena,
                nombre: nombre,apellido1:apellido1,apellido2:apellido2,correo:correo,
                telefono:telefono,rol:rol,activo:"Si"});

            var urlEditar = "http://172.24.41.206:8090/Usuarios/actualizarUsuario/S/" + nombreUsuarioOLD;
            $http({
                method: "POST",
                url: urlEditar,
                data: usuarioObjeto,
                headers:  {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function (result) {
                alert("si");
                window.location.href = ('#/user/home');
            }).error(function(error){
                alert("No "+ error.text);
            });

        };



    });