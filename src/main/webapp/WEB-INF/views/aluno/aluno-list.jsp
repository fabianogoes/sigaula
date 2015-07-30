<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div ng-controller="AlunoController as ctrl">
	<div style="width:100%; height:280px; overflow: auto;" class="table-responsive">
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
				<c:forEach var="aluno" items="${ list }">
					<tr>
						<td>${ aluno.id }</td>
						<td>${ aluno.nome }</td>
						<td>${ aluno.email }</td>
						<td class="text-center">
							<a href="#" class="btn btn-xs btn-warning" title="Editar registro...">
								<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
							</a>
							<a href="#" class="btn btn-xs btn-danger" title="Deletar registro...">
								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
							</a>
						</td>
					</tr>
				</c:forEach>	
			</tbody>
		</table>
	</div>
	
	<hr/>
	
	<!-- 
	<div class="alert alert-info alert-dismissible" role="alert">
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  <strong>Warning!</strong> <span ng-bind="ctrl.message"></span>
	</div>
	-->	
	
</div>