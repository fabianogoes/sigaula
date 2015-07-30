app.controller('AlunoController', ['$http', '$location', '$window',
                                   function($http, $location, $window){
	var self = this;
	
	self.action = "list";
	self.lista = [];
	
	self.add = function(){
		self.action = "edit";
	}
	
	self.cancel = function(){
		self.action = "list";
	}
	
	self.submit = function(){
		return $http.post('/sigaula/aluno/save', self.aluno).then(
				function(resp){
					//var urlRedirect = '/sigaula/aluno/list';
					//$window.open( urlRedirect, '_self' );
					//$window.location.href = urlRedirect;
					//console.log( resp.data );
					self.aluno = {}
					self.lista = resp.data;
					self.action = "list";
				});
	}
	
}]);