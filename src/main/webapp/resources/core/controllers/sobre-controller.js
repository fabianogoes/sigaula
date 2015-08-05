app.controller('SobreController', ['$http', '$location', '$window',
                                   function($http, $location, $window){
	var self = this;
	
	var init = function(){
		self.setActiveMenu();
		$("#id_moduleDescription").html( "Sistema Integrado para Gestao de Aulas" );
	}

	self.setActiveMenu = function(){
		/**
		 * id_menu_home : seletor dentro do arquivo > home-top.jsp
		 * id_menu_aluno: seletor dentro do arquivo > home-top.jsp 
		 */
		$("#id_menu_home").removeClass( "active" );
		$("#id_menu_aluno").removeClass( "active" );
		$("#id_menu_professor").removeClass( "active" );
		$("#id_menu_curso").removeClass( "active" );
		$("#id_menu_sobre").addClass( "active" );
	}

	
	init();
}]);