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
			    			<!-- 
			    			<select name="txtCurso" 
			    			       class="form-control" 
			    			       ng-model="ctrl.turma.curso.id"
			    			       required>
			    				<option ng:repeat="curso in ctrl.cursos" value="{{curso.id}}">{{curso.nome}}</option>
			    			</select>
			    			-->
			    			<select ng-model="ctrl.turma.curso" ng-options="c.nome for c in ctrl.cursos" class="form-control"></select>
			  			</div>
	    			</div>
	    			<div class="col-md-6">
						<div class="form-group">
			    			<label>Professor:</label>
			    			<!-- 
			    			<select name="txtProfessor" 
			    			       class="form-control" 
			    			       ng-model="ctrl.turma.professor.id"
			    			       required>
			    				<option ng:repeat="professor in ctrl.professores" value="{{professor.id}}">{{professor.nome}}</option>
			    			</select>
			    			-->
			    			<select ng-model="ctrl.turma.professor" ng-options="p.nome for p in ctrl.professores" class="form-control"></select>
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
	    		
	    		<!-- *** Modal Add Aluno | Turma ********************************************************************************************* -->
	    		<div class="modal fade" id="modalAddAlunoTurma" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header text-center">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title">Aluno | Turma</h4>
				      </div>

				      <div class="modal-body">
				        <input type="text" class="form-control" name="alunoFilterValue" ng-model="query" placeholder="Digite o nome do Aluno..." autofocus/>
					  	<div style="width:100%; height:350px; overflow: auto;" class="table-responsive">
					        <table class="table table-condensed table-responsive">
								<thead>
									<tr class="text-center">
										<th class="col-md-1 text-center">ID</th>
										<th class="col-md-2">Nome</th>
										<th class="col-md-1 text-center">CPF|CNPJ</th>
										<th class="col-md-3">Email</th>
										<th class="col-md-1 text-center">
											<span class="glyphicon glyphicon-tasks" aria-hidden="true"></span>
										</th>
									</tr>
								</thead>
					        	<tbody>
						      		<tr ng-repeat="aluno in ctrl.alunosFull | filter:query | orderBy: 'id'">
						      			<td class="text-center">{{ aluno.id }}</td>
						      			<td>{{ aluno.nome }}</td>
						      			<td class="col-md-1 text-center">{{ aluno.cpfcnpj }}</td>
						      			<td>{{ aluno.email }}</td>
										<td class="text-center">
											<a href ng-click="ctrl.setAlunoToTurma( ctrl.turma, aluno )" class="btn btn-xs btn-success" title="Adicionar Aluno na Turma">
												<span class="glyphicon glyphicon-save" aria-hidden="true"></span>
											</a>
										</td>					      			
						      		</tr>
						      	</tbody>
					        </table>
					  	</div>	
				      </div>

				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
				      </div>
				    </div><!-- /.modal-content -->
				  </div><!-- /.modal-dialog -->
				</div><!-- /.modal -->
				<!--/ *** Modal Add Aluno | Turma ********************************************************************************************* -->
	    		
	    		
				<div class="panel panel-default">
				  <div class="panel-heading">
				    <h3 class="panel-title">
				    	<a href class="btn btn-xs btn-default pull-right text-primary" data-toggle="modal" data-target="#modalAddAlunoTurma">
					    	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 
					    	Adicionar Aluno
				    	</a>
				    	<span class="glyphicon glyphicon-user text-primary" aria-hidden="true"> Alunos
				    </h3>
				  </div>
				  <div class="panel-body">
				  	 <div style="width:100%; height:180px; overflow: auto;" class="table-responsive">
				   
				        <table class="table table-condensed table-responsive">
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