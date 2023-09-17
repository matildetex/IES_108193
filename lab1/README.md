Notas Sobre Guião 1:
.Maven: https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
.groupID (com.mycompany.app)and artifactID(my-app) specific for each project
.-D-> used to define/pass a property to Maven in CLI
.see atributtes of POM (can be too much)
.dependencies for artifacts
.artifacts might require other dependencies forming a graph

Maven Commands:
$mvn package #get dependencies, compiles the project and creates the jar
$mvn exec:java -Dexec.mainClass="weather.WeatherStarter" #adapt to match your own 
package structure and class name
CheatSheet Maven Commands- https://www.digitalocean.com/community/tutorials/maven-commands-options-cheat-sheet

-Run with arguments: mvn exec:java -Dexec.mainClass=test.Main -Dexec.args="arg1 arg2 arg3"