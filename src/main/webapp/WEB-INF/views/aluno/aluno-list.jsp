<div ng-controller="AlunoListController as ctrl">

	<jsp:include page="../core/home-description.jsp"></jsp:include>

	<a href ng-click="ctrl.atualizar()" class="pull-right">
		<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span> Atualizar &nbsp;   
	</a>

	<a href="#/aluno/form">
		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
		Adicionar novo Aluno
	</a>


	<div class="panel panel-primary">
		<div class="panel-body">
		
			<div style="width:100%; height:320px; overflow: auto;" class="table-responsive">
				<table class="table table-hover table-responsive">
					<thead>
						<tr>
							<th class="col-md-1">ID</th>
							<th class="col-md-5">Nome</th>
							<th>E-Mail</th>
							<th class="text-center">Telefones</th>
							<th class="col-md-1 text-center">
								<span class="glyphicon glyphicon-tasks" aria-hidden="true"></span>
							</th>
						</tr>
					</thead>
					<tbody>
							<tr ng-repeat="aluno in ctrl.alunos">
								<td>{{ aluno.id }}</td>
								<td>{{ aluno.nome }}</td>
								<td>{{ aluno.email }}</td>
								<td class="text-center">
									<a href ng-click="ctrl.verTelefones( aluno )" class="btn btn-xs btn-default" title="Ver Telefones...">
										<span class="glyphicon glyphicon-phone-alt" aria-hidden="true"></span>
									</a>
								</td>
								<td class="text-center">
									<a href="#/aluno/{{ aluno.id }}" class="btn btn-xs btn-warning" title="Editar registro...">
										<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
									</a>
									<a href ng-click="ctrl.remove( aluno.id )" class="btn btn-xs btn-danger" title="Deletar registro...">
										<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
									</a>
								</td>
							</tr>
					</tbody>
				</table>
			</div>
			
		</div> <!-- panel body -->
	</div> <!-- panel -->

 	<!-- Modal Telefones -->
	<div class="modal fade bs-example-modal-sm" id="modalTelefones" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog modal-sm" role="document">
	    <div class="modal-content">
	      
	      <div class="modal-body">
	        	
	            <h5>Aluno: <span class="badge">{{ ctrl.aluno.nome }}</span> </h5>	
		        <table class="table table-bordered">
		      		<tr ng-repeat="telefone in ctrl.aluno.telefones">
		      			<td>{{ telefone.numero }}</td>
		      		</tr>
		        </table>
		      
		      <form name="frmTelefone" ng-submit="ctrl.telefoneSubmit()">
		      	<input type="text" autofocus="autofocus" name="numero" ng-model="ctrl.telefone.numero" />
		      	<button type="submit" class="btn btn-xs" >
		      		<span class="glyphicon glyphicon-plus text-primary" aria-hidden="true"></span>
		      	</button>
	          </form>
	        
	      </div>
	      
	      <div class="modal-footer">
    	      <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Fechar</button>
          </div>
          
	    </div>
	  </div>
	</div> 	

</div> <!-- ctrl -->