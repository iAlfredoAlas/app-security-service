
---

# 🔐 app-security-service

**app-security-service** is a Spring Boot microservice responsible for managing **authentication**, **role-based access control (RBAC)**, and **JWT token lifecycle** within a distributed inventory management system.

This service handles secure login, token issuance and refresh, user-role-permission resolution, and acts as the centralized security layer across all backend services.

---

## 📦 Tech Stack

- **Spring Boot 3.5.7**
- **Java 21**
- **PostgreSQL 16**
- **Spring Security**
- **JWT (JSON Web Tokens)**
- **Spring Data JPA**
- **Flyway**
- **Maven**
- **Lombok**

---

## 📁 Project Structure

```

app-security-service/
├── src/main/java/com/utilsdev/security/
│   ├── controller/       # Auth endpoints
│   ├── dto/              # DTOs for requests/responses
│   ├── entity/           # JPA entities mapped to schema `security`
│   ├── repository/       # JPA repositories
│   ├── security/         # JWT filters, config, user details
│   ├── service/          # Business logic
│   └── AppSecurityServiceApplication.java
├── src/main/resources/
│   ├── application.yml   # Configuration
│   └── db/migration/     # Flyway SQL files
└── pom.xml

````

---

## ⚙️ Configuration

Make sure to configure your `application.yml` with PostgreSQL credentials and JWT secret:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/inventorydb
    username: appinventory
    password: yourpassword
  jpa:
    hibernate:
      ddl-auto: none
    show-sql: true
    properties:
      hibernate:
        format_sql: true

jwt:
  secret: your-super-secret-key
  expiration: 3600000 # 1 hour
````

---

## 🚀 Endpoints Overview

| Method | Path                | Description                        |
| ------ | ------------------- | ---------------------------------- |
| POST   | `/api/auth/login`   | Authenticate and get JWT token     |
| POST   | `/api/auth/refresh` | Refresh expired tokens             |
| GET    | `/api/me`           | Get current logged-in user details |
| GET    | `/api/users`        | (Protected) List all users         |

---

## 🔐 Security Layer

* JWT access and refresh tokens
* Spring Security with custom filters
* Permission validation using `@PreAuthorize`
* Role and permission checks based on database relationships

---

## 🗃️ Database Schema

This service interacts only with the `security` schema, which includes:

* `user_account`
* `role`
* `permission`
* `user_role`
* `role_permission`
* `program_module`
* `program_module_permission`

---

## 🧪 Test Commands

```bash
# Build the app
mvn clean install

# Run locally
mvn spring-boot:run
```

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

```

