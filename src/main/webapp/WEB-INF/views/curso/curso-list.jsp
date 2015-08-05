<div ng-controller="CursoListController as ctrl">

	<jsp:include page="../core/home-description.jsp"></jsp:include>

	<a href ng-click="ctrl.atualizar()" class="pull-right">
		<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span> Atualizar &nbsp;   
	</a>

	<a href="#/curso/form">
		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
		Adicionar novo Curso
	</a>


	<div class="panel panel-primary">
		<div class="panel-body">
		
			<div style="width:100%; height:320px; overflow: auto;" class="table-responsive">
				<table class="table table-hover table-responsive">
					<thead>
						<tr>
							<th class="col-md-1">ID</th>
							<th class="col-md-5">Nome</th>
							<th class="col-md-1 text-center">
								<span class="glyphicon glyphicon-tasks" aria-hidden="true"></span>
							</th>
						</tr>
					</thead>
					<tbody>
							<tr ng-repeat="curso in ctrl.cursos">
								<td>{{ curso.id }}</td>
								<td>{{ curso.nome }}</td>
								<td class="text-center">
									<a href="#/curso/{{ curso.id }}" class="btn btn-xs btn-warning" title="Editar registro...">
										<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
									</a>
									<a href ng-click="ctrl.remove( curso.id )" class="btn btn-xs btn-danger" title="Deletar registro...">
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