<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="panel panel-primary">
  	<div class="panel-heading">
    	<h3 class="panel-title">Detalhes</h3>
  	</div>
  	<div class="panel-body">
    	
    	<form>
    		<div class="row">
    			<div class="col-md-6">
					<div class="form-group">
		    			<label for="id_aluno_nome">Nome:</label>
		    			<input type="text" name="nome" class="form-control" id="id_aluno_nome" placeholder="Nome...">
		  			</div>
    			</div>
    			<div class="col-md-6">
					<div class="form-group">
		    			<label for="id_aluno_email">E-mail:</label>
		    			<input type="email" name="email" class="form-control" id="id_aluno_email" placeholder="Email...">
		  			</div>
		  		</div>
    		</div>
    		
    		<hr/>
    		
    		<div class="row">
    			<div class="col-md-6">
    				<button type="submit" class="btn btn-primary">Salvar</button>
    				<a href="${ pageContext.request.contextPath }/aluno/list" class="btn btn-default">Cancelar</a>
    			</div>
    		</div>
    	</form>
    	
  	</div>
</div>
