<div ng-controller="HomeController as ctrlHome">    

    <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#/" ng-click="ctrlHome.setActiveMenu()">SIGaula</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active" id="id_menu_home"><a href="#/" ng-click="ctrlHome.setActiveMenu()">Home</a></li>
            <li class="" id="id_menu_aluno"><a href="#/pessoa/aluno">Alunos</a></li>
            <li class="" id="id_menu_professor"><a href="#/pessoa/professor">Professores</a></li>
            <li class="" id="id_menu_sobre"><a href="#/sobre">Sobre</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
</div>