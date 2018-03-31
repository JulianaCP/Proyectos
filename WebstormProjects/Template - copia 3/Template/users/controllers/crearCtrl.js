/**
 * Created by Juliana on 17/04/2017.
 */

angular.module('mantenimientoApp')
    .controller('crearCtrl', function($scope,$http) {
        $scope.crear = function crear() {
            var tipoUVar = $scope.tipoUsuario;
            var nombreVar = $scope.nombre;
            var primerApellidoVar = $scope.Apellido1;
            var segundoApellidoVar = $scope.Apellido2;
            var nombreUsuarioVar = $scope.nombreUsuario;
            var contrasenna1Var = $scope.contrasena;
            var contrasenna2Var = $scope.confirmarContrasena;
            var telefVar = $scope.telefono;
            var correoVar = $scope.correo;

            var tipoUsuario = "N";

        /*    alert("\nInfo: "+ tipoUVar+" "+nombreVar+" "+primerApellidoVar+" "+segundoApellidoVar+" "+contrasenna1Var+
                " "+contrasenna2Var+" "+telefVar+" "+correoVar);
         */
            if (tipoUVar== null || nombreVar == null ||primerApellidoVar== null||segundoApellidoVar== null||
                contrasenna1Var== null|| contrasenna2Var== null || telefVar == null || correoVar == null){
                alert("Error posibles datos nulos o sin valor (Espacios en blanco)");
                return;
            }

            if (contrasenna2Var != contrasenna1Var){
                alert("Contraseñas distintas");
                return;
            }

            var usuarioObjeto = $.param({nombreUsuario: nombreUsuarioVar,contrasena: contrasenna1Var,
                nombre: nombreVar,apellido1:primerApellidoVar,apellido2:segundoApellidoVar,correo:correoVar,
                telefono:telefVar,rol:tipoUVar,activo:"No"});

            var url = "http://172.24.41.206:8090/Usuarios/insertarUsuario/"+"S";
            $http({
                method: "POST",
                url: url,
                data: usuarioObjeto,
                headers:  {'Content-Type': 'application/x-www-form-urlencoded'}

            }).success(function (result) {
                alert("se creo");
                window.location.href = ('#/user/home');
            }).error(function(error){
                alert("No "+ error.text);
            });
        };
    });




