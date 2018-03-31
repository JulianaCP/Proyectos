/**
 * Created by Juliana on 17/04/2017.
 */

angular.module('mantenimientoApp')
    .controller('mainCtrl', function($scope,$location) {
    /* config object */

       /* var usuario = JSON.parse(sessionStorage.getItem("user"));

        $scope.user = usuario.name;
        $scope.email= usuario.email;*/
        $scope.user = sessionStorage.getItem("user");
        $scope.email = sessionStorage.getItem("correo");
        window.location.href = ('#/notificacion');
});