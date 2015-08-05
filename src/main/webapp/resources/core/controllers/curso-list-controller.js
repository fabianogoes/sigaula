app.controller('CursoListController', ['$http', '$location', '$window', '$routeParams',
                                   function($http, $location, $window, $routeParams){
	var self = this;
	
	var init = function(){
		
		/**
		 * 
		 * active/deactive seletores de menu dentro do arquivo > home-top.jsp
		 * 
		 */
		$("#id_menu_home").removeClass( "active" );
		$("#id_menu_sobre").removeClass( "active" );
		$("#id_menu_professor").removeClass( "active" );
		$("#id_menu_aluno").removeClass( "active" );
		$("#id_menu_curso").addClass( "active" );
		
		/**
		 * id_moduleDescription: seletor dentro do arquivo > home-description.jsp
		 */
		$("#id_moduleDescription").html( "Cadastro de Cursos" );
		self.list();
	}

	self.list = function(){
		$http.get( SERVER_APP + '/curso' ).then(function(resp){
			self.cursos = resp.data;
		});
	}
	
	self.remove = function(id){
		$http.get( SERVER_APP + '/curso/'+id+'/delete').then(function(resp){
			self.cursos = resp.data;
		});
	}
	
	self.atualizar = function(){
		self.list();
	}
	
	init();
}]);