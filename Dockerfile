FROM maven:3-jdk-11 as BUILD

ADD . /app
RUN mvn --batch-mode -f /app/pom.xml clean package

FROM fabric8/java-alpine-openjdk8-jre
ENV JAVA_OPTIONS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV AB_ENABLED=jmx_exporter
COPY --from=BUILD /app/target/lib/* /deployments/lib/
COPY --from=BUILD /app/target/*-runner.jar /deployments/app.jar
ENTRYPOINT [ "/deployments/run-java.sh" ]