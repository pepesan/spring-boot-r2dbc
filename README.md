# Ejemplo de spring boot con r2dbc y mysql 
# crear la instancia de la bbdd
$ docker-compose up -d

# Fichero que configura mysql
docker-compose.yaml

# Crear la tabla en la BBDD test
# fichero src/main/resources/schema.sql
CREATE TABLE product (
id MEDIUMINT NOT NULL AUTO_INCREMENT,
name CHAR(30) NOT NULL,
description CHAR(30) NOT NULL,
PRIMARY KEY (id)
);

# Arrancar la Aplicación
mvn clean spring-boot:run
