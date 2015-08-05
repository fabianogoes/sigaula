var app = angular.module('app', ['ngRoute']);

var url = "";
var SERVER_APP = '/sigaula';


app.$inject = ["$rootScope", "$window"];
app.run(["$rootScope", "$window", function ($rootScope, $window) {
	console.log( "$window.location.href = "+$window.location.href );
	SERVER_APP = $window.location.href.contains( "heroku" ) ? "https://sigaula.herokuapp.com" : SERVER_APP; 
}] );

console.log( "SERVER_APP = "+SERVER_APP );

//var SERVER_APP = 'https://sigaula.herokuapp.com';


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
                 * CRUD Aluno
                 */
                .when('/pessoa/aluno', { templateUrl: SERVER_APP + '/pessoa/pageList'})
                .when('/pessoa/aluno/form', { templateUrl: SERVER_APP + '/pessoa/pageForm'})
                .when('/pessoa/aluno/:id', { templateUrl: SERVER_APP + '/pessoa/pageForm'})
                
                .when('/pessoa/professor', { templateUrl: SERVER_APP + '/pessoa/pageList'})
                .when('/pessoa/professor/form', { templateUrl: SERVER_APP + '/pessoa/pageForm'})
                .when('/pessoa/professor/:id', { templateUrl: SERVER_APP + '/pessoa/pageForm'})
                
                .otherwise({redirectTo: '/'});
}]);  

 