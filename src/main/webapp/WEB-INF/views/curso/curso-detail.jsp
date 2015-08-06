<div ng-controller="CursoDetailController as ctrl">

	<jsp:include page="../core/home-description.jsp"></jsp:include>

	<div class="panel panel-default">
	  	<div class="panel-heading">
	    	<h3 class="panel-title">Curso <span class="badge pull-right">ID: {{ ctrl.curso.id }}</span> </h3>
	  	</div>
	  	<div class="panel-body">
	    	
	    	<form ng-submit="ctrl.submit()" name="frmfrmCurso">

	    		<div class="row">
	    			<div class="col-md-4">
						<div class="form-group" ng-class="{ 'has-error': frmCurso.txtNome.$invalid && frmCurso.txtNome.$dirty}">
			    			<label>Nome:</label>
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
	    			<div class="col-md-3">
						<div class="form-group">
			    			<label>Tipo:</label>
			    			<select name="txtTipo" 
			    			        class="form-control" 
			    			        ng-model="ctrl.curso.tipo"
			    			        required>
								<option value="INDIVIDUAL">INDIVIDUAL</option>			    			
								<option value="GRUPO">GRUPO</option>
			    			</select>
			  			</div>
	    			</div>	    			
	    			<div class="col-md-3">
						<div class="form-group">
			    			<label>Categoria:</label>
			    			<select name="txtCategoria" 
			    			        class="form-control" 
			    			        ng-model="ctrl.curso.categoria"
			    			        required>
								<option value="SEMANAL">SEMANAL</option>
								<option value="QUINZENAL">QUINZENAL</option>
								<option value="MENSAL">MENSAL</option>
								<option value="DIARIO">DIARIO</option>
								<option value="PERIODICO">PERIODICO</option>			    			
			    			</select>
			  			</div>
	    			</div>	    			
	    			<div class="col-md-2">
						<div class="form-group">
			    			<label>Carga Horária:</label>
			    			<input type="number" 
			    			       name="txtCargaHoraria" 
			    			       class="form-control" 
			    			       ng-model="ctrl.curso.cargaHoraria"
			    			       required>
			  			</div>
	    			</div>	    			
	    		</div>
	    		
	    		<div class="row">
	    			<div class="col-md-2">
						<div class="form-group">
			    			<label>Preço:</label>
			    			<input type="text" 
			    			       name="txtPreco" 
			    			       class="form-control" 
			    			       ng-model="ctrl.curso.preco"
			    			       required>
			  			</div>
	    			</div>		    		
	    			<div class="col-md-2">
						<div class="form-group">
			    			<label>Duracao Aula:</label>
			    			<input type="text" 
			    			       name="txtDuracaoAula" 
			    			       class="form-control" 
			    			       ng-model="ctrl.curso.duracaoAula"
			    			       required>
			  			</div>
	    			</div>		    		
	    			<div class="col-md-2">
						<div class="form-group">
			    			<label>Sulfixo Duração Aula:</label>
			    			<input type="text" 
			    			       name="txtSulfixoDuracaoAula" 
			    			       class="form-control" 
			    			       ng-model="ctrl.curso.sulfixoDuracaoAula">
			  			</div>
	    			</div>		    		
	    			<div class="col-md-6">
						<div class="form-group">
			    			<label>Requisitos:</label>
			    			<input type="text" 
			    			       name="txtRequisitos" 
			    			       class="form-control" 
			    			       ng-model="ctrl.curso.requisitos">
			  			</div>
	    			</div>		    		
	    		</div>
	    		
	    		<div class="row">
	    			<div class="col-md-12">
						<div class="form-group">
			    			<label>Obervações:</label>
			    			<input type="text" 
			    			       name="txtObservacoes" 
			    			       class="form-control" 
			    			       ng-model="ctrl.curso.observacoes">
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