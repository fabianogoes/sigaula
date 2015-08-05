var app = angular.module('app', ['ngRoute']);

var SERVER_APP = "/sigaula";
console.log( "init..." + SERVER_APP );


app.$inject = ["$rootScope", "$window"];
app.run(["$rootScope", "$window", function ($rootScope, $window) {
	SERVER_APP = $window.location.href.contains( "heroku" ) ? "https://sigaula.herokuapp.com" : "/sigaula";
	
	console.log( "run..." + SERVER_APP );
	console.log( "contains = " + $window.location.href.contains( "heroku" ) );
	console.log( "$window.location.href = "+$window.location.href );
}] );

app.config(['$routeProvider', '$window', function($routeProvider, $window) {
//	    SERVER_APP = $window.location.href.contains( "herokuapp.com" ) ? "https://sigaula.herokuapp.com" : "/sigaula";
	    console.log( "config..." + SERVER_APP );
	
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

 