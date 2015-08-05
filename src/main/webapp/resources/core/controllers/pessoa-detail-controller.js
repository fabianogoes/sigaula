app.controller('PessoaDetailController', ['$http', '$location', '$window', '$routeParams',
                                 function($http, $location, $window, $routeParams){
	var self = this;
	
	self.pessoa = {};
	
	var init = function(){
		
		/**
		 * id_menu_home : seletor dentro do arquivo > home-top.jsp
		 * id_menu_aluno: seletor dentro do arquivo > home-top.jsp 
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
		
		if( $routeParams.id != undefined ){
			$http.get( SERVER_APP + '/pessoa/'+$routeParams.id ).then(function(resp){
				self.pessoa = resp.data;
			});
		}
		
	}

	self.submit = function(){
		$http.post( SERVER_APP + '/pessoa/', self.pessoa).then(function(resp){
			$window.location.href = SERVER_APP + "/#/pessoa/"+self.module;
		});
	}
	
	
	init();
}]);