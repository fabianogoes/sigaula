<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
  
  <!-- *** home-head ****************************** -->
  <jsp:include page="core/home-head.jsp"></jsp:include>
  
  <body>

	<!-- *** home-top ****************************** -->
	<jsp:include page="core/home-top.jsp"></jsp:include>

    <!-- *** Begin page content ***************************** -->
    <div class="container">
      <div class="page-header">
        <h1>SIGaula - Sistema Integrado para Gestão de Aulas</h1>
      </div>
      <img alt="SIG" src="${ pageContext.request.contextPath }/resources/img/sig.png">
    </div>
    <!--/ *** Begin page content ***************************** -->

	<!-- *** home-footer ****************************** -->
	<jsp:include page="core/home-footer.jsp"></jsp:include>


	<!-- *** home-buttonjs ****************************** -->
	<jsp:include page="core/home-buttonjs.jsp"></jsp:include>    
    
  </body>
</html>
