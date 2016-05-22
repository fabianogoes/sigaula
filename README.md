# SIGaula
### SIGaula - Sistema Integrado para Gestão de Aulas

**Tecnologias envolvidas:**   
* Java EE
* JPA/Hibernate
* Spring MVC
* Spring Transaction
* Spring IoC
* Spring Data
* HTML
* CSS
* JS
* JQuery
* AngularJS
* Twitter Bootstrap
* MySQL
* Eclipse IDE
* Maven 	
* Tomcat Tomcat
* Git
* Github 	
* Heroku

Como Contribuir
---------------

* Faça um fork deste repositório, clicando no botão [![Fork][1]][2], na parte superior direita da pagina do Github
* Faça um clone o repositório/fork do seu github:

    ```shell
    git clone --recursive https://github.com/SEU_USUARIO_DO_GITHUB/opentask.git
    ```    

    **Configuração de Variaveis de Ambiente no Eclipse**   
    ```
    Run > Run Configurations

    Environment Tab
    New
    name = DATABASE_URL
    value = mysql://root:root@localhost/sigaula

    New
    name = DATASOURCE_ENV
    value = dsDev

    Arguments Tab
    in VM arguments add:
    -DDATABASE_URL="mysql://root:root@localhost/sigaula"
    -DDATASOURCE_ENV="dsDev"
    ```       

* Após criar ou editar algum código/issue faça um pull-request para que sua implementação entre em produção.

Veja o video que explica o processo de fork, clone, push e pull-request:
http://pythonclub.com.br/como-fazer-fork-clone-push-pull-request-no-github.html

Sincronizando seu fork
----------------------

Caso você já tenha feito fork a algum tempo você tem duas opções para garantir que
estará trabalhando com as ultimas alterações, que pode ser simplesmente deletar
seu fork e fazer um novo ou sincronizar seu fork com o repositório de origem
usando as [instruções contidas na wiki](https://gist.github.com/55ed9eed0664d2f90f9c.git)

License
-------
[![MIT][3]][4]   
Licensed under an [MIT-style permissive license][3].   

Open Source
-----------
[![Open Source][5]][6]  

=====================================================   

**Aplicação rodando no Heroku:**   
[Sigaula][0]


[0]: https://sigaula.herokuapp.com/ "Sigaula"
[1]: https://raw.githubusercontent.com/fabianogoes/sigaula/master/doc/github-fork-btn.png
[2]: https://github.com/fabianogoes/sigaula/fork
[3]: https://raw.githubusercontent.com/fabianogoes/sigaula/master/LICENSE
[4]: https://raw.githubusercontent.com/fabianogoes/sigaula/master/doc/mit-license.png
[5]: https://raw.githubusercontent.com/fabianogoes/sigaula/master/doc/opensource-iniciative.png
[6]: https://en.wikipedia.org/wiki/Open_Source_Initiative
