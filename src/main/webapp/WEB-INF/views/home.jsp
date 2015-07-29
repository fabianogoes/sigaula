<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br" ng-app>
  
  <!-- *** home-head ****************************** -->
  <jsp:include page="core/home-head.jsp"></jsp:include>
  
  <body>

	<!-- *** home-top ****************************** -->
	<jsp:include page="core/home-top.jsp"></jsp:include>

    <!-- *** Begin page content ***************************** -->
    <div class="container">
      	<div class="page-header">
        	<h1>
        		<img alt="SIG" src="${ pageContext.request.contextPath }/resources/img/sig.png" width="100px"> 
        		${ appName }&nbsp; 
        		<small>
        			<c:if test="${ module_caption_add != null }">
		        		<a href="${ module_url_add }" class="btn btn-success pull-right">
		        			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
		        			${ module_caption_add }
		        		</a>
        			</c:if>
        			${ module_include != null ? moduleDescription : appDescription }
        		</small>
        		
        	</h1>
      	</div>
      	<br/>
     
      	<c:if test="${ module_include != null }">
      		<jsp:include page="${ module_include }"></jsp:include>
      	</c:if>
    </div>
    <!--/ *** Begin page content ***************************** -->

	<!-- *** home-footer ****************************** -->
	<jsp:include page="core/home-footer.jsp"></jsp:include>


	<!-- *** home-buttonjs ****************************** -->
	<jsp:include page="core/home-buttonjs.jsp"></jsp:include>    
    
  </body>
</html>
