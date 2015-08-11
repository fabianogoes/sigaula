app.controller('HomeController', ['$http', '$location', '$window',
                                   function($http, $location, $window){
	var self = this;
	
	var init = function(){
		/**
		 * id_menu_home : seletor dentro do arquivo > home-top.jsp
		 * id_menu_aluno: seletor dentro do arquivo > home-top.jsp 
		 */
		$("#id_menu_aluno").removeClass( "active" );
		$("#id_menu_professor").removeClass( "active" );
		$("#id_menu_curso").removeClass( "active" );
		$("#id_menu_sobre").removeClass( "active" );
		$("#id_menu_turma").removeClass( "active" );
		$("#id_menu_home").addClass( "active" );
		
		$("#id_moduleDescription").html( "Sistema Integrado para Gestao de Aulas" );
	}

	
	init();
}]);