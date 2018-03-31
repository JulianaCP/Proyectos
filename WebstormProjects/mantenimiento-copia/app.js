/**
 * Created by Juliana on 07/04/2017.
 */

'use strict';


angular.module('mantenimientoApp', ['ngRoute','ngStorage','jlareau.pnotify'])
    .config(function($routeProvider,$http)
    {
        $routeProvider
            .when('/login', {
                templateUrl	: 'app/Login/login.html',
                controller 	: 'loginController'
            })
            .when("/login/homePage",{
                templateUrl:'app/home/homePage.html',
                controller: 'home'
            })
            .otherwise({
                redirectTo: '/'
            });
    });