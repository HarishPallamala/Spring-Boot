# Spring Practice Project 🚀

A comprehensive Spring Boot practice project designed to demonstrate core Spring Framework concepts and best practices for building REST APIs with database integration.

---

## Table of Contents

- [Project Overview](#project-overview)
- [Technologies & Dependencies](#technologies--dependencies)
- [Project Structure](#project-structure)
- [Topics Covered](#topics-covered)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Database Configuration](#database-configuration)
- [Key Features](#key-features)
- [Project Architecture](#project-architecture)
- [Contributing](#contributing)
- [License](#license)

---

## Project Overview

This project serves as a learning resource for Spring Boot development, covering essential backend concepts including:

- Spring Boot application setup and initialization
- Dependency Injection and IoC Container
- Building RESTful APIs
- Database operations with Spring Data JPA
- Layered architecture implementation
- CRUD operations with H2 in-memory database

**Target Audience:** Beginners to intermediate Java developers learning Spring Boot

---

## Technologies & Dependencies

### Core Technologies

| Technology | Version | Purpose |
|-----------|---------|---------|
| **Java** | 17 | Programming Language |
| **Spring Boot** | 3.3.5 | Framework |
| **Maven** | Latest | Build & Dependency Management |

### Key Dependencies

```xml
<!-- Web & REST APIs -->
spring-boot-starter-web          // Spring MVC + REST support

<!-- Database & ORM -->
spring-boot-starter-data-jpa     // JPA + Hibernate
h2                               // In-memory Database

<!-- Utilities -->
lombok                           // Reduce boilerplate code

<!-- Testing -->
spring-boot-starter-test         // JUnit + Mockito
```

---

## Project Structure

```
spring-practice/
│
├── src/main/java/spring/spring_practice/
│   ├── SpringPracticeApplication.java          # Main entry point
│   ├── Computer.java                           # Interface (polymorphism demo)
│   ├── Developers.java                         # Component with DI examples
│   ├── Desktop.java                            # Computer implementation
│   ├── Laptop.java                             # Computer implementation
│   │
│   ├── controllers/
│   │   ├── HomeController.java                 # REST endpoint for home
│   │   ├── LoginController.java                # REST endpoint for login
│   │   └── ProductsController.java             # REST CRUD endpoints
│   │
│   ├── services/
│   │   └── ProductService.java                 # Business logic layer
│   │
│   ├── models/
│   │   └── Product.java                        # JPA Entity
│   │
│   └── repository/
│       └── ProductRepo.java                    # Data access layer
│
├── src/main/resources/
│   ├── application.properties                  # Configuration file
│   ├── static/                                 # Static resources
│   └── templates/                              # HTML templates
│
├── src/test/java/
│   └── spring/spring_practice/
│       └── SpringPracticeApplicationTests.java # Test class
│
├── pom.xml                                     # Maven configuration
├── mvnw & mvnw.cmd                             # Maven wrapper scripts
└── README.md                                   # This file
```

---

## Topics Covered

### 1. **Spring Boot Basics**

- **Spring Boot Application Setup**
  - `@SpringBootApplication` annotation
  - Main method with `SpringApplication.run()`
  - Auto-configuration

- **IoC (Inversion of Control) Container**
  ```java
  ApplicationContext context = SpringApplication.run(...);
  Developers dev = context.getBean(Developers.class);
  ```
  - BeanFactory (basic container)
  - ApplicationContext (advanced container)
  - Bean lifecycle management

### 2. **Dependency Injection (DI)**

- **@Component Annotation**
  - Marks a class as a Spring component
  - Automatically registers bean in IoC container
  - Used in: `Developers`, `Desktop`, `Laptop` classes

- **@Autowired Annotation**
  - Field Injection
  - Constructor Injection (commented examples)
  - Setter Injection (available pattern)

- **@Qualifier Annotation**
  ```java
  @Autowired
  @Qualifier("desktop")
  private Computer machineObj;
  ```
  - Resolves ambiguity when multiple beans exist
  - Used to select specific implementation

- **@Primary Annotation**
  - Alternative to @Qualifier
  - Marks default bean when multiple candidates exist

### 3. **Spring Stereotypes**

- **@Component** - Generic component marker
- **@Service** - Business logic layer (`ProductService`)
- **@Repository** - Data access layer (`ProductRepo`)
- **@RestController** - REST endpoint handler (`ProductsController`)

### 4. **REST API Development**

- **@RestController**
  - Combines @Controller + @ResponseBody
  - Returns JSON/XML responses

- **@RequestMapping**
  - Maps HTTP requests to handler methods
  - Supports all HTTP methods (GET, POST, etc. by default)

- **HTTP Method Annotations**
  - `@GetMapping` - HTTP GET requests
  - `@PostMapping` - HTTP POST requests
  - `@PutMapping` - HTTP PUT requests
  - `@DeleteMapping` - HTTP DELETE requests

- **Request Parameters**
  - `@RequestBody` - Parse request body to object
  - `@PathVariable` - Extract path variables (e.g., `/products/{id}`)

### 5. **Database & ORM (Hibernate)**

- **Spring Data JPA**
  - `JpaRepository` interface
  - Built-in CRUD operations
  - No need to write boilerplate SQL

- **H2 Database**
  - In-memory database perfect for development/testing
  - Configuration via `application.properties`
  - H2 Console available at `/h2-console`

- **JPA Annotations**
  - `@Entity` - Marks class as database entity
  - `@Id` - Primary key field
  - `@Table` - Customize table name (if needed)

- **Custom Repository**
  ```java
  public interface ProductRepo extends JpaRepository<Product, Integer> {
      // Automatically get: save(), findById(), findAll(), delete(), etc.
  }
  ```

### 6. **Lombok Integration**

- **@Data** - Generates getters, setters, toString(), equals(), hashCode()
- **@AllArgsConstructor** - Generates constructor with all fields
- **@NoArgsConstructor** - Generates default no-argument constructor
- Reduces boilerplate code significantly

### 7. **Layered Architecture**

The project follows a 3-tier architecture pattern:

```
┌─────────────────────────────────┐
│   Controllers                   │ ← HTTP requests/responses
├─────────────────────────────────┤
│   Services                      │ ← Business logic
├─────────────────────────────────┤
│   Repository/DAO                │ ← Data access
├─────────────────────────────────┤
│   Database                      │ ← Persistence
└─────────────────────────────────┘
```

**Benefits:**
- Separation of concerns
- Easy to test
- Maintainable code
- Reusable components

### 8. **Design Patterns Demonstrated**

- **Dependency Injection Pattern** - Invert control of object creation
- **Singleton Pattern** - Spring beans are singletons by default
- **Repository Pattern** - Abstract data access logic
- **Strategy Pattern** - Computer interface with multiple implementations
- **Factory Pattern** - Spring creates beans automatically

### 9. **Testing**

- **spring-boot-starter-test** dependency
- Support for JUnit 5
- Mockito integration for mocking
- Test class: `SpringPracticeApplicationTests`

---

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Git (optional, for cloning)

### Installation & Running

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/spring-practice.git
   cd spring-practice/spring-practice
   ```

2. **Build the Project**
   ```bash
   mvn clean install
   ```
   Or using Maven wrapper:
   ```bash
   ./mvnw clean install      # Linux/Mac
   mvnw.cmd clean install    # Windows
   ```

3. **Run the Application**
   ```bash
   mvn spring-boot:run
   ```
   Or using Maven wrapper:
   ```bash
   ./mvnw spring-boot:run    # Linux/Mac
   mvnw.cmd spring-boot:run  # Windows
   ```

4. **Access the Application**
   - Application runs on: `http://localhost:8080`
   - H2 Console: `http://localhost:8080/h2-console`
   - H2 Console credentials:
     - URL: `jdbc:h2:mem:hari`
     - Username: `sa`
     - Password: (leave empty)

### Running Tests

```bash
mvn test
```

---

## API Endpoints

### Home Controller
```
GET  http://localhost:8080/
     Response: "Hello! Welcome to Spring"
```

### Login Controller
```
GET  http://localhost:8080/login
     Response: "Login Page POP up"
```

### Products Controller (CRUD Operations)

#### 1. Get All Products
```
GET /products

Response:
[
  {"id": 101, "name": "iPhone 16", "price": 127000},
  {"id": 102, "name": "Samsung S23", "price": 75000}
]
```

#### 2. Get Product by ID
```
GET /products/{id}
Example: GET /products/101

Response:
{"id": 101, "name": "iPhone 16", "price": 127000}
```

#### 3. Add New Product
```
POST /products

Request Body:
{"id": 104, "name": "Pixel 8", "price": 85000}

Response: [All products list]
```

#### 4. Update Product
```
PUT /products

Request Body:
{"id": 101, "name": "iPhone 16 Pro", "price": 135000}

Response: [All products list]
```

#### 5. Delete Product
```
DELETE /products/{id}
Example: DELETE /products/101

Response: [Remaining products list]
```

---

## Database Configuration

### H2 Database Setup (application.properties)

```properties
# Application name
spring.application.name=spring-practice

# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:hari
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Hibernate/JPA Configuration
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.show-sql=true
```

### Key Properties Explained

| Property | Purpose |
|----------|---------|
| `spring.datasource.url` | In-memory database name |
| `spring.h2.console.enabled` | Enable H2 web console |
| `spring.jpa.show-sql=true` | Log SQL statements to console |

---

## Key Features

### ✅ Complete CRUD Operations
- Create products
- Read/Retrieve products
- Update existing products
- Delete products

### ✅ REST API Design
- RESTful endpoint conventions
- Proper HTTP methods (GET, POST, PUT, DELETE)
- JSON request/response handling

### ✅ Dependency Injection Examples
- Multiple DI patterns demonstrated
- Qualifier vs Primary annotation comparison
- Real-world DI scenarios

### ✅ Database Persistence
- JPA entity mapping
- Repository pattern implementation
- Transaction management

### ✅ Clean Code
- Lombok for reducing boilerplate
- Layered architecture
- Interface-based design

---

## Project Architecture

### Request Flow Diagram

```
HTTP Request
     ↓
@RestController (ProductsController)
     ↓
@Service (ProductService)
     ↓
@Repository (ProductRepo extends JpaRepository)
     ↓
H2 Database
     ↓
Response (JSON)
```

### Component Interaction

```
SpringPracticeApplication (Entry Point)
    ↓
    ├── IoC Container (ApplicationContext)
    │   ├── Manages all beans
    │   └── Handles DI
    ├── Controllers
    │   ├── HomeController
    │   ├── LoginController
    │   └── ProductsController
    ├── Services
    │   └── ProductService
    ├── Repositories
    │   └── ProductRepo
    └── Components
        ├── Developers (DI example)
        ├── Desktop (Computer interface)
        └── Laptop (Computer interface)
```

---

## Learning Path

Recommended order to explore the code:

1. **Start Here:** `SpringPracticeApplication.java` - Understand IoC & ApplicationContext
2. **DI Concepts:** `Developers.java`, `Computer.java`, `Desktop.java`, `Laptop.java`
3. **REST Basics:** `HomeController.java`, `LoginController.java`
4. **Models:** `Product.java` - JPA entity
5. **Service Layer:** `ProductService.java` - Business logic
6. **Repository:** `ProductRepo.java` - Data access
7. **Full Integration:** `ProductsController.java` - Complete CRUD

---

## Common Issues & Solutions

### Issue: Multiple implementations of Computer interface
**Solution:** Use `@Qualifier("desktop")` or `@Primary` annotation

### Issue: H2 Console not loading
**Solution:** Ensure `spring.h2.console.enabled=true` in application.properties

### Issue: Port 8080 already in use
**Solution:** Change port in application.properties:
```properties
server.port=8081
```

---

## Future Enhancements

- [ ] Add authentication & authorization (Spring Security)
- [ ] Implement custom repository methods
- [ ] Add validation annotations
- [ ] Create DTOs (Data Transfer Objects)
- [ ] Add exception handling (@ControllerAdvice)
- [ ] Implement pagination & filtering
- [ ] Add logging (SLF4J + Logback)
- [ ] Integration tests with TestContainers
- [ ] API documentation (Swagger/Springdoc)

---

## Resources & References

### Official Documentation
- [Spring Boot Official Docs](https://spring.io/projects/spring-boot)
- [Spring Framework](https://spring.io/projects/spring-framework)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Lombok Project](https://projectlombok.org/)

### Key Concepts
- [IoC & DI in Spring](https://docs.spring.io/spring-framework/reference/core/beans.html)
- [Spring Web MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [JPA Specification](https://jakarta.ee/specifications/persistence/)

---

## Author

Created as a Spring Boot learning project.

---

## License

This project is open source and available under the MIT License.

---

## Acknowledgments

- Spring Boot community and documentation
- Spring Framework best practices
- Java development standards

---

## Contact & Support

For questions or suggestions about this project, feel free to reach out or open an issue.

---

**Last Updated:** 2026

**Status:** Active Learning Project ✅
