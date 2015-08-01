app.controller('AlunoListController', ['$http', '$location', '$window',
                                   function($http, $location, $window){
	var self = this;
	
	var init = function(){
		/**
		 * id_menu_home : seletor dentro do arquivo > home-top.jsp
		 * id_menu_aluno: seletor dentro do arquivo > home-top.jsp 
		 */
		$("#id_menu_home").removeClass( "active" );
		$("#id_menu_sobre").removeClass( "active" );
		$("#id_menu_aluno").addClass( "active" );
		
		/**
		 * id_moduleDescription: seletor dentro do arquivo > home-description.jsp
		 */
		$("#id_moduleDescription").html( "Cadastro de Usuarios" );
		self.list();
	}

	self.list = function(){
		$http.get( SERVER_APP + '/aluno/list' ).then(function(resp){
			self.alunos = resp.data;
		});
	}
	
	self.remove = function(id){
		$http.get( SERVER_APP + '/aluno/remove/'+id).then(function(resp){
			self.alunos = resp.data;
		});
	}
	
	self.atualizar = function(){
		self.list();
	}
	
	init();
}]);