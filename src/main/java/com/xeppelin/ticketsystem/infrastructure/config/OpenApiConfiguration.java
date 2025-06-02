package com.xeppelin.ticketsystem.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * OpenAPI 3.0 configuration for Ticket System.
 * 
 * This configuration provides comprehensive API documentation including:
 * - API metadata (title, description, version)
 * - Contact information
 * - License information  
 * - Server configuration for different environments
 */
@Configuration
public class OpenApiConfiguration {

    @Value("${server.port:8080}")
    private String serverPort;

    @Value("${spring.application.name:ticket-system}")
    private String applicationName;

    @Bean
    public OpenAPI ticketSystemOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Xeppelin Ticket System API")
                        .description("""
                                RESTful API for managing tickets in the Xeppelin platform.
                                
                                This service provides comprehensive ticket management capabilities including:
                                - Ticket lifecycle management (creation, publication, cancellation, completion)
                                - Venue and capacity management
                                - Ticket type configuration and pricing
                                - Sales period management 
                                - Ticket status tracking and business rule enforcement
                                
                                The API follows REST principles and uses JSON for data exchange.
                                All responses include appropriate HTTP status codes and error handling.
                                """)
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Xeppelin Platform Team")
                                .email("platform@xeppelin.com")
                                .url("https://xeppelin.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:" + serverPort)
                                .description("Local development server"),
                        new Server()
                                .url("https://api-dev.xeppelin.com")
                                .description("Development server"),
                        new Server()
                                .url("https://api-staging.xeppelin.com")
                                .description("Staging server"),
                        new Server()
                                .url("https://api.xeppelin.com")
                                .description("Production server")
                ));
    }
} 