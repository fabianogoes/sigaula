app.controller('AlunoController', ['$http', '$location', '$window',
                                   function($http, $location, $window){
	var self = this;
	
	self.module = 'list';
	self.lista = [];

	$http.get('http://localhost:8080/sigaula/aluno/list').then(
		function(resp){
			self.lista = resp.data;
		});

	console.log( self.lista );

	self.add = function(){
		self.module = 'edit';	
	}
	
	self.cancel = function(){
		self.module = "list";
	}
	
	self.submit = function(){
		return $http.post('http://localhost:8080/sigaula/aluno/save', self.aluno).then(
				function(resp){
					//var urlRedirect = '/sigaula/aluno/list';
					//$window.open( urlRedirect, '_self' );
					//$window.location.href = urlRedirect;
					//console.log( resp.data );
					self.aluno = {}
					self.lista = resp.data;
					self.module = "list";
				});
	}
	
}]);