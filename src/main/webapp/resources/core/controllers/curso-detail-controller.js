app.controller('CursoDetailController', ['$http', '$location', '$window', '$routeParams',
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
		 * 
		 * id_moduleDescription: seletor dentro do arquivo > home-description.jsp
		 * 
		 */
		$("#id_moduleDescription").html( "Cadastro de Cursos" );
		
		if( $routeParams.id != undefined ){
			$http.get( SERVER_APP + '/curso/'+$routeParams.id ).then(function(resp){
				self.curso = resp.data;
			});
		}
		
	}

	self.submit = function(){
		console.log( self.curso );
		$http.post( SERVER_APP + '/curso/', self.curso).then(function(resp){
			$window.location.href = SERVER_APP + "/#/curso/";
		});
	}
	
	
	init();
}]);