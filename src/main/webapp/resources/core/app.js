

var app = angular.module('app', ['ngRoute']);

var SERVER_APP = '/sigaula';

app.config(['$routeProvider', function($routeProvider) {
        
        $routeProvider
                //.when('/',                    { redirectTo: '/'})
                .when('/', { templateUrl: SERVER_APP + '/home'})
                .when('/sobre', { templateUrl: SERVER_APP + '/sobre'})
                .when('/aluno', { templateUrl: SERVER_APP + '/aluno/'})
                .when('/aluno/add', { templateUrl: SERVER_APP + '/aluno/form'})
                .when('/aluno/edit/:id', { templateUrl: SERVER_APP + '/aluno/form'})
                .otherwise({redirectTo: '/'});
}]);  

 