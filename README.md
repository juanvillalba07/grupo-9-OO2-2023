# Proyecto Smart City UNLa (Grupo 9 - OO2 - 2023)
Trabajo Practico Cuatrimestral de la materia Orientacion a Objetos 2 de la Universidad Nacional de Lanus

## Descripcion
El objetivo de este proyecto es brindarle a la Universidad de Lanus un sistema inteligente de riego, alumbrado,
estacionamiento y baños.

## 1) Como levantar el proyecto
Como primer paso se debe comprobar que se tenga instalado:
- Java 18 o superior
- Maven 
- MySQL Server(para administrar y visualizar los datos se usa MySQL Workbench)
- IDE de preferencia (puede ser Spring Tool Suite, VSC, IntelliJ, etc)

- Se deja en el repositorio el script de smart-city.sql para poder correr los usuarios con sus contraseñas encriptadas 
y sus roles para poder acceder a dichas paginas

- En la pestaña Code, puede copiar el link del repositorio y clonarlo en su Sistema Operativo o tambien puede clonarlo
mediante el IDE Spring Tool Suite

- Todo nuestro proyecto esta en la branch master

## 2) Soluciones IoT
1. **Baños (Tomas Strycharski)**: Sensores o Cámaras que detectan cuando un baño está siendo higienizado para avisar que no se puede usar.
2. **Estacionamiento (Juan Villalba)**: Sensores o cámaras que detectan lugares libres y ocupados por autos.
3. **Alumbrado (Tomas Zarich)**: Sensores de luz que prenden o apagan alumbrado según sea necesario.
4. **Riego (Pablo Necco)**: Sensores de humedad que rieguen automáticamente el pasto si la humedad ambiente es baja.

## 3) Tecnologias Utilizadas
1. **Spring**: Framework ligero para construir aplicaciones Java con inversión de control (IoC) y programación por componentes. Facilita la organización del proyecto, la inyección de dependencias y la reutilización de servicios.
2. **Spring Boot**: Extensión de Spring que acelera el arranque y la configuración automática de aplicaciones. Proporciona servidor embebido, convenciones por defecto y empaquetado sencillo.
3. **Spring Security**: Biblioteca para implementar autenticación y autorización en aplicaciones Spring. Gestiona login, logout, roles y protección de endpoints.
4. **Hibernate**: ORM que mapea entidades Java a tablas relacionales y gestiona la persistencia. Simplifica consultas, transacciones y el manejo de sesiones.
5. **MySQL**: Sistema de gestión de bases de datos relacional usado para almacenar la información de la aplicación. Se usan scripts (por ejemplo `smart-city.sql`) para cargar datos iniciales, usuarios y roles.
6. **Apache Maven**: Herramienta de gestión y automatización de builds para proyectos Java. Define dependencias y ciclos de vida en `pom.xml` y facilita reproducir compilaciones y tests.

## 4) Funcionalidades Implementadas

- **Seguridad y Autenticación de Usuarios**: Autenticación con Spring Security, login/logout y control de accesos por roles (`ROLE_ADMIN`, `ROLE_AUDITOR`).
- **Gestión de Sensores de Baños**: CRUD, activar/desactivar, configuración de horarios de limpieza y vistas para `sensorBanio`.
- **Gestión de Riego / Sensores de Humedad**: Registro de mediciones, cálculo de estado de riego, CRUD, activación/desactivación y vistas para `sensorHumedad`.
- **Gestión de Sensores de Alumbrado**: CRUD, activar/desactivar y vistas para `alumbrado`.
- **Gestión de Sensores de Estacionamiento**: CRUD, activar/desactivar y vistas para `estacionamiento`.
- **Eventos y Auditoría**: Registro de eventos por dispositivo, búsqueda por rango de fechas y por nombre de dispositivo.
- **Consultas / Búsquedas**: páginas para buscar y filtrar información (`consultas`).
- **Interfaz Web:** Plantillas Thymeleaf en `src/main/resources/templates` y recursos estáticos en `src/main/resources/static`.

## 5) Recursos Adicionales
- [**Documentación de Spring**](https://docs.spring.io/spring-framework/reference/index.html)
- [**Documentación de Spring Boot**](https://docs.spring.io/spring-boot/documentation.html)
- [**Documentación de Spring Security**](https://docs.spring.io/spring-security/reference/index.html)
- [**Documentación de Hibernate**](https://hibernate.org/orm/documentation/7.2/)
- [**Documentación de MySQL**](https://dev.mysql.com/doc/)
- [**Documentación de Apache Maven**](https://maven.apache.org/)
