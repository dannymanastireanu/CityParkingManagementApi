FROM eclipse-temurin:17-jdk-jammy

COPY ./build/libs/CityParkingManagementApi-1.0-boot.jar ./app.jar

CMD ["java", "jar", "app.jar"]

