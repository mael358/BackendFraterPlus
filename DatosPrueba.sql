-- Datos de prueba para la tabla Proveedor
INSERT INTO proveedor (nombres, apellidos, direccion, nit, DPI) VALUES
('Carlos', 'Martínez', 'Zona 1, Ciudad de Guatemala', '12345678', '1234567890101'),
('María', 'López', 'Zona 10, Ciudad de Guatemala', '87654321', '0102030405060'),
('Juan', 'Pérez', 'Zona 12, Ciudad de Guatemala', '13572468', '0204060801020'),
('Ana', 'González', 'Zona 3, Ciudad de Guatemala', '24681357', '0405060708091'),
('Luis', 'Rodríguez', 'Zona 5, Ciudad de Guatemala', '97531864', '0607080901012');

-- Datos de prueba para la tabla Cliente
INSERT INTO cliente (nombres, apellidos, fechaNacimiento, edad, direccion, nit, DPI) VALUES
('Luis', 'González', '1985-05-20 00:00:00', 39, 'Zona 1, Ciudad de Guatemala', '12345678', '1234567890102'),
('Ana', 'Rodríguez', '1990-11-15 00:00:00', 33, 'Zona 5, Ciudad de Guatemala', '87654321', '0102030405061'),
('Carlos', 'Méndez', '1980-08-25 00:00:00', 44, 'Zona 10, Ciudad de Guatemala', '13572468', '0204060801021'),
('Julia', 'Hernández', '1995-07-10 00:00:00', 29, 'Zona 7, Ciudad de Guatemala', '46802468', '0301020507061'),
('Fernando', 'Ruiz', '1975-09-30 00:00:00', 49, 'Zona 3, Ciudad de Guatemala', '97531864', '0406070809012');

-- Datos de prueba para la tabla Articulo
INSERT INTO articulo (nombre, descripcion, valorCosto, valorVenta) VALUES
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

-- Datos de prueba para la tabla Compra
INSERT INTO compra (fecha, proveedorId) VALUES
('2024-09-01 10:30:00', 1),
('2024-09-02 14:45:00', 2),
('2024-09-03 09:15:00', 3),
('2024-09-04 11:00:00', 4),
('2024-09-05 16:20:00', 5);

-- Datos de prueba para la tabla Pedido
INSERT INTO pedido (fechaCreacion, Clienteid, Estadoid) VALUES
('2024-09-01 10:00:00', 1, 1),  -- Pedido de cliente 1 en estado 'Pendiente'
('2024-09-02 11:30:00', 2, 2),  -- Pedido de cliente 2 en estado 'Procesado'
('2024-09-03 15:45:00', 3, 3),  -- Pedido de cliente 3 en estado 'Enviado'
('2024-09-04 09:20:00', 1, 4),  -- Pedido de cliente 1 en estado 'Entregado'
('2024-09-05 12:10:00', 2, 5);  -- Pedido de cliente 2 en estado 'Cancelado'

-- Datos de prueba para la tabla Factura
INSERT INTO factura (nitEmisor, nombreEmisor, montoTotal, direccionEmisor, tipoFactura, departamentoReceptor, Clienteid, Pedidoid) VALUES
('12345678', 'Distribuidora X', 5200.00, 'Zona 1, Ciudad de Guatemala', 0, 'Guatemala', 1, 1), -- Factura de contado para el cliente 1, pedido 1
('87654321', 'Distribuidora Y', 200.00, 'Zona 5, Ciudad de Guatemala', 1, 'Guatemala', 2, 2),  -- Factura de crédito para el cliente 2, pedido 2
('13572468', 'Distribuidora Z', 250.00, 'Zona 10, Ciudad de Guatemala', 0, 'Guatemala', 3, 3), -- Factura de contado para el cliente 3, pedido 3
('46802468', 'Distribuidora A', 3200.00, 'Zona 7, Ciudad de Guatemala', 1, 'Escuintla', 1, 4),  -- Factura de crédito para el cliente 1, pedido 4
('97531864', 'Distribuidora B', 450.00, 'Zona 3, Ciudad de Guatemala', 0, 'Guatemala', 2, 5);  -- Factura de contado para el cliente 2, pedido 5

-- Datos de prueba para la tabla Lote
INSERT INTO lote (fechaVencimiento, cantidadInicial, cantidadDisponible, Articuloid, compraId) VALUES
('2025-12-31 00:00:00', 50, 50, 1, 1),  -- Lote para el artículo 1 (Laptop HP) asociado a la compra 1
('2025-06-30 00:00:00', 100, 80, 2, 2),  -- Lote para el artículo 2 (Mouse Logitech) asociado a la compra 2
('2024-11-30 00:00:00', 60, 60, 3, 3),  -- Lote para el artículo 3 (Teclado mecánico) asociado a la compra 3
('2026-01-15 00:00:00', 40, 40, 4, 4),  -- Lote para el artículo 4 (Monitor Samsung) asociado a la compra 4
('2024-10-31 00:00:00', 30, 25, 5, 5);  -- Lote para el artículo 5 (Impresora Epson) asociado a la compra 5

-- Datos de prueba para la tabla MovimientoLote
INSERT INTO movimiento_lote (tipoMovimiento, cantidad, fechaMovimiento, referenciaDetalleFactura, loteid) VALUES
(1, 50, '2024-09-01 10:30:00', NULL, 1),  -- Entrada de 50 unidades al lote 1 (Laptop HP)
(0, 5, '2024-09-02 14:00:00', 1, 1),      -- Salida de 5 unidades del lote 1, asociada al detalle de factura 1
(1, 100, '2024-09-02 15:00:00', NULL, 2), -- Entrada de 100 unidades al lote 2 (Mouse Logitech)
(0, 10, '2024-09-03 16:00:00', 2, 2),     -- Salida de 10 unidades del lote 2, asociada al detalle de factura 2
(1, 60, '2024-09-03 17:00:00', NULL, 3),  -- Entrada de 60 unidades al lote 3 (Teclado mecánico)
(0, 15, '2024-09-04 18:00:00', 3, 3),     -- Salida de 15 unidades del lote 3, asociada al detalle de factura 3
(1, 40, '2024-09-05 19:00:00', NULL, 4),  -- Entrada de 40 unidades al lote 4 (Monitor Samsung)
(0, 5, '2024-09-06 20:00:00', 4, 4);      -- Salida de 5 unidades del lote 4, asociada al detalle de factura 4

-- Datos de prueba para la tabla Detalle_Factura
INSERT INTO detalle_Factura (cantidad, precioUnitario, noLinea, Facturaid, Articuloid) VALUES
(1, 5000.00, 1, 1, 1),  -- 1 Laptop HP a 5000.00 en la factura 1, línea 1
(2, 200.00, 2, 1, 2),   -- 2 Mouse Logitech a 200.00 en la factura 1, línea 2
(1, 200.00, 1, 2, 2),   -- 1 Mouse Logitech a 200.00 en la factura 2, línea 1
(1, 250.00, 1, 3, 3),   -- 1 Teclado mecánico a 250.00 en la factura 3, línea 1
(1, 950.00, 1, 4, 4),   -- 1 Monitor Samsung a 950.00 en la factura 4, línea 1
(1, 1500.00, 2, 4, 5),  -- 1 Impresora Epson a 1500.00 en la factura 4, línea 2
(1, 450.00, 1, 5, 5);   -- 1 Impresora Epson a 450.00 en la factura 5, línea 1

-- Datos de prueba para la tabla PedidoDetalle
INSERT INTO pedido_detalle (linea, cantidad, Articuloid, Pedidoid) VALUES
(1, 1, 1, 1),  -- 1 Laptop HP en el pedido 1, línea 1
(2, 2, 2, 1),  -- 2 Mouse Logitech en el pedido 1, línea 2
(1, 1, 2, 2),  -- 1 Mouse Logitech en el pedido 2, línea 1
(1, 1, 3, 3),  -- 1 Teclado mecánico en el pedido 3, línea 1
(1, 1, 4, 4),  -- 1 Monitor Samsung en el pedido 4, línea 1
(2, 1, 5, 4),  -- 1 Impresora Epson en el pedido 4, línea 2
(1, 1, 5, 5);  -- 1 Impresora Epson en el pedido 5, línea 1

-- Datos de prueba para la tabla Usuario
INSERT INTO usuario (nombre, username, password, enabled, apellido, email) VALUES
('Juan', 'jmartinez', 'hashedpassword1', 1, 'Martínez', 'juan.martinez@example.com'), -- Usuario activo
('María', 'mlopez', 'hashedpassword2', 1, 'López', 'maria.lopez@example.com'),       -- Usuario activo
('Carlos', 'cperez', 'hashedpassword3', 0, 'Pérez', 'carlos.perez@example.com'),     -- Usuario inactivo
('Ana', 'agonzalez', 'hashedpassword4', 1, 'González', 'ana.gonzalez@example.com'),  -- Usuario activo
('Luis', 'lrodriguez', 'hashedpassword5', 1, 'Rodríguez', 'luis.rodriguez@example.com'); -- Usuario activo

-- Datos de prueba para la tabla Rol
INSERT INTO rol (nombre, descripcion) VALUES
('Administrador', 'Tiene acceso completo a todas las funcionalidades del sistema'),
('Vendedor', 'Acceso a la gestión de ventas y pedidos'),
('Almacén', 'Acceso a la gestión de inventarios y lotes'),
('Soporte', 'Acceso a la atención al cliente y resolución de problemas'),
('Gerente', 'Acceso a reportes y decisiones estratégicas del negocio');

-- Datos de prueba para la tabla UsuarioRol
INSERT INTO usuario_rol (Usuarioid, Rolid) VALUES
(1, 1),  -- El usuario 1 (Juan Martínez) tiene el rol de Administrador
(2, 2),  -- El usuario 2 (María López) tiene el rol de Vendedor
(3, 3),  -- El usuario 3 (Carlos Pérez) tiene el rol de Almacén
(4, 4),  -- El usuario 4 (Ana González) tiene el rol de Soporte
(5, 5),  -- El usuario 5 (Luis Rodríguez) tiene el rol de Gerente
(1, 5),  -- El usuario 1 (Juan Martínez) también tiene el rol de Gerente
(2, 4);  -- El usuario 2 (María López) también tiene el rol de Soporte

