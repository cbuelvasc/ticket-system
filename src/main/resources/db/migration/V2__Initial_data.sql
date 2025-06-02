-- =====================================================
-- Initial Data for Ticket System
-- =====================================================

-- =====================================================
-- 1. SAMPLE USERS
-- =====================================================
INSERT INTO users (id, name, email, created_by, created_date, version) VALUES
('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Juan Carlos Pérez', 'juan.perez@example.com', 'system', CURRENT_TIMESTAMP, 0),
('b1eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Emily Thompson', 'emily.thompson@example.com', 'system', CURRENT_TIMESTAMP, 0),
('c2eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Hiroshi Tanaka', 'hiroshi.tanaka@example.com', 'system', CURRENT_TIMESTAMP, 0),
('d3eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'Ana Sofía López', 'ana.lopez@example.com', 'system', CURRENT_TIMESTAMP, 0),
('e4eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'Roberto Martínez', 'roberto.martinez@example.com', 'system', CURRENT_TIMESTAMP, 0),
('f5eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'Sophie Dubois', 'sophie.dubois@example.com', 'system', CURRENT_TIMESTAMP, 0),
('a6eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'Mohammed Al-Rashid', 'mohammed.alrashid@example.com', 'system', CURRENT_TIMESTAMP, 0),
('b7eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'Valentina Torres', 'valentina.torres@example.com', 'system', CURRENT_TIMESTAMP, 0),
('c8eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', 'Klaus Müller', 'klaus.muller@example.com', 'system', CURRENT_TIMESTAMP, 0),
('d9eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'Priya Sharma', 'priya.sharma@example.com', 'system', CURRENT_TIMESTAMP, 0),
('11eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Alessandro Rossi', 'alessandro.rossi@example.com', 'system', CURRENT_TIMESTAMP, 0),
('12eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Maria Fernandez', 'maria.fernandez@example.com', 'system', CURRENT_TIMESTAMP, 0),
('13eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Zhang Wei', 'zhang.wei@example.com', 'system', CURRENT_TIMESTAMP, 0),
('14eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'Olav Andersen', 'olav.andersen@example.com', 'system', CURRENT_TIMESTAMP, 0),
('15eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'Fatima Al-Zahra', 'fatima.alzahra@example.com', 'system', CURRENT_TIMESTAMP, 0),
('16eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'João Silva', 'joao.silva@example.com', 'system', CURRENT_TIMESTAMP, 0),
('17eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'Anastasia Petrov', 'anastasia.petrov@example.com', 'system', CURRENT_TIMESTAMP, 0),
('18eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'Ahmed Hassan', 'ahmed.hassan@example.com', 'system', CURRENT_TIMESTAMP, 0),
('19eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', 'Yuki Nakamura', 'yuki.nakamura@example.com', 'system', CURRENT_TIMESTAMP, 0),
('20eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'Isabella Garcia', 'isabella.garcia@example.com', 'system', CURRENT_TIMESTAMP, 0),
('21eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Chen Lu', 'chen.lu@example.com', 'system', CURRENT_TIMESTAMP, 0),
('22eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Liam OConnor', 'liam.oconnor@example.com', 'system', CURRENT_TIMESTAMP, 0),
('23eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Ingrid Larsson', 'ingrid.larsson@example.com', 'system', CURRENT_TIMESTAMP, 0),
('24eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'Carlos Mendoza', 'carlos.mendoza@example.com', 'system', CURRENT_TIMESTAMP, 0),
('25eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'Sarah Williams', 'sarah.williams@example.com', 'system', CURRENT_TIMESTAMP, 0),
('26eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'Francesco Romano', 'francesco.romano@example.com', 'system', CURRENT_TIMESTAMP, 0),
('27eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'Natasha Ivanova', 'natasha.ivanova@example.com', 'system', CURRENT_TIMESTAMP, 0),
('28eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'Diego Ramirez', 'diego.ramirez@example.com', 'system', CURRENT_TIMESTAMP, 0),
('29eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', 'Emma Johnson', 'emma.johnson@example.com', 'system', CURRENT_TIMESTAMP, 0),
('30eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'Raj Patel', 'raj.patel@example.com', 'system', CURRENT_TIMESTAMP, 0),
('31eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Amélie Moreau', 'amelie.moreau@example.com', 'system', CURRENT_TIMESTAMP, 0),
('32eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Hassan Al-Mahmoud', 'hassan.almahmoud@example.com', 'system', CURRENT_TIMESTAMP, 0),
('33eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Lucia Martinez', 'lucia.martinez@example.com', 'system', CURRENT_TIMESTAMP, 0),
('34eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'Thomas Anderson', 'thomas.anderson@example.com', 'system', CURRENT_TIMESTAMP, 0),
('35eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'Sakura Yamamoto', 'sakura.yamamoto@example.com', 'system', CURRENT_TIMESTAMP, 0),
('36eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'Pavel Novak', 'pavel.novak@example.com', 'system', CURRENT_TIMESTAMP, 0),
('37eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'Camila Santos', 'camila.santos@example.com', 'system', CURRENT_TIMESTAMP, 0),
('38eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'Viktor Petersen', 'viktor.petersen@example.com', 'system', CURRENT_TIMESTAMP, 0),
('39eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', 'Zahra Bahati', 'zahra.bahati@example.com', 'system', CURRENT_TIMESTAMP, 0),
('40eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'Marco Bianchi', 'marco.bianchi@example.com', 'system', CURRENT_TIMESTAMP, 0),
('41eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Aisha Okafor', 'aisha.okafor@example.com', 'system', CURRENT_TIMESTAMP, 0),
('42eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Jin-Woo Park', 'jinwoo.park@example.com', 'system', CURRENT_TIMESTAMP, 0),
('43eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Rachel Green', 'rachel.green@example.com', 'system', CURRENT_TIMESTAMP, 0),
('44eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'André Leblanc', 'andre.leblanc@example.com', 'system', CURRENT_TIMESTAMP, 0),
('45eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'Catalina Vega', 'catalina.vega@example.com', 'system', CURRENT_TIMESTAMP, 0),
('46eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'Daniel Kim', 'daniel.kim@example.com', 'system', CURRENT_TIMESTAMP, 0),
('47eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'Meryem Özkan', 'meryem.ozkan@example.com', 'system', CURRENT_TIMESTAMP, 0),
('48eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'Gabriel Kowalski', 'gabriel.kowalski@example.com', 'system', CURRENT_TIMESTAMP, 0),
('49eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', 'Leila Mohammadi', 'leila.mohammadi@example.com', 'system', CURRENT_TIMESTAMP, 0),
('50eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'James Wilson', 'james.wilson@example.com', 'system', CURRENT_TIMESTAMP, 0),
('51eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Noor Al-Mansouri', 'noor.almansouri@example.com', 'system', CURRENT_TIMESTAMP, 0),
('52eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Erik Johansson', 'erik.johansson@example.com', 'system', CURRENT_TIMESTAMP, 0),
('53eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Luna Rodriguez', 'luna.rodriguez@example.com', 'system', CURRENT_TIMESTAMP, 0),
('54eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'Kai Chen', 'kai.chen@example.com', 'system', CURRENT_TIMESTAMP, 0),
('55eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'Olivia Brown', 'olivia.brown@example.com', 'system', CURRENT_TIMESTAMP, 0),
('56eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'Abdul Rahman', 'abdul.rahman@example.com', 'system', CURRENT_TIMESTAMP, 0),
('57eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'Charlotte Dubois', 'charlotte.dubois@example.com', 'system', CURRENT_TIMESTAMP, 0),
('58eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'Federico López', 'federico.lopez@example.com', 'system', CURRENT_TIMESTAMP, 0),
('59eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', 'Maya Singh', 'maya.singh@example.com', 'system', CURRENT_TIMESTAMP, 0),
('60eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'Alexander Volkov', 'alexander.volkov@example.com', 'system', CURRENT_TIMESTAMP, 0);

-- =====================================================
-- 2. SAMPLE EVENTS
-- =====================================================
INSERT INTO events (id, name, event_start, event_end, venue, sales_start, sales_end, status, organizer_id, created_by, created_date, version) VALUES
-- Events in Americas (Colombia - UTC-5)
('10eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Concierto Rock Nacional 2025', '2025-06-15 20:00:00-05:00', '2025-06-15 23:30:00-05:00', 'Estadio El Campín - Bogotá, Colombia', '2025-03-01 00:00:00-05:00', '2025-06-14 23:59:59-05:00', 'PUBLISHED', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'system', CURRENT_TIMESTAMP, 0),

-- Events in Europe (France - UTC+1)
('20eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Festival de Jazz de Paris 2025', '2025-07-20 19:00:00+01:00', '2025-07-20 22:00:00+01:00', 'Olympia Theatre - Paris, France', '2025-04-01 00:00:00+01:00', '2025-07-19 23:59:59+01:00', 'PUBLISHED', 'f5eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'system', CURRENT_TIMESTAMP, 0),

-- Events in Asia (Japan - UTC+9)
('30eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Tokyo Tech Summit 2025', '2025-08-10 09:00:00+09:00', '2025-08-10 18:00:00+09:00', 'Tokyo International Forum - Tokyo, Japan', '2025-05-01 00:00:00+09:00', '2025-08-09 23:59:59+09:00', 'PUBLISHED', 'c2eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'system', CURRENT_TIMESTAMP, 0),

-- Events in Europe (Germany - UTC+1)
('40eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'Berlin International Film Festival', '2025-09-05 16:00:00+01:00', '2025-09-07 22:00:00+01:00', 'Berlinale Palast - Berlin, Germany', '2025-06-01 00:00:00+01:00', '2025-09-04 23:59:59+01:00', 'DRAFT', 'c8eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', 'system', CURRENT_TIMESTAMP, 0),

-- Events in Asia (India - UTC+5:30)
('50eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'Mumbai Marathon 2025', '2025-10-15 06:00:00+05:30', '2025-10-15 12:00:00+05:30', 'Marine Drive - Mumbai, India', '2025-07-01 00:00:00+05:30', '2025-10-14 23:59:59+05:30', 'PUBLISHED', 'd9eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'system', CURRENT_TIMESTAMP, 0),

-- Events in Middle East (UAE - UTC+4)
('60eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'Dubai International Conference', '2025-11-20 08:00:00+04:00', '2025-11-22 17:00:00+04:00', 'Dubai World Trade Centre - Dubai, UAE', '2025-08-01 00:00:00+04:00', '2025-11-19 23:59:59+04:00', 'PUBLISHED', 'a6eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'system', CURRENT_TIMESTAMP, 0),

-- Events in Americas (USA - UTC-8) - ACTIVE event happening soon
('70eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'San Francisco Music Festival', '2025-03-15 18:00:00-08:00', '2025-03-15 23:00:00-08:00', 'Golden Gate Park - San Francisco, USA', CURRENT_TIMESTAMP, '2025-03-14 23:59:59-08:00', 'ACTIVE', 'b1eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'system', CURRENT_TIMESTAMP, 0),

-- Additional Events Around the World (30+)
-- Europe Events
('80eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'Roma Food & Wine Festival', '2025-06-20 17:00:00+01:00', '2025-06-22 22:00:00+01:00', 'Villa Borghese - Roma, Italy', '2025-04-01 00:00:00+01:00', '2025-06-19 23:59:59+01:00', 'PUBLISHED', '11eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'system', CURRENT_TIMESTAMP, 0),
('81eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', 'Barcelona Design Week', '2025-07-10 10:00:00+01:00', '2025-07-14 20:00:00+01:00', 'Palau de Congressos - Barcelona, Spain', '2025-05-01 00:00:00+01:00', '2025-07-09 23:59:59+01:00', 'PUBLISHED', '12eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'system', CURRENT_TIMESTAMP, 0),
('82eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'Amsterdam Electronic Festival', '2025-08-15 18:00:00+01:00', '2025-08-17 02:00:00+01:00', 'RAI Amsterdam - Netherlands', '2025-06-01 00:00:00+01:00', '2025-08-14 23:59:59+01:00', 'PUBLISHED', '14eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'system', CURRENT_TIMESTAMP, 0),
('83eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'London Shakespeare Festival', '2025-09-01 19:30:00+00:00', '2025-09-30 21:30:00+00:00', 'Globe Theatre - London, UK', '2025-07-01 00:00:00+00:00', '2025-08-31 23:59:59+00:00', 'PUBLISHED', '22eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'system', CURRENT_TIMESTAMP, 0),
('84eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Stockholm Jazz Days', '2025-10-05 20:00:00+01:00', '2025-10-07 23:00:00+01:00', 'Konserthuset - Stockholm, Sweden', '2025-08-01 00:00:00+01:00', '2025-10-04 23:59:59+01:00', 'PUBLISHED', '23eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'system', CURRENT_TIMESTAMP, 0),

-- Asia-Pacific Events
('85eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Singapore Formula 1 Grand Prix', '2025-09-22 20:00:00+08:00', '2025-09-22 22:30:00+08:00', 'Marina Bay Circuit - Singapore', '2025-06-01 00:00:00+08:00', '2025-09-21 23:59:59+08:00', 'PUBLISHED', '13eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'system', CURRENT_TIMESTAMP, 0),
('86eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'Seoul K-Pop Festival', '2025-08-25 19:00:00+09:00', '2025-08-25 22:30:00+09:00', 'Olympic Stadium - Seoul, South Korea', '2025-06-01 00:00:00+09:00', '2025-08-24 23:59:59+09:00', 'PUBLISHED', '42eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'system', CURRENT_TIMESTAMP, 0),
('87eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'Sydney Opera House Gala', '2025-11-12 19:30:00+11:00', '2025-11-12 22:00:00+11:00', 'Sydney Opera House - Sydney, Australia', '2025-09-01 00:00:00+11:00', '2025-11-11 23:59:59+11:00', 'PUBLISHED', '34eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'system', CURRENT_TIMESTAMP, 0),
('88eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'Hong Kong International Film Festival', '2025-10-20 18:00:00+08:00', '2025-10-25 22:00:00+08:00', 'Hong Kong Cultural Centre - Hong Kong', '2025-08-01 00:00:00+08:00', '2025-10-19 23:59:59+08:00', 'PUBLISHED', '21eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'system', CURRENT_TIMESTAMP, 0),
('89eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'Bangkok Street Food Festival', '2025-12-10 16:00:00+07:00', '2025-12-12 23:00:00+07:00', 'Lumpini Park - Bangkok, Thailand', '2025-10-01 00:00:00+07:00', '2025-12-09 23:59:59+07:00', 'PUBLISHED', '54eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'system', CURRENT_TIMESTAMP, 0),

-- North America Events
('90eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'Toronto International Comedy Festival', '2025-07-15 20:00:00-04:00', '2025-07-18 23:30:00-04:00', 'Second City Toronto - Toronto, Canada', '2025-05-01 00:00:00-04:00', '2025-07-14 23:59:59-04:00', 'PUBLISHED', '25eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'system', CURRENT_TIMESTAMP, 0),
('91eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', 'Chicago Blues Festival', '2025-08-05 18:00:00-05:00', '2025-08-07 23:00:00-05:00', 'Grant Park - Chicago, USA', '2025-06-01 00:00:00-05:00', '2025-08-04 23:59:59-05:00', 'PUBLISHED', '29eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', 'system', CURRENT_TIMESTAMP, 0),
('92eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'Miami Art Basel', '2025-12-01 10:00:00-05:00', '2025-12-03 20:00:00-05:00', 'Miami Beach Convention Center - Miami, USA', '2025-09-01 00:00:00-05:00', '2025-11-30 23:59:59-05:00', 'PUBLISHED', '50eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'system', CURRENT_TIMESTAMP, 0),
('93eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Vancouver Film Festival', '2025-09-28 19:00:00-07:00', '2025-10-13 22:00:00-07:00', 'International Village - Vancouver, Canada', '2025-08-01 00:00:00-07:00', '2025-09-27 23:59:59-07:00', 'PUBLISHED', '43eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'system', CURRENT_TIMESTAMP, 0),

-- South America Events
('94eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Rio de Janeiro Carnival', '2024-02-10 14:00:00-03:00', '2024-02-13 22:00:00-03:00', 'Sambadrome - Rio de Janeiro, Brazil', '2023-12-01 00:00:00-03:00', '2024-02-09 23:59:59-03:00', 'COMPLETED', '16eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'system', CURRENT_TIMESTAMP, 0),
('95eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Buenos Aires Tango Festival', '2025-08-14 20:00:00-03:00', '2025-08-18 24:00:00-03:00', 'Teatro Colón - Buenos Aires, Argentina', '2025-06-01 00:00:00-03:00', '2025-08-13 23:59:59-03:00', 'PUBLISHED', '28eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'system', CURRENT_TIMESTAMP, 0),
('96eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'Santiago Wine Festival', '2025-11-05 12:00:00-03:00', '2025-11-07 20:00:00-03:00', 'Parque Forestal - Santiago, Chile', '2025-09-01 00:00:00-03:00', '2025-11-04 23:59:59-03:00', 'PUBLISHED', '37eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'system', CURRENT_TIMESTAMP, 0),

-- Africa Events
('97eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'Cape Town Jazz Festival', '2025-09-14 19:00:00+02:00', '2025-09-15 23:00:00+02:00', 'Cape Town International Convention Centre - South Africa', '2025-07-01 00:00:00+02:00', '2025-09-13 23:59:59+02:00', 'PUBLISHED', '41eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'system', CURRENT_TIMESTAMP, 0),
('98eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'Lagos Fashion Week', '2025-10-25 15:00:00+01:00', '2025-10-27 21:00:00+01:00', 'Federal Palace Hotel - Lagos, Nigeria', '2025-08-01 00:00:00+01:00', '2025-10-24 23:59:59+01:00', 'PUBLISHED', '39eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', 'system', CURRENT_TIMESTAMP, 0),

-- Middle East Events
('99eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'Doha Cultural Festival', '2025-11-15 18:00:00+03:00', '2025-11-17 22:00:00+03:00', 'Katara Cultural Village - Doha, Qatar', '2025-09-01 00:00:00+03:00', '2025-11-14 23:59:59+03:00', 'PUBLISHED', '32eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'system', CURRENT_TIMESTAMP, 0),
('100ebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'Istanbul International Music Festival', '2025-06-08 20:00:00+03:00', '2025-06-30 23:00:00+03:00', 'Hagia Irene - Istanbul, Turkey', '2025-04-01 00:00:00+03:00', '2025-06-07 23:59:59+03:00', 'PUBLISHED', '47eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'system', CURRENT_TIMESTAMP, 0),
('101ebc99-9c0b-4ef8-bb6d-6bb9bd380a99', 'Tehran Book Fair', '2025-05-10 09:00:00+04:30', '2025-05-20 18:00:00+04:30', 'Tehran International Fairground - Iran', '2025-03-01 00:00:00+04:30', '2025-05-09 23:59:59+04:30', 'PUBLISHED', '49eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', 'system', CURRENT_TIMESTAMP, 0),

-- Additional European Events
('102ebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'Prague Classical Music Festival', '2025-10-10 19:30:00+01:00', '2025-10-12 22:00:00+01:00', 'Rudolfinum - Prague, Czech Republic', '2025-08-01 00:00:00+01:00', '2025-10-09 23:59:59+01:00', 'PUBLISHED', '36eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'system', CURRENT_TIMESTAMP, 0),
('103ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Warsaw Tech Conference', '2025-11-08 09:00:00+01:00', '2025-11-10 17:00:00+01:00', 'Palace of Culture and Science - Warsaw, Poland', '2025-09-01 00:00:00+01:00', '2025-11-07 23:59:59+01:00', 'PUBLISHED', '48eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'system', CURRENT_TIMESTAMP, 0),
('104ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Oslo Northern Lights Festival', '2025-12-15 17:00:00+01:00', '2025-12-17 22:00:00+01:00', 'Opera House - Oslo, Norway', '2025-10-01 00:00:00+01:00', '2025-12-14 23:59:59+01:00', 'PUBLISHED', '38eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'system', CURRENT_TIMESTAMP, 0),

-- Additional Asian Events
('105ebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Delhi Food Festival', '2025-12-20 11:00:00+05:30', '2025-12-22 23:00:00+05:30', 'India Gate - New Delhi, India', '2025-10-01 00:00:00+05:30', '2025-12-19 23:59:59+05:30', 'PUBLISHED', '30eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'system', CURRENT_TIMESTAMP, 0),
('106ebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'Manila International Conference', '2025-09-18 08:00:00+08:00', '2025-09-20 17:00:00+08:00', 'PICC - Manila, Philippines', '2025-07-01 00:00:00+08:00', '2025-09-17 23:59:59+08:00', 'PUBLISHED', '46eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'system', CURRENT_TIMESTAMP, 0),
('107ebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'Kyoto Traditional Arts Festival', '2025-11-23 10:00:00+09:00', '2025-11-25 18:00:00+09:00', 'Kiyomizu Temple - Kyoto, Japan', '2025-09-01 00:00:00+09:00', '2025-11-22 23:59:59+09:00', 'PUBLISHED', '35eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'system', CURRENT_TIMESTAMP, 0),

-- Additional Americas Events
('108ebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'Montreal Film Festival', '2025-08-29 19:00:00-04:00', '2025-09-08 22:00:00-04:00', 'Place des Arts - Montreal, Canada', '2025-07-01 00:00:00-04:00', '2025-08-28 23:59:59-04:00', 'PUBLISHED', '44eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'system', CURRENT_TIMESTAMP, 0),
('109ebc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'Austin Music Festival', '2025-10-18 16:00:00-05:00', '2025-10-20 23:30:00-05:00', 'Zilker Park - Austin, USA', '2025-08-01 00:00:00-05:00', '2025-10-17 23:59:59-05:00', 'PUBLISHED', '55eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'system', CURRENT_TIMESTAMP, 0),
('110ebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'Lima Gastronomic Fair', '2025-09-12 12:00:00-05:00', '2025-09-15 22:00:00-05:00', 'Centro de Lima - Peru', '2025-07-01 00:00:00-05:00', '2025-09-11 23:59:59-05:00', 'PUBLISHED', '24eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'system', CURRENT_TIMESTAMP, 0),

-- Future Events for 2026 (DRAFT status)
('111ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'World Music Festival 2026', '2026-06-20 19:00:00-05:00', '2026-06-22 23:00:00-05:00', 'Central Park - New York, USA', '2025-12-01 00:00:00-05:00', '2026-06-19 23:59:59-05:00', 'DRAFT', '50eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'system', CURRENT_TIMESTAMP, 0),
('112ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'European Tech Summit 2026', '2026-04-15 09:00:00+01:00', '2026-04-17 18:00:00+01:00', 'ExCeL London - London, UK', '2025-11-01 00:00:00+01:00', '2026-04-14 23:59:59+01:00', 'DRAFT', '22eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'system', CURRENT_TIMESTAMP, 0),
('113ebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Asian Cultural Expo 2026', '2026-03-10 10:00:00+08:00', '2026-03-14 20:00:00+08:00', 'Singapore Expo - Singapore', '2025-10-01 00:00:00+08:00', '2026-03-09 23:59:59+08:00', 'DRAFT', '13eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'system', CURRENT_TIMESTAMP, 0),

-- Near-term ACTIVE events for realistic testing
('114ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'New Year Concert 2025', '2025-02-15 20:00:00+01:00', '2025-02-15 22:30:00+01:00', 'Vienna State Opera - Vienna, Austria', CURRENT_TIMESTAMP - INTERVAL '7 days', '2025-02-14 23:59:59+01:00', 'ACTIVE', '36eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'system', CURRENT_TIMESTAMP, 0),
('115ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Valentine Jazz Night', '2025-02-20 19:30:00-05:00', '2025-02-20 23:00:00-05:00', 'Blue Note - New York, USA', CURRENT_TIMESTAMP - INTERVAL '3 days', '2025-02-19 23:59:59-05:00', 'ACTIVE', '50eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'system', CURRENT_TIMESTAMP, 0),
('116ebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Chinese New Year Celebration', '2025-02-25 18:00:00+08:00', '2025-02-25 22:00:00+08:00', 'Singapore Gardens by the Bay', CURRENT_TIMESTAMP, '2025-02-24 23:59:59+08:00', 'ACTIVE', '13eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'system', CURRENT_TIMESTAMP, 0);

-- =====================================================
-- 3. USER-EVENT RELATIONSHIPS
-- =====================================================

-- Users attending events
INSERT INTO user_attending_events (user_id, event_id, created_date) VALUES
('f5eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', '10eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', CURRENT_TIMESTAMP), -- Sophie attending Rock concert in Colombia
('a6eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', '10eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', CURRENT_TIMESTAMP), -- Mohammed attending Rock concert in Colombia
('b7eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', '20eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', CURRENT_TIMESTAMP), -- Valentina attending Jazz in Paris
('c2eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', '30eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', CURRENT_TIMESTAMP), -- Hiroshi attending Tech Summit in Tokyo
('d9eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', '50eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', CURRENT_TIMESTAMP), -- Priya attending Mumbai Marathon
('b1eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', '70eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', CURRENT_TIMESTAMP), -- Emily attending SF Music Festival
('c8eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', '40eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', CURRENT_TIMESTAMP), -- Klaus attending Berlin Film Festival
('11eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', '80eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', CURRENT_TIMESTAMP), -- Alessandro attending Roma Food Festival
('26eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', '80eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', CURRENT_TIMESTAMP), -- Francesco attending Roma Food Festival
('40eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', '80eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', CURRENT_TIMESTAMP), -- Marco attending Roma Food Festival
('12eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', '81eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', CURRENT_TIMESTAMP), -- Maria attending Barcelona Design Week
('33eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', '81eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', CURRENT_TIMESTAMP), -- Lucia staffing Barcelona Design Week
('58eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', '81eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', CURRENT_TIMESTAMP), -- Federico staffing Barcelona Design Week
('14eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', '82eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', CURRENT_TIMESTAMP), -- Olav attending Amsterdam Electronic Festival
('52eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', '82eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', CURRENT_TIMESTAMP), -- Erik staffing Amsterdam Electronic Festival
('22eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', '83eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', CURRENT_TIMESTAMP), -- Liam attending London Shakespeare Festival
('25eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', '83eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', CURRENT_TIMESTAMP), -- Sarah staffing London Shakespeare Festival
('43eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', '83eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', CURRENT_TIMESTAMP), -- Rachel staffing London Shakespeare Festival
('23eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', '84eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', CURRENT_TIMESTAMP), -- Ingrid staffing Stockholm Jazz Days
('52eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', '84eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', CURRENT_TIMESTAMP), -- Erik staffing Stockholm Jazz Days
('13eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', '85eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', CURRENT_TIMESTAMP), -- Zhang Wei staffing Singapore F1
('21eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', '85eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', CURRENT_TIMESTAMP), -- Chen Lu staffing Singapore F1
('54eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', '85eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', CURRENT_TIMESTAMP), -- Kai Chen staffing Singapore F1
('42eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', '86eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', CURRENT_TIMESTAMP), -- Jin-Woo staffing Seoul K-Pop Festival
('46eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', '86eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', CURRENT_TIMESTAMP), -- Daniel staffing Seoul K-Pop Festival
('19eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', '86eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', CURRENT_TIMESTAMP), -- Yuki staffing Seoul K-Pop Festival
('34eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', '87eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', CURRENT_TIMESTAMP), -- Thomas staffing Sydney Opera Gala
('55eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', '87eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', CURRENT_TIMESTAMP), -- Olivia staffing Sydney Opera Gala
('21eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', '88eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', CURRENT_TIMESTAMP), -- Chen Lu staffing Hong Kong Film Festival
('54eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', '89eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', CURRENT_TIMESTAMP), -- Kai Chen staffing Bangkok Food Festival
('16eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', '94eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', CURRENT_TIMESTAMP), -- João staffing Rio Carnival
('37eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', '94eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', CURRENT_TIMESTAMP), -- Camila staffing Rio Carnival
('28eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', '95eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', CURRENT_TIMESTAMP), -- Diego staffing Buenos Aires Tango Festival
('37eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', '96eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', CURRENT_TIMESTAMP), -- Camila staffing Santiago Wine Festival
('41eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', '97eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', CURRENT_TIMESTAMP), -- Aisha staffing Cape Town Jazz Festival
('39eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', '98eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', CURRENT_TIMESTAMP), -- Zahra staffing Lagos Fashion Week
('15eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', '99eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', CURRENT_TIMESTAMP), -- Fatima staffing Doha Cultural Festival
('51eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', '99eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', CURRENT_TIMESTAMP), -- Noor staffing Doha Cultural Festival
('47eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', '100ebc99-9c0b-4ef8-bb6d-6bb9bd380a88', CURRENT_TIMESTAMP), -- Meryem staffing Istanbul Music Festival
('49eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', '101ebc99-9c0b-4ef8-bb6d-6bb9bd380a99', CURRENT_TIMESTAMP), -- Leila staffing Tehran Book Fair
('36eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', '102ebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', CURRENT_TIMESTAMP), -- Pavel staffing Prague Classical Music Festival
('48eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', '103ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', CURRENT_TIMESTAMP), -- Gabriel staffing Warsaw Tech Conference
('38eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', '104ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', CURRENT_TIMESTAMP), -- Viktor staffing Oslo Northern Lights Festival
('59eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', '105ebc99-9c0b-4ef8-bb6d-6bb9bd380a33', CURRENT_TIMESTAMP), -- Maya staffing Delhi Food Festival
('30eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', '105ebc99-9c0b-4ef8-bb6d-6bb9bd380a33', CURRENT_TIMESTAMP), -- Raj staffing Delhi Food Festival
('46eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', '106ebc99-9c0b-4ef8-bb6d-6bb9bd380a44', CURRENT_TIMESTAMP), -- Daniel staffing Manila Conference
('35eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', '107ebc99-9c0b-4ef8-bb6d-6bb9bd380a55', CURRENT_TIMESTAMP), -- Sakura staffing Kyoto Arts Festival
('44eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', '108ebc99-9c0b-4ef8-bb6d-6bb9bd380a66', CURRENT_TIMESTAMP), -- André staffing Montreal Film Festival
('50eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', '92eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', CURRENT_TIMESTAMP), -- James staffing Miami Art Basel
('55eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', '109ebc99-9c0b-4ef8-bb6d-6bb9bd380a77', CURRENT_TIMESTAMP), -- Olivia staffing Austin Music Festival
('24eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', '110ebc99-9c0b-4ef8-bb6d-6bb9bd380a88', CURRENT_TIMESTAMP); -- Carlos staffing Lima Gastronomic Fair

-- Users staffing events
INSERT INTO user_staffing_events (user_id, event_id, created_date) VALUES
('d3eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', '10eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', CURRENT_TIMESTAMP), -- Ana staffing Rock concert
('e4eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', '20eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', CURRENT_TIMESTAMP), -- Roberto staffing Jazz festival  
('b1eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', '30eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', CURRENT_TIMESTAMP), -- Emily staffing Tokyo Tech Summit
('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', '60eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', CURRENT_TIMESTAMP), -- Juan Carlos staffing Dubai Conference
('26eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', '80eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', CURRENT_TIMESTAMP), -- Francesco staffing Roma Food Festival
('57eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', '80eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', CURRENT_TIMESTAMP), -- Charlotte staffing Roma Food Festival
('33eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', '81eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', CURRENT_TIMESTAMP), -- Lucia staffing Barcelona Design Week
('45eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', '81eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', CURRENT_TIMESTAMP), -- Catalina staffing Barcelona Design Week
('52eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', '82eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', CURRENT_TIMESTAMP), -- Erik staffing Amsterdam Electronic Festival
('29eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', '83eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', CURRENT_TIMESTAMP), -- Emma staffing London Shakespeare Festival
('43eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', '83eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', CURRENT_TIMESTAMP), -- Rachel staffing London Shakespeare Festival
('23eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', '84eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', CURRENT_TIMESTAMP), -- Ingrid staffing Stockholm Jazz Days
('38eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', '84eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', CURRENT_TIMESTAMP), -- Viktor staffing Stockholm Jazz Days
('21eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', '85eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', CURRENT_TIMESTAMP), -- Chen Lu staffing Singapore F1
('46eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', '85eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', CURRENT_TIMESTAMP), -- Daniel staffing Singapore F1
('19eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', '86eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', CURRENT_TIMESTAMP), -- Yuki staffing Seoul K-Pop Festival
('35eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', '86eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', CURRENT_TIMESTAMP), -- Sakura staffing Seoul K-Pop Festival
('25eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', '87eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', CURRENT_TIMESTAMP), -- Sarah staffing Sydney Opera Gala
('13eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', '88eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', CURRENT_TIMESTAMP), -- Zhang Wei staffing Hong Kong Film Festival
('46eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', '89eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', CURRENT_TIMESTAMP), -- Daniel staffing Bangkok Food Festival
('25eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', '90eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', CURRENT_TIMESTAMP), -- Sarah staffing Toronto Comedy Festival
('44eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', '90eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', CURRENT_TIMESTAMP), -- André staffing Toronto Comedy Festival
('50eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', '91eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', CURRENT_TIMESTAMP), -- James staffing Chicago Blues Festival
('34eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', '92eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', CURRENT_TIMESTAMP), -- Thomas staffing Miami Art Basel
('29eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', '93eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', CURRENT_TIMESTAMP), -- Emma staffing Vancouver Film Festival
('16eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', '94eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', CURRENT_TIMESTAMP), -- João staffing Rio Carnival
('37eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', '94eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', CURRENT_TIMESTAMP), -- Camila staffing Rio Carnival
('20eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', '95eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', CURRENT_TIMESTAMP), -- Isabella staffing Buenos Aires Tango Festival
('24eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', '96eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', CURRENT_TIMESTAMP), -- Carlos staffing Santiago Wine Festival
('39eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', '97eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', CURRENT_TIMESTAMP), -- Zahra staffing Cape Town Jazz Festival
('18eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', '98eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', CURRENT_TIMESTAMP), -- Ahmed staffing Lagos Fashion Week
('56eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', '99eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', CURRENT_TIMESTAMP), -- Abdul staffing Doha Cultural Festival
('32eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', '99eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', CURRENT_TIMESTAMP), -- Hassan staffing Doha Cultural Festival
('18eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', '100ebc99-9c0b-4ef8-bb6d-6bb9bd380a88', CURRENT_TIMESTAMP), -- Ahmed staffing Istanbul Music Festival
('56eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', '101ebc99-9c0b-4ef8-bb6d-6bb9bd380a99', CURRENT_TIMESTAMP), -- Abdul staffing Tehran Book Fair
('48eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', '102ebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', CURRENT_TIMESTAMP), -- Gabriel staffing Prague Classical Music Festival
('27eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', '103ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', CURRENT_TIMESTAMP), -- Natasha staffing Warsaw Tech Conference
('14eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', '104ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', CURRENT_TIMESTAMP), -- Olav staffing Oslo Northern Lights Festival
('30eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', '105ebc99-9c0b-4ef8-bb6d-6bb9bd380a33', CURRENT_TIMESTAMP), -- Raj staffing Delhi Food Festival
('59eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', '105ebc99-9c0b-4ef8-bb6d-6bb9bd380a33', CURRENT_TIMESTAMP), -- Maya staffing Delhi Food Festival
('54eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', '106ebc99-9c0b-4ef8-bb6d-6bb9bd380a44', CURRENT_TIMESTAMP), -- Kai staffing Manila Conference
('19eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', '107ebc99-9c0b-4ef8-bb6d-6bb9bd380a55', CURRENT_TIMESTAMP), -- Yuki staffing Kyoto Arts Festival
('22eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', '108ebc99-9c0b-4ef8-bb6d-6bb9bd380a66', CURRENT_TIMESTAMP), -- Liam staffing Montreal Film Festival
('29eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', '109ebc99-9c0b-4ef8-bb6d-6bb9bd380a77', CURRENT_TIMESTAMP), -- Emma staffing Austin Music Festival
('28eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', '110ebc99-9c0b-4ef8-bb6d-6bb9bd380a88', CURRENT_TIMESTAMP), -- Diego staffing Lima Gastronomic Fair
('58eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', '110ebc99-9c0b-4ef8-bb6d-6bb9bd380a88', CURRENT_TIMESTAMP);

-- =====================================================
-- 4. TICKET TYPES
-- =====================================================
INSERT INTO ticket_types (id, name, price, description, total_available, event_id, created_by, created_date, version) VALUES
-- Concierto Rock Nacional (Colombia)
('100ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'General', 150000.00, 'Entrada general al concierto. Incluye acceso a todas las áreas públicas.', 5000, '10eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'system', CURRENT_TIMESTAMP, 0),
('110ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'VIP', 350000.00, 'Acceso VIP con área exclusiva, bebida de bienvenida y merchandise.', 500, '10eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'system', CURRENT_TIMESTAMP, 0),
('120ebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Palco', 500000.00, 'Acceso a palcos con la mejor vista y servicio premium.', 100, '10eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'system', CURRENT_TIMESTAMP, 0),

-- Festival de Jazz de Paris (France)
('200ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Standard', 65.00, 'Entrée standard au festival de jazz.', 2000, '20eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'system', CURRENT_TIMESTAMP, 0),
('210ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Premium', 120.00, 'Accès premium avec sièges réservés et restauration.', 300, '20eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'system', CURRENT_TIMESTAMP, 0),

-- Tokyo Tech Summit (Japan)
('300ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Student', 8000.00, 'Special rate for students with valid ID. 学生証提示で特別料金.', 200, '30eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'system', CURRENT_TIMESTAMP, 0),
('310ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Professional', 25000.00, 'Professional access with all talks and networking. 全講演とネットワーキング参加可能.', 800, '30eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'system', CURRENT_TIMESTAMP, 0),

-- Berlin Film Festival (Germany)
('400ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Daily Pass', 25.00, 'Tagespass für Filmvorführungen.', 500, '40eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'system', CURRENT_TIMESTAMP, 0),
('410ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Festival Pass', 85.00, 'Kompletter Festivalpass für alle drei Tage.', 200, '40eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'system', CURRENT_TIMESTAMP, 0),

-- Mumbai Marathon (India)  
('500ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', '5K Fun Run', 1500.00, '5 किमी मजेदार दौड़ के लिए पंजीकरण.', 1000, '50eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'system', CURRENT_TIMESTAMP, 0),
('510ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', '10K Challenge', 2500.00, '10 किमी चुनौती के लिए पंजीकरण.', 1500, '50eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'system', CURRENT_TIMESTAMP, 0),
('520ebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Half Marathon', 4000.00, 'हाफ मैराथन (21 किमी) के लिए पंजीकरण.', 800, '50eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'system', CURRENT_TIMESTAMP, 0),

-- Dubai International Conference (UAE)
('600ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Standard Access', 450.00, 'Standard conference access. وصول قياسي للمؤتمر.', 1200, '60eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'system', CURRENT_TIMESTAMP, 0),
('610ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Executive Package', 850.00, 'Executive access with premium networking. حزمة تنفيذية مع شبكات متميزة.', 300, '60eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'system', CURRENT_TIMESTAMP, 0),

-- San Francisco Music Festival (USA)
('700ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'General Admission', 75.00, 'General admission to the music festival.', 3000, '70eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'system', CURRENT_TIMESTAMP, 0),
('710ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'VIP Experience', 200.00, 'VIP access with exclusive viewing area and amenities.', 500, '70eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'system', CURRENT_TIMESTAMP, 0),

-- Additional Ticket Types for New Events

-- Roma Food & Wine Festival (Italy)
('800ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Tasting Pass', 45.00, 'Accesso per degustazioni e masterclass.', 1500, '80eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'system', CURRENT_TIMESTAMP, 0),
('810ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Chef Experience', 120.00, 'Esperienza esclusiva con chef stellati.', 200, '80eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'system', CURRENT_TIMESTAMP, 0),
('820ebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Weekend Pass', 75.00, 'Pass completo per tutto il weekend.', 800, '80eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'system', CURRENT_TIMESTAMP, 0),

-- Barcelona Design Week (Spain)
('830ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'General', 35.00, 'Entrada general a todas las conferencias.', 2000, '81eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', 'system', CURRENT_TIMESTAMP, 0),
('840ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Professional', 85.00, 'Acceso profesional con networking.', 600, '81eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', 'system', CURRENT_TIMESTAMP, 0),
('850ebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Student', 20.00, 'Descuento especial para estudiantes.', 300, '81eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', 'system', CURRENT_TIMESTAMP, 0),

-- Amsterdam Electronic Festival (Netherlands)
('860ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Day Pass', 65.00, 'Dagkaart voor elektronische muziek.', 3000, '82eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'system', CURRENT_TIMESTAMP, 0),
('870ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'VIP Weekend', 180.00, 'VIP toegang voor het hele weekend.', 400, '82eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'system', CURRENT_TIMESTAMP, 0),
('880ebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Early Bird', 45.00, 'Vroegboeker korting.', 1000, '82eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'system', CURRENT_TIMESTAMP, 0),

-- London Shakespeare Festival (UK)
('890ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Groundling', 25.00, 'Standing tickets in the yard.', 500, '83eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'system', CURRENT_TIMESTAMP, 0),
('900ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Gallery', 45.00, 'Seated in the gallery.', 200, '83eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'system', CURRENT_TIMESTAMP, 0),
('910ebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Premium', 85.00, 'Best seats in the house.', 100, '83eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'system', CURRENT_TIMESTAMP, 0),

-- Stockholm Jazz Days (Sweden)
('920ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Standard', 55.00, 'Standardbiljett för jazzkonsert.', 1200, '84eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'system', CURRENT_TIMESTAMP, 0),
('930ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Premium', 95.00, 'Premium platser med fördrink.', 300, '84eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'system', CURRENT_TIMESTAMP, 0),

-- Singapore Formula 1 Grand Prix (Singapore)
('940ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Grandstand', 150.00, 'Grandstand seating for the race.', 5000, '85eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'system', CURRENT_TIMESTAMP, 0),
('950ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Paddock Club', 800.00, 'Exclusive paddock access with hospitality.', 200, '85eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'system', CURRENT_TIMESTAMP, 0),
('960ebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Bay Grandstand', 280.00, 'Marina Bay circuit premium viewing.', 1000, '85eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'system', CURRENT_TIMESTAMP, 0),

-- Seoul K-Pop Festival (South Korea)
('970ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'General', 80.00, 'General admission. 일반 입장권.', 8000, '86eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'system', CURRENT_TIMESTAMP, 0),
('980ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'VIP', 250.00, 'VIP access with meet & greet. VIP 특전.', 500, '86eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'system', CURRENT_TIMESTAMP, 0),
('990ebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Premium', 150.00, 'Premium seating. 프리미엄 좌석.', 1500, '86eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'system', CURRENT_TIMESTAMP, 0),

-- Sydney Opera House Gala (Australia)
('1000bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Dress Circle', 120.00, 'Dress Circle seating for the gala.', 400, '87eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'system', CURRENT_TIMESTAMP, 0),
('1010bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Premium Orchestra', 200.00, 'Best orchestra seats.', 200, '87eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'system', CURRENT_TIMESTAMP, 0),

-- Hong Kong International Film Festival (Hong Kong)
('1020bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Regular Screening', 25.00, 'Regular movie screening. 一般電影放映.', 2000, '88eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'system', CURRENT_TIMESTAMP, 0),
('1030bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Gala Screening', 75.00, 'Gala premiere screening. 首映典禮.', 300, '88eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'system', CURRENT_TIMESTAMP, 0),
('1040bc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Festival Pass', 180.00, 'Access to all screenings. 全票通行證.', 150, '88eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'system', CURRENT_TIMESTAMP, 0),

-- Bangkok Street Food Festival (Thailand)
('1050bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Food Pass', 15.00, 'Entry to food festival. ผ่านเข้างานอาหาร.', 5000, '89eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'system', CURRENT_TIMESTAMP, 0),
('1060bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Chef Tour', 45.00, 'Guided tour with famous chefs. ทัวร์กับเชฟ.', 200, '89eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'system', CURRENT_TIMESTAMP, 0),

-- Toronto International Comedy Festival (Canada)
('1070bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Single Show', 35.00, 'Single comedy show admission.', 1000, '90eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'system', CURRENT_TIMESTAMP, 0),
('1080bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Festival Pass', 120.00, 'Access to all comedy shows.', 300, '90eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'system', CURRENT_TIMESTAMP, 0),

-- Chicago Blues Festival (USA)
('1090bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'General Admission', 40.00, 'General admission to blues festival.', 4000, '91eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', 'system', CURRENT_TIMESTAMP, 0),
('1100bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'VIP Blues', 125.00, 'VIP access with artist meet & greet.', 400, '91eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', 'system', CURRENT_TIMESTAMP, 0),

-- Miami Art Basel (USA)
('1110bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Day Pass', 60.00, 'Single day access to art exhibitions.', 2000, '92eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'system', CURRENT_TIMESTAMP, 0),
('1120bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Collector Pass', 150.00, 'Priority access for collectors.', 500, '92eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'system', CURRENT_TIMESTAMP, 0),
('1130bc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'VIP Basel', 350.00, 'VIP access with private tours.', 200, '92eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'system', CURRENT_TIMESTAMP, 0),

-- Vancouver Film Festival (Canada)
('1140bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Regular', 18.00, 'Regular film screening.', 1500, '93eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'system', CURRENT_TIMESTAMP, 0),
('1150bc99-9c0b-4ef8-bb6d-6bb9bd380a22', '10-Pack', 150.00, 'Package of 10 film tickets.', 200, '93eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'system', CURRENT_TIMESTAMP, 0),

-- Rio de Janeiro Carnival (Brazil)
('1160bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Arquibancada', 80.00, 'Entrada para arquibancada popular.', 8000, '94eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'system', CURRENT_TIMESTAMP, 0),
('1170bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Camarote', 350.00, 'Camarote VIP com open bar.', 600, '94eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'system', CURRENT_TIMESTAMP, 0),
('1180bc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Frisante', 180.00, 'Setor especial Frisante.', 1200, '94eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'system', CURRENT_TIMESTAMP, 0),

-- Buenos Aires Tango Festival (Argentina)
('1190bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Milonga Entry', 25.00, 'Entrada para milongas nocturnas.', 1000, '95eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'system', CURRENT_TIMESTAMP, 0),
('1200bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Show Premium', 85.00, 'Espectáculo de tango premium.', 400, '95eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'system', CURRENT_TIMESTAMP, 0),
('1210bc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Workshop', 45.00, 'Clases magistrales de tango.', 200, '95eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'system', CURRENT_TIMESTAMP, 0),

-- Santiago Wine Festival (Chile)
('1220bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Degustación', 35.00, 'Degustación de vinos nacionales.', 1500, '96eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'system', CURRENT_TIMESTAMP, 0),
('1230bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Premium Tasting', 75.00, 'Cata premium con enólogos.', 300, '96eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'system', CURRENT_TIMESTAMP, 0),

-- Cape Town Jazz Festival (South Africa)
('1240bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'General', 45.00, 'General admission to jazz festival.', 2000, '97eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'system', CURRENT_TIMESTAMP, 0),
('1250bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'VIP Jazz', 120.00, 'VIP access with artist interactions.', 300, '97eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'system', CURRENT_TIMESTAMP, 0),

-- Lagos Fashion Week (Nigeria)
('1260bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Fashion Show', 30.00, 'Access to fashion runway shows.', 1000, '98eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'system', CURRENT_TIMESTAMP, 0),
('1270bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Designer Meet', 80.00, 'Meet with African designers.', 200, '98eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'system', CURRENT_TIMESTAMP, 0),

-- Doha Cultural Festival (Qatar)
('1280bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Cultural Pass', 40.00, 'مدخل للفعاليات الثقافية. Cultural events access.', 1500, '99eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'system', CURRENT_TIMESTAMP, 0),
('1290bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Heritage Tour', 65.00, 'جولة التراث المميزة. Premium heritage tour.', 400, '99eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'system', CURRENT_TIMESTAMP, 0),

-- Istanbul International Music Festival (Turkey)
('1300bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Concert Ticket', 55.00, 'Konser bileti. Concert admission.', 1200, '100ebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'system', CURRENT_TIMESTAMP, 0),
('1310bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Festival Pass', 180.00, 'Festival geçiş kartı. Full festival access.', 300, '100ebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'system', CURRENT_TIMESTAMP, 0),

-- Tehran Book Fair (Iran)
('1320bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'General Entry', 8.00, 'ورودی عمومی نمایشگاه کتاب. General book fair entry.', 5000, '101ebc99-9c0b-4ef8-bb6d-6bb9bd380a99', 'system', CURRENT_TIMESTAMP, 0),
('1330bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Author Meet', 25.00, 'ملاقات با نویسندگان. Meet the authors.', 200, '101ebc99-9c0b-4ef8-bb6d-6bb9bd380a99', 'system', CURRENT_TIMESTAMP, 0),

-- Prague Classical Music Festival (Czech Republic)
('1340bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Orchestra', 65.00, 'Orchestrální koncert. Orchestra concert.', 800, '102ebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'system', CURRENT_TIMESTAMP, 0),
('1350bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Chamber Music', 45.00, 'Komorní hudba. Chamber music.', 300, '102ebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'system', CURRENT_TIMESTAMP, 0),

-- Warsaw Tech Conference (Poland)
('1360bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Developer', 120.00, 'Bilet dla deweloperów. Developer access.', 1000, '103ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'system', CURRENT_TIMESTAMP, 0),
('1370bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Student', 50.00, 'Zniżka studencka. Student discount.', 300, '103ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'system', CURRENT_TIMESTAMP, 0),

-- Oslo Northern Lights Festival (Norway)
('1380bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Aurora Tour', 85.00, 'Nordlys tur. Northern lights tour.', 500, '104ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'system', CURRENT_TIMESTAMP, 0),
('1390bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Premium Experience', 150.00, 'Premium nordlys opplevelse.', 200, '104ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'system', CURRENT_TIMESTAMP, 0),

-- Delhi Food Festival (India)
('1400bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Food Entry', 12.00, 'खाना महोत्सव प्रवेश. Food festival entry.', 3000, '105ebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'system', CURRENT_TIMESTAMP, 0),
('1410bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Chef Special', 35.00, 'शेफ विशेष. Chef special experience.', 500, '105ebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'system', CURRENT_TIMESTAMP, 0),

-- Manila International Conference (Philippines)
('1420bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Conference Pass', 95.00, 'Full conference access.', 800, '106ebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'system', CURRENT_TIMESTAMP, 0),
('1430bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Networking', 150.00, 'Conference with premium networking.', 300, '106ebc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'system', CURRENT_TIMESTAMP, 0),

-- Kyoto Traditional Arts Festival (Japan)
('1440bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Arts Pass', 45.00, '伝統芸術パス. Traditional arts pass.', 1000, '107ebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'system', CURRENT_TIMESTAMP, 0),
('1450bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Master Class', 85.00, 'マスタークラス. Master class with artists.', 200, '107ebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'system', CURRENT_TIMESTAMP, 0),

-- Montreal Film Festival (Canada)
('1460bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Film Pass', 22.00, 'Billet de cinéma. Single film ticket.', 2000, '108ebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'system', CURRENT_TIMESTAMP, 0),
('1470bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Festival Access', 180.00, 'Accès complet festival. Full festival access.', 400, '108ebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'system', CURRENT_TIMESTAMP, 0),

-- Austin Music Festival (USA)
('1480bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'General Admission', 65.00, 'General admission to music festival.', 5000, '109ebc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'system', CURRENT_TIMESTAMP, 0),
('1490bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'VIP Music', 180.00, 'VIP access with artist meet & greet.', 600, '109ebc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'system', CURRENT_TIMESTAMP, 0),

-- Lima Gastronomic Fair (Peru)
('1500bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Degustación', 20.00, 'Entrada para degustación gastronómica.', 2000, '110ebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'system', CURRENT_TIMESTAMP, 0),
('1510bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'Chef Experience', 60.00, 'Experiencia con chefs peruanos.', 300, '110ebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'system', CURRENT_TIMESTAMP, 0),
('1520bc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'Pisco Tasting', 35.00, 'Cata especial de piscos premium.', 500, '110ebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'system', CURRENT_TIMESTAMP, 0);

-- =====================================================
-- 5. SAMPLE TICKET RESERVATIONS
-- =====================================================
INSERT INTO ticket_reservations (id, status, reserved_at, expires_at, confirmed_at, released_at, session_id, quantity, ticket_type_id, user_id, event_id, created_by, created_date, version) VALUES
-- Reservaciones activas
('1e50ebc9-9c0b-4ef8-bb6d-6bb9bd380a11', 'ACTIVE', CURRENT_TIMESTAMP - INTERVAL '5 minutes', CURRENT_TIMESTAMP + INTERVAL '10 minutes', NULL, NULL, 'session_12345', 2, '100ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'f5eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', '10eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'system', CURRENT_TIMESTAMP, 0),
('1e51bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'ACTIVE', CURRENT_TIMESTAMP - INTERVAL '3 minutes', CURRENT_TIMESTAMP + INTERVAL '12 minutes', NULL, NULL, 'session_67890', 1, '210ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'a6eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', '20eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'system', CURRENT_TIMESTAMP, 0),
('1e58bc99-9c0b-4ef8-bb6d-6bb9bd380a99', 'ACTIVE', CURRENT_TIMESTAMP - INTERVAL '2 minutes', CURRENT_TIMESTAMP + INTERVAL '13 minutes', NULL, NULL, 'session_tokyo01', 1, '310ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'c2eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', '30eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'system', CURRENT_TIMESTAMP, 0),

-- Reservaciones confirmadas (convertidas en compras)
('1e52bc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'CONFIRMED', CURRENT_TIMESTAMP - INTERVAL '1 hour', CURRENT_TIMESTAMP - INTERVAL '45 minutes', CURRENT_TIMESTAMP - INTERVAL '30 minutes', NULL, 'session_11111', 1, '110ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'a6eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', '10eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'system', CURRENT_TIMESTAMP - INTERVAL '1 hour', 0),
('1e53bc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'CONFIRMED', CURRENT_TIMESTAMP - INTERVAL '2 hours', CURRENT_TIMESTAMP - INTERVAL '1 hour 45 minutes', CURRENT_TIMESTAMP - INTERVAL '1 hour 30 minutes', NULL, 'session_22222', 1, '200ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'b7eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', '20eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'system', CURRENT_TIMESTAMP - INTERVAL '2 hours', 0),
('1e59bc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'CONFIRMED', CURRENT_TIMESTAMP - INTERVAL '3 hours', CURRENT_TIMESTAMP - INTERVAL '2 hour 45 minutes', CURRENT_TIMESTAMP - INTERVAL '2 hour 30 minutes', NULL, 'session_mumbai01', 1, '500ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'd9eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', '50eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'system', CURRENT_TIMESTAMP - INTERVAL '3 hours', 0),

-- Reservaciones expiradas
('1e54bc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'EXPIRED', CURRENT_TIMESTAMP - INTERVAL '30 minutes', CURRENT_TIMESTAMP - INTERVAL '15 minutes', NULL, CURRENT_TIMESTAMP - INTERVAL '15 minutes', 'session_33333', 3, '100ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'd3eebc99-9c0b-4ef8-bb6d-6bb9bd380a44', '10eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'system', CURRENT_TIMESTAMP - INTERVAL '30 minutes', 0),
('1e55bc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'EXPIRED', CURRENT_TIMESTAMP - INTERVAL '45 minutes', CURRENT_TIMESTAMP - INTERVAL '30 minutes', NULL, CURRENT_TIMESTAMP - INTERVAL '30 minutes', 'session_44444', 1, '300ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'e4eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', '30eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'system', CURRENT_TIMESTAMP - INTERVAL '45 minutes', 0),

-- Reservaciones canceladas
('1e56bc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'CANCELLED', CURRENT_TIMESTAMP - INTERVAL '1 hour', CURRENT_TIMESTAMP + INTERVAL '14 minutes', NULL, CURRENT_TIMESTAMP - INTERVAL '50 minutes', 'session_55555', 2, '510ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'f5eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', '50eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'system', CURRENT_TIMESTAMP - INTERVAL '1 hour', 0),
('1e5abc99-9c0b-4ef8-bb6d-6bb9bd380abb', 'CANCELLED', CURRENT_TIMESTAMP - INTERVAL '2 hours', CURRENT_TIMESTAMP - INTERVAL '1 hour 45 minutes', NULL, CURRENT_TIMESTAMP - INTERVAL '1 hour 30 minutes', 'session_dubai01', 1, '600ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'b1eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', '60eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'system', CURRENT_TIMESTAMP - INTERVAL '2 hours', 0),

-- Reservaciones liberadas manualmente
('1e57bc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'RELEASED', CURRENT_TIMESTAMP - INTERVAL '2 hours', CURRENT_TIMESTAMP - INTERVAL '1 hour 45 minutes', NULL, CURRENT_TIMESTAMP - INTERVAL '1 hour 30 minutes', 'session_66666', 1, '120ebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'b7eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', '10eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'system', CURRENT_TIMESTAMP - INTERVAL '2 hours', 0);

-- =====================================================
-- 6. SAMPLE TICKETS
-- =====================================================
INSERT INTO tickets (id, status, ticket_type_id, purchaser_id, created_by, created_date, version) VALUES
-- Tickets para Concierto Rock Colombia
('1000bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'PAID', '100ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'f5eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'system', CURRENT_TIMESTAMP, 0),
('1010bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'PAID', '110ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'a6eebc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'system', CURRENT_TIMESTAMP, 0),

-- Tickets para Festival de Jazz Paris
('2000bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'PAID', '200ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'b7eebc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'system', CURRENT_TIMESTAMP, 0),
('2010bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'PAID', '210ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'f5eebc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'system', CURRENT_TIMESTAMP, 0),

-- Tickets para Tokyo Tech Summit
('3000bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'PAID', '310ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'c2eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'system', CURRENT_TIMESTAMP, 0),

-- Tickets para Mumbai Marathon
('4000bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'PAID', '500ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'd9eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa', 'system', CURRENT_TIMESTAMP, 0),
('4010bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'PAID', '510ebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'e4eebc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'system', CURRENT_TIMESTAMP, 0),

-- Tickets para San Francisco Music Festival
('5000bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'PAID', '700ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'b1eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'system', CURRENT_TIMESTAMP, 0),

-- Ticket reservado en proceso
('6000bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'RESERVED', '400ebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'c8eebc99-9c0b-4ef8-bb6d-6bb9bd380a99', 'system', CURRENT_TIMESTAMP, 0);

-- =====================================================
-- 7. QR CODES FOR PAID TICKETS
-- =====================================================
INSERT INTO qr_codes (id, status, value, ticket_id, created_by, created_date, version) VALUES
('1c00bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'ACTIVE', 'QR-ROCK-COL-2025-001-GENERAL-f5ee', '1000bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'system', CURRENT_TIMESTAMP, 0),
('1c10bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'ACTIVE', 'QR-ROCK-COL-2025-002-VIP-a6ee', '1010bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'system', CURRENT_TIMESTAMP, 0),
('1c20bc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'ACTIVE', 'QR-JAZZ-PAR-2025-001-STD-b7ee', '2000bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'system', CURRENT_TIMESTAMP, 0),
('1c30bc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'ACTIVE', 'QR-JAZZ-PAR-2025-002-PREM-f5ee', '2010bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'system', CURRENT_TIMESTAMP, 0),
('1c40bc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'ACTIVE', 'QR-TECH-TOK-2025-001-PROF-c2ee', '3000bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'system', CURRENT_TIMESTAMP, 0),
('1c50bc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'ACTIVE', 'QR-MARA-MUM-2025-001-5K-d9ee', '4000bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'system', CURRENT_TIMESTAMP, 0),
('1c60bc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'ACTIVE', 'QR-MARA-MUM-2025-002-10K-e4ee', '4010bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'system', CURRENT_TIMESTAMP, 0),
('1c70bc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'ACTIVE', 'QR-MUSIC-SF-2025-001-GEN-b1ee', '5000bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'system', CURRENT_TIMESTAMP, 0);

-- =====================================================
-- 8. SAMPLE TICKET VALIDATIONS
-- =====================================================
INSERT INTO ticket_validations (id, status, validation_method, validation_date_time, validation_location, ticket_id, created_by, created_date, version) VALUES
-- Validaciones en Colombia (UTC-5) - Para eventos futuros estas serían validaciones de prueba
('1a10bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'SUCCESS', 'QR_SCAN', '2025-06-15 19:45:00-05:00', 'Entrada Principal - Estadio El Campín', '1000bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'staff_ana_lopez', CURRENT_TIMESTAMP, 0),
('1a11bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'SUCCESS', 'QR_SCAN', '2025-06-15 19:50:00-05:00', 'Entrada VIP - Estadio El Campín', '1010bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'staff_roberto_martinez', CURRENT_TIMESTAMP, 0),

-- Validaciones en Francia (UTC+1)
('1a12bc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'FAILED', 'QR_SCAN', '2025-07-20 18:30:00+01:00', 'Olympia Theatre - Main Entrance', '2000bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'staff_sophie_dubois', CURRENT_TIMESTAMP, 0),
('1a13bc99-9c0b-4ef8-bb6d-6bb9bd380a44', 'SUCCESS', 'MANUAL', '2025-07-20 18:35:00+01:00', 'Olympia Theatre - Box Office', '2000bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'staff_sophie_dubois', CURRENT_TIMESTAMP, 0),
('1a14bc99-9c0b-4ef8-bb6d-6bb9bd380a55', 'SUCCESS', 'QR_SCAN', '2025-07-20 18:55:00+01:00', 'Olympia Theatre - Premium Entrance', '2010bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'staff_sophie_dubois', CURRENT_TIMESTAMP, 0),

-- Validaciones en Japón (UTC+9)
('1a15bc99-9c0b-4ef8-bb6d-6bb9bd380a66', 'SUCCESS', 'NFC', '2025-08-10 08:45:00+09:00', 'Tokyo International Forum - Hall A', '3000bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'staff_hiroshi_tanaka', CURRENT_TIMESTAMP, 0),

-- Validaciones en India (UTC+5:30)
('1a16bc99-9c0b-4ef8-bb6d-6bb9bd380a77', 'SUCCESS', 'MOBILE_APP', '2025-10-15 05:45:00+05:30', 'Marine Drive - Starting Point', '4000bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'staff_priya_sharma', CURRENT_TIMESTAMP, 0),
('1a17bc99-9c0b-4ef8-bb6d-6bb9bd380a88', 'SUCCESS', 'QR_SCAN', '2025-10-15 05:50:00+05:30', 'Marine Drive - Registration Area', '4010bc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'staff_priya_sharma', CURRENT_TIMESTAMP, 0),

-- Validaciones en USA (UTC-8) - Para el evento ACTIVE de marzo 2025
('1a18bc99-9c0b-4ef8-bb6d-6bb9bd380a99', 'SUCCESS', 'QR_SCAN', '2025-03-15 17:30:00-08:00', 'Golden Gate Park - Main Stage Area', '5000bc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'staff_emily_thompson', CURRENT_TIMESTAMP, 0);

-- =====================================================
-- COMMENTS
-- =====================================================
-- This data provides a complete international sample dataset for testing the ticket system
-- Including events across multiple time zones, multilingual content, and diverse user demographics
-- with REALISTIC FUTURE DATES (2025-2026) for proper system testing
--
-- INTERNATIONAL SAMPLE DATA INCLUDES:
-- - 60+ users with names from different countries and cultures
-- - 40+ events across multiple time zones spanning 2025-2026:
--   * Global distribution: Americas, Europe, Asia-Pacific, Africa, Middle East
--   * Multiple event types: Concerts, Festivals, Conferences, Sports, Cultural Events
--   * Realistic date distribution with appropriate event statuses
--
-- EVENT STATUS DISTRIBUTION:
-- - ACTIVE: Events with sales currently open (near-term events in 2025)
-- - PUBLISHED: Events available for sale (throughout 2025)
-- - DRAFT: Future events in planning (some 2026 events)
-- - COMPLETED: Historical events (Rio Carnival 2024)
--
-- TIMEZONE VALIDATION FEATURES:
-- - All timestamp fields use proper timezone notation (±HH:MM)
-- - Events span from UTC-8 to UTC+11 covering global operations
-- - Sales and event dates with timezone-aware scheduling
-- - Validation timestamps showing timezone-specific event entry times
--
-- MULTILINGUAL CONTENT:
-- - Event names and descriptions in local languages
-- - Ticket type descriptions in multiple languages including:
--   * Spanish, French, German, Japanese, Korean, Chinese, Hindi, Arabic, Thai, Portuguese
-- - Validation locations with local naming conventions
-- - Currency amounts reflecting local pricing (COP, EUR, JPY, INR, AED, USD, etc.)
--
-- TICKET RESERVATION LIFECYCLE:
-- - Active reservations: Currently being held for users across time zones
-- - Confirmed reservations: Successfully converted to international purchases  
-- - Expired reservations: Automatically released due to timeout
-- - Cancelled reservations: Manually cancelled by international users
-- - Released reservations: Manually released by system administrators
--
-- VALIDATION SCENARIOS:
-- - Multiple validation methods: QR_SCAN, MANUAL, NFC, MOBILE_APP
-- - Timezone-aware validation timestamps for global events
-- - Location-specific validation points in different languages
-- - Staff members with culturally appropriate names for each region
--
-- REALISTIC DATE SCENARIOS:
-- - Near-term ACTIVE events (February-March 2025) for testing current sales
-- - Mid-term PUBLISHED events (throughout 2025) for regular sales testing
-- - Long-term DRAFT events (2026) for planning scenarios
-- - Historical COMPLETED events (2024) for archival data testing
--
-- This dataset enables comprehensive testing of:
-- - ZonedDateTime handling across multiple time zones
-- - International event management and ticketing
-- - Multi-currency pricing and reservation systems
-- - Cross-cultural user experience validation
-- - Global event validation and access control systems
-- - Realistic business scenarios with appropriate event timing
