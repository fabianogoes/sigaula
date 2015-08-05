var app = angular.module('app', ['ngRoute']);

var SERVER_APP;


app.$inject = ["$rootScope", "$window"];
app.run(["$rootScope", "$window", function ($rootScope, $window) {
	console.log( "$window.location.href = "+$window.location.href );
	SERVER_APP = $window.location.href.contains( "heroku" ) ? "https://sigaula.herokuapp.com" : "/sigaula"; 
}] );

console.log( "SERVER_APP = "+SERVER_APP );

//var SERVER_APP = 'https://sigaula.herokuapp.com';


app.config(['$routeProvider', function($routeProvider) {
        
	    SERVER_APP = $window.location.href.contains( "herokuapp.com" ) ? "https://sigaula.herokuapp.com" : "/sigaula";
	
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

 