/**
 * Created by Roberto y Leidy on 3/3/2017.
 */
angular.module('proyodonto')
    .controller("loginCtrl", function($scope, $location, notificaciones,$http) {

        $scope.hola = function hola() {
            console.log("ojo");


                var user=$("#email").val();
                var passs=$("#pass").val();

                //notificaciones.notificacion2(user,user+" "+passs,"bien");
            var ur="http://192.168.43.49/estudiantes/estudiante/"+user+"/"+passs;
            $http({
                method: "GET",
                url: ur,
            }).then(function mySucces(response) {

                var datos=response.data;
                console.log("work");
                if(datos.carne!="0"){
                    $location.path("/menu");
                }
                else{
                    notificaciones.notificacion2("Error","Datos inconsistentes","ojo");
                }
            });


            /*$.ajax({
                type: "GET",
                url: ur,
                success: function (data) {
                        console.log(data);

                       // $location.path('/menu');
                    },
                error: function OnGetMemberSuccess(data) {
                    console.log("Se obtuvo un error");
                },
            });*/






        }

    });