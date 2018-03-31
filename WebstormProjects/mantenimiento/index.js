var app = angular.module('loginModule', ["ngRoute"])
    .controller('loginController', function($scope, $http) {
    $scope.accederLogin = function() {
        if ($scope.username && $scope.password) {
            var user = $scope.username;
            var pass = $scope.password;
            $(location).attr('href',"http://localhost:63342/mantenimiento/app/main.html");
            var ur = "http://172.24.42.236:8090/Usuarios/ObtenerInfo/" + user + "/" + pass;
            console.log(ur);

            $http({
                dataType: 'JSON',
                url: ur,
                data:{}
            }).then(function mySucces(response) {
                console.log("entro 1");
                var datos = response.data;
                console.log("work");
                console.log(datos.nombreUsuario);
                console.log(datos.contrasena);
                if (datos.nombreUsuario == user && datos.contrasena == pass) {
                    console.log("Login realizado");
                    $(location).attr('href',"http://localhost:63342/mantenimiento/app/main.html");
                }
                else {
                    notificaciones.notificacion2("Error", "Datos inconsistentes", "ojo");
                }
            });
        } else {
            alert("Invalid Login");
        }
    };
});

