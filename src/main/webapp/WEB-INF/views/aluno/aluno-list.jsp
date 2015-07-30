<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div ng-controller="AlunoController as ctrl">

	<a href="#" ng-click="ctrl.add()">
		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
		${ module_caption_add }
	</a>


	<div class="panel panel-primary" ng-show="ctrl.action == 'list'">
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
<%-- 						<c:forEach var="aluno" items="${ list }"> --%>
							<tr ng-repeat="aluno in ctrl.lista">
								<td>{{ aluno.id }}</td>
								<td>{{ aluno.nome }}</td>
								<td>{{ aluno.email }}</td>
								<td class="text-center">
									<a href="#" class="btn btn-xs btn-warning" title="Editar registro...">
										<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
									</a>
									<a href="#" class="btn btn-xs btn-danger" title="Deletar registro...">
										<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
									</a>
								</td>
							</tr>
<%-- 						</c:forEach>	 --%>
					</tbody>
				</table>
			</div>
			
			<!-- 
			<hr/>
			<div class="alert alert-info alert-dismissible" role="alert">
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			  <strong>Warning!</strong> <span ng-bind="ctrl.message"></span>
			</div>
			-->	
			
		</div> <!-- panel body -->
	</div> <!-- panel -->
	
	
	<div class="panel panel-primary" ng-show="ctrl.action == 'edit'">
	  	<div class="panel-heading">
	    	<h3 class="panel-title">Detalhes</h3>
	  	</div>
	  	<div class="panel-body">
	    	
	    	<form ng-submit="ctrl.submit()" name="frmAluno">
				<input type="hidden" name="txtId" ng-model="ctrl.aluno.id">    	
	    		<div class="row">
	    			<div class="col-md-6">
						<div class="form-group" ng-class="{ 'has-error': frmAluno.txtNome.$invalid && frmAluno.txtNome.$dirty}">
			    			<label for="id_aluno_nome">Nome:</label>
			    			<input type="text" 
			    			       name="txtNome" 
			    			       class="form-control" 
			    			       ng-model="ctrl.aluno.nome"
			    			       required  
			    			       autofocus 
			    			       ng-minlength="3"
			    			       placeholder="Nome...">
			    			<div class="error text-danger" ng-show="frmAluno.txtNome.$invalid && frmAluno.txtNome.$dirty">
				    			<span class="glyphicon glyphicon-warning-sign" ng-show="frmAluno.txtNome.$error.required" aria-hidden="true"></span> 
				    			<small ng-show="frmAluno.txtNome.$error.required">Campo obrigatório</small>
				    			<small ng-show="frmAluno.txtNome.$error.minlength">Campo deve ter no minimo 3 caracteres</small>
			    			</div>
			  			</div>
	    			</div>
	    			<div class="col-md-6">
						<div class="form-group" ng-class="{ 'has-error': frmAluno.txtEmail.$invalid && frmAluno.txtEmail.$dirty }">
			    			<label for="id_aluno_email">E-mail:</label>
			    			<input type="email" 
			    			       name="txtEmail" 
			    			       class="form-control" 
			    			       ng-model="ctrl.aluno.email"
			    			       required 
			    			       placeholder="Email...">
			    			<div class="error text-danger" ng-show="frmAluno.txtEmail.$invalid && frmAluno.txtEmail.$dirty">
			    				<span class="glyphicon glyphicon-warning-sign" ng-show="frmAluno.txtNome.$error.required" aria-hidden="true"></span>
				    			<small ng-show="frmAluno.txtEmail.$error.required" class="text-danger">Campo obrigatório! </small>
			    			</div>		  			
			  			</div>
			  		</div>
	    		</div>
	    		
	    		<hr/>
	    		
	    		<div class="row">
	    			<div class="col-md-6">
	    				<button type="submit" 
	    				        class="btn btn-primary"
	    				        ng-disabled="frmAluno.$invalid">Salvar</button>
	    				        
	    				<a href="#" 
	    				   class="btn btn-default"  
	    				   ng-click="ctrl.cancel()">Cancelar</a>
	    			</div>
	    		</div>
	    	</form>
	    	
	  	</div>
	</div>
	
		
</div> <!-- ctrl -->