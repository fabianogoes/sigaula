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

**Aplicação rodando no Heroku:**   
[Sigaula]: [0]


[0]: https://sigaula.herokuapp.com/
