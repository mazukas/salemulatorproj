(function () {
    'use strict';

    angular.module('app')
        .config(['$routeProvider', function($routeProvider) {
            var routes, setRoutes;

            routes = [
                'dashboard',
                'events/byApp'
            ]

            setRoutes = function(route) {
                var config, url;
                url = '/' + route;
                config = {
                    templateUrl: route + '.html'
                };
                $routeProvider.when(url, config);
                
                return $routeProvider;
            };

            routes.forEach(function(route) {
                return setRoutes(route);
            });

            $routeProvider
                .when('/', {redirectTo: '/dashboard'})
                .when('/dashboard', {templateUrl: 'dashboard/dashboard.html'})
                .when('/404', {templateUrl: 'page/404.html'})
                .otherwise({ redirectTo: '/404'});

        }]
    );

})(); 