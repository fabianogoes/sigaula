app.controller('PessoaListController', ['$http', '$location', '$window', '$routeParams',
                                   function($http, $location, $window, $routeParams){
	var self = this;
	
	self.pessoa = {};
	
	var init = function(){
		
		/**
		 * id_menu_home : seletor dentro do arquivo > home-top.jsp
		 * id_menu_aluno: seletor dentro do arquivo > home-top.jsp 
		 * id_menu_professor: seletor dentro do arquivo > home-top.jsp 
		 */
		$("#id_menu_home").removeClass( "active" );
		$("#id_menu_sobre").removeClass( "active" );
		
		if( $window.location.href.contains('aluno') ){
			self.moduleNameSingular = "Aluno";
			self.moduleNamePlural = self.moduleNameSingular+"";
			self.module = self.moduleNameSingular.toLowerCase();
			self.pessoa.tipo = "ALUNO";
			$("#id_menu_professor").removeClass( "active" );
			$("#id_menu_aluno").addClass( "active" );
		}else{
			self.moduleNameSingular = "Professor";
			self.moduleNamePlural = self.moduleNameSingular+"";
			self.module = self.moduleNameSingular.toLowerCase();
			self.pessoa.tipo = "PROFESSOR";
			$("#id_menu_aluno").removeClass( "active" );
			$("#id_menu_professor").addClass( "active" );
		}	
		
		/**
		 * id_moduleDescription: seletor dentro do arquivo > home-description.jsp
		 */
		$("#id_moduleDescription").html( "Cadastro de "+self.moduleNamePlural );
		self.list();
	}

	self.list = function(){
		$http.get( SERVER_APP + '/pessoa/tipo/'+self.pessoa.tipo ).then(function(resp){
			self.pessoas = resp.data;
		});
	}
	
	self.remove = function(id){
		$http.get( SERVER_APP + '/pessoa/'+id+'/delete').then(function(resp){
			self.pessoas = resp.data;
		});
	}
	
	self.atualizar = function(){
		self.list();
	}
	
	self.verTelefones = function( pessoa ){
		self.pessoa = pessoa;
		$('#modalTelefones').modal('show');
	}
	
	self.telefoneSubmit = function(){
		self.telefone.pessoa = self.pessoa;
		$http.post( SERVER_APP + '/pessoa/telefone', self.telefone).then(function(resp){
			self.pessoa = resp.data;
			$window.location.href = SERVER_APP + "/#/pessoa/"+self.module;
			self.telefone.numero = "";
		});
	}
	
	init();
}]);