FROM eclipse-temurin:17-jre-focal as builder
#ARG JAR_FILE=target/*.jar
COPY target/fi-verification-0.0.1-SNAPSHOT.jar fi-verification.jar
RUN java -Djarmode=layertools -jar fi-verification.jar extract

FROM eclipse-temurin:17-jre-focal
COPY --from=builder dependencies/ ./
COPY --from=builder snapshot-dependencies/ ./
COPY --from=builder spring-boot-loader/ ./
COPY --from=builder fi-verification/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
