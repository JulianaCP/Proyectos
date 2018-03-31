/**
 * Created by Juliana on 17/04/2017.
 */

angular.module('mantenimientoApp', ["ngRoute"])

 .controller("crearController", function($scope,$http) {
    $scope.personas = [{"nombreUsuario":"Anthony","contrasena":"132","nombre":"Anthony","apellido1":"Montero","apellido2":"Campos","correo":"montero@gmail.com","telefono":"89619415","rol":"Profesor","activo":"Si"},{"nombreUsuario":"Brenes02","contrasena":"Brenes02","nombre":"Josue","apellido1":"Brenes","apellido2":"Rojas","correo":"kkk@hotmail.com","telefono":"88610001","rol":"Tecnico","activo":"Si"},{"nombreUsuario":"FabiR03","contrasena":"FabiR03","nombre":"Fabiola","apellido1":"Rosales","apellido2":"Fonseca","correo":"fff@hotmail.com","telefono":"54210012","rol":"Operador","activo":"Si"},{"nombreUsuario":"JCP27","contrasena":"123","nombre":"Juliana","apellido1":"Campos","apellido2":"Parajeles","correo":"JCP27@hotmail.com","telefono":"86806809","rol":"Administrador","activo":"Si"},{"nombreUsuario":"Marcos06","contrasena":"Marcos06","nombre":"Marcos","apellido1":"Elizondo","apellido2":"Torres","correo":"yyy@hotmail.com","telefono":"78128994","rol":"Profesor","activo":"Si"},{"nombreUsuario":"Maria2","contrasena":"3212","nombre":"Maria2","apellido1":"Rojas2","apellido2":"Brenes2","correo":"Maria2@gmail.com","telefono":"85639405","rol":"Tecnico","activo":"Si"}];
    $scope.crear = function crear() {
        var permisoAdmin = "S";
        var nombreUsuario = "nombreUsuarioVar";
        var contrasena = "contrasenaVar";
        var nombre = "nombreVar";
        var apellido1 = "apellido1Var";
        var apellido2 = "apellido2Var";
        var correo = "correoVar@hotmail.com";
        var telefono = "86806809";
        var rol = "Profesor";

        console.log("Entra crear");
        var ur = "http://172.24.43.15:8090/Usuarios/insertarUsuario/"+permisoAdmin+"/ "+ tipoUsuario;
        $http({
            method: "POST",
            url: ur
        }).success(function (result) {
            alert("si");
        }).error(function(error){
            alert("No");
        });
    };
    $scope.eliminar = function eliminar(valorEliminar) {
        console.log("valor Eliminar: "+valorEliminar);
        $scope.personas = [{"nombreUsuario":"Anthony","contrasena":"132","nombre":"Anthony","apellido1":"Montero","apellido2":"Campos","correo":"montero@gmail.com","telefono":"89619415","rol":"Profesor","activo":"Si"},{"nombreUsuario":"Brenes02","contrasena":"Brenes02","nombre":"Josue","apellido1":"Brenes","apellido2":"Rojas","correo":"kkk@hotmail.com","telefono":"88610001","rol":"Tecnico","activo":"Si"},{"nombreUsuario":"FabiR03","contrasena":"FabiR03","nombre":"Fabiola","apellido1":"Rosales","apellido2":"Fonseca","correo":"fff@hotmail.com","telefono":"54210012","rol":"Operador","activo":"Si"},{"nombreUsuario":"JCP27","contrasena":"123","nombre":"Juliana","apellido1":"Campos","apellido2":"Parajeles","correo":"JCP27@hotmail.com","telefono":"86806809","rol":"Administrador","activo":"Si"},{"nombreUsuario":"Marcos06","contrasena":"Marcos06","nombre":"Marcos","apellido1":"Elizondo","apellido2":"Torres","correo":"yyy@hotmail.com","telefono":"78128994","rol":"Profesor","activo":"Si"},{"nombreUsuario":"Maria2","contrasena":"3212","nombre":"Maria2","apellido1":"Rojas2","apellido2":"Brenes2","correo":"Maria2@gmail.com","telefono":"85639405","rol":"Tecnico","activo":"Si"}];
    };
});