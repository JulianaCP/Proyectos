'use strict';

angular.module('proyodonto', ['ngRoute','ngStorage','jlareau.pnotify'])
    .config(function($routeProvider)
    {
        $routeProvider
            .when('/', {
                templateUrl	: 'appWeb/Enfermedades/enfermedad.html',
                controller 	: 'enfermedadCtrl'
            })
            .when('/menu', {
                templateUrl	: 'appWeb/Menu/menu.html',
                controller 	: 'menuCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });
    });
