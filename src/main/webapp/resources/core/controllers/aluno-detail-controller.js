app.controller('AlunoDetailController', ['$http', '$location', '$window', '$routeParams',
                                 function($http, $location, $window, $routeParams){
	var self = this;
	
	self.aluno = {};
	self.dataNascimento = new Date();
	
	var init = function(){
		
		/**
		 * id_menu_home : seletor dentro do arquivo > home-top.jsp
		 * id_menu_aluno: seletor dentro do arquivo > home-top.jsp 
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
		
		if( $routeParams.id != undefined ){
			$http.get( SERVER_APP + '/aluno/'+$routeParams.id ).then(function(resp){
				self.aluno = resp.data;
			});
		}
		
	}

	self.submit = function(){
		console.log( self.aluno );
		$http.post( SERVER_APP + '/aluno/', self.aluno).then(function(resp){
			$window.location.href = SERVER_APP + "/#/aluno";
		});
	}
	
	
	init();
}]);