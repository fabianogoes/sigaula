<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="panel panel-primary" ng-controller="AlunoController as ctrl">
  	<div class="panel-heading">
    	<h3 class="panel-title">Detalhes</h3>
  	</div>
  	<div class="panel-body">
    	
    	<form ng-submit="ctrl.submit()" name="frmAluno">
			<input type="text" name="txtId" ng-model="ctrl.aluno.id">    	
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
    				        
    				<a href="${ pageContext.request.contextPath }/aluno/list" class="btn btn-default">Cancelar</a>
    			</div>
    		</div>
    	</form>
    	
  	</div>
</div>
