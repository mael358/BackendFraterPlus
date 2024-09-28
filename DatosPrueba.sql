-- Datos de prueba para la tabla Proveedor
INSERT INTO proveedor (nombres, direccion, nit, DPI) VALUES
('Carlos', 'Zona 1, Ciudad de Guatemala', '12345678', '1234567890101'),
('María', 'Zona 10, Ciudad de Guatemala', '87654321', '0102030405060'),
('Juan', 'Zona 12, Ciudad de Guatemala', '13572468', '0204060801020'),
('Ana', 'Zona 3, Ciudad de Guatemala', '24681357', '0405060708091'),
('Luis', 'Zona 5, Ciudad de Guatemala', '97531864', '0607080901012');

-- Datos de prueba para la tabla Cliente
INSERT INTO cliente (nombres, fecha_nacimiento, edad, direccion, nit, DPI) VALUES
('Luis', '1985-05-20 00:00:00', 39, 'Zona 1, Ciudad de Guatemala', '12345678', '1234567890102'),
('Ana', '1990-11-15 00:00:00', 33, 'Zona 5, Ciudad de Guatemala', '87654321', '0102030405061'),
('Carlos', '1980-08-25 00:00:00', 44, 'Zona 10, Ciudad de Guatemala', '13572468', '0204060801021'),
('Julia', '1995-07-10 00:00:00', 29, 'Zona 7, Ciudad de Guatemala', '46802468', '0301020507061'),
('Fernando', '1975-09-30 00:00:00', 49, 'Zona 3, Ciudad de Guatemala', '97531864', '0406070809012');

-- Datos de prueba para la tabla Articulo
INSERT INTO articulo (nombre, descripcion, valor_costo, valor_venta) VALUES
('Laptop HP', 'Laptop HP Core i5, 8GB RAM, 256GB SSD', 4500.00, 5000.00),
('Mouse Logitech', 'Mouse inalámbrico Logitech, color negro', 150.00, 200.00),
('Teclado mecánico', 'Teclado mecánico RGB, con interruptores cherry blue', 200.00, 250.00),
('Monitor Samsung', 'Monitor Samsung 24 pulgadas, Full HD', 800.00, 950.00),
('Impresora Epson', 'Impresora Epson EcoTank, multifuncional a color', 1200.00, 1500.00);

-- Datos de prueba para la tabla Estado
INSERT INTO estado (descripcion) VALUES
('Pendiente'),
('Procesado'),
('Enviado'),
('Entregado'),
('Cancelado');

-- Datos de prueba para la tabla Pedido
INSERT INTO pedido (observaciones, fecha_creacion, cliente_id, estado_id) VALUES
('Pedido urgente', '2024-09-01 10:00:00', 6, 1),
('Pedido normal', '2024-09-02 11:30:00', 7, 2),
('Pedido express', '2024-09-03 15:45:00', 8, 3),
('Pedido de seguimiento', '2024-09-04 09:20:00', 9, 4),
('Pedido cancelado por el cliente', '2024-09-05 12:10:00', 10, 5);

-- Datos de prueba para la tabla Factura con fecha de creación actual
INSERT INTO factura (
    no_factura,
    nit_emisor,
    observaciones,
    nombre_emisor,
    monto_total,
    direccion_emisor,
    tipo_factura,
    departamento_receptor,
    fecha_creacion,
    cliente_id,
    pedido_id,
    proveedor_id
) VALUES
      ('F001', '12345678', 'Factura correspondiente al pedido 1', 'Distribuidora X', 5200.00, 'Zona 1, Ciudad de Guatemala', 0, 'Guatemala', NOW(), 6, 11, 1),
      ('F002', '87654321', 'Factura correspondiente al pedido 2', 'Distribuidora Y', 200.00, 'Zona 5, Ciudad de Guatemala', 1, 'Guatemala', NOW(), 7, 12, 2),
      ('F003', '13572468', 'Factura correspondiente al pedido 3', 'Distribuidora Z', 250.00, 'Zona 10, Ciudad de Guatemala', 0, 'Guatemala', NOW(), 8, 13, 3),
      ('F004', '46802468', 'Factura correspondiente al pedido 4', 'Distribuidora A', 3200.00, 'Zona 7, Ciudad de Guatemala', 1, 'Escuintla', NOW(), 9, 14, 4),
      ('F005', '97531864', 'Factura correspondiente al pedido 5', 'Distribuidora B', 450.00, 'Zona 3, Ciudad de Guatemala', 0, 'Guatemala', NOW(), 10, 15, 5);


-- Datos de prueba para la tabla Detalle_Factura
INSERT INTO detalle_Factura (cantidad, precio_unitario, no_linea, factura_id, articulo_id) VALUES
(1, 5000.00, 1, 21, 1),
(2, 200.00, 2, 21, 2),
(1, 200.00, 1, 22, 2),
(1, 250.00, 1, 23, 3);


-- Datos de prueba para la tabla Pedido_Detalle
INSERT INTO pedido_detalle (linea, cantidad, precio_ofertado, articulo_id, pedido_id) VALUES
(1, 1, 5000.00, 1, 11),
(2, 2, 200.00, 2, 11),
(1, 1, 200.00, 2, 12),
(1, 1, 250.00, 3, 13),
(1, 1, 950.00, 4, 14),
(2, 1, 1500.00, 5, 14),
(1, 1, 1500.00, 5, 15);

-- Datos de prueba para la tabla Usuario (correo corregido)
INSERT INTO usuario (nombre, username, password, enabled, apellido, email) VALUES
('Juan', 'jmartinez', '$2y$10$eBxfz5qY3Z2bP4sdjXk5tuZF4fX1bE3OfxKjlJv/kVrXEQ0S5/BLC', 1, 'Martínez', 'juan.martinez@example.com'), -- Contraseña: password1
('María', 'mlopez', '$2y$10$Yj3DkYpVv.xUQ9XG/dSbAu8E66qKAGjIZaW/y3KObBuOVcZpFdqcK', 1, 'López', 'maria.lopez@example.com'),       -- Contraseña: password2
('Carlos', 'cperez', '$2y$10$LZjIyEtQUbw13zC0BcN1OeubrxGMxYIBdu9s4d6gTiKz4Yl/XVUqi', 0, 'Pérez', 'carlos.perez@example.com'),     -- Contraseña: password3
('Ana', 'agonzalez', '$2y$10$RcMsAqwZFKZxB2Y2jVE3EesqZqZ6V3HygzXJpJGbJHmkbZp/s1Zse', 1, 'González', 'ana.gonzalez@example.com'),  -- Contraseña: password4
('Luis', 'lrodriguez', '$2y$10$E49gwNTUUL1c8fVYj13I/.bW5olITtXz9zpgo1aMufxHHZcxbPuXO', 1, 'Rodríguez', 'luis.rodriguez@example.com'),
('Diego', 'dialvehid', '$2a$12$NOOJu.lN7GtEi1SUvlFA0u1GAL3juAhRDmAx5cQA2WJ39Xlih1U/2', 1, 'Velasquez', 'skdiego27@gmail.com'); -- Contraseña: password5

-- Datos de prueba para la tabla Rol
INSERT INTO rol (nombre, descripcion) VALUES
('Administrador', 'Tiene acceso completo a todas las funcionalidades del sistema'),
('Vendedor', 'Acceso a la gestión de ventas y pedidos'),
('Almacén', 'Acceso a la gestión de inventarios y lotes'),
('Soporte', 'Acceso a la atención al cliente y resolución de problemas'),
('Gerente', 'Acceso a reportes y decisiones estratégicas del negocio');

-- Datos de prueba para la tabla Usuario_Rol
INSERT INTO usuario_rol (usuario_id, rol_id) VALUES
(1, 1),  -- El usuario 1 (Juan Martínez) tiene el rol de Administrador
(2, 2),  -- El usuario 2 (María López) tiene el rol de Vendedor
(3, 3),  -- El usuario 3 (Carlos Pérez) tiene el rol de Almacén
(4, 4),  -- El usuario 4 (Ana González) tiene el rol de Soporte
(5, 5),  -- El usuario 5 (Luis Rodríguez) tiene el rol de Gerente
(1, 5),  -- El usuario 1 (Juan Martínez) también tiene el rol de Gerente
(2, 4);  -- El usuario 2 (María López) también tiene el rol de Soporte

-- Datos de prueba para la tabla Lote
INSERT INTO lote (fecha_vencimiento, cantidad_inicial, cantidad_disponible, articulo_id, compra_id) VALUES
('2025-12-31 00:00:00', 50, 45, 1, 1),
('2025-06-30 00:00:00', 100, 90, 2, 2),
('2024-11-30 00:00:00', 60, 45, 3, 3),
('2026-01-15 00:00:00', 40, 35, 4, 4),
('2024-10-31 00:00:00', 30, 25, 5, 5);


-- Datos de prueba para la tabla Movimiento_Lote
INSERT INTO movimiento_lote (tipo_movimiento, cantidad, fecha_movimiento, referencia_detalle_factura, lote_id) VALUES
(1, 50, '2024-09-01 10:30:00', NULL, 1),  -- Entrada de 50 unidades al lote 1
(0, 5, '2024-09-02 14:00:00', 1, 1),      -- Salida de 5 unidades del lote 1, referencia a detalle_factura 1
(1, 100, '2024-09-02 15:00:00', NULL, 2), -- Entrada de 100 unidades al lote 2
(0, 10, '2024-09-03 16:00:00', 2, 2),     -- Salida de 10 unidades del lote 2, referencia a detalle_factura 2
(1, 60, '2024-09-03 17:00:00', NULL, 3),  -- Entrada de 60 unidades al lote 3
(0, 15, '2024-09-04 18:00:00', 3, 3),     -- Salida de 15 unidades del lote 3, referencia a detalle_factura 3
(1, 40, '2024-09-05 19:00:00', NULL, 4),  -- Entrada de 40 unidades al lote 4
(0, 5, '2024-09-06 20:00:00', 4, 4);      -- Salida de 5 unidades del lote 4, referencia a detalle_factura 4