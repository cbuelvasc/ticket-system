# Ticket Reservation Configuration

Este documento explica cómo configurar y utilizar las constantes de reservas de tickets en el sistema.

## Descripción General

El sistema utiliza un enfoque de configuración externa para manejar las constantes relacionadas con las reservas de tickets. Esto permite ajustar los valores sin modificar el código fuente y facilita diferentes configuraciones para distintos entornos.

## Componente Principal

### TicketReservationProperties

Clase de configuración principal que utiliza `@ConfigurationProperties` de Spring Boot para cargar valores desde archivos de propiedades.

**Ubicación:** `com.xeppelin.ticketsystem.infrastructure.config.TicketReservationProperties`

**Uso:** Esta es la única clase de configuración que debe usarse directamente en los servicios para acceder a las configuraciones de reservas.

**Propiedades disponibles:**

| Propiedad | Tipo | Valor por defecto | Descripción |
|-----------|------|-------------------|-------------|
| `maxReservationsPerSession` | Integer | 5 | Máximo número de reservas activas por sesión |
| `maxQuantityPerReservation` | Integer | 10 | Máxima cantidad de tickets por reserva |
| `maxExtensionDuration` | Duration | 1 hora | Máxima duración para extender una reserva |
| `defaultReservationDuration` | Duration | 15 minutos | Duración por defecto de nuevas reservas |
| `expirationGracePeriod` | Duration | 1 minuto | Período de gracia antes de marcar como expiradas |

## Configuración

### Archivo application.yml

```yaml
app:
  ticket:
    reservation:
      max-reservations-per-session: 5
      max-quantity-per-reservation: 10
      max-extension-duration: PT1H        # Formato ISO-8601 (1 hora)
      default-reservation-duration: PT15M  # Formato ISO-8601 (15 minutos)
      expiration-grace-period: PT1M       # Formato ISO-8601 (1 minuto)
```

### Configuración por Entorno

Para diferentes entornos, puedes sobrescribir estos valores:

**application-dev.yml:**
```yaml
app:
  ticket:
    reservation:
      max-reservations-per-session: 10
      default-reservation-duration: PT30M
```

**application-prod.yml:**
```yaml
app:
  ticket:
    reservation:
      max-reservations-per-session: 3
      max-quantity-per-reservation: 5
      default-reservation-duration: PT10M
```

## Uso en el Código

### Inyección y Uso Directo

```java
@Service
@RequiredArgsConstructor
public class TicketReservationServiceImpl {
    
    private final TicketReservationProperties reservationProperties;
    
    public void validateReservation(Integer quantity) {
        if (quantity > reservationProperties.getMaxQuantityPerReservation()) {
            throw new IllegalArgumentException(
                String.format("Quantity cannot exceed %d per reservation", 
                    reservationProperties.getMaxQuantityPerReservation()));
        }
    }
    
    public boolean hasReachedLimit(String sessionId) {
        long activeCount = repository.countActiveReservationsBySession(sessionId);
        return activeCount >= reservationProperties.getMaxReservationsPerSession();
    }
    
    public void validateExtensionDuration(Duration additionalDuration) {
        if (additionalDuration.compareTo(reservationProperties.getMaxExtensionDuration()) > 0) {
            throw new IllegalArgumentException(
                String.format("Extension duration cannot exceed %d minutes", 
                    reservationProperties.getMaxExtensionDuration().toMinutes()));
        }
    }
}
```

### Ejemplos de Validación Personalizada

```java
// Validación de cantidad
private void validateQuantity(Integer quantity) {
    if (quantity == null || quantity <= 0) {
        throw new IllegalArgumentException("Quantity must be positive");
    }
    
    if (quantity > reservationProperties.getMaxQuantityPerReservation()) {
        throw new IllegalArgumentException(
            String.format("Quantity cannot exceed %d per reservation", 
                reservationProperties.getMaxQuantityPerReservation()));
    }
}

// Validación de límite de sesión
private void validateSessionLimit(String sessionId) {
    long activeCount = ticketReservationRepository.countActiveReservationsBySession(sessionId);
    if (activeCount >= reservationProperties.getMaxReservationsPerSession()) {
        throw new IllegalArgumentException(
            String.format("Session has reached maximum reservation limit of %d", 
                reservationProperties.getMaxReservationsPerSession()));
    }
}

// Validación de duración
private void validateDuration(Duration duration) {
    if (duration == null || duration.isNegative() || duration.isZero()) {
        throw new IllegalArgumentException("Duration must be positive");
    }
}
```

## Acceso a Propiedades

```java
// Acceso directo a las configuraciones
int maxReservations = reservationProperties.getMaxReservationsPerSession();
int maxQuantity = reservationProperties.getMaxQuantityPerReservation();
Duration maxExtension = reservationProperties.getMaxExtensionDuration();
Duration defaultDuration = reservationProperties.getDefaultReservationDuration();
Duration gracePeriod = reservationProperties.getExpirationGracePeriod();

// Uso en validaciones
if (quantity > reservationProperties.getMaxQuantityPerReservation()) {
    throw new IllegalArgumentException("Quantity too high");
}

if (sessionCount >= reservationProperties.getMaxReservationsPerSession()) {
    throw new IllegalArgumentException("Session limit exceeded");
}
```

## Validación

Las propiedades incluyen validaciones automáticas usando Bean Validation:

- `@NotNull`: Campos obligatorios
- `@Min(1)`: Valores mínimos para cantidades
- `@Validated`: Validación automática al cargar propiedades

## Variables de Entorno

También puedes configurar usando variables de entorno:

```bash
export APP_TICKET_RESERVATION_MAX_RESERVATIONS_PER_SESSION=8
export APP_TICKET_RESERVATION_MAX_QUANTITY_PER_RESERVATION=15
export APP_TICKET_RESERVATION_MAX_EXTENSION_DURATION=PT2H
export APP_TICKET_RESERVATION_DEFAULT_RESERVATION_DURATION=PT30M
export APP_TICKET_RESERVATION_EXPIRATION_GRACE_PERIOD=PT2M
```

## Testing

### Configuración de Pruebas

```java
@SpringBootTest
@TestPropertySource(properties = {
    "app.ticket.reservation.max-reservations-per-session=3",
    "app.ticket.reservation.max-quantity-per-reservation=5",
    "app.ticket.reservation.max-extension-duration=PT30M",
    "app.ticket.reservation.default-reservation-duration=PT10M"
})
class TicketReservationServiceTest {
    
    @Autowired
    private TicketReservationProperties properties;
    
    @Test
    void testPropertyConfiguration() {
        assertThat(properties.getMaxReservationsPerSession()).isEqualTo(3);
        assertThat(properties.getMaxQuantityPerReservation()).isEqualTo(5);
        assertThat(properties.getMaxExtensionDuration()).isEqualTo(Duration.ofMinutes(30));
    }
    
    @Test
    void testServiceValidation() {
        // Test que el servicio use correctamente las propiedades
        int maxQuantity = properties.getMaxQuantityPerReservation();
        assertThatThrownBy(() -> service.createReservation(eventId, ticketTypeId, maxQuantity + 1, sessionId, userId, duration))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Quantity cannot exceed");
    }
}
```

### Testing con Mocks

```java
@ExtendWith(MockitoExtension.class)
class TicketReservationServiceTest {
    
    @Mock
    private TicketReservationProperties reservationProperties;
    
    @InjectMocks
    private TicketReservationServiceImpl service;
    
    @Test
    void testQuantityValidation() {
        when(reservationProperties.getMaxQuantityPerReservation()).thenReturn(5);
        
        assertThatThrownBy(() -> service.validateQuantity(10))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
```

## Migración desde Constantes Hard-Coded

**Antes:**
```java
private static final int MAX_RESERVATIONS_PER_SESSION = 5;
private static final int MAX_QUANTITY_PER_RESERVATION = 10;
private static final Duration MAX_EXTENSION_DURATION = Duration.ofHours(1);
```

**Después:**
```java
private final TicketReservationProperties reservationProperties;

// En el método:
int maxReservations = reservationProperties.getMaxReservationsPerSession();
int maxQuantity = reservationProperties.getMaxQuantityPerReservation();
Duration maxExtension = reservationProperties.getMaxExtensionDuration();
```

## Ventajas del Enfoque

1. **Simplicidad**: Acceso directo sin capas adicionales
2. **Control**: Control total sobre la lógica de validación
3. **Claridad**: Es obvio de dónde vienen los valores
4. **Configurabilidad**: Valores ajustables sin recompilar
5. **Flexibilidad**: Validaciones específicas por contexto
6. **Type Safety**: Tipos seguros en tiempo de compilación
7. **Testing**: Fácil override para pruebas

## Formato de Duraciones

Para las duraciones, utiliza el formato ISO-8601:

- `PT15M` = 15 minutos
- `PT1H` = 1 hora
- `PT30S` = 30 segundos
- `PT1H30M` = 1 hora y 30 minutos
- `PT2H15M30S` = 2 horas, 15 minutos y 30 segundos

## Mejores Prácticas

1. **Inyecta TicketReservationProperties directamente** en servicios que necesiten configuración
2. **Crea métodos de validación privados** en cada servicio para encapsular la lógica
3. **Usa nombres descriptivos** en los mensajes de error
4. **Configura valores por entorno** según las necesidades del negocio
5. **Mantén la lógica de validación cerca del contexto** donde se usa
6. **Documenta cambios** en las configuraciones
7. **Valida en pruebas** que las configuraciones se cargan correctamente
8. **Usa valores por defecto sensatos** en el código

## Ejemplo Completo

```java
@Service
@RequiredArgsConstructor
@Slf4j
public class TicketReservationServiceImpl implements TicketReservationService {
    
    private final TicketReservationProperties reservationProperties;
    private final TicketReservationRepository repository;
    
    public TicketReservation createReservation(UUID eventId, UUID ticketTypeId, 
                                             Integer quantity, String sessionId, 
                                             UUID userId, Duration reservationDuration) {
        
        // Validaciones usando las propiedades directamente
        validateQuantity(quantity);
        validateSessionLimit(sessionId);
        validateDuration(reservationDuration);
        
        // Lógica de creación...
    }
    
    private void validateQuantity(Integer quantity) {
        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        
        if (quantity > reservationProperties.getMaxQuantityPerReservation()) {
            throw new IllegalArgumentException(
                String.format("Quantity cannot exceed %d per reservation", 
                    reservationProperties.getMaxQuantityPerReservation()));
        }
    }
    
    private void validateSessionLimit(String sessionId) {
        long activeCount = repository.countActiveReservationsBySession(sessionId);
        if (activeCount >= reservationProperties.getMaxReservationsPerSession()) {
            throw new IllegalArgumentException(
                String.format("Session has reached maximum reservation limit of %d", 
                    reservationProperties.getMaxReservationsPerSession()));
        }
    }
    
    private void validateDuration(Duration duration) {
        if (duration == null || duration.isNegative() || duration.isZero()) {
            throw new IllegalArgumentException("Duration must be positive");
        }
    }
} 