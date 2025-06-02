# Xeppelin Ticket System

A comprehensive ticket reservation and management system built with **Spring Boot 3.4.6** and **Java 21**, following **Hexagonal Architecture** principles and implementing modern cloud-native patterns.

## 🎯 Project Overview

The Xeppelin Ticket System is a robust, enterprise-grade platform designed for managing events and ticket reservations. It provides a complete solution for event organizers to create, manage, and monitor their events while offering attendees a seamless ticket purchasing experience.

### Key Features

- **Event Management**: Complete CRUD operations for events with lifecycle management
- **Ticket Reservation System**: Advanced reservation mechanism with session-based cart management
- **Real-time Availability**: Redis-powered caching for instant ticket availability updates
- **QR Code Generation**: Secure ticket validation with QR codes
- **User Management**: Role-based access control for organizers and attendees
- **REST API**: Comprehensive RESTful API with OpenAPI 3.0 documentation
- **Observability**: Full observability stack with metrics, tracing, and logging
- **Cloud-Ready**: Containerized with optimized buildpacks for production deployment

## 🏗️ Architecture

### Hexagonal Architecture (Ports & Adapters)

The system follows clean architecture principles with clear separation of concerns:

```
src/main/java/com/xeppelin/ticketsystem/
├── application/           # Application Layer
│   ├── port/
│   │   ├── input/        # Use Case Interfaces
│   │   └── output/       # Repository Interfaces
│   └── service/          # Use Case Implementations
├── domain/               # Domain Layer
│   ├── model/           # Domain Entities
│   ├── service/         # Domain Services
│   └── exception/       # Domain Exceptions
└── infrastructure/      # Infrastructure Layer
    ├── adapter/
    │   ├── input/       # REST Controllers, Messaging
    │   └── output/      # Database, External APIs
    └── config/          # Configuration Classes
```

### Technology Stack

#### Core Framework
- **Spring Boot 3.4.6** - Main framework
- **Java 21** - Programming language with modern features
- **Spring Data JPA** - Data persistence layer
- **Spring Validation** - Request validation
- **Flyway** - Database migrations

#### Database & Caching
- **PostgreSQL** - Primary database
- **Redis** - Caching and session management
- **HikariCP** - Connection pooling

#### Documentation & API
- **SpringDoc OpenAPI 3.0** - API documentation
- **MapStruct** - Object mapping
- **Lombok** - Code generation

#### Observability
- **Micrometer** - Metrics collection
- **OpenTelemetry** - Distributed tracing
- **Prometheus** - Metrics storage
- **Grafana** - Observability dashboard

#### Testing
- **JUnit 5** - Unit testing
- **Spring Boot Test** - Integration testing
- **Testcontainers** - Database testing

#### Build & Deployment
- **Gradle** - Build tool
- **Buildpacks** - Container image creation
- **Docker Compose** - Local development environment

## 🚀 Quick Start

### Prerequisites

- **Java 21** or higher
- **Docker & Docker Compose**
- **Gradle 8.14** (included via wrapper)

### Local Development Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd ticket-system
   ```

2. **Start infrastructure services**
   ```bash
   # Start PostgreSQL and Redis
   docker-compose up -d postgres redis
   ```

3. **Run the application**
   ```bash
   ./gradlew bootRun
   ```

4. **Access the application**
   - **API Base URL**: http://localhost:9001/api/ticket-system
   - **API Documentation**: http://localhost:9001/api/ticket-system/swagger-ui.html
   - **Health Check**: http://localhost:9001/api/ticket-system/admin/health

### Full Stack Deployment

```bash
# Build optimized container image
./build-buildpack.sh

# Start complete stack
docker-compose up -d

# View logs
docker-compose logs -f ticket-system
```

## 📊 Database Schema

The system uses a comprehensive database schema with the following main entities:

- **USERS** - System users (organizers and attendees)
- **EVENTS** - Event information and lifecycle management
- **TICKET_TYPES** - Different ticket categories for events
- **TICKET_RESERVATIONS** - Temporary reservations during purchase
- **TICKETS** - Purchased tickets
- **QR_CODES** - Ticket validation codes
- **TICKET_VALIDATIONS** - Ticket validation history

For detailed ER diagram, see [ER_Diagram_TicketSystem.md](ER_Diagram_TicketSystem.md)

## 🔌 API Documentation

### API Endpoints Overview

#### Organizer Operations
- `POST /api/v1/organizers/{organizerId}/events` - Create event
- `GET /api/v1/organizers/{organizerId}/events` - List organizer events
- `GET /api/v1/organizers/{organizerId}/events/{eventId}` - Get specific event
- `PUT /api/v1/organizers/{organizerId}/events/{eventId}` - Update event
- `DELETE /api/v1/organizers/{organizerId}/events/{eventId}` - Delete event

#### Public Operations
- `GET /api/v1/events` - List published events
- `GET /api/v1/events/search` - Search events
- `GET /api/v1/events/{eventId}` - Get event details

### Request/Response Examples

#### Create Event
```bash
curl -X POST "http://localhost:9001/api/ticket-system/api/v1/organizers/{organizerId}/events" \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Spring Conference 2024",
    "start": "2024-12-15T20:00:00+01:00[Europe/Madrid]",
    "end": "2024-12-15T23:00:00+01:00[Europe/Madrid]",
    "venue": "Madrid Convention Center",
    "salesStart": "2024-11-01T10:00:00+01:00[Europe/Madrid]",
    "salesEnd": "2024-12-15T19:00:00+01:00[Europe/Madrid]"
  }'
```

For complete API documentation, see [EVENT_API_DOCUMENTATION.md](EVENT_API_DOCUMENTATION.md)

## 🔧 Configuration

### Application Properties

The application can be configured through environment variables:

#### Database Configuration
```yaml
DB_HOST=localhost
DB_PORT=5432
DB_NAME=ticket_db
DB_USER=user
DB_PASSWORD=password
```

#### Redis Configuration
```yaml
REDIS_HOST=localhost
REDIS_PORT=6379
REDIS_PASSWORD=
```

#### Observability Configuration
```yaml
OTEL_EXPORTER_OTLP_ENDPOINT=http://otel-collector:4318
ENVIRONMENT=development
LOG_LEVEL=INFO
```

### Business Logic Configuration

#### Ticket Reservation Settings
```yaml
app:
  ticket:
    reservation:
      max-reservations-per-session: 5
      max-quantity-per-reservation: 10
      default-reservation-duration: PT15M  # 15 minutes
      expiration-grace-period: PT1M       # 1 minute
```

## 🏃‍♂️ Development

### Code Style & Conventions

- **Java 21** features with modern syntax
- **Spring Boot 3.x** best practices
- **Constructor injection** over field injection
- **Record classes** for DTOs
- **Lombok** annotations for boilerplate reduction
- **MapStruct** for object mapping

### Project Structure Guidelines

#### Application Layer
- **Use Cases** define business operations interfaces
- **Services** implement business logic
- **Ports** define infrastructure contracts

#### Domain Layer
- **Models** contain core business entities
- **Domain Services** handle complex business rules
- **Exceptions** define domain-specific errors

#### Infrastructure Layer
- **REST Controllers** handle HTTP concerns only
- **Repositories** implement data persistence
- **Mappers** convert between layers

### Testing Strategy

#### Unit Tests
```bash
./gradlew test
```

#### Integration Tests
```bash
./gradlew integrationTest
```

#### Test with Testcontainers
```bash
./gradlew testWithContainers
```

### Build & Deployment

#### Fast Development Build
```bash
./build-buildpack.sh --dev  # 15-30 seconds
```

#### Complete Build
```bash
./build-buildpack.sh        # 1-3 minutes
```

#### Clean Build
```bash
./build-buildpack.sh --clean  # 2-3 minutes
```

For optimization details, see [DOCKER_BUILD_OPTIMIZATION.md](DOCKER_BUILD_OPTIMIZATION.md)

## 📈 Monitoring & Observability

### Health Checks
- **Application Health**: `/admin/health`
- **Database Health**: `/admin/health/db`
- **Redis Health**: `/admin/health/redis`

### Metrics
- **Application Metrics**: `/admin/metrics`
- **Prometheus Endpoint**: `/admin/prometheus`
- **Custom Business Metrics**: Event creation, ticket sales, etc.

### Tracing
- **OpenTelemetry** integration
- **Distributed tracing** across services
- **Performance monitoring**

### Logging
- **Structured logging** with JSON format
- **Correlation IDs** for request tracing
- **Log aggregation** with ELK stack

## 🛠️ Tools & Utilities

### Postman Collection
Complete API testing collection available:
- **File**: `Ticket_System_Postman_Collection.json`
- **Documentation**: [POSTMAN_COLLECTION_README.md](POSTMAN_COLLECTION_README.md)

### Database Migrations
```bash
# Check migration status
./gradlew flywayInfo

# Apply migrations
./gradlew flywayMigrate

# Validate migrations
./gradlew flywayValidate
```

### Development Scripts
- `create_structure.sh` - Generate project structure
- `build-buildpack.sh` - Optimized container builds
- `build-fast.sh` - Quick development builds

## 🤝 Contributing

### Development Workflow

1. **Create feature branch**
   ```bash
   git checkout -b feature/your-feature-name
   ```

2. **Implement changes**
   - Follow code style guidelines
   - Add unit tests
   - Update documentation

3. **Run tests**
   ```bash
   ./gradlew test integrationTest
   ```

4. **Build and test locally**
   ```bash
   ./build-buildpack.sh --dev
   docker-compose up -d
   ```

5. **Create pull request**

### Code Quality Standards

- **Test Coverage**: Minimum 80%
- **Code Style**: Enforced by Checkstyle
- **Documentation**: JavaDoc for public APIs
- **Performance**: No degradation in critical paths

## 📄 License

[Add your license information here]

## 👥 Team

**Xeppelin Development Team**

For support and questions, please contact the development team or create an issue in the repository.

---

**Version**: 0.0.1-SNAPSHOT  
**Last Updated**: December 2024  
**Spring Boot Version**: 3.4.6  
**Java Version**: 21
