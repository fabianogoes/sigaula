app.controller('AlunoController', ['$http', '$location', '$window',
                                   function($http, $location, $window){
	var self = this;
	
	self.submit = function(){
		return $http.post('/sigaula/aluno/save', self.aluno).then(
				function(resp){
					var urlRedirect = '/sigaula/aluno/list';
					//$window.open( urlRedirect, '_self' );
					
					self.message = 'OK';
					$window.location.href = urlRedirect;
				});
	}
	
}]);