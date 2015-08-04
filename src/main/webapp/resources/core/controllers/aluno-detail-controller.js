app.controller('AlunoDetailController', ['$http', '$location', '$window', '$routeParams',
                                 function($http, $location, $window, $routeParams){
	var self = this;
	
	var init = function(){
		self.setActiveMenu();
		
		if( $routeParams.id != undefined ){
			console.log( 'id = '+$routeParams.id );
			$http.get( SERVER_APP + '/aluno/'+$routeParams.id ).then(function(resp){
				console.log( resp.data );
				self.aluno = resp.data;
			});
		}
		
	}

	self.setActiveMenu = function(){
		/**
		 * id_menu_home : seletor dentro do arquivo > home-top.jsp
		 * id_menu_aluno: seletor dentro do arquivo > home-top.jsp 
		 */
		$("#id_menu_home").removeClass( "active" );
		$("#id_menu_sobre").removeClass( "active" );
		$("#id_menu_aluno").addClass( "active" );
		
		/**
		 * id_moduleDescription: seletor dentro do arquivo > home-description.jsp
		 */
		$("#id_moduleDescription").html( "Cadastro de Usuarios" );
	}
	
	self.submit = function(){
		//console.log( 'aluno save >>> '+JSON.stringify(self.aluno) );
		$http.post( SERVER_APP + '/aluno/', self.aluno).then(function(resp){
			$window.location.href = SERVER_APP + "/#/aluno";
		});
	}
	
	
	init();
}]);