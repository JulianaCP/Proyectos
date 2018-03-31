/**
 * Created by Erwin on 25/10/2016.
 */
angular.module('mantenimientoApp',["ngRoute","ngResource"])
.config(['$routeProvider',function($routeProvider)
    {
        $routeProvider
            
            .when("/notificacion",{
            templateUrl:'notificacion.html',
            controller: 'dashboardCtrl'
            })
            .when("/user/crear",{
                templateUrl:'crear/crear.html',
                controller: 'crearCtrl'
            })
            .when("/user/editar/:userName",{
                templateUrl:'editar/editar.html',
                controller: 'editarCtrl'
            })
            .when("/user/home",{
                templateUrl:'home/home.html',
                controller: 'homeCtrl'
            })

    }
]);
