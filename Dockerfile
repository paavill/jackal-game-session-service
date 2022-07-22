FROM gradle:7.4.0-jdk17-alpine AS TEMP_BUILD_IMAGE
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME

COPY . .

RUN gradle clean build

FROM openjdk:17.0.2-jdk
ENV ARTIFACT_NAME=jackal-game-session-service-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app

WORKDIR $APP_HOME

COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/$ARTIFACT_NAME .

ENTRYPOINT java -Dserver.host=$GAME_SESSION_SERVICE_HOST -Dserver.port=$GAME_SESSION_SERVICE_PORT -jar $ARTIFACT_NAME