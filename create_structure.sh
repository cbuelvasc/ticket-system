#!/bin/bash

# Script to create project structure for ticketsystem
# This follows the hexagonal architecture with DDD principles

# Create main directory structure
mkdir -p src/main/java/com/xeppelin/ticketsystem/domain/{model,service,exception}
mkdir -p src/main/java/com/xeppelin/ticketsystem/application/{port,service}
mkdir -p src/main/java/com/xeppelin/ticketsystem/application/port/{input,output}
mkdir -p src/main/java/com/xeppelin/ticketsystem/infrastructure/config
mkdir -p src/main/java/com/xeppelin/ticketsystem/infrastructure/adapter/input/{rest,messaging}
mkdir -p src/main/java/com/xeppelin/ticketsystem/infrastructure/adapter/input/rest/{request,response,impl,exception,mapper}
mkdir -p src/main/java/com/xeppelin/ticketsystem/infrastructure/adapter/output/{persistence,client,messaging}
mkdir -p src/main/java/com/xeppelin/ticketsystem/infrastructure/adapter/output/persistence/{adapter,entity,mapper,repository}

# Create basic configuration files
cat > src/main/resources/application.yml << EOF
server:
  port: 8080

spring:
  application:
    name: ticketsystem
  datasource:
    url: jdbc:postgresql://localhost:5432/user_db
    username: user
    password: password
  jpa:
    hibernate:
      ddl-auto: validate
    show-sql: true
  flyway:
    enabled: true
    locations: classpath:db/migration

logging:
  level:
    com.xeppelin.bookingservice: INFO
EOF

cat > src/main/resources/application-custom.yaml << EOF
# Custom environment specific configuration
# Override properties as needed
EOF

echo "Project structure created successfully!"
echo "Run 'chmod +x create_structure.sh && ./create_structure.sh' to execute the script." 