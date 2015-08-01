<div ng-controller="AlunoListController as ctrl">

	<jsp:include page="../core/home-description.jsp"></jsp:include>

	<a href ng-click="ctrl.atualizar()" class="pull-right">
		<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span> Atualizar &nbsp;   
	</a>

	<a href="#/aluno/add">
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
									<a href="#/aluno/edit/{{ aluno.id }}" class="btn btn-xs btn-warning" title="Editar registro...">
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

</div> <!-- ctrl -->