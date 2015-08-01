
<jsp:include page="../core/home-description.jsp"></jsp:include>

<div ng-controller="SobreController as ctrl" class="text-center">
	<div class="panel panel-primary">
  		<div class="panel-body">
			<h2>Tecnologias:</h2>
		</div>
	
		<table class="table table-condensed table-bordered table-responsive">
			<tbody>
				<tr>
					<td>
						<img alt="Java EE" src="${ pageContext.request.contextPath }/resources/img/javaee.png" height="30px">
					</td>
					<td>
						<img alt="HTML CSS JS" src="${ pageContext.request.contextPath }/resources/img/html-css-js.png" height="20px">
					</td>
				</tr>
				<tr>
					<td>
						<img alt="Spring MVC" src="${ pageContext.request.contextPath }/resources/img/spring.png" height="20px"> 
						Spring MVC
					</td>
					<td>
						<img alt="MySQL" src="${ pageContext.request.contextPath }/resources/img/mysql.jpg" height="30px">
						<img alt="MySQL" src="${ pageContext.request.contextPath }/resources/img/poestgresql.png" height="25px">
					</td>
				</tr>
				<tr>
					<td>
						<img alt="Spring Transaction" src="${ pageContext.request.contextPath }/resources/img/spring.png" height="20px"> 
						Spring Transaction
					</td>
					<td>
						<img alt="Eclipse IDE" src="${ pageContext.request.contextPath }/resources/img/eclipse.png" height="20px">
					</td>
				</tr>
				<tr>
					<td>
						<img alt="Spring IoC" src="${ pageContext.request.contextPath }/resources/img/spring.png" height="20px"> 
						Spring IoC
					</td>
					<td>
						<img alt="JQuery" src="${ pageContext.request.contextPath }/resources/img/jquery.png" height="23px">
					</td>
				</tr>
				<tr>
					<td>
						<img alt="Hibernate/JPA" src="${ pageContext.request.contextPath }/resources/img/hibernate.png" height="20px"> 
						Hibernate/JPA
					</td>
					<td>
						<img alt="AngularJS" src="${ pageContext.request.contextPath }/resources/img/angularjs.png" height="20px">
					</td>
				</tr>
				<tr>
					<td>
						<img alt="Maven" src="${ pageContext.request.contextPath }/resources/img/maven.png" height="20px">
					</td>
					<td>
						<img alt="Tomcat" src="${ pageContext.request.contextPath }/resources/img/tomcat.png" height="20px">
						Tomcat
					</td>
				</tr>
				<tr>
					<td>
						<img alt="Git" src="${ pageContext.request.contextPath }/resources/img/git.png" height="20px">
					</td>
					<td>
						<img alt="Twitter Bootstrap" src="${ pageContext.request.contextPath }/resources/img/bootstrap.png" height="23px">
					</td>
				</tr>
				<tr>
					<td>
						<img alt="Github" src="${ pageContext.request.contextPath }/resources/img/github.png" height="15px">
					</td>
					<td>
						<img alt="Heroku" src="${ pageContext.request.contextPath }/resources/img/heroku.png" height="25px">
					</td>
				</tr>
				
			</tbody>
		</table>
		
	</div><!-- panel -->
	
	<a href="http://opensource.org/licenses/MIT" target="_blank">
		<img class="pull-right" alt="MIT License" src="${ pageContext.request.contextPath }/resources/img/opensource.png" height="50px">
	</a>
	<a href="http://opensource.org/licenses/MIT" target="_blank">
		<img class="pull-left" alt="MIT License" src="${ pageContext.request.contextPath }/resources/img/mit-license.png" height="40px">
	</a>
	
</div>