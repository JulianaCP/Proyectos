/**
 * Created by Roberto y Leidy on 3/3/2017.
 */
angular.module('proyodonto')
    .controller("loginCtrl", function($scope, $location, notificaciones,$http) {
        $scope.hola = function hola() {
            var user= $("#email").val();
            var passs= $("#pass").val();
            var ur="http://172.24.42.129/estudiantes/estudiante/"+user+"/"+passs;
            $http({
                method: "GET",
                url: ur
            }).then(function mySucces(response) {

                var datos=response.data;
                if(datos.carne!="0"){
                    $location.path("/menu");
                }
                else{
                    notificaciones.notificacion2("Error","Datos inconsistentes","ojo");
                }
            });
        }

    });
