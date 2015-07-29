# SIGaula
### SIGaula - Sistema Integrado para Gestão de Aulas

*Configure Variable Environment in Project Run*   
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
