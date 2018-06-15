# robot
Robot Operation APIs


#### Robot APIs #####

####Docker Setup##########
##Install docker on your machine

brew cask install docker


#####Virtual Box (Optional)#######
##Install Oracle Virtual Box


############Start Docker ###############

bash /Applications/Docker/Docker\ Quickstart\ Terminal.app/Contents/Resources/Scripts/start.sh

#######Install and Start Postgres############

docker pull postgres:9.6

docker run --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=password -e POSTGRES_DB=postgres -d postgres:9.6


########Download the Spring boot application and set your workspace with InteliJ ######

##Execute command Gradle clean build

./gradlew clean

./gradlew build -x test

##Create Docker Image of your Robot application#####
## Go to project Base Directory and execute below command

docker build -t robot:latest .

### Start your Robot application with Postgres on Docker

docker run --link postgres -p 8082:8082 --name robot -t robot:latest


#####Application Started#######
Use Swagger URL to access.

http://localhost:8082/swagger-ui.html

or

http://<Virtual_box_ip>:8082/swagger-ui.html
