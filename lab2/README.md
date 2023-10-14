Notas Lab2:
Ex1:
Servlet is a Java class that runs at the server, handles (client) requests,
processes them, and reply with a response. Must be deployed into a (multithreaded) Servlet Container to be usable.

When an application running in a web server receives a request, the Server hands the request to the Servlet Container which in turn passes it to the
target Servlet.

For some use cases, you may prefer to run the web container from within your app.

Ex2:
For TomCat:
-Fazer dockerFile
-fazer 2 imagens
-dar build às imagens
-fazer ficheiro dockercompose

Ex3
-Spring Boot-rapid application development platform built on top of the popular Spring Framework, convention-over-configuration addition to the Spring
platform, useful to get started with minimum effort and create stand-alone, production-grade applications.
-https://spring.io/guides/gs/serving-web-content/

endereço para rodar: http://localhost:8080/greeting

com curl: curl -v http://localhost:8083/greeting

Ex4
Notas:
-instanciar classes
-ter cuidado com nomes de classes e returns
-ver e ter cuidado com a apresentação de dados
-inicializar estruturas
-@RequestParam -> meter argumentos
-@RestController-> não esuqecer de meter
-quando dá Error estranhos ver classes dependentes