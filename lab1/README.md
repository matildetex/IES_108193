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

GitHub:





Docker: 
A container is a sandboxed process running on a host machine that is isolated from all other processes running on that host machine.

-runnable instance of image. You can create, start, stop, move, or delete a container using the Docker API or CLI.
-Can run on local machines, virtual machines, or deployed to the cloud.
-portable (and can be run on any OS).
-isolated from other containers and runs its own software, binaries, configurations, etc.
-Running container uses an isolated filesystem, which is provided by an IMAGE, where it must contain everything needed to run an application.

-docker build -t getting-started . -> build new image

-docker run -dp 127.0.0.1:3000:3000 getting-started -> iniciar

-touch Dockerfile-> criar ficheiro docker

-docker compose up ->Compose pulls a Redis image, builds an image for your code, and starts the services you defined. In this case, the code is statically copied into the image at build time. 

-docker inspect <tag or id> -> inspect images

-docker compose stop-> stop aplication

-docker compose up -d -> run services in background
-docker compose ps -> see what is running

- docker compose run web env -> run one-off commands against a service

-docker compose down --volumes -> can bring everything down, removing the containers entirely, with the down command. Pass --volumes to also remove the data volume used by the Redis container.
