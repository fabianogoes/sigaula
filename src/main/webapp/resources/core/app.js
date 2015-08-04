

var app = angular.module('app', ['ngRoute']);

//var SERVER_APP = '/sigaula';
var SERVER_APP = 'https://sigaula.herokuapp.com';

app.config(['$routeProvider', function($routeProvider) {
        
        $routeProvider
                //.when('/',                    { redirectTo: '/'})
        		/**
        		 * Show Page Welcome
        		 */
                .when('/', { templateUrl: SERVER_APP + '/welcome'})
                /**
                 * Show Page About
                 */
                .when('/sobre', { templateUrl: SERVER_APP + '/about'})
                /**
                 * Show Page List
                 */
                .when('/aluno', { templateUrl: SERVER_APP + '/aluno/pageList'})
                /**
                 * Show Page Form to Create
                 */
                .when('/aluno/form', { templateUrl: SERVER_APP + '/aluno/pageForm'})
                /**
                 * Show Page Form to Update
                 */
                .when('/aluno/:id', { templateUrl: SERVER_APP + '/aluno/pageForm'})
                /**
                 * Show Page Welcome
                 */
                .otherwise({redirectTo: '/'});
}]);  

 