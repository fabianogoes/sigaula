var app = angular.module('app', ['ngRoute']);

//var SERVER_APP = "/sigaula";

//***********************************************
// para deploy no heroku
//***********************************************
var SERVER_APP = "https://sigaula.herokuapp.com";

//app.$inject = ["$rootScope", "$window"];
//app.run(["$rootScope", "$window", function ($rootScope, $window) {
//	SERVER_APP = $window.location.href.contains( "heroku" ) ? "https://sigaula.herokuapp.com" : "/sigaula";
//	
//	console.log( "run..." + SERVER_APP );
//	console.log( "contains = " + $window.location.href.contains( "heroku" ) );
//	console.log( "$window.location.href = "+$window.location.href );
//}] );

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
                .when('/aluno', { templateUrl: SERVER_APP + '/aluno/pageList'})
                .when('/aluno/form', { templateUrl: SERVER_APP + '/aluno/pageForm'})
                .when('/aluno/:id', { templateUrl: SERVER_APP + '/aluno/pageForm'})
                
                .when('/professor', { templateUrl: SERVER_APP + '/professor/pageList'})
                .when('/professor/form', { templateUrl: SERVER_APP + '/professor/pageForm'})
                .when('/professor/:id', { templateUrl: SERVER_APP + '/professor/pageForm'})
                
                .when('/curso', { templateUrl: SERVER_APP + '/curso/pageList'})
                .when('/curso/form', { templateUrl: SERVER_APP + '/curso/pageForm'})
                .when('/curso/:id', { templateUrl: SERVER_APP + '/curso/pageForm'})                
                
                .when('/turma', { templateUrl: SERVER_APP + '/turma/pageList'})
                .when('/turma/form', { templateUrl: SERVER_APP + '/turma/pageForm'})
                .when('/turma/:id', { templateUrl: SERVER_APP + '/turma/pageForm'})                
                
                .otherwise({redirectTo: '/'});
}]);  

 