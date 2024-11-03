INSERT INTO FraterPlus.articulo (nombre, descripcion, valor_costo, valor_venta)
VALUES
    ('Caja lapiceros faber castel negro', '12 lapiceros faber castel negro', 25.50, 35.00),
    ('Resma de papel', '1000 hojas de papel', 15.00, 20.00),
    ('Lapiz Maped', 'Caja de 12 lapices maped', 20.00, 25.00),
    ('Laminas sistema solar', 'Juego de laminas del sistema solar', 80.00, 95.00),
    ('Caja de marcadores multicolor Faber Castel', 'Caja de 24 marcadores surtidos', 20.00, 35.00);

INSERT INTO FraterPlus.proveedor (nombres, direccion, nit, DPI, telefono, extension, correo)
VALUES
    ('VICTOR INTERNACIONAL', '7a Calle 9-14 zona 1 Guatemala', '6792731', '1234567890101', '2253 5405', null, null),
    ('DISTRIBUIDORA INESSIA II', '3A AV. 17-04 ZONA 1', '87654321', '0102030405060', '2285 1381', null, null),
    ('IMPORTADORA SACA, S.A.', '10 avenida 5-51 ZONA 1', '13572468', '0204060801020', '2232 8932 / 2253 2726', null, null),
    ('MICROSPACE COMUNICCIONES, S.A.', '12 CALLE 2-25 ZONA 1 APTO 1-C', '24681357', '0405060708091', '2285 0324', null, null),
    ('PLATINO', '5 AV 1-57 ZONA 9', '97531864', '0607080901012', '2410 9696', null, null);

INSERT INTO FraterPlus.cliente (nombres, fecha_creacion, edad, direccion, nit, DPI, correo, telefono, extension)
VALUES
    ('LIBRERÍA EL CENTRO', '2024-09-28 00:00:00', null, 'CALLE PRINCIPAL RÍO DULCE, LIVING TONS OFICINA RÍO DULCE LITESVA', null, null, 'libreriaelcentro@gmail.com', '7930-5207', null),
    ('LIBRERÍA Y PAPELERÍA JAYLINGE', '2024-09-28 00:00:00', null, '3AVE 1-61 ZONA 1 QUEZALTEPEQUE', null, null, 'jaylinge@gmail.com', '5853-2066', null),
    ('LIBRERÍA Y PAPELERÍA ARCAIR', '2024-09-28 00:00:00', null, '6AV 4-24 ZONA 1 ESQUIPULAS', null, null, 'arcair@gmail.com', '7943-0295', null),
    ('LIBRERÍA Y VARIEDADES ALISON', '2024-09-28 00:00:00', null, 'ENTRADA PRINCIPAL QUEZALTEPEQUE', null, null, 'alison@gmail.com', '4160-0254', null),
    ('LIBRERÍA EL ESTUDIANTE', '2024-09-28 00:00:00', null, '8 CALLE 5-44 ZONA 2 BARRIO LA REFORMA, ZACAPA', null, null, 'elestudiante@gmail.com', '7941-4874', null),
    ('LIBRERÍA Y VARIEDADES TITA', '2024-09-28 00:00:00', null, '1 CALLE 4-18 ZONA 9 QUEZALTEPEQUE', null, null, 'tita@gmail.com', '7944-0126', null),
    ('LIBRERÍA RABY', '2024-09-28 00:00:00', null, 'FRENTE A ESCUELA NACIONAL CONCEPCIÓN LAS MINAS', null, null, 'raby@gmail.com', '7943-8181', null),
    ('LIBRERÍA Y VARIEDADES MELY', '2024-09-28 00:00:00', null, 'PRÓXIMO IGLESIA EVANGÉLICA EL COMPLETO ESTANZUELA', null, null, 'mely@gmail.com', '7933-5355', null),
    ('LIBRERÍA Y PAPELERÍA MARGOT', '2024-09-28 00:00:00', null, '18 AV. Y 7 CALLE ZONA 3 ZACAPA', null, null, 'margot@gmail.com', '5757-5120', null),
    ('COMERCIAL GRACIELITA', '2024-09-28 00:00:00', null, 'BARRIO EL GOLFO GUASTATOYA', null, null, 'gracielita@gmail.com', '7945-1944', null),
    ('EXCLUSIVIDADES LAS GEMELAS', '2024-09-28 00:00:00', null, 'BARRIO EL CALVARIO, SAN LUIS JILOTEPEQUE', null, null, 'lasgemelas@gmail.com', '7923-7068', null),
    ('LIBRERÍA FRIDA MARIA', '2024-09-28 00:00:00', null, '2 CALLE 10-30 ZONA 1 CHIQUIMULA', null, null, 'fridamaria@gmail.com', '7741-6475', null),
    ('LIBRERÍA PAZ Y BIEN', '2024-09-28 00:00:00', null, '4 CALLE 5-39 ZONA 2 BARRIO CONCORDIA QUEZALTEPEQUE', null, null, 'pazybien@gmail.com', '5072-3806', null),
    ('LIBRERÍA MARYS', '2024-09-28 00:00:00', null, '7 AV. 7-15 ZONA 2 CARCHÁ, BARRIO SEBASTIAN', null, null, 'marys@gmail.com', '4086-9704', null),
    ('LIBRERÍA EL REGALITO', '2024-09-28 00:00:00', null, 'RUTA 4 4-30 ZONA 1 SALAMÁ', null, null, 'elregalito@gmail.com', '5847-4969', null),
    ('COMERCIAL SAMY', '2024-09-28 00:00:00', null, '5 CALLE 5-56 ZONA 1 SALAMÁ', null, null, 'sammy@gmail.com', '7940-1478', null),
    ('LIBRERÍA BETHEL', '2024-09-28 00:00:00', null, 'FRENTE A MERCADO TERMINAL SALAMÁ', null, null, 'bethel@gmail.com', '7954-5088', null),
    ('MISLANEA HISPANOAMERICANA', '2024-09-28 00:00:00', null, '1 CALLE 9-35 ZONA 1 COBÁN', null, null, 'hispanoamericana@gmail.com', '5259-9446 / 5608-1540', null),
    ('MULTISERVICIOS MANES', '2024-09-28 00:00:00', null, '1 AV 1-17 ZONA 8 COBÁN', null, null, 'manes@gmail.com', '7952-3600 / 7951-6964', null),
    ('LIBRERÍA LADY DY', '2024-09-28 00:00:00', null, '4 CALLE 11-31 ZONA 2 BARRIO SAN VICENTE COBÁN', null, null, 'ladydy@gmail.com', '7951-0484 / 7821-2343', null),
    ('INVERSIONES UNIDAS', '2024-09-28 00:00:00', null, 'CENTRO COMERCIAL PLAZA MAGDALENA COBÁN ALTA VERAPAZ', null, null, 'inversionesunidas@gmail.com', '7951-4454', null),
    ('COMERCIAL NATALIA', '2024-09-28 00:00:00', null, 'COSTADO MERCADO MUNICIPAL SAN JUAN CHAMELCO', null, null, 'natalia@gmail.com', '5036-3949', null),
    ('LIBRERÍA GABY', '2024-09-28 00:00:00', null, '2 CALLE 10-74 ZONA 4 BARRIO SAN MARCOS COBÁN', null, null, 'gaby@gmail.com', '7951-1634', null),
    ('LIBRERÍA Y PAPELERÍA SIERRA', '2024-09-28 00:00:00', null, '00AV. 1-27 ZONA 3 SAN JUAN, CHAUJATE', null, null, 'sierra@gmail.com', '7950-0334 / 7950-0481', null),
    ('LIBRERÍA TRAZOS', '2024-09-28 00:00:00', null, '1 CALLE 8-33 ZONA 4 BARRIO SAN MARCOS, COBÁN', null, null, 'trazos@gmail.com', '5929-0305 / 4145-4494', null),
    ('LIBRERÍA MANOLO', '2024-09-28 00:00:00', null, '3 AV. BARRIO SANITA ANA ZONA 1 SAN CRISTOBAL', null, null, 'manolo@gmail.com', '7950-4860', null),
    ('VARIEDADES Y BORDADOS MEILYN', '2024-09-28 00:00:00', null, 'BARRIO EL CENTRO SAN JUAN CHAMELCO', null, null, 'meilyn@gmail.com', '7950-0555', null),
    ('LIBRERÍA HERMANO PEDRO', '2024-09-28 00:00:00', null, '1 CALLE 0-15 ZONA 4 SAN CRISTOBAL', null, null, 'hermanopedro@gmail.com', '7950-4600', null),
    ('LIBRERÍA Y PAPELERÍA SAN PEDRO', '2024-09-28 00:00:00', null, '8 AV LOCAL MUNICIPAL NO. 22 BARRIO SAN PEDRO CARCHA COBÁN', null, null, 'sanpedro@gmail.com', '7954-5088', null),
    ('PAPELERÍA SANDHI', '2024-09-28 00:00:00', null, '4AV 4-28 ZONA 3 ALTA VERAPAZ', null, null, 'sandhi@gmail.com', '7951-2980', null),
    ('MARIO CHOC', '2024-09-28 00:00:00', null, '3 CALLE 0-23 ZONA 5 COLONIA CHICHOCHOL, COBÁN', null, null, 'mariochoc@gmail.com', '7952-1282', null),
    ('LIBRERÍA Y VARIEDADES PAOLA', '2024-09-28 00:00:00', null, 'COLONIA EL MICHEL SATOL LOTE 26 PTO. BARRIOS', null, null, 'paola@gmail.com', '5377-7822', null),
    ('LIBRERÍA LAS FLORES', '2024-09-28 00:00:00', null, 'BARRIO LAS FLORES GUALÁN ZACAPA', null, null, 'lasflores@gmail.com', '7933-2768', null),
    ('DISTRIBUIDORA GIRÓN', '2024-09-28 00:00:00', null, 'EDIFICIO DE LAS PRESTACIONES SANTO TOMÁS', null, null, 'girón@gmail.com', '7948-4316', null),
    ('LIBRERÍA Y COPICENTRO CHARLENE', '2024-09-28 00:00:00', null, 'BARRIO EL PORVENIR GUASTATOYA EL PROGRESO', null, null, 'charlene@gmail.com', '7945-0958', null),
    ('DISTRIBUIDORA LAS TRES MARÍAS', '2024-09-28 00:00:00', null, 'C.C. PLAN PRESTACIONES SANTO TOMÁS DE CASTILLA LOCAL 1 Y 2', null, null, 'lastresmarias@gmail.com', '7960-0982', null),
    ('LIBRERÍA LUCY', '2024-09-28 00:00:00', null, '3 CALLE Y 14 AVENIDA COL. SAN AUGUSTÍN STO. TOMÁS DE CASTILLA', null, null, 'lucy@gmail.com', '7948-3601', null),
    ('LIBRERÍA LA NUEVA', '2024-09-28 00:00:00', null, 'CALLE PRINCIPAL, MORALES IZABAL', null, null, 'lanueva@gmail.com', '7947-7367', null),
    ('LIBRERÍA DILCIA', '2024-09-28 00:00:00', null, 'BARRIO EL CARRIZAL MORALES IZABAL', null, null, 'dilcia@gmail.com', '4046-6495', null),
    ('LIBRERÍA JURÍDICA', '2024-09-28 00:00:00', null, 'CALZADA JUSTO RUFINO BARRIOS 160 CALLE PTO. BARRIOS', null, null, 'juridica@gmail.com', '7948-2042', null),
    ('LIBRERÍA CHEW', '2024-09-28 00:00:00', null, '9 CALLE Y 6 AV. PUERTO BARRIOS', null, null, 'chew@gmail.com', '7948-6261', null),
    ('CAFÉ INTERNET KARLITA', '2024-09-28 00:00:00', null, '4 AV LOTE 12 MANZANA 5 COL. SAN ANDRÉS STO. TOMÁS DE CASTILLA', null, null, 'karlita@gmail.com', '7945-3898', null),
    ('LWENDIS LIBRERÍA', '2024-09-28 00:00:00', null, '4 CALLE 1-22 ZONA 1 SAN FCO, EL ALTO TOTONICAPÁN', null, null, 'lwendis@gmail.com', '5992-0655', null),
    ('SUPERTIENDA Y LIBRERÍA EL TRIÁNGULO', '2024-09-28 00:00:00', null, 'ENTRADA CALZADA ARRIO EL PORVENIR MONJAS JALAPA', null, null, 'eltriangulo@gmail.com', '5360-8107', null),
    ('CENTRO FARMACIA', '2024-09-28 00:00:00', null, 'EL PROGRESO JUTIAPA', null, null, 'centrofarmacia@gmail.com', '7843-4923', null),
    ('LIBRERÍA GABRIEL', '2024-09-28 00:00:00', null, 'CARRIO EL PORVENIR MONJAS JALAPA', null, null, 'gabriel@gmail.com', '4066-0005', null),
    ('LIBRERÍA DBLOMIN', '2024-09-28 00:00:00', null, 'SAN JORGE KM. 55.5 LOTE 24 ZONA 4 CHIMALTENANGO', null, null, 'dblomin@gmail.com', '7839-5550', null),
    ('LIBRERÍA CLICK', '2024-09-28 00:00:00', null, 'BARRIO EL CENTRO CUILAPA SANTA ROSA', null, null, 'click@gmail.com', '5541-0528', null),
    ('LIBRERÍA NATTY', '2024-09-28 00:00:00', null, '2 CALLE 5-49 ZONA 3 BARRIO PATACA TECPÁN', null, null, 'natty@gmail.com', '4234-7759', null),
    ('LIBRERÍA EL ESTUDIANTE', '2024-09-28 00:00:00', null, '1 AV 1-56 ZONA 2 CUILAPA STA ROSA', null, null, 'elestudiante2@gmail.com', '7886-5569', null),
    ('LIBRERÍA FEBE', '2024-09-28 00:00:00', null, '2 CALLE 6-56 ZONA 3 BARRIO PATACA, TECPÁN', null, null, 'febe@gmail.com', '4234-7759', null),
    ('LIBRERÍA CLICK', '2024-09-28 00:00:00', null, '5 AV Y 5 CALLE ZONA 1 BARBERENA', null, null, 'click2@gmail.com', '7887-0596', null),
    ('JHONNY FLORES', '2024-09-28 00:00:00', null, 'CALLE PRINCIPAL BARRIO EL CENTRO CUILAPA', null, null, 'jhonnyflores@gmail.com', '7886-5353', null),
    ('MATERIALES DE COSTURA MARLYN', '2024-09-28 00:00:00', null, '2 AV 3-22 ZONA 1 SANTA LUCÍA COTZUMALGUAPA', null, null, 'marlyn@gmail.com', '7882-1501', null),
    ('PAPELERÍA Y CURIOSIDADES BFL', '2024-09-28 00:00:00', null, '6 AV 6-86 ZONA 3 ALDEA SAN ISIDRO CHAMAL, SAN PEDRO SAN MARCOS', null, null, 'bfl@gmail.com', '7762-9023', null),
    ('LIBRERÍA COPILAND', '2024-09-28 00:00:00', null, '1 CALLE 2-71 ZONA 4 CANTÓN EL MOSQUITO SAN PEDRO SAN MARCOS', null, null, 'copiland@gmail.com', '7760-3430', null),
    ('LIBRERÍA EBEN-EZER', '2024-09-28 00:00:00', null, '21 AVENIDA 9-09 ZONA 6', null, null, 'ebenezer@gmail.com', '7951-4352', null),
    ('LIBRERÍA LA SELECTA', '2024-09-28 00:00:00', null, '2 AV. 1-31 ZONA 3 COBÁN', null, null, 'laselecta@gmail.com', '792-1914', null),
    ('LIBRERÍA Y PAPELERÍA SHANDY', '2024-09-28 00:00:00', null, '2 AV. 4-28 ZONA 3 COBÁN', null, null, 'shandy@gmail.com', '792-1914', null),
    ('LIBRERÍA Y VARIEDADES GLORIA', '2024-09-28 00:00:00', null, '6 AV 6-36 ZONA 1 QUICHÉ', null, null, 'gloria@gmail.com', '7755-4045', null),
    ('LIBRERÍA EVANGÉLICA GUMARCAK', '2024-09-28 00:00:00', null, '1 AV 2-31 ZONA 5 QUICHÉ', null, null, 'gumarcak@gmail.com', '792-1914', null),
    ('TERESA IXCOY MENDOZA', '2024-09-28 00:00:00', null, '0 CALLE 9-33 ZONA 3 SANTA CRUZ QUICHÉ', null, null, 'teresamendoza@gmail.com', '5802-5850', null),
    ('LIBRERÍA JIREH', '2024-09-28 00:00:00', null, '3 CALLE 3-29 ZONA 1 EL TEJAR CHIMALTENANGO', null, null, 'jireh@gmail.com', '5672-9025', null),
    ('LIBRERÍA EL PADRINO', '2024-09-28 00:00:00', null, '7 CALLE 4-24 ZONA 4 SAN JUAN SACATEPÉQUEZ', null, null, 'elpadrino@gmail.com', '6630-2182', null),
    ('LIBRERÍA VICTORIA', '2024-09-28 00:00:00', null, 'SAN JOSÉ PINULA', null, null, 'victoria@gmail.com', '5262-5223 / 7872-3652', null),
    ('LIBRERÍA TOLEDO', '2024-09-28 00:00:00', null, '2 AV. 2-65 ZONA 2 COLONIA ACEITUNO MAZATENANGO', null, null, 'toledo@gmail.com', '7947-3826', null),
    ('LIBRERÍA EL ÉXITO', '2024-09-28 00:00:00', null, 'PARQUE REGRESO LOS AMATES IZABAL', null, null, 'exito@gmail.com', '7947-3826', null),
    ('TIENDA LISETH', '2024-09-28 00:00:00', null, '21 CALLE CALZADA JUSTO RUFINO BARRIOS', null, null, 'liseth@gmail.com', '5691-4954', null),
    ('LIBRERÍA Y COPICENTRO KARLITA', '2024-09-28 00:00:00', null, '8AV Y 12 CALLE PUERTO BARRIOS', null, null, 'copicentrokarla@gmail.com', '7948-6450', null),
    ('LIBRERÍA SEMA', '2024-09-28 00:00:00', null, 'BARRIO LAS FLORES GUALÁN ZACAPA', null, null, 'sema@gmail.com', '7933-0805', null),
    ('BENJAMIN', '2024-09-28 00:00:00', null, '1 CALLE 2-59 ZONA 1 CANTON PAJON PROXIMO TOPCENTER SAN SEBASTIAN REU', null, null, 'benjamin@gmail.com', '5406-1117 / 4569-3197', null),
    ('LIBRERÍA JIREH', '2024-09-28 00:00:00', null, '3 AV. 4-85 ZONA 1 TECÚN HUMAN', null, null, 'jireh2@gmail.com', '7776-6289', null),
    ('LIBRERÍA EL MAESTRO', '2024-09-28 00:00:00', null, '3AV. 1-70 ZONA 1 TECÚN HUMAN', null, null, 'elmaestro@gmail.com', '7776-6109', null),
    ('LIBRERÍA E IMPRENTA ALMA', '2024-09-28 00:00:00', null, '6 CALLE 5-31 ZONA 2 BARRIO EL ROSARIO COATEPEQUE', null, null, 'imprentaalma@gmail.com', '7775-4789 / 5125-2756', null),
    ('LIBRERÍA Y FOTOCOPIAS EL ESFUERZO', '2024-09-28 00:00:00', null, 'CC. PLAZA PASEO CALARIAL CATARINA SAN MARCOS', null, null, 'elesfuerzo@gmail.com', '5330-2144', null),
    ('LIBRERÍA LUCÍA', '2024-09-28 00:00:00', null, '8 CALLE 7-38 ZONA 2 BARRIO EL GUARDIÁN COATEPEQUE', null, null, 'lucia2@gmail.com', '7775-6000 / 5121-1170', null),
    ('LIBRERÍA LA BENDICIÓN', '2024-09-28 00:00:00', null, '5 CALLE 5-26 ZONA 2 SANTA LUCÍA COTZUMALGUAPA', null, null, 'labendicion@gmail.com', '7882-2236', null),
    ('LIBRERÍA TAZMANIA', '2024-09-28 00:00:00', null, 'CALZADA 15 DE SEPT. SANTA LUCÍA COTZ.', null, null, 'tazmania@gmail.com', '5938-6591', null),
    ('LIBRERÍA Y PIÑATERÍA WENDY', '2024-09-28 00:00:00', null, 'AV. CENTRAL PALÍN ESCUINTLA', null, null, 'wendy@gmail.com', '7824-6005', null);

-- Datos de prueba para la tabla Usuario (correo corregido)
INSERT INTO FraterPlus.usuario (nombre, username, password, enabled, apellido, email) VALUES
                                                                               ('Marcos', 'mvelasquez', '$2a$12$CL9rvW2ni.olqKkfYCxhkeqxOjmvR7.t6nIx0TLLSd3XeLUOnaKda', 1, 'Velasquez', 'mvelasquezh4@miumg.edu.gt'), -- Contraseña: hola123
                                                                               ('María', 'mlopez', '$2a$12$wcdCREGfpTmvpDPNukN7TubkffzfT6GaxozCHj6RIPih.z2nyWNBW', 1, 'López', 'maria.lopez@example.com'),       -- Contraseña: hola123
                                                                               ('Carlos', 'srodas', '$2a$12$5zBeWCHTRXRC4Ao1gfJ13.8hUY7dTtyk2mqCGyBXuPqgMxiZVB2KS', 0, 'Pérez', 'carlos.perez@example.com'),     -- Contraseña: hola123
                                                                               ('Ana', 'dvelasquez', '$2a$12$mMzuc4IGZYbDaJ5bZOn3DetWBO8PxPv.g55pAWrwphhprV2r76qhS', 1, 'González', 'ana.gonzalez@example.com'),  -- Contraseña: hola123
                                                                               ('Luis', 'lrodriguez', '$2y$10$E49gwNTUUL1c8fVYj13I/.bW5olITtXz9zpgo1aMufxHHZcxbPuXO', 1, 'Rodríguez', 'luis.rodriguez@example.com'),
                                                                               ('Diego', 'dialvehid', '$2a$12$NOOJu.lN7GtEi1SUvlFA0u1GAL3juAhRDmAx5cQA2WJ39Xlih1U/2', 1, 'Velasquez', 'skdiego27@gmail.com'); -- Contraseña: password5

-- Datos de prueba para la tabla Rol
INSERT INTO FraterPlus.rol (nombre, descripcion) VALUES
                                          ('ROLE_ADMIN', 'Tiene acceso completo a todas las funcionalidades del sistema'),
                                          ('Vendedor', 'Acceso a la gestión de ventas y pedidos'),
                                          ('Almacén', 'Acceso a la gestión de inventarios y lotes'),
                                          ('Soporte', 'Acceso a la atención al cliente y resolución de problemas'),
                                          ('Gerente', 'Acceso a reportes y decisiones estratégicas del negocio');

-- Datos de prueba para la tabla Usuario_Rol
INSERT INTO FraterPlus.usuario_rol (usuario_id, rol_id) VALUES
                                                 (1, 1),  -- El usuario 1 (Marcos Velasquez) tiene el rol de Administrador
                                                 (2, 1),  -- El usuario 2 (Misael Lopez) tiene el rol de Administrador
                                                 (3, 1),  -- El usuario 3 (Samuel Rodas) tiene el rol de Administrador
                                                 (4, 1),  -- El usuario 4 (Diego Velasquez) tiene el rol de Administrador
                                                 (5, 5),  -- El usuario 5 (Luis Rodríguez) tiene el rol de Gerente
                                                 (1, 5),  -- El usuario 1 (Juan Martínez) también tiene el rol de Gerente
                                                 (2, 4);  -- El usuario 2 (María López) también tiene el rol de Soporte

-- Datos de prueba para la tabla Estado
INSERT INTO FraterPlus.estado (descripcion) VALUES
                                     ('Pendiente'),
                                     ('Procesado'),
                                     ('Enviado'),
                                     ('Entregado'),
                                     ('Cancelado');

/*


-- Datos de prueba para la tabla Pedido
INSERT INTO pedido (observaciones, fecha_creacion, cliente_id, estado_id) VALUES
('Pedido urgente', '2024-09-01 10:00:00', 1, 1),
('Pedido normal', '2024-09-02 11:30:00', 2, 2),
('Pedido express', '2024-09-03 15:45:00', 3, 3),
('Pedido de seguimiento', '2024-09-04 09:20:00', 4, 4),
('Pedido cancelado por el cliente', '2024-09-05 12:10:00', 5, 5);

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
      ('F001', '12345678', 'Factura correspondiente al pedido 1', 'Distribuidora X', 5200.00, 'Zona 1, Ciudad de Guatemala', 0, 'Guatemala', NOW(), 1, 1, 1),
      ('F002', '87654321', 'Factura correspondiente al pedido 2', 'Distribuidora Y', 200.00, 'Zona 5, Ciudad de Guatemala', 1, 'Guatemala', NOW(), 2, 2, 2),
      ('F003', '13572468', 'Factura correspondiente al pedido 3', 'Distribuidora Z', 250.00, 'Zona 10, Ciudad de Guatemala', 0, 'Guatemala', NOW(), 3, 3, 3),
      ('F004', '46802468', 'Factura correspondiente al pedido 4', 'Distribuidora A', 3200.00, 'Zona 7, Ciudad de Guatemala', 1, 'Escuintla', NOW(), 4, 4, 4),
      ('F005', '97531864', 'Factura correspondiente al pedido 5', 'Distribuidora B', 450.00, 'Zona 3, Ciudad de Guatemala', 0, 'Guatemala', NOW(), 5, 5, 5);


-- Datos de prueba para la tabla Detalle_Factura
INSERT INTO detalle_Factura (cantidad, precio_unitario, no_linea, factura_id, articulo_id) VALUES
(1, 5000.00, 1, 1, 1),
(2, 200.00, 2, 1, 2),
(1, 200.00, 1, 2, 2),
(1, 250.00, 1, 3, 3);


-- Datos de prueba para la tabla Pedido_Detalle
INSERT INTO pedido_detalle (linea, cantidad, precio_ofertado, articulo_id, pedido_id) VALUES
(1, 1, 5000.00, 1, 1),
(2, 2, 200.00, 2, 1),
(1, 1, 200.00, 2, 2),
(1, 1, 250.00, 3, 3),
(1, 1, 950.00, 4, 4),
(2, 1, 1500.00, 5, 4),
(1, 1, 1500.00, 5, 5);

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

 */