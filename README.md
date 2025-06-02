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
│   │   ├── input/        # Use Case Interfaces (Primary Ports)
│   │   └── output/       # Repository Interfaces (Secondary Ports)
│   └── service/          # Application Services (Use Case Implementations)
├── domain/               # Domain Layer (Core Business Logic)
│   ├── model/           # Domain Entities & Value Objects
│   ├── service/         # Domain Services
│   │   └── impl/
│   └── exception/       # Domain Exceptions
└── infrastructure/      # Infrastructure Layer
    ├── adapter/
    │   ├── input/       # Primary Adapters
    │   │   ├── rest/    # REST Controllers
    │   │   │   ├── impl/
    │   │   │   ├── mapper/
    │   │   │   ├── request/
    │   │   │   ├── response/
    │   │   │   ├── validation/
    │   │   │   └── exception/
    │   │   └── messaging/ # Event Subscribers
    │   └── output/      # Secondary Adapters
    │       ├── persistence/ # Database Adapters
    │       │   ├── adapter/
    │       │   ├── entity/
    │       │   ├── mapper/
    │       │   └── repository/
    │       ├── client/  # External API Clients
    │       └── messaging/ # Event Publishers
    └── config/          # Configuration Classes
```

### Architecture Principles

#### 1. **Domain-Driven Design (DDD)**
- **Entities**: Core business objects with identity
- **Value Objects**: Immutable objects without identity
- **Aggregates**: Consistency boundaries around related entities
- **Domain Services**: Business logic that doesn't belong to a specific entity
- **Repositories**: Data access abstraction

#### 2. **Dependency Inversion**
- High-level modules don't depend on low-level modules
- Both depend on abstractions (interfaces/ports)
- Infrastructure depends on domain, not vice versa

#### 3. **Interface Segregation**
- Specific interfaces for each use case
- Clients depend only on interfaces they use
- Small, focused ports instead of large interfaces

#### 4. **Single Responsibility**
- Each layer has one reason to change
- Each class has one responsibility
- Clear separation of concerns

### Technology Stack

#### Core Framework
- **Spring Boot 3.4.6** - Main framework with auto-configuration
- **Java 21** - Programming language with modern features
- **Spring Data JPA 3.2.x** - Data persistence layer
- **Spring Validation** - Request validation
- **Flyway 10.x** - Database migrations

#### Database & Caching
- **PostgreSQL 16** - Primary database
- **Redis 7.x** - Caching and session management
- **HikariCP 5.x** - High-performance connection pooling

#### Documentation & API
- **SpringDoc OpenAPI 3.0** - API documentation
- **MapStruct 1.5.x** - Object mapping
- **Lombok 1.18.x** - Code generation

#### Observability & Monitoring
- **Micrometer 1.12.x** - Metrics collection
- **OpenTelemetry 1.32.x** - Distributed tracing
- **Prometheus** - Metrics storage and alerting
- **Grafana** - Observability dashboard
- **Loki** - Log aggregation

#### Testing Framework
- **JUnit 5** - Unit testing framework
- **Spring Boot Test** - Integration testing
- **Testcontainers** - Integration testing with real databases
- **Mockito 5.x** - Mocking framework
- **AssertJ** - Fluent assertions

#### Build & Deployment
- **Gradle 8.14** - Build automation tool
- **Buildpacks** - Container image creation
- **Docker & Docker Compose** - Containerization
- **GitHub Actions** - CI/CD pipeline

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
- `POST /events/organizers/{organizerId}` - Create event
- `GET /events/organizers/{organizerId}` - List organizer events
- `GET /events/{eventId}/organizers/{organizerId}` - Get specific event
- `PUT /events/{eventId}/organizers/{organizerId}` - Update event
- `DELETE /events/{eventId}/organizers/{organizerId}` - Delete event

#### Public Operations
- `GET /events` - List published events
- `GET /events/search` - Search events
- `GET /events/{eventId}` - Get event details

### Request/Response Examples

#### Create Event
```bash
curl -X POST "http://localhost:9001/api/ticket-system/events/organizers/{organizerId}" \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Spring Conference 2024",
    "start": "2024-12-15T20:00:00+01:00[Europe/Madrid]",
    "end": "2024-12-15T23:00:00+01:00[Europe/Madrid]",
    "venue": "Madrid Convention Center",
    "salesStart": "2024-11-01T10:00:00+01:00[Europe/Madrid]",
    "salesEnd": "2024-12-15T19:00:00+01:00[Europe/Madrid]",
    "staffIds": [
      "a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11",
      "b1ffcd99-9c0b-4ef8-bb6d-6bb9bd380a22"
    ],
    "ticketTypes": [
      {
        "name": "General Admission",
        "description": "Standard access to the conference",
        "price": 150.00,
        "totalAvailable": 500
      },
      {
        "name": "VIP",
        "description": "VIP access with premium seating and catering",
        "price": 299.00,
        "totalAvailable": 50
      }
    ]
  }'
```

**Response (HTTP 201):**
```json
{
  "id": "123e4567-e89b-12d3-a456-426614174001",
  "name": "Spring Conference 2024",
  "start": "2024-12-15T20:00:00+01:00[Europe/Madrid]",
  "end": "2024-12-15T23:00:00+01:00[Europe/Madrid]",
  "venue": "Madrid Convention Center",
  "salesStart": "2024-11-01T10:00:00+01:00[Europe/Madrid]",
  "salesEnd": "2024-12-15T19:00:00+01:00[Europe/Madrid]",
  "status": "DRAFT",
  "organizer": {
    "id": "123e4567-e89b-12d3-a456-426614174000",
    "name": "John Doe",
    "email": "john.doe@example.com"
  },
  "attendees": [],
  "staff": [
    {
      "id": "a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11",
      "name": "Alice Smith",
      "email": "alice.smith@example.com"
    },
    {
      "id": "b1ffcd99-9c0b-4ef8-bb6d-6bb9bd380a22",
      "name": "Bob Johnson",
      "email": "bob.johnson@example.com"
    }
  ],
  "ticketTypes": [
    {
      "id": "c2eeffaa-9c0b-4ef8-bb6d-6bb9bd380a33",
      "name": "General Admission",
      "description": "Standard access to the conference",
      "price": 150.00,
      "totalAvailable": 500
    },
    {
      "id": "d3ffggbb-9c0b-4ef8-bb6d-6bb9bd380a44",
      "name": "VIP",
      "description": "VIP access with premium seating and catering",
      "price": 299.00,
      "totalAvailable": 50
    }
  ]
}
```

For complete API documentation, see [EVENT_API_DOCUMENTATION.md](EVENT_API_DOCUMENTATION.md)

## 📝 Configuration

### Environment Variables Reference

The application can be configured through environment variables for different deployment scenarios:

#### Database Configuration
```yaml
# PostgreSQL Database
DB_HOST=localhost                    # Database host
DB_PORT=5432                        # Database port
DB_NAME=ticket_db                   # Database name
DB_USER=user                        # Database username
DB_PASSWORD=password                # Database password
```

#### Redis Configuration
```yaml
# Redis Cache & Session Store
REDIS_HOST=localhost                # Redis host
REDIS_PORT=6379                     # Redis port
REDIS_PASSWORD=                     # Redis password (optional)
```

#### Observability Configuration
```yaml
# OpenTelemetry & Monitoring
OTEL_EXPORTER_OTLP_ENDPOINT=http://otel-collector:4318
ENVIRONMENT=development             # Environment name for metrics
LOG_LEVEL=INFO                      # Application log level
```

### Application Properties (application.yml)

The current configuration includes:

- **Server Configuration**: Port 9001, context path `/api/ticket-system`
- **Database**: PostgreSQL with HikariCP connection pooling
- **Cache**: Redis for caching and session management
- **Monitoring**: Actuator endpoints, Prometheus metrics, OpenTelemetry tracing
- **API Documentation**: SpringDoc OpenAPI with Swagger UI
- **Business Configuration**: Ticket reservation settings

Key configuration sections:
- Server and Tomcat settings
- Spring Data JPA and Hibernate configuration
- Redis caching configuration
- Management endpoints and health checks
- OpenTelemetry tracing and metrics
- SpringDoc API documentation

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

## 📈 Monitoring & Observability

### Health Checks
- **Application Health**: `/admin/health`