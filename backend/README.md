This is the backend springboot web server
    command to compile(Maven install required):
        1. cd spring-boot-ensf480-api-server
        2. mvn clean package (if maven installed, this create .jar file)

    Run Webserver WITHOUT Maven(Require jdk 21):
        1. cd spring-boot-ensf480-api-server
        2. java -jar target/spring-boot-ensf480-api-server-0.0.1-SNAPSHOT.jar

    Run Webserver WITH Maven already installed:
        1. mvn spring-boot:run