# Hospital Billing Backend

A comprehensive Spring Boot REST API backend for hospital billing management, supporting diagnosis tracking, physician management, and treatment billing operations.

## Features

- RESTful API endpoints for diagnosis, physician, and treatment management
- H2 in-memory database for development and testing
- MySQL database support for production
- CORS configuration for frontend integration
- Comprehensive unit tests with JUnit and Mockito
- Code coverage with JaCoCo
- Docker support for containerized deployment
- Flexible build and run scripts with multiple options

## Technology Stack

- **Java**: 17
- **Spring Boot**: 3.1.0
- **Spring Data JPA**: For database operations
- **Hibernate**: ORM framework
- **H2 Database**: In-memory database for development
- **MySQL**: Production database (version 8.0.33)
- **Maven**: Build automation
- **JUnit 5**: Testing framework
- **Mockito**: Mocking framework for tests
- **JaCoCo**: Code coverage
- **Docker**: Containerization

## Prerequisites

- Java Development Kit (JDK) 17 or higher
- Maven 3.9 or higher
- MySQL 8.0+ (for production profile)
- Docker (optional, for containerized deployment)

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/sekacorn/Hospital-Billing-Backend.git
cd Hospital-Billing-Backend
```

### Configuration

The application supports two profiles:

#### Development Profile (H2 Database)
- Profile name: `dev`
- Database: H2 in-memory
- Configuration: `src/main/resources/application-dev.properties`
- H2 Console: Available at `http://localhost:8080/h2-console`
- Sample data automatically loaded

#### Production Profile (MySQL)
- Profile name: `prod` (or default)
- Database: MySQL
- Configuration: `src/main/resources/application.properties`

Edit the appropriate properties file to configure database connection:

```properties
# MySQL Configuration (application.properties)
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_billing
spring.datasource.username=your_username
spring.datasource.password=your_password
```

## Running the Application

### Option 1: Using the Build Script (Recommended)

The project includes a flexible build and run script with multiple options:

```bash
# Show help and available options
./build-run.sh --help

# Run with development profile (default)
./build-run.sh

# Run with production profile
./build-run.sh --prod

# Skip tests during build
./build-run.sh --skip-tests

# Skip clean step (faster rebuild)
./build-run.sh --skip-clean

# Skip build entirely (just run)
./build-run.sh --skip-build

# Run on custom port
./build-run.sh --port 9090

# Combined options
./build-run.sh --skip-tests --skip-clean --port 9090
```

### Option 2: Using Maven Directly

```bash
# Development profile with H2 database
mvn spring-boot:run -Dspring-boot.run.profiles=dev

# Production profile
mvn spring-boot:run -Dspring-boot.run.profiles=prod

# Skip tests
mvn spring-boot:run -Dspring-boot.run.profiles=dev -DskipTests

# Custom port
mvn spring-boot:run -Dspring-boot.run.profiles=dev -Dspring-boot.run.jvmArguments="-Dserver.port=9090"
```

### Option 3: Using Docker

```bash
# Build and run using the build script
./build-run.sh --docker

# Or manually
docker build -t hospital-billing-backend .
docker run -d -p 8080:8080 --name hospital-billing-backend hospital-billing-backend

# With custom environment
docker run -d -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=prod \
  -e SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/hospital_billing \
  --name hospital-billing-backend \
  hospital-billing-backend
```

## API Endpoints

All endpoints are prefixed with `/api`

### Diagnosis Endpoints

- `GET /api/diagnoses` - Get all diagnoses
- `GET /api/diagnoses/{id}` - Get diagnosis by ID
- `POST /api/diagnoses` - Create new diagnosis
- `PUT /api/diagnoses/{id}` - Update diagnosis
- `DELETE /api/diagnoses/{id}` - Delete diagnosis

### Physician Endpoints

- `GET /api/physicians` - Get all physicians
- `GET /api/physicians/{id}` - Get physician by ID
- `POST /api/physicians` - Create new physician
- `PUT /api/physicians/{id}` - Update physician
- `DELETE /api/physicians/{id}` - Delete physician

### Treatment Endpoints

- `GET /api/treatments` - Get all treatments
- `GET /api/treatments/{id}` - Get treatment by ID
- `POST /api/treatments` - Create new treatment
- `PUT /api/treatments/{id}` - Update treatment
- `DELETE /api/treatments/{id}` - Delete treatment

### Example API Requests

```bash
# Get all diagnoses
curl http://localhost:8080/api/diagnoses

# Create a new diagnosis
curl -X POST http://localhost:8080/api/diagnoses \
  -H "Content-Type: application/json" \
  -d '{
    "code": "J45.909",
    "description": "Unspecified asthma",
    "category": "Respiratory",
    "isActive": true
  }'

# Get all physicians
curl http://localhost:8080/api/physicians
```

## Project Structure

```
src/
├── main/
│   ├── java/com/app/hospitalbilling/
│   │   ├── config/          # Configuration classes (CORS, etc.)
│   │   ├── controller/      # REST controllers
│   │   ├── model/          # Entity models
│   │   ├── repository/     # JPA repositories
│   │   ├── service/        # Business logic services
│   │   └── HospitalBillingApplication.java
│   └── resources/
│       ├── application.properties          # Production config
│       ├── application-dev.properties      # Development config
│       └── data.sql                       # Sample data
└── test/
    └── java/com/app/hospitalbilling/
        └── BillingControllerTests.java    # Unit tests
```

## Building the Application

```bash
# Clean and build
mvn clean package

# Build without tests
mvn clean package -DskipTests

# Run tests only
mvn test

# Generate code coverage report
mvn clean test
# Report available at: target/site/jacoco/index.html
```

## Testing

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=BillingControllerTests

# Run tests with coverage
mvn clean test jacoco:report
```

## H2 Database Console (Development)

When running with the `dev` profile:

1. Navigate to: `http://localhost:8080/h2-console`
2. Use these settings:
   - JDBC URL: `jdbc:h2:mem:hospital_billing`
   - Username: `sa`
   - Password: (leave empty)

## Sample Data

The development profile automatically loads sample data including:
- 5 diagnosis records (ICD-10 codes)
- 5 physician records
- 12 treatment records

## Docker Configuration

### Dockerfile

The project includes a multi-stage Dockerfile:
- **Stage 1**: Maven build stage
- **Stage 2**: Runtime stage with JRE Alpine

### Environment Variables

- `SPRING_PROFILES_ACTIVE`: Active profile (dev/prod)
- `JAVA_OPTS`: Additional JVM options

### Docker Compose (Optional)

Create a `docker-compose.yml` for full stack deployment:

```yaml
version: '3.8'
services:
  backend:
    build: .
    ports:
      - "8080:8080"
    environment:
      SPRING_PROFILES_ACTIVE: dev
```

## Build Script Options

The `build-run.sh` script supports:

| Option | Description |
|--------|-------------|
| `--skip-clean` | Skip Maven clean phase |
| `--skip-tests` | Skip running tests |
| `--skip-build` | Skip build, only run application |
| `--docker` | Build and run using Docker |
| `--prod` | Use production profile |
| `--port PORT` | Run on custom port (default: 8080) |
| `-h, --help` | Display help message |

## Cleaning Build Artifacts

```bash
# Using Maven
mvn clean

# Remove all compiled files
rm -rf target/
```

## Troubleshooting

### Port Already in Use

If port 8080 is already in use:
```bash
# Use custom port
./build-run.sh --port 9090
```

### Database Connection Issues

For MySQL connection issues:
1. Ensure MySQL is running
2. Verify credentials in `application.properties`
3. Check database exists: `CREATE DATABASE hospital_billing;`

### H2 Console Not Accessible

Ensure you're using the dev profile:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add/update tests
5. Submit a pull request
