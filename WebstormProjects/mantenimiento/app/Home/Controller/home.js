/**
 * Created by Juliana on 17/04/2017.
 */


angular.module('mantenimientoApp', ["ngRoute"])
    .controller("homeController", function($scope,$http) {
        var tipoUsuario = "N";
        var ur = "http://172.24.42.236:8090/Usuarios/obtenerListaUsuarios/" + tipoUsuario;
        console.log("ur: "+ur);
        $http({
            method: "GET",
            url: ur
        }).success(function (result) {
            $scope.personas = result;
        }).error(function(error){
            alert("No ");
        });

        // $scope.personas = [{"nombreUsuario":"Anthony","contrasena":"132","nombre":"Anthony","apellido1":"Montero","apellido2":"Campos","correo":"montero@gmail.com","telefono":"89619415","rol":"Profesor","activo":"Si"},{"nombreUsuario":"Brenes02","contrasena":"Brenes02","nombre":"Josue","apellido1":"Brenes","apellido2":"Rojas","correo":"kkk@hotmail.com","telefono":"88610001","rol":"Tecnico","activo":"Si"},{"nombreUsuario":"FabiR03","contrasena":"FabiR03","nombre":"Fabiola","apellido1":"Rosales","apellido2":"Fonseca","correo":"fff@hotmail.com","telefono":"54210012","rol":"Operador","activo":"Si"},{"nombreUsuario":"JCP27","contrasena":"123","nombre":"Juliana","apellido1":"Campos","apellido2":"Parajeles","correo":"JCP27@hotmail.com","telefono":"86806809","rol":"Administrador","activo":"Si"},{"nombreUsuario":"Marcos06","contrasena":"Marcos06","nombre":"Marcos","apellido1":"Elizondo","apellido2":"Torres","correo":"yyy@hotmail.com","telefono":"78128994","rol":"Profesor","activo":"Si"},{"nombreUsuario":"Maria2","contrasena":"3212","nombre":"Maria2","apellido1":"Rojas2","apellido2":"Brenes2","correo":"Maria2@gmail.com","telefono":"85639405","rol":"Tecnico","activo":"Si"}];
        $scope.mostrarLista = function() {
            //var tipoUsuario = $scope.valorSelect;

            tipoUsuario = $scope.valorSelect;
            var ur = "http://172.24.42.236:8090/Usuarios/obtenerListaUsuarios/" + tipoUsuario;
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
            var ur = "http://172.24.42.236:8090/Usuarios/eliminarUsuario/" + valorEliminar;
            $http({
                method: "POST",
                url: ur
            }).success(function (result) {
                alert("si")
            }).error(function(error){
                alert("No ");
            });

            //obtener
            var ur = "http://172.24.42.236:8090/Usuarios/obtenerListaUsuarios/" + tipoUsuario;
            console.log("ur: "+ur);
            $http({
                method: "GET",
                url: ur,
            }).success(function (result) {
                alert("si");
            }).error(function(error){
                alert("No ");
            });
        };
    });




/*
funcion para ng-view   trabajando



 angular.module('mantenimientoApp', ["ngRoute"])
 .controller("homeController", function($scope,$http) {
 var tipoUsuario = "N";
 var ur = "http://172.24.42.236:8090/Usuarios/obtenerListaUsuarios/" + tipoUsuario;
 console.log("ur: "+ur);
 $http({
 method: "GET",
 url: ur,
 }).success(function (result) {
 $scope.personas = result;
 }).error(function(error){
 alert("No ");
 });

 // $scope.personas = [{"nombreUsuario":"Anthony","contrasena":"132","nombre":"Anthony","apellido1":"Montero","apellido2":"Campos","correo":"montero@gmail.com","telefono":"89619415","rol":"Profesor","activo":"Si"},{"nombreUsuario":"Brenes02","contrasena":"Brenes02","nombre":"Josue","apellido1":"Brenes","apellido2":"Rojas","correo":"kkk@hotmail.com","telefono":"88610001","rol":"Tecnico","activo":"Si"},{"nombreUsuario":"FabiR03","contrasena":"FabiR03","nombre":"Fabiola","apellido1":"Rosales","apellido2":"Fonseca","correo":"fff@hotmail.com","telefono":"54210012","rol":"Operador","activo":"Si"},{"nombreUsuario":"JCP27","contrasena":"123","nombre":"Juliana","apellido1":"Campos","apellido2":"Parajeles","correo":"JCP27@hotmail.com","telefono":"86806809","rol":"Administrador","activo":"Si"},{"nombreUsuario":"Marcos06","contrasena":"Marcos06","nombre":"Marcos","apellido1":"Elizondo","apellido2":"Torres","correo":"yyy@hotmail.com","telefono":"78128994","rol":"Profesor","activo":"Si"},{"nombreUsuario":"Maria2","contrasena":"3212","nombre":"Maria2","apellido1":"Rojas2","apellido2":"Brenes2","correo":"Maria2@gmail.com","telefono":"85639405","rol":"Tecnico","activo":"Si"}];
 $scope.mostrarLista = function() {
 //var tipoUsuario = $scope.valorSelect;

 tipoUsuario = $scope.valorSelect;
 var ur = "http://172.24.42.236:8090/Usuarios/obtenerListaUsuarios/" + tipoUsuario;
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
 var ur = "http://172.24.42.236:8090/Usuarios/eliminarUsuario/" + valorEliminar;
 $http({
 method: "POST",
 url: ur,
 }).success(function (result) {
 alert("si")
 }).error(function(error){
 alert("No ");
 });

 //obtener
 var ur = "http://172.24.42.236:8090/Usuarios/obtenerListaUsuarios/" + tipoUsuario;
 console.log("ur: "+ur);
 $http({
 method: "GET",
 url: ur,
 }).success(function (result) {
 alert("si");
 }).error(function(error){
 alert("No ");
 });
 };
 });

* */







/*


funciona sin ng-view

 var app = angular.module('mantenimientoApp',[]);

 app.controller("homeController", function($scope,$http) {
 var tipoUsuario = "N";
 var ur = "http://172.24.42.100:8090/Usuarios/obtenerListaUsuarios/" + tipoUsuario;
 console.log("ur: "+ur);
 $http({
 method: "GET",
 url: ur,
 }).success(function (result) {
 $scope.personas = result;
 }).error(function(error){
 alert("No ");
 });

 // $scope.personas = [{"nombreUsuario":"Anthony","contrasena":"132","nombre":"Anthony","apellido1":"Montero","apellido2":"Campos","correo":"montero@gmail.com","telefono":"89619415","rol":"Profesor","activo":"Si"},{"nombreUsuario":"Brenes02","contrasena":"Brenes02","nombre":"Josue","apellido1":"Brenes","apellido2":"Rojas","correo":"kkk@hotmail.com","telefono":"88610001","rol":"Tecnico","activo":"Si"},{"nombreUsuario":"FabiR03","contrasena":"FabiR03","nombre":"Fabiola","apellido1":"Rosales","apellido2":"Fonseca","correo":"fff@hotmail.com","telefono":"54210012","rol":"Operador","activo":"Si"},{"nombreUsuario":"JCP27","contrasena":"123","nombre":"Juliana","apellido1":"Campos","apellido2":"Parajeles","correo":"JCP27@hotmail.com","telefono":"86806809","rol":"Administrador","activo":"Si"},{"nombreUsuario":"Marcos06","contrasena":"Marcos06","nombre":"Marcos","apellido1":"Elizondo","apellido2":"Torres","correo":"yyy@hotmail.com","telefono":"78128994","rol":"Profesor","activo":"Si"},{"nombreUsuario":"Maria2","contrasena":"3212","nombre":"Maria2","apellido1":"Rojas2","apellido2":"Brenes2","correo":"Maria2@gmail.com","telefono":"85639405","rol":"Tecnico","activo":"Si"}];
 $scope.mostrarLista = function() {
 //var tipoUsuario = $scope.valorSelect;

 tipoUsuario = $scope.valorSelect;
 var ur = "http://172.24.42.100:8090/Usuarios/obtenerListaUsuarios/" + tipoUsuario;
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
 var ur = "http://172.24.42.236:8090/Usuarios/eliminarUsuario/" + valorEliminar;
 $http({
 method: "POST",
 url: ur,
 }).success(function (result) {
 alert("si")
 }).error(function(error){
 alert("No ");
 });

 //obtener
 var ur = "http://172.24.42.236:8090/Usuarios/obtenerListaUsuarios/" + tipoUsuario;
 console.log("ur: "+ur);
 $http({
 method: "GET",
 url: ur,
 }).success(function (result) {
 alert("si");
 }).error(function(error){
 alert("No ");
 });
 };
 });


*/



  