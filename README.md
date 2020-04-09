# Getting Started

## Reference Documentation

* Java 11
* Spring Boot 2.3.0.M3
* Maven 4.0.0
* Docker Engine 19.03.5
* Docker Compose 1.24.1
* Kubernetes 1.14.8
* Helm 3

## Esquema

![Esquema](https://github.com/peterm85/dkh/blob/master/dkh-schema.PNG)

## Componentes

### DkhService1

Microservicio encargado de saludar e identificar desde qué host se realiza (localhost, docker, pod de kubernetes)

End-points:
* hello 

Parametrización:
* Activación/desactivación del mostrado de host

### DkhService2

Microservicio-api encargado de la gestión de Personas en la base de datos

End-points:
* person/{id}

### MySql

Base de datos para almacenar personas

Credenciales de accesos almacenadas en fichero un fichero Secret.
Persistencia vinculada a un volumen de datos.

### CronJob

