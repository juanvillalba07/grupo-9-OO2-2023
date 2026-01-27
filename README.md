# Proyecto Smart City UNLa (Grupo 9 - OO2 - 2023)
Trabajo Practico Cuatrimestral de la materia Orientacion a Objetos 2 de la Universidad Nacional de Lanus

## Descripcion
El objetivo de este proyecto es brindarle a la Universidad de Lanus un sistema inteligente de riego, alumbrado,
estacionamiento y baños.

## 1) Requisitos Previos
- Java 18 o superior (JDK instalado y `JAVA_HOME` configurado).
- Maven instalado o usar el wrapper incluido (`mvnw.cmd` en Windows).
- MySQL Server en ejecución y acceso a un cliente (MySQL Workbench o `mysql`).
- Espacio para crear una base de datos y ejecutar el script `smart-city.sql` incluido en la raíz.
- Puerto `8080` disponible (o actualizar `server.port` en `application.yml`).

## 2) Como Levantar el Proyecto
1. Crear la base de datos e importar datos iniciales (usuarios/roles) con el script `smart-city.sql`:

```powershell
mysql -u root -p < smart-city.sql
```

2. Actualizar las credenciales de conexión en `src/main/resources/application.yml` si es necesario (usuario, contraseña, URL).
3. Ejecutar la aplicación desde la raíz del proyecto (Windows):

```powershell
.\mvnw.cmd spring-boot:run
```

4. Alternativa: importar el proyecto como proyecto Maven en su IDE (IntelliJ, STS, VSCode) y ejecutar la clase `SmartCityApplication` como aplicación Spring Boot.
5. Abrir en el navegador: `http://localhost:8080/` (login en `/login`).

> Notas:
> - Si aparecen errores de conexión, verificar `application.yml` y que MySQL acepte conexiones desde su usuario.
> - El script `smart-city.sql` contiene usuarios y roles para acceder con permisos (contraseñas encriptadas).

## 3) Soluciones IoT
1. **Baños (Tomas Strycharski)**: Sensores o Cámaras que detectan cuando un baño está siendo higienizado para avisar que no se puede usar.
2. **Estacionamiento (Juan Villalba)**: Sensores o cámaras que detectan lugares libres y ocupados por autos.
3. **Alumbrado (Tomas Zarich)**: Sensores de luz que prenden o apagan alumbrado según sea necesario.
4. **Riego (Pablo Necco)**: Sensores de humedad que rieguen automáticamente el pasto si la humedad ambiente es baja.

## 4) Tecnologias Utilizadas
1. **Spring**: Framework ligero para construir aplicaciones Java con inversión de control (IoC) y programación por componentes. Facilita la organización del proyecto, la inyección de dependencias y la reutilización de servicios.
2. **Spring Boot**: Extensión de Spring que acelera el arranque y la configuración automática de aplicaciones. Proporciona servidor embebido, convenciones por defecto y empaquetado sencillo.
3. **Spring Security**: Biblioteca para implementar autenticación y autorización en aplicaciones Spring. Gestiona login, logout, roles y protección de endpoints.
4. **Hibernate**: ORM que mapea entidades Java a tablas relacionales y gestiona la persistencia. Simplifica consultas, transacciones y el manejo de sesiones.
5. **MySQL**: Sistema de gestión de bases de datos relacional usado para almacenar la información de la aplicación. Se usan scripts (por ejemplo `smart-city.sql`) para cargar datos iniciales, usuarios y roles.
6. **Apache Maven**: Herramienta de gestión y automatización de builds para proyectos Java. Define dependencias y ciclos de vida en `pom.xml` y facilita reproducir compilaciones y tests.

## 5) Funcionalidades Implementadas

- **Seguridad y Autenticación de Usuarios**: Autenticación con Spring Security, login/logout y control de accesos por roles (`ROLE_ADMIN`, `ROLE_AUDITOR`).
- **Gestión de Sensores de Baños**: CRUD, activar/desactivar, configuración de horarios de limpieza y vistas para `sensorBanio`.
- **Gestión de Riego / Sensores de Humedad**: Registro de mediciones, cálculo de estado de riego, CRUD, activación/desactivación y vistas para `sensorHumedad`.
- **Gestión de Sensores de Alumbrado**: CRUD, activar/desactivar y vistas para `alumbrado`.
- **Gestión de Sensores de Estacionamiento**: CRUD, activar/desactivar y vistas para `estacionamiento`.
- **Eventos y Auditoría**: Registro de eventos por dispositivo, búsqueda por rango de fechas y por nombre de dispositivo.
- **Consultas / Búsquedas**: páginas para buscar y filtrar información (`consultas`).
- **Interfaz Web:** Plantillas Thymeleaf en `src/main/resources/templates` y recursos estáticos en `src/main/resources/static`.

## 6) Recursos Adicionales
- [**Documentación de Spring**](https://docs.spring.io/spring-framework/reference/index.html)
- [**Documentación de Spring Boot**](https://docs.spring.io/spring-boot/documentation.html)
- [**Documentación de Spring Security**](https://docs.spring.io/spring-security/reference/index.html)
- [**Documentación de Hibernate**](https://hibernate.org/orm/documentation/7.2/)
- [**Documentación de MySQL**](https://dev.mysql.com/doc/)
- [**Documentación de Apache Maven**](https://maven.apache.org/)
