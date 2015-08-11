<div ng-controller="TurmaListController as ctrl">

	<jsp:include page="../core/home-description.jsp"></jsp:include>

	<a href ng-click="ctrl.atualizar()" class="pull-right">
		<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span> Atualizar &nbsp;   
	</a>

	<a href="#/turma/form">
		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
		Adicionar novo Turma
	</a>


	<div class="panel panel-primary">
		<div class="panel-body">
		
			<div style="width:100%; height:320px; overflow: auto;" class="table-responsive">
				<table class="table table-hover table-responsive">
					<thead>
						<tr class="text-center">
							<th class="col-md-1 text-center">ID</th>
							<th class="col-md-3 text-center">Curso</th>
							<th class="col-md-3 text-center">Professor</th>
							<th class="col-md-1 text-center">Data Inicio</th>
							<th class="col-md-1 text-center">Data Fim</th>
							<th class="col-md-1 text-center">Hora Inicio</th>
							<th class="col-md-1 text-center">Hora Fim</th>
							<th class="col-md-1">
								<span class="glyphicon glyphicon-tasks" aria-hidden="true"></span>
							</th>
						</tr>
					</thead>
					<tbody>
							<tr ng-repeat="turma in ctrl.turmas" class="text-center">
								<td>{{ turma.id }}</td>
								<td>{{ turma.curso.nome }}</td>
								<td>{{ turma.professor.nome }}</td>
								<td>{{ turma.dataInicio }}</td>
								<td>{{ turma.dataFinal }}</td>
								<td>{{ turma.horaInicioAula }}</td>
								<td>{{ turma.horaFimAula }}</td>
								<td class="text-center">
									<a href="#/turma/{{ turma.id }}" class="btn btn-xs btn-default" title="Editar registro...">
										<span class="glyphicon glyphicon-edit text-primary" aria-hidden="true"></span>
									</a>
									<a href ng-click="ctrl.remove( turma.id )" class="btn btn-xs btn-default" title="Deletar registro...">
										<span class="glyphicon glyphicon-remove text-danger" aria-hidden="true"></span>
									</a>
								</td>
							</tr>
					</tbody>
				</table>
			</div>
			
		</div> <!-- panel body -->
	</div> <!-- panel -->

</div> <!-- ctrl -->