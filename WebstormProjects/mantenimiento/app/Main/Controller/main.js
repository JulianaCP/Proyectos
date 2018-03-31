/**
 * Created by Juliana on 26/04/2017.
 */
angular.module('mantenimientoApp')
    .controller('mainController', function($scope,$location) {
        /* config object */

        /* var usuario = JSON.parse(sessionStorage.getItem("user"));

         $scope.user = usuario.name;
         $scope.email= usuario.email;*/
        $scope.user = "Ejemplo";
        $scope.email = "Ejemplo@TEC.ac.cr";
        //window.location.href = ('#/notificacion');
    });