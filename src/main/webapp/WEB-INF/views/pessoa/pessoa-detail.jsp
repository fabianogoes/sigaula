<div ng-controller="PessoaDetailController as ctrl">

	<jsp:include page="../core/home-description.jsp"></jsp:include>

	<div class="panel panel-primary">
	  	<div class="panel-heading">
	    	<h3 class="panel-title">{{ ctrl.moduleNameSingular }} <span class="badge pull-right">ID: {{ ctrl.pessoa.id }}</span> </h3>
	  	</div>
	  	<div class="panel-body">
	    	
	    	<form ng-submit="ctrl.submit()" name="frmfrmPessoa">

				<input type="hidden" name="tipo" ng-model="ctrl.pessoa.tipo">
	    	
	    		<div class="row">
	    			<div class="col-md-6">
						<div class="form-group" ng-class="{ 'has-error': frmPessoa.txtNome.$invalid && frmPessoa.txtNome.$dirty}">
			    			<label for="id_pessoa_nome">Nome:</label>
			    			<input type="text" 
			    			       name="txtNome" 
			    			       class="form-control" 
			    			       ng-model="ctrl.pessoa.nome"
			    			       required  
			    			       autofocus 
			    			       ng-minlength="3"
			    			       placeholder="Nome...">
			    			<div class="error text-danger" ng-show="frmPessoa.txtNome.$invalid && frmPessoa.txtNome.$dirty">
				    			<span class="glyphicon glyphicon-warning-sign" ng-show="frmPessoa.txtNome.$error.required" aria-hidden="true"></span> 
				    			<small ng-show="frmPessoa.txtNome.$error.required">Campo obrigatório</small>
				    			<small ng-show="frmPessoa.txtNome.$error.minlength">Campo deve ter no minimo 3 caracteres</small>
			    			</div>
			  			</div>
	    			</div>
	    			<div class="col-md-6">
						<div class="form-group" ng-class="{ 'has-error': frmPessoa.txtEmail.$invalid && frmPessoa.txtEmail.$dirty }">
			    			<label for="id_pessoa_email">E-mail:</label>
			    			<input type="email" 
			    			       name="txtEmail" 
			    			       class="form-control" 
			    			       ng-model="ctrl.pessoa.email"
			    			       required 
			    			       placeholder="Email...">
			    			<div class="error text-danger" ng-show="frmPessoa.txtEmail.$invalid && frmPessoa.txtEmail.$dirty">
			    				<span class="glyphicon glyphicon-warning-sign" ng-show="frmPessoa.txtNome.$error.required" aria-hidden="true"></span>
				    			<small ng-show="frmPessoa.txtEmail.$error.required" class="text-danger">Campo obrigatório! </small>
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
				      		<tr ng-repeat="telefone in ctrl.pessoa.telefones">
				      			<td>
				      				<span class="glyphicon glyphicon-phone-alt" aria-hidden="true"></span>
				      				{{ telefone.numero }}
				      			</td>
				      		</tr>
				        </table>				   
				   
				  </div>
				</div>	    		
	    		
	    		<hr/>
	    		
	    		<div class="row">
	    			<div class="col-md-6">
	    				<button type="submit" 
	    				        class="btn btn-primary"
	    				        ng-disabled="frmPessoa.$invalid">Salvar</button>
	    				        
	    				<a href="#/pessoa/{{ ctrl.module }}" 
	    				   class="btn btn-default">Cancelar</a>
	    			</div>
	    		</div>
	    	</form>
	    	
	  	</div>
	</div>