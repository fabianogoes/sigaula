app.controller('TurmaDetailController', ['$http', '$location', '$window', '$routeParams',
                                 function($http, $location, $window, $routeParams){
	var self = this;
	
	self.curso = {};
	self.professor = {};
	self.alunos = [];
	self.init = function(){
		
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
		
		
		if( $routeParams.id != undefined ){
			$http.get( SERVER_APP + '/turma/'+$routeParams.id ).then(function(resp){
				//console.log( "Turma = " + JSON.stringify(resp.data) );
				self.turma = resp.data;
				self.alunos = self.turma.alunos;
				console.log( self.alunos );
			}).then(function() {
                $http.get( SERVER_APP + '/curso' ).then(function(resp){
                	self.cursos = resp.data; 
                    for(var i = 0; self.cursos.length-1; i++) {
                    	if (self.turma.curso.id == self.cursos[i].id) {
                    		self.turma.curso = self.cursos[i];
                    		break;
                        }
                    }
                });                     
			}).then(function(){
				$http.get( SERVER_APP + '/professor' ).then(function(resp){
					self.professores = resp.data; 
                    for(var i = 0; self.professores.length-1; i++) {
                            if (self.turma.professor.id == self.professores[i].id) {
                                    self.turma.professor = self.professores[i];
                                    break;
                            }
                    }					
				});
			});
		} else{
			$http.get( SERVER_APP + '/curso').then(function(resp){
				self.cursos = resp.data;
			});
				
			$http.get( SERVER_APP + '/professor').then(function(resp){
				self.professores = resp.data;
			});
		}		
		
		
		$http.get( SERVER_APP + '/aluno').then(function(resp){
			self.alunosFull = resp.data;
		});		
		
		
	};

	self.setAlunoToTurma = function( turma, aluno ){
		console.log( aluno );
		console.log( turma );
		$http.get( SERVER_APP + '/turma/'+turma.id+'/aluno/'+aluno.id ).then(function(resp){
			//$window.location.href = SERVER_APP + "/#/turma/";
			//console.log( "response = "+JSON.stringify(resp.data) );
			//console.log( resp.data );
			//self.turma = resp.data;
			self.init();
		});		
	};
	
	self.submit = function(){
		console.log( self.turma );
		$http.post( SERVER_APP + '/turma/', self.turma).then(function(resp){
			$window.location.href = SERVER_APP + "/#/turma/";
		});
	};
	
	
	self.init();
}]);