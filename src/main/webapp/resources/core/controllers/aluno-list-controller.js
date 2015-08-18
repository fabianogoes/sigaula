app.controller('AlunoListController', ['$http', '$location', '$window', '$routeParams',
                                   function($http, $location, $window, $routeParams){
	var self = this;
	
	//self.aluno = {};
	//self.telefone = {}
	
	var init = function(){
		
		/**
		 * id_menu_home : seletor dentro do arquivo > home-top.jsp
		 * id_menu_aluno: seletor dentro do arquivo > home-top.jsp 
		 * id_menu_professor: seletor dentro do arquivo > home-top.jsp 
		 */
		$("#id_menu_home").removeClass( "active" );
		$("#id_menu_sobre").removeClass( "active" );
		$("#id_menu_curso").removeClass( "active" );
		$("#id_menu_professor").removeClass( "active" );
		$("#id_menu_turma").removeClass( "active" );
		$("#id_menu_aluno").addClass( "active" );
		
		/**
		 * id_moduleDescription: seletor dentro do arquivo > home-description.jsp
		 */
		$("#id_moduleDescription").html( "Cadastro de Alunos" );
		self.list();
	}

	self.list = function(){
		$http.get( SERVER_APP + '/aluno' ).then(function(resp){
			self.alunos = resp.data;
		});
	}
	
	self.remove = function(id){
		$http.get( SERVER_APP + '/aluno/'+id+'/delete').then(function(resp){
			self.alunos = resp.data;
		});
	}
	
	self.atualizar = function(){
		self.list();
	}
	
	self.verTelefones = function( aluno ){
		self.aluno = aluno;
		$('#modalTelefones').modal('show');
	}
	
	self.telefoneSubmit = function(){
		self.telefone.pessoa = self.aluno;
		console.log( self.telefone );
		$http.post( SERVER_APP + '/aluno/telefone', self.telefone).then(function(resp){
			self.aluno = resp.data;
			//$window.location.href = SERVER_APP + "/#/aluno";
			self.telefone = null;
		});
	}
	
	init();
}]);