-- =====================================================
-- Initial Schema for Ticket System
-- =====================================================

-- =====================================================
-- 1. USERS TABLE
-- =====================================================
CREATE TABLE users (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    created_by VARCHAR(255),
    created_date TIMESTAMP WITH TIME ZONE,
    last_modified_by VARCHAR(255),
    last_modified_date TIMESTAMP WITH TIME ZONE,
    version INTEGER DEFAULT 0 NOT NULL,
    
    -- Constraints
    CONSTRAINT chk_users_email_format 
        CHECK (email ~* '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$')
);

-- Users indexes
CREATE UNIQUE INDEX idx_users_email ON users(email);
CREATE INDEX idx_users_created_date ON users(created_date);
CREATE INDEX idx_users_created_by ON users(created_by);
CREATE INDEX idx_users_name ON users(name);

-- =====================================================
-- 2. EVENTS TABLE
-- =====================================================
CREATE TABLE events (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    event_start TIMESTAMP WITH TIME ZONE,
    event_end TIMESTAMP WITH TIME ZONE,
    venue VARCHAR(500) NOT NULL,
    sales_start TIMESTAMP WITH TIME ZONE,
    sales_end TIMESTAMP WITH TIME ZONE,
    status VARCHAR(50) NOT NULL,
    organizer_id UUID,
    created_by VARCHAR(255),
    created_date TIMESTAMP WITH TIME ZONE,
    last_modified_by VARCHAR(255),
    last_modified_date TIMESTAMP WITH TIME ZONE,
    version INTEGER DEFAULT 0 NOT NULL,
    
    -- Foreign Keys
    CONSTRAINT fk_events_organizer FOREIGN KEY (organizer_id) REFERENCES users(id),
    
    -- Business Logic Constraints
    CONSTRAINT chk_events_valid_dates 
        CHECK (event_end IS NULL OR event_start IS NULL OR event_end >= event_start),
    CONSTRAINT chk_events_valid_sales_dates 
        CHECK (sales_end IS NULL OR sales_start IS NULL OR sales_end >= sales_start),
    CONSTRAINT chk_events_status_values 
        CHECK (status IN ('DRAFT', 'PUBLISHED', 'ACTIVE', 'COMPLETED', 'CANCELLED'))
);

-- Events indexes
CREATE INDEX idx_events_organizer_id ON events(organizer_id);
CREATE INDEX idx_events_status ON events(status);
CREATE INDEX idx_events_venue ON events(venue);
CREATE INDEX idx_events_dates ON events(event_start, event_end);
CREATE INDEX idx_events_sales_dates ON events(sales_start, sales_end);
CREATE INDEX idx_events_created_date ON events(created_date);
CREATE INDEX idx_events_status_dates ON events(status, event_start, event_end);
CREATE INDEX idx_events_organizer_status ON events(organizer_id, status);

-- Comments for events table timezone fields
COMMENT ON COLUMN events.event_start IS 'Event start date and time with timezone information';
COMMENT ON COLUMN events.event_end IS 'Event end date and time with timezone information';
COMMENT ON COLUMN events.sales_start IS 'Ticket sales start date and time with timezone information';
COMMENT ON COLUMN events.sales_end IS 'Ticket sales end date and time with timezone information';

-- =====================================================
-- 3. USER-EVENT RELATIONSHIP TABLES
-- =====================================================

-- Users attending events
CREATE TABLE user_attending_events (
    user_id UUID NOT NULL,
    event_id UUID NOT NULL,
    created_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    
    PRIMARY KEY (user_id, event_id),
    CONSTRAINT fk_attending_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_attending_event FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE
);

CREATE INDEX idx_attending_user_id ON user_attending_events(user_id);
CREATE INDEX idx_attending_event_id ON user_attending_events(event_id);
CREATE INDEX idx_attending_created_date ON user_attending_events(created_date);

-- Users staffing events
CREATE TABLE user_staffing_events (
    user_id UUID NOT NULL,
    event_id UUID NOT NULL,
    created_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    
    PRIMARY KEY (user_id, event_id),
    CONSTRAINT fk_staffing_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_staffing_event FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE
);

CREATE INDEX idx_staffing_user_id ON user_staffing_events(user_id);
CREATE INDEX idx_staffing_event_id ON user_staffing_events(event_id);
CREATE INDEX idx_staffing_created_date ON user_staffing_events(created_date);

-- =====================================================
-- 4. TICKET TYPES TABLE
-- =====================================================
CREATE TABLE ticket_types (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    description TEXT,
    total_available INTEGER,
    event_id UUID NOT NULL,
    created_by VARCHAR(255),
    created_date TIMESTAMP WITH TIME ZONE,
    last_modified_by VARCHAR(255),
    last_modified_date TIMESTAMP WITH TIME ZONE,
    version INTEGER DEFAULT 0 NOT NULL,
    
    -- Foreign Keys
    CONSTRAINT fk_ticket_types_event FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE,
    
    -- Business Logic Constraints
    CONSTRAINT chk_ticket_types_price_positive CHECK (price >= 0),
    CONSTRAINT chk_ticket_types_total_available_positive 
        CHECK (total_available IS NULL OR total_available >= 0)
);

-- Ticket types indexes
CREATE INDEX idx_ticket_types_event_id ON ticket_types(event_id);
CREATE INDEX idx_ticket_types_name ON ticket_types(name);
CREATE INDEX idx_ticket_types_price ON ticket_types(price);
CREATE INDEX idx_ticket_types_created_date ON ticket_types(created_date);
CREATE INDEX idx_ticket_types_event_price ON ticket_types(event_id, price);
CREATE INDEX idx_ticket_types_event_name ON ticket_types(event_id, name);

-- =====================================================
-- 5. TICKET RESERVATIONS TABLE
-- =====================================================
CREATE TABLE ticket_reservations (
    id UUID PRIMARY KEY,
    status VARCHAR(50) NOT NULL,
    reserved_at TIMESTAMP WITH TIME ZONE NOT NULL,
    expires_at TIMESTAMP WITH TIME ZONE NOT NULL,
    confirmed_at TIMESTAMP WITH TIME ZONE,
    released_at TIMESTAMP WITH TIME ZONE,
    session_id VARCHAR(255) NOT NULL,
    quantity INTEGER NOT NULL,
    ticket_type_id UUID NOT NULL,
    user_id UUID,
    event_id UUID NOT NULL,
    created_by VARCHAR(255),
    created_date TIMESTAMP WITH TIME ZONE,
    last_modified_by VARCHAR(255),
    last_modified_date TIMESTAMP WITH TIME ZONE,
    version INTEGER DEFAULT 0 NOT NULL,
    
    -- Foreign Keys
    CONSTRAINT fk_reservations_ticket_type FOREIGN KEY (ticket_type_id) REFERENCES ticket_types(id) ON DELETE CASCADE,
    CONSTRAINT fk_reservations_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL,
    CONSTRAINT fk_reservations_event FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE,
    
    -- Business Logic Constraints
    CONSTRAINT chk_reservations_status_values 
        CHECK (status IN ('ACTIVE', 'CONFIRMED', 'EXPIRED', 'CANCELLED', 'RELEASED')),
    CONSTRAINT chk_reservations_quantity_positive 
        CHECK (quantity > 0),
    CONSTRAINT chk_reservations_expires_after_reserved 
        CHECK (expires_at > reserved_at),
    CONSTRAINT chk_reservations_confirmed_logic 
        CHECK ((status = 'CONFIRMED' AND confirmed_at IS NOT NULL) OR 
               (status != 'CONFIRMED' AND confirmed_at IS NULL)),
    CONSTRAINT chk_reservations_released_logic 
        CHECK ((status IN ('EXPIRED', 'CANCELLED', 'RELEASED') AND released_at IS NOT NULL) OR 
               (status NOT IN ('EXPIRED', 'CANCELLED', 'RELEASED') AND released_at IS NULL))
);

-- Indexes for performance and business queries
CREATE INDEX idx_reservations_status ON ticket_reservations(status);
CREATE INDEX idx_reservations_expires_at ON ticket_reservations(expires_at);
CREATE INDEX idx_reservations_session_id ON ticket_reservations(session_id);
CREATE INDEX idx_reservations_ticket_type_id ON ticket_reservations(ticket_type_id);
CREATE INDEX idx_reservations_user_id ON ticket_reservations(user_id);
CREATE INDEX idx_reservations_event_id ON ticket_reservations(event_id);
CREATE INDEX idx_reservations_created_date ON ticket_reservations(created_date);

-- Composite indexes for complex queries
CREATE INDEX idx_reservations_status_expires ON ticket_reservations(status, expires_at);
CREATE INDEX idx_reservations_active_expires ON ticket_reservations(status, expires_at) 
    WHERE status = 'ACTIVE';
CREATE INDEX idx_reservations_ticket_type_status ON ticket_reservations(ticket_type_id, status);
CREATE INDEX idx_reservations_session_status ON ticket_reservations(session_id, status);

-- =====================================================
-- 6. TICKETS TABLE
-- =====================================================
CREATE TABLE tickets (
    id UUID PRIMARY KEY,
    status VARCHAR(50) NOT NULL,
    ticket_type_id UUID NOT NULL,
    purchaser_id UUID NOT NULL,
    purchase_date TIMESTAMP WITH TIME ZONE,
    valid_until TIMESTAMP WITH TIME ZONE,
    expiration_date TIMESTAMP WITH TIME ZONE,
    created_by VARCHAR(255),
    created_date TIMESTAMP WITH TIME ZONE,
    last_modified_by VARCHAR(255),
    last_modified_date TIMESTAMP WITH TIME ZONE,
    version INTEGER DEFAULT 0 NOT NULL,
    
    -- Foreign Keys
    CONSTRAINT fk_tickets_ticket_type FOREIGN KEY (ticket_type_id) REFERENCES ticket_types(id) ON DELETE RESTRICT,
    CONSTRAINT fk_tickets_purchaser FOREIGN KEY (purchaser_id) REFERENCES users(id) ON DELETE RESTRICT,
    
    -- Business Logic Constraints
    CONSTRAINT chk_tickets_status_values 
        CHECK (status IN ('RESERVED', 'PAID', 'CANCELLED', 'USED', 'EXPIRED')),
    CONSTRAINT chk_tickets_valid_dates 
        CHECK (expiration_date IS NULL OR valid_until IS NULL OR expiration_date >= valid_until),
    CONSTRAINT chk_tickets_purchase_valid 
        CHECK (valid_until IS NULL OR purchase_date IS NULL OR valid_until >= purchase_date)
);

-- Tickets indexes
CREATE INDEX idx_tickets_ticket_type_id ON tickets(ticket_type_id);
CREATE INDEX idx_tickets_purchaser_id ON tickets(purchaser_id);
CREATE INDEX idx_tickets_status ON tickets(status);
CREATE INDEX idx_tickets_created_date ON tickets(created_date);
CREATE INDEX idx_tickets_purchaser_status ON tickets(purchaser_id, status);
CREATE INDEX idx_tickets_type_status ON tickets(ticket_type_id, status);
CREATE INDEX idx_tickets_purchaser_created ON tickets(purchaser_id, created_date);
CREATE INDEX idx_tickets_type_status_created ON tickets(ticket_type_id, status, created_date);
-- Temporal indexes for business logic
CREATE INDEX idx_tickets_purchase_date ON tickets(purchase_date);
CREATE INDEX idx_tickets_valid_until ON tickets(valid_until);
CREATE INDEX idx_tickets_expiration_date ON tickets(expiration_date);
CREATE INDEX idx_tickets_status_expiration ON tickets(status, expiration_date);

-- Comments for tickets temporal fields
COMMENT ON COLUMN tickets.purchase_date IS 'Date and time when the ticket was purchased';
COMMENT ON COLUMN tickets.valid_until IS 'Date and time until which the ticket is valid for entry';
COMMENT ON COLUMN tickets.expiration_date IS 'Date and time when the ticket expires and becomes unusable';

-- =====================================================
-- 7. QR CODES TABLE
-- =====================================================
CREATE TABLE qr_codes (
    id UUID PRIMARY KEY,
    status VARCHAR(50) NOT NULL,
    value VARCHAR(512) NOT NULL,
    ticket_id UUID NOT NULL,
    created_by VARCHAR(255),
    created_date TIMESTAMP WITH TIME ZONE,
    last_modified_by VARCHAR(255),
    last_modified_date TIMESTAMP WITH TIME ZONE,
    version INTEGER DEFAULT 0 NOT NULL,
    
    -- Foreign Keys
    CONSTRAINT fk_qr_codes_ticket FOREIGN KEY (ticket_id) REFERENCES tickets(id) ON DELETE CASCADE,
    
    -- Business Logic Constraints
    CONSTRAINT chk_qr_codes_status_values 
        CHECK (status IN ('ACTIVE', 'USED', 'EXPIRED', 'REVOKED')),
    CONSTRAINT chk_qr_codes_value_not_empty 
        CHECK (LENGTH(TRIM(value)) > 0)
);

-- QR codes indexes
CREATE INDEX idx_qr_codes_ticket_id ON qr_codes(ticket_id);
CREATE INDEX idx_qr_codes_status ON qr_codes(status);
CREATE INDEX idx_qr_codes_created_date ON qr_codes(created_date);
CREATE UNIQUE INDEX idx_qr_codes_value_unique ON qr_codes(value);
CREATE INDEX idx_qr_codes_ticket_status ON qr_codes(ticket_id, status);
CREATE INDEX idx_qr_codes_status_created ON qr_codes(status, created_date);

-- =====================================================
-- 8. TICKET VALIDATIONS TABLE
-- =====================================================
CREATE TABLE ticket_validations (
    id UUID PRIMARY KEY,
    status VARCHAR(50) NOT NULL,
    validation_method VARCHAR(50) NOT NULL,
    validation_date_time TIMESTAMP WITH TIME ZONE,
    validation_location VARCHAR(255),
    ticket_id UUID NOT NULL,
    created_by VARCHAR(255),
    created_date TIMESTAMP WITH TIME ZONE,
    last_modified_by VARCHAR(255),
    last_modified_date TIMESTAMP WITH TIME ZONE,
    version INTEGER DEFAULT 0 NOT NULL,
    
    -- Foreign Keys
    CONSTRAINT fk_ticket_validations_ticket FOREIGN KEY (ticket_id) REFERENCES tickets(id) ON DELETE CASCADE,
    
    -- Business Logic Constraints
    CONSTRAINT chk_ticket_validations_status_values 
        CHECK (status IN ('SUCCESS', 'FAILED', 'PENDING', 'CANCELLED')),
    CONSTRAINT chk_ticket_validations_method_values 
        CHECK (validation_method IN ('QR_SCAN', 'MANUAL', 'NFC', 'BARCODE', 'MOBILE_APP'))
);

-- Ticket validations indexes
CREATE INDEX idx_ticket_validations_ticket_id ON ticket_validations(ticket_id);
CREATE INDEX idx_ticket_validations_status ON ticket_validations(status);
CREATE INDEX idx_ticket_validations_method ON ticket_validations(validation_method);
CREATE INDEX idx_ticket_validations_created_date ON ticket_validations(created_date);
CREATE INDEX idx_ticket_validations_ticket_status ON ticket_validations(ticket_id, status);
CREATE INDEX idx_ticket_validations_ticket_method ON ticket_validations(ticket_id, validation_method);
CREATE INDEX idx_ticket_validations_status_created ON ticket_validations(status, created_date);
CREATE INDEX idx_ticket_validations_method_created ON ticket_validations(validation_method, created_date);
CREATE INDEX idx_ticket_validations_created_by_date ON ticket_validations(created_by, created_date);
-- Temporal and location indexes for business logic
CREATE INDEX idx_ticket_validations_validation_date ON ticket_validations(validation_date_time);
CREATE INDEX idx_ticket_validations_date_status ON ticket_validations(validation_date_time, status);

-- Comments for ticket validations temporal and location fields
COMMENT ON COLUMN ticket_validations.validation_date_time IS 'Date and time when the validation occurred';
COMMENT ON COLUMN ticket_validations.validation_location IS 'Location where the validation occurred';

-- =====================================================
-- COMMENTS FOR DOCUMENTATION
-- =====================================================
COMMENT ON TABLE users IS 'Stores user information for the ticket system';
COMMENT ON TABLE events IS 'Stores event information in the ticket system';
COMMENT ON TABLE user_attending_events IS 'Many-to-many relationship between users and events they are attending';
COMMENT ON TABLE user_staffing_events IS 'Many-to-many relationship between users and events they are staffing';
COMMENT ON TABLE ticket_types IS 'Defines different types of tickets available for events';
COMMENT ON TABLE ticket_reservations IS 'Temporary reservations of tickets during purchase process';
COMMENT ON TABLE tickets IS 'Individual tickets purchased by users';
COMMENT ON TABLE qr_codes IS 'QR codes generated for tickets for validation purposes';
COMMENT ON TABLE ticket_validations IS 'Records of ticket validation attempts and results';

-- Comments for ticket_reservations temporal fields
COMMENT ON COLUMN ticket_reservations.reserved_at IS 'When the reservation was created';
COMMENT ON COLUMN ticket_reservations.expires_at IS 'When the reservation expires and tickets become available again';
COMMENT ON COLUMN ticket_reservations.confirmed_at IS 'When the reservation was confirmed (purchase completed)';
COMMENT ON COLUMN ticket_reservations.released_at IS 'When the reservation was released or expired';
COMMENT ON COLUMN ticket_reservations.session_id IS 'Session identifier for tracking user sessions';
COMMENT ON COLUMN ticket_reservations.quantity IS 'Number of tickets reserved in this reservation';
