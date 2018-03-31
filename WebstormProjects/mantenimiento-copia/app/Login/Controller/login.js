/**
 * Created by Juliana on 07/04/2017.
 */
var myApp = angular.module('mantenimientoApp', []);
myApp.controller('SpicyController', ['$scope','$http', function($scope, $http) {
    $scope.spice = 'very';
    $scope.jalapenoSpicy = function() {
        if ($scope.username && $scope.password) {
            var user = $scope.username;
            var pass = $scope.password;
            alert(user+pass);
            var ur = "http://172.24.40.212:8090/Usuarios/ObtenerInfo/" + user + "/" + pass;
            console.log(ur);
            $http({
                dataType: 'JSON',
                url: ur,
                data: {}
            }).then(function mySucces(response) {
                alert("Login");
                
                var datos = response.data;
                console.log("work");
                console.log(datos.nombreUsuario);
                console.log(datos.contrasena);
                if (datos.nombreUsuario == user && datos.contrasena == pass) {
                    alert("Login realizado");
                    $(location).attr('href',"http://localhost:63342/mantenimiento/app/home/homePage.html");
                    window.location.replace("http:/localhost:63342/mantenimiento/app/home/homePage.html")
                }
                else {
                    notificaciones.notificacion2("Error", "Datos inconsistentes", "ojo");
                }

            });
        } else {
            alert("Invalid Login");
        }
    };
}]);