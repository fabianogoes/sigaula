app.controller('TurmaDetailController', ['$http', '$location', '$window', '$routeParams',
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
		$("#id_menu_curso").removeClass( "active" );		
		$("#id_menu_turma").addClass( "active" );
		
		/**
		 * 
		 * id_moduleDescription: seletor dentro do arquivo > home-description.jsp
		 * 
		 */
		$("#id_moduleDescription").html( "Cadastro de Turmas" );
		
		$http.get( SERVER_APP + '/curso').then(function(resp){
			self.cursos = resp.data;
		});
		
		$http.get( SERVER_APP + '/professor').then(function(resp){
			self.professores = resp.data;
		});
		
		if( $routeParams.id != undefined ){
			$http.get( SERVER_APP + '/turma/'+$routeParams.id ).then(function(resp){
				self.turma = resp.data;
			});
		}
		
	}

	self.submit = function(){
		console.log( self.turma );
		$http.post( SERVER_APP + '/turma/', self.turma).then(function(resp){
			$window.location.href = SERVER_APP + "/#/turma/";
		});
	}
	
	
	init();
}]);