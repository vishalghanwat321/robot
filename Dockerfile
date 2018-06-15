FROM frolvlad/alpine-oraclejdk8:slim
EXPOSE 8082
ADD build/libs/robot-0.0.1-SNAPSHOT.jar robot.jar
ENTRYPOINT ["java","-jar","robot.jar"]