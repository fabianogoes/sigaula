app.controller('ProfessorListController', ['$http', '$location', '$window', '$routeParams',
                                   function($http, $location, $window, $routeParams){
	var self = this;
	
	self.professor = {};
	self.telefone = {}
	
	var init = function(){
		
		/**
		 * id_menu_home : seletor dentro do arquivo > home-top.jsp
		 * id_menu_professor: seletor dentro do arquivo > home-top.jsp 
		 */
		$("#id_menu_home").removeClass( "active" );
		$("#id_menu_sobre").removeClass( "active" );
		$("#id_menu_curso").removeClass( "active" );
		$("#id_menu_aluno").removeClass( "active" );
		$("#id_menu_turma").removeClass( "active" );
		$("#id_menu_professor").addClass( "active" );
		
		/**
		 * id_moduleDescription: seletor dentro do arquivo > home-description.jsp
		 */
		$("#id_moduleDescription").html( "Cadastro de Professores" );
		self.list();
	}

	self.list = function(){
		$http.get( SERVER_APP + '/professor' ).then(function(resp){
			self.professores = resp.data;
		});
	}
	
	self.remove = function(id){
		$http.get( SERVER_APP + '/professor/'+id+'/delete').then(function(resp){
			self.professores = resp.data;
		});
	}
	
	self.atualizar = function(){
		self.list();
	}
	
	self.verTelefones = function( professor ){
		self.professor = professor;
		console.log( self.professor );
		$('#modalTelefones').modal('show');
	}
	
	self.telefoneSubmit = function(){
		self.telefone.pessoa = self.professor;
		console.log( self.telefone );
		$http.post( SERVER_APP + '/professor/telefone', self.telefone).then(function(resp){
			self.professor = resp.data;
			$window.location.href = SERVER_APP + "/#/professor";
			self.telefone.numero = "";
		});
	}
	
	init();
}]);