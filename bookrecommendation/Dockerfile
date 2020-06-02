FROM adoptopenjdk/openjdk13-openj9:jdk-13.0.2_8_openj9-0.18.0-alpine-slim
COPY bookrecommendation/build/libs/bookrecommendation-*-all.jar bookrecommendation.jar
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-XX:+IdleTuningGcOnIdle", "-Xtune:virtualized", "-jar", "bookrecommendation.jar"]
EXPOSE 8080
