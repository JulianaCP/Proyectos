/**
 * Created by Juliana on 17/04/2017.
 */

angular.module('mantenimientoApp')
    .controller('homeCtrl', function($scope,$http) {

        var tipoUsuario = "N";
        var ur = "http://172.24.41.206:8090/Usuarios/obtenerListaUsuarios/" + tipoUsuario;
        console.log("ur: "+ur);
        $http({
            method: "GET",
            url: ur
        }).success(function (result) {
            $scope.personas = result;
        }).error(function(error){
            alert("No ");
        });

        $scope.mostrarLista = function() {

            tipoUsuario = $scope.valorSelect;
            var ur = "http://172.24.41.206:8090/Usuarios/obtenerListaUsuarios/" + tipoUsuario;
            console.log("ur: "+ur);
            $http({
                method: "GET",
                url: ur,
            }).success(function (result) {
                $scope.personas = result;
            }).error(function(error){
                alert("No ");
            });
        };
        $scope.eliminar = function eliminar(valorEliminar) {
            console.log("valor Eliminar: "+valorEliminar);

            //eliminar
            var ur = "http://172.24.41.206:8090/Usuarios/eliminarUsuario/" + valorEliminar;
            $http({
                method: "POST",
                url: ur
            }).success(function (result) {
                alert("se elimino")
            }).error(function(error){
                alert("No ");
            });

            //obtener
            var ur = "http://172.24.41.206:8090/Usuarios/obtenerListaUsuarios/" + tipoUsuario;
            console.log("ur: "+ur);
            $http({
                method: "GET",
                url: ur,
            }).success(function (result) {
               // alert("si");
                $scope.personas = result;
            }).error(function(error){
                alert("No ");
            });
        };
    });