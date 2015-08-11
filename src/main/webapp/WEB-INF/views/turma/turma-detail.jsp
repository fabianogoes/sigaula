<div ng-controller="TurmaDetailController as ctrl">

	<jsp:include page="../core/home-description.jsp"></jsp:include>

	<div class="panel panel-default">
	  	<div class="panel-heading">
	    	<h3 class="panel-title">Turma <span class="badge pull-right">ID: {{ ctrl.turma.id }}</span> </h3>
	  	</div>
	  	<div class="panel-body">
	    	
	    	<form ng-submit="ctrl.submit()" name="frmTurma">

	    		<div class="row">
	    			<div class="col-md-6">
						<div class="form-group">
			    			<label>Curso:</label>
			    			<select name="txtCurso" 
			    			       class="form-control" 
			    			       ng-model="ctrl.turma.curso.id"
			    			       required>
			    				<option ng:repeat="curso in ctrl.cursos" value="{{curso.id}}">{{curso.nome}}</option>
			    			</select>
			  			</div>
	    			</div>
	    			<div class="col-md-6">
						<div class="form-group">
			    			<label>Professor:</label>
			    			<select name="txtProfessor" 
			    			       class="form-control" 
			    			       ng-model="ctrl.turma.professor.id"
			    			       required>
			    				<option ng:repeat="professor in ctrl.professores" value="{{professor.id}}">{{professor.nome}}</option>
			    			</select>
			  			</div>
	    			</div>
	    		</div>
	    		
	    		<div class="row">
	    			<div class="col-md-3">
						<div class="form-group">
			    			<label>Data Inicio:</label>
			    			<input type="text" 
			    			       name="txtDataInicio" 
			    			       class="form-control" 
			    			       ng-model="ctrl.turma.dataInicio"
			    			       required>
			  			</div>
	    			</div>	 	    			
	    			<div class="col-md-3">
						<div class="form-group">
			    			<label>Data Fim:</label>
			    			<input type="text" 
			    			       name="txtDataFim" 
			    			       class="form-control" 
			    			       ng-model="ctrl.turma.dataFinal"
			    			       required>
			  			</div>
	    			</div>	 	    			
	    			<div class="col-md-3">
						<div class="form-group">
			    			<label>Hora Inicio:</label>
			    			<input type="text" 
			    			       name="txtHoraInicio" 
			    			       class="form-control" 
			    			       ng-model="ctrl.turma.horaInicioAula"
			    			       required>
			  			</div>
	    			</div>	 	    			
	    			<div class="col-md-3">
						<div class="form-group">
			    			<label>Hora Fim:</label>
			    			<input type="text" 
			    			       name="txtHoraFim" 
			    			       class="form-control" 
			    			       ng-model="ctrl.turma.horaFimAula"
			    			       required>
			  			</div>
	    			</div>	 	    			
	    		</div>
	    		
				<div class="panel panel-default">
				  <div class="panel-heading">
				    <h3 class="panel-title"><span class="glyphicon glyphicon-phone-alt text-primary pull-right" aria-hidden="true"></span> Alunos</h3>
				  </div>
				  <div class="panel-body">
				  	 <div style="width:100%; height:180px; overflow: auto;" class="table-responsive">
				   
				        <table class="table table-condensed">
				      		<tr ng-repeat="aluno in ctrl.turma.alunos">
				      			<td>{{ aluno.id }}</td>
				      			<td>{{ aluno.nome }}</td>
				      			<td>{{ aluno.cpfcnpj }}</td>
				      			<td>{{ aluno.email }}</td>
				      		</tr>
				        </table>				   
				   	 </div>
				  </div>
				</div>	    		
	    		
	    		<div class="row">
	    			<div class="col-md-6">
	    				<button type="submit" 
	    				        class="btn btn-primary"
	    				        ng-disabled="frmTurma.$invalid">Salvar</button>
	    				        
	    				<a href="#/turma/{{ ctrl.module }}" 
	    				   class="btn btn-default">Cancelar</a>
	    			</div>
	    		</div>
	    	</form>
	    	
	  	</div>
	</div>