<div ng-controller="AlunoDetailController as ctrl">

	<jsp:include page="../core/home-description.jsp"></jsp:include>

	<div class="panel panel-default">
	  	<div class="panel-heading">
	    	<h3 class="panel-title">Aluno <span class="badge pull-right">ID: {{ ctrl.aluno.id }}</span> </h3>
	  	</div>
	  	<div class="panel-body">
	    	
	    	<form ng-submit="ctrl.submit()" name="frmAluno">

				<input type="hidden" name="id" ng-model="ctrl.aluno.id">  

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
	    			<div class="col-md-3">
						<div class="form-group">
			    			<label for="id_aluno_cpfcnpj">Cpf/CNPJ:</label>
			    			<input type="text" 
			    			       name="txtCpfCnpj" 
			    			       class="form-control" 
			    			       ng-model="ctrl.aluno.cpfcnpj"
			    			       placeholder="CpfCNPJ...">
			  			</div>
			  		</div>
	    			<div class="col-md-3">
						<div class="form-group">
			    			<label for="id_aluno_dataNascimento">Data Nascimento:</label>
			    			<input type="text" 
			    			       name="txtDataNascimento" 
			    			       class="form-control" 
			    			       ng-model="ctrl.aluno.dataNascimento"
			    			       pattern="\d{1,2}/\d{1,2}/\d{4}"
			    			       maxlength="10"
			    			       placeholder="DD/MM/YYYY">
			  			</div>
			  		</div>
	    			
	    		</div>
	    		
	    		<div class="row">
	    			<div class="col-md-12">
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
	    		
	    		<br/>
	    		
				<div class="panel panel-default">
				  <div class="panel-heading">
				    <h3 class="panel-title"><span class="glyphicon glyphicon-phone-alt text-primary pull-right" aria-hidden="true"></span> Telefones</h3>
				  </div>
				  <div class="panel-body">
				   
				        <table class="table">
				      		<tr ng-repeat="telefone in ctrl.aluno.telefones">
				      			<td>
				      				( {{ telefone.ddd }} ) 	
				      				<span class="glyphicon glyphicon-phone-alt" aria-hidden="true"></span>
				      				{{ telefone.numero }}
				      			</td>
				      			<td>{{ telefone.tipo }}</td>
				      		</tr>
				        </table>				   
				   
				  </div>
				</div>	    		
	    		
	    		<hr/>
	    		
	    		<div class="row">
	    			<div class="col-md-6">
	    				<button type="submit" 
	    				        class="btn btn-primary"
	    				        ng-disabled="frmAluno.$invalid">Salvar</button>
	    				        
	    				<a href="#/aluno/{{ ctrl.module }}" 
	    				   class="btn btn-default">Cancelar</a>
	    			</div>
	    		</div>
	    	</form>
	    	
	  	</div>
	</div>