# Xeppelin Ticket System - Postman Collection

Esta colección de Postman proporciona una suite completa de pruebas para la API del Sistema de Tickets de Xeppelin.

## 📋 Contenido de la Colección

La colección incluye los siguientes grupos de endpoints:

### 🎫 Event Management (Gestión de Eventos)
- **Operaciones de Organizador**: CRUD completo para eventos (crear, listar, obtener, actualizar, eliminar)
- **Operaciones Públicas**: Acceso público a eventos publicados (listar, buscar, obtener detalles)

### 🎟️ Ticket Reservations (Reservas de Tickets)
- Crear reservas temporales de tickets
- Gestionar reservas activas por sesión
- Extender, confirmar o cancelar reservas
- **Nota**: Estos endpoints estarán disponibles cuando se implemente el controlador de reservas

### 💚 Health & Monitoring (Salud y Monitoreo)
- Verificación de salud de la aplicación
- Información de la aplicación
- Métricas y rendimiento

### 📚 OpenAPI Documentation (Documentación OpenAPI)
- Acceso a Swagger UI
- Especificación OpenAPI en formato JSON

## 🚀 Configuración Inicial

### 1. Importar la Colección

1. Abre Postman
2. Haz clic en "Import" en la esquina superior izquierda
3. Selecciona el archivo `Ticket_System_Postman_Collection.json`
4. La colección se importará con todas las variables predefinidas

### 2. Variables de Entorno

La colección viene preconfigurada con las siguientes variables:

| Variable | Valor por Defecto | Descripción |
|----------|-------------------|-------------|
| `baseUrl` | `http://localhost:9001` | URL base del servicio |
| `organizerId` | `123e4567-e89b-12d3-a456-426614174000` | ID de organizador de ejemplo |
| `eventId` | `123e4567-e89b-12d3-a456-426614174001` | ID de evento de ejemplo |
| `sessionId` | `session_{{$randomUUID}}` | ID de sesión único |
| `ticketTypeId` | `123e4567-e89b-12d3-a456-426614174002` | ID de tipo de ticket de ejemplo |
| `reservationId` | `123e4567-e89b-12d3-a456-426614174003` | ID de reserva de ejemplo |

### 3. Configuración del Entorno

Puedes crear diferentes entornos para diferentes contextos:

#### Entorno Local (Development)
```json
{
  "baseUrl": "http://localhost:9001",
  "authToken": "tu_token_de_desarrollo"
}
```

#### Entorno de Staging
```json
{
  "baseUrl": "https://api-staging.xeppelin.com",
  "authToken": "tu_token_de_staging"
}
```

#### Entorno de Producción
```json
{
  "baseUrl": "https://api.xeppelin.com",
  "authToken": "tu_token_de_produccion"
}
```

## 🔐 Autenticación

La colección está configurada para usar Bearer Token authentication. Para usar autenticación:

1. Ve a la configuración de la colección
2. En la pestaña "Authorization", selecciona "Bearer Token"
3. Configura la variable `authToken` en tu entorno
4. Todas las requests heredarán automáticamente esta configuración

## 🎯 Escenarios de Prueba

### Escenario 1: Flujo Completo de Gestión de Eventos

1. **Verificar Salud del Sistema**
   ```
   GET /admin/health
   ```

2. **Crear un Nuevo Evento**
   ```
   POST /events/organizers/{organizerId}
   ```
   - El test automáticamente capturará el ID del evento creado

3. **Listar Eventos del Organizador**
   ```
   GET /events/organizers/{organizerId}
   ```

4. **Obtener Detalles del Evento**
   ```
   GET /events/{eventId}/organizers/{organizerId}
   ```

5. **Actualizar el Evento**
   ```
   PUT /events/{eventId}/organizers/{organizerId}
   ```

6. **Publicar el Evento** (a través de actualización de status)
   ```
   PUT /events/{eventId}/organizers/{organizerId}
   Body: {"status": "PUBLISHED"}
   ```

7. **Verificar en Listado Público**
   ```
   GET /events
   ```

### Escenario 2: Flujo de Reservas de Tickets

1. **Crear una Reserva**
   ```
   POST /reservations
   ```
   - Requiere X-Session-ID header
   - El test capturará automáticamente el ID de la reserva

2. **Verificar Mis Reservas**
   ```
   GET /reservations/session
   ```

3. **Extender la Reserva**
   ```
   PATCH /reservations/{reservationId}/extend
   ```

4. **Confirmar la Reserva**
   ```
   POST /reservations/{reservationId}/confirm
   ```

### Escenario 3: Búsqueda y Consulta Pública

1. **Listar Eventos Públicos**
   ```
   GET /events?page=0&size=10&sort=start,asc
   ```

2. **Buscar Eventos**
   ```
   GET /events/search?query=spring conference
   ```

3. **Obtener Detalles de Evento Público**
   ```
   GET /events/{eventId}
   ```

## 🧪 Tests Automatizados

Cada request incluye tests automatizados que verifican:

### Tests Comunes
- ✅ Código de estado HTTP correcto
- ✅ Tiempo de respuesta < 2000ms
- ✅ Formato JSON válido (cuando aplica)
- ✅ Extracción automática de IDs para requests subsecuentes

### Tests Específicos

#### Event Management
- ✅ Eventos creados tienen ID y status válido
- ✅ Listados incluyen información de paginación
- ✅ Eventos públicos solo muestran status PUBLISHED
- ✅ Búsquedas devuelven resultados relevantes

#### Reservations
- ✅ Reservas tienen status ACTIVE al crearse
- ✅ Tiempo de expiración es futuro
- ✅ Reservas confirmadas cambian a status CONFIRMED
- ✅ Reservas canceladas cambian a status CANCELLED

#### Health & Monitoring
- ✅ Sistema reporta status UP
- ✅ Métricas devuelven datos válidos

## 📊 Scripts de Colección

### Pre-request Scripts
- Generación automática de Session ID único
- Logging de URLs de request
- Configuración dinámica de variables

### Test Scripts
- Validación de respuestas JSON
- Extracción automática de IDs
- Manejo de errores con logging detallado
- Validación de business rules

## 🔧 Personalización

### Agregar Nuevos Endpoints

1. Duplica un request existente similar
2. Modifica la URL y método HTTP
3. Actualiza el body de request si es necesario
4. Añade tests específicos en la pestaña "Tests"

### Modificar Variables

Las variables se pueden modificar en:
- **Nivel de Colección**: Afecta todos los requests
- **Nivel de Entorno**: Específico del entorno seleccionado
- **Nivel de Request**: Solo para un request específico

### Personalizar Tests

```javascript
pm.test("Mi test personalizado", function () {
    const jsonData = pm.response.json();
    pm.expect(jsonData.campo).to.equal("valor_esperado");
});
```

## 🐛 Resolución de Problemas

### Error de Conexión
```
Error: connect ECONNREFUSED 127.0.0.1:9001
```
**Solución**: Verifica que la aplicación esté ejecutándose en el puerto correcto.

### Error 404 en Endpoints de Reservas
```
404 Not Found
```
**Solución**: Los endpoints de reservas están disponibles solo cuando se implementa el controlador correspondiente.

### Error de Autenticación
```
401 Unauthorized
```
**Solución**: Configura la variable `authToken` en tu entorno con un token válido.

### Timezone Issues
```
400 Bad Request - Invalid date format
```
**Solución**: Asegúrate de usar el formato correcto con timezone:
```
"2024-12-15T20:00:00+01:00[Europe/Madrid]"
```

## 📈 Monitoreo y Métricas

La colección incluye endpoints para monitorear:

- **Estado de la aplicación**: `/admin/health`
- **Información del sistema**: `/admin/info`
- **Métricas de rendimiento**: `/admin/metrics`
- **Documentación en vivo**: `/swagger-ui.html`

## 🔄 Actualización de la Colección

Para mantener la colección actualizada:

1. **Exporta** la colección modificada desde Postman
2. **Reemplaza** el archivo JSON existente
3. **Actualiza** este README si hay cambios significativos
4. **Versiona** los cambios en el control de versiones

## 📝 Notas Importantes

- **IDs de Ejemplo**: Los UUIDs incluidos son solo para ejemplos. Reemplázalos con IDs reales de tu entorno.
- **Zona Horaria**: El sistema utiliza ZonedDateTime con timezone específico (Europe/Madrid en los ejemplos).
- **Paginación**: Todos los endpoints de listado soportan paginación estándar de Spring Boot.
- **Session Management**: Las reservas requieren gestión de sesión mediante header X-Session-ID.

## 🤝 Contribución

Para contribuir mejoras a esta colección:

1. Fork el repositorio
2. Crea una rama para tu feature
3. Modifica la colección según sea necesario
4. Actualiza la documentación
5. Crea un Pull Request

## 📞 Soporte

Para soporte técnico o consultas sobre la API:

- **Equipo**: Xeppelin Platform Team
- **Email**: platform@xeppelin.com
- **Documentación**: http://localhost:9001/api/ticket-system/swagger-ui.html 