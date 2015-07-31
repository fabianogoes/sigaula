app.controller('IndexController', ['$http', '$location', '$window',
                                   function($http, $location, $window){
	var self = this;

	self.appTitle = 'SIGaula';
	self.moduleDescription = 'Sistema Integrado para Gestão de Aulas';

	self.showHome = function(){
		self.moduleDescription = 'Sistema Integrado para Gestão de Aulas';
		self.moduleContent = '';
	}

	self.showAluno = function(){
		self.moduleDescription = 'Cadastro de Alunos';
		self.moduleContent = 'aluno.html';	
	}

}]);