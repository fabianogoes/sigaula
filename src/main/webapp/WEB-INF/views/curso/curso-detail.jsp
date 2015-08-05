<div ng-controller="CursoDetailController as ctrl">

	<jsp:include page="../core/home-description.jsp"></jsp:include>

	<div class="panel panel-primary">
	  	<div class="panel-heading">
	    	<h3 class="panel-title">Curso <span class="badge pull-right">ID: {{ ctrl.curso.id }}</span> </h3>
	  	</div>
	  	<div class="panel-body">
	    	
	    	<form ng-submit="ctrl.submit()" name="frmfrmCurso">

	    		<div class="row">
	    			<div class="col-md-12">
						<div class="form-group" ng-class="{ 'has-error': frmCurso.txtNome.$invalid && frmCurso.txtNome.$dirty}">
			    			<label for="id_curso_nome">Nome:</label>
			    			<input type="text" 
			    			       name="txtNome" 
			    			       class="form-control" 
			    			       ng-model="ctrl.curso.nome"
			    			       required  
			    			       autofocus 
			    			       ng-minlength="3"
			    			       placeholder="Nome...">
			    			<div class="error text-danger" ng-show="frmCurso.txtNome.$invalid && frmCurso.txtNome.$dirty">
				    			<span class="glyphicon glyphicon-warning-sign" ng-show="frmCurso.txtNome.$error.required" aria-hidden="true"></span> 
				    			<small ng-show="frmCurso.txtNome.$error.required">Campo obrigatório</small>
				    			<small ng-show="frmCurso.txtNome.$error.minlength">Campo deve ter no minimo 3 caracteres</small>
			    			</div>
			  			</div>
	    			</div>
	    		</div>
	    		
	    		<hr/>
	    		
	    		<div class="row">
	    			<div class="col-md-6">
	    				<button type="submit" 
	    				        class="btn btn-primary"
	    				        ng-disabled="frmCurso.$invalid">Salvar</button>
	    				        
	    				<a href="#/curso/{{ ctrl.module }}" 
	    				   class="btn btn-default">Cancelar</a>
	    			</div>
	    		</div>
	    	</form>
	    	
	  	</div>
	</div>