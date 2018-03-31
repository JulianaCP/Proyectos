/**
 * Created by Juliana on 17/04/2017.
 */

angular.module('mantenimientoApp')
    .controller('mainCtrl', function($scope,$location) {
        $scope.user = sessionStorage.getItem("user");
        $scope.email = sessionStorage.getItem("correo");
        window.location.href = ('#/notificacion');
});