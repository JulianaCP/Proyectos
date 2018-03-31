/**
 * Created by Juliana on 07/04/2017.
 */
angular.module('mantenimientoApp',["ngRoute"])
    .config(['$routeProvider',function($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'main.html',
                controller: 'mainController'
            })
            .when('/notificacion', {
                templateUrl: 'Notificacion/notificacion.html',
                controller: 'notificacionController'
            })
            .when('/main', {
                templateUrl: 'Main/main.html',
                controller: 'crearController'
            })
            .when('/crear', {
                templateUrl: 'Crear/crear.html',
                controller: 'crearController'
            })
            .when('/home', {
                redirectTo: 'Home/home.html',
                controller: 'homeController'
            })
            

    }
    ]);