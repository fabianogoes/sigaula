var app = angular.module('app', []);

var SERVER_APP = '/sigaula';

//app.config(['$routeProvider', function($routeProvider) {
//	$routeProvider
//		.when('/', { templateUrl: SERVER_APP + '/home'});
//		.when('/campeonato/novo', { templateUrl: SERVER_APP + '/campeonato/novo'})	 
//		.when('/edicao/pendentes', { templateUrl: SERVER_APP + '/edicao/list'})		 
//		.when('/edicao/novo',      { templateUrl: SERVER_APP + '/edicao/novo'}) 
//		.when('/edicao/novo/:id',  { templateUrl: SERVER_APP + '/edicao/novo'})
//		.when('/grupo/novo/edicao/:edicaoId',  { templateUrl: SERVER_APP + '/grupo/novo'})
//		.when('/classificacao/novo/edicao/:edicaoId',  { templateUrl: SERVER_APP + '/classificacao/novo'});
//}]);  