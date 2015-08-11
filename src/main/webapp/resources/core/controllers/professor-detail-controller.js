app.controller('ProfessorDetailController', ['$http', '$location', '$window', '$routeParams',
                                 function($http, $location, $window, $routeParams){
	var self = this;
	
	self.professor = {};
	
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
		
		if( $routeParams.id != undefined ){
			$http.get( SERVER_APP + '/professor/'+$routeParams.id ).then(function(resp){
				self.professor = resp.data;
			});
		}
		
	}

	self.submit = function(){
		$http.post( SERVER_APP + '/professor/', self.professor).then(function(resp){
			$window.location.href = SERVER_APP + "/#/professor";
		});
	}
	
	
	init();
}]);