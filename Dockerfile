FROM gradle:8.3.0-jdk17 AS builder

WORKDIR ./building

COPY . .

RUN gradle build

FROM registry.access.redhat.com/ubi8/openjdk-17:1.14

#ENV LANGUAGE='en_US:en'


# We make four distinct layers so if there are application changes the library layers can be re-used
COPY --chown=185 --from=builder home/gradle/building/build/quarkus-app/lib/ /deployments/lib/
COPY --chown=185 --from=builder home/gradle/building/build/quarkus-app/*.jar /deployments/
COPY --chown=185 --from=builder home/gradle/building/build/quarkus-app/app/ /deployments/app/
COPY --chown=185 --from=builder home/gradle/building/build/quarkus-app/quarkus/ /deployments/quarkus/
#COPY --chown=185 --from=builder home/.gradle/building/build/quarkus-app/ deployments/

EXPOSE 8080
USER 185
ENV JAVA_OPTS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV JAVA_APP_JAR="/deployments/quarkus-run.jar"