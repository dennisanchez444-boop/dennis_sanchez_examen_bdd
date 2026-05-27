--creacion de la tabla
CREATE TABLE vuelos (
    id SERIAL PRIMARY KEY,
    codigo VARCHAR(10) NOT NULL UNIQUE,
    precio_boleto NUMERIC(10,2) NOT NULL CHECK (precio_boleto >= 0),
    asientos_disponibles INTEGER NOT NULL CHECK (asientos_disponibles >= 0)
);
ALTER TABLE vuelos ADD COLUMN destino VARCHAR(100);
--Inserts
INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('AA-101', 350.50, 25);
INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('LA-202', 420.00, 4);
INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('IB-303', 600.75, 0);
INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('AV-404', 180.20, 12);
INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('DL-505', 799.99, 2);
INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('UA-606', 510.10, 30);
INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('CM-707', 290.00, 1);
INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('AF-808', 910.00, 15);
INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('LH-909', 1000.00, 0);
INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('EK-111', 1200.50, 8);
INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('QR-222', 980.75, 5);
INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('BA-333', 450.00, 18);
INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('KL-444', 399.99, 3);
INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('AM-555', 275.60, 10);
INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('AC-666', 640.40, 0);
INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('TK-777', 830.00, 6);
INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('AZ-888', 515.15, 14);
INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('QF-999', 1500.00, 2);
INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('NH-123', 720.90, 20);
INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('CX-456', 890.00, 0);
--Consultas
SELECT * FROM vuelos;
-- Vuelos con menos de 5 asientos
SELECT * FROM vuelos WHERE asientos_disponibles < 5;
-- Incrementar precio en 15% para un vuelo específico
UPDATE vuelos SET precio_boleto = precio_boleto * 1.15 WHERE id = 1;
-- Eliminar vuelos con 0 asientos
DELETE FROM vuelos WHERE asientos_disponibles = 0;