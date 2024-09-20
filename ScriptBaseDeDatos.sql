-- Tabla de proveedor
CREATE TABLE proveedor (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           nombres VARCHAR(150) NOT NULL COMMENT 'Nombres del proveedor',
                           apellidos VARCHAR(150) COMMENT 'Apellidos del proveedor',
                           direccion VARCHAR(255) NULL COMMENT 'Dirección del proveedor',
                           nit VARCHAR(40) NOT NULL COMMENT 'Número de Identificación Tributaria del proveedor',
                           DPI VARCHAR(40) NULL COMMENT 'Documento Personal de Identificación del proveedor'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla que almacena la información de los proveedor';

-- Tabla de cliente
CREATE TABLE cliente (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         nombres VARCHAR(150) NOT NULL COMMENT 'Nombres del cliente',
                         apellidos VARCHAR(150) NOT NULL COMMENT 'Apellidos del cliente',
                         fecha_nacimiento TIMESTAMP NULL COMMENT 'Fecha de nacimiento del cliente',
                         edad INT NULL COMMENT 'Edad del cliente calculada a partir de la fecha de nacimiento',
                         direccion VARCHAR(255) NULL COMMENT 'Dirección del cliente',
                         nit VARCHAR(40) NULL COMMENT 'Número de Identificación Tributaria del cliente',
                         DPI VARCHAR(40) NULL COMMENT 'Documento Personal de Identificación del cliente'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla que almacena la información de los clientes';

-- Tabla articulo
CREATE TABLE articulo (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(255) NOT NULL COMMENT 'Nombre del artículo',
                          descripcion VARCHAR(255) NULL COMMENT 'Descripción detallada del artículo',
                          valor_costo DECIMAL(19,4) NOT NULL COMMENT 'Costo unitario del artículo',
                          valor_venta DECIMAL(19,4) NOT NULL COMMENT 'Precio de venta unitario del artículo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla que almacena la información de los artículos o productos';

-- Tabla de estado de pedido
CREATE TABLE estado (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        descripcion VARCHAR(255) NOT NULL COMMENT 'Descripción del estado del pedido'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla que define los posibles estados de un pedido';

-- Tabla de compras
CREATE TABLE compra (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        fecha TIMESTAMP NOT NULL COMMENT 'Fecha de la compra',
                        proveedor_id INT NOT NULL COMMENT 'ID del proveedor al que le compramos',
                        FOREIGN KEY (proveedor_id) REFERENCES proveedor(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla que almacena la información de las facturas emitidas';

-- Tabla de pedido
CREATE TABLE pedido (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        fecha_creacion TIMESTAMP NOT NULL COMMENT 'Fecha y hora en que se creó el pedido',
                        cliente_id INT NOT NULL COMMENT 'Identificador del cliente que realizó el pedido',
                        estado_id INT NOT NULL COMMENT 'Identificador del estado actual del pedido',
                        FOREIGN KEY (cliente_id) REFERENCES cliente(id),
                        FOREIGN KEY (estado_id) REFERENCES estado(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla que registra los pedidos realizados por los clientes';

-- Tabla de factura
CREATE TABLE factura (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         nit_emisor VARCHAR(40) NOT NULL COMMENT 'Número de Identificación Tributaria del emisor de la factura',
                         nombre_emisor VARCHAR(150) NOT NULL COMMENT 'Nombre del emisor de la factura',
                         monto_total DECIMAL(19,4) NOT NULL COMMENT 'Monto total de la factura',
                         direccion_emisor VARCHAR(255) NOT NULL COMMENT 'Dirección del emisor de la factura',
                         tipo_factura BIT NOT NULL COMMENT 'Tipo de factura (1: Crédito, 0: Contado)',
                         departamento_receptor VARCHAR(100) NULL COMMENT 'Departamento al que se envía la factura',
                         cliente_id INT NOT NULL COMMENT 'Identificador del cliente relacionado con la factura',
                         pedido_id INT NOT NULL COMMENT 'Identificador del pedido relacionado con la factura',
                         FOREIGN KEY (cliente_id) REFERENCES cliente(id),
                         FOREIGN KEY (pedido_id) REFERENCES pedido(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla que almacena la información de las facturas emitidas';

-- Tabla lote
CREATE TABLE lote (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      fecha_vencimiento TIMESTAMP NULL COMMENT 'Fecha de vencimiento de los productos del lote',
                      cantidad_inicial INT NOT NULL COMMENT 'Cantidad inicial de artículos en el lote',
                      cantidad_disponible INT NOT NULL COMMENT 'Cantidad disponible de artículos en el lote',
                      articulo_id INT NOT NULL COMMENT 'Identificador del artículo asociado al lote',
                      compra_id INT NOT NULL COMMENT 'Identificador para asociacion con compras',
                      FOREIGN KEY (articulo_id) REFERENCES articulo(id),
                      FOREIGN KEY (compra_id) REFERENCES compra(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla que almacena la información sobre los lotes de productos';

-- Tabla de movimiento lote
CREATE TABLE movimiento_lote (
                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 tipo_movimiento BIT NOT NULL COMMENT 'Tipo de movimiento (1: Entrada, 0: Salida)',
                                 cantidad INT NOT NULL COMMENT 'Cantidad de artículos afectados por el movimiento',
                                 fecha_movimiento TIMESTAMP NOT NULL COMMENT 'Fecha y hora del movimiento del lote',
                                 referencia_detalle_factura INT NULL COMMENT 'Referencia al detalle de factura asociado al movimiento (si aplica)',
                                 lote_id INT NOT NULL COMMENT 'Identificador del lote al que pertenece el movimiento',
                                 FOREIGN KEY (lote_id) REFERENCES lote(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla que registra los movimientos de stock dentro de cada lote';

-- Tabla de Detalle_Factura
CREATE TABLE detalle_Factura (
                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 cantidad INT NOT NULL COMMENT 'Cantidad de artículos incluidos en la línea de la factura',
                                 precio_unitario DECIMAL(19,4) NOT NULL COMMENT 'Precio unitario de cada artículo en la línea de la factura',
                                 no_linea INT NOT NULL COMMENT 'Número de línea dentro de la factura',
                                 factura_id INT NOT NULL COMMENT 'Identificador de la factura a la que pertenece el detalle',
                                 articulo_id INT NOT NULL COMMENT 'Identificador del artículo asociado a la línea de la factura',
                                 FOREIGN KEY (factura_id) REFERENCES factura(id),
                                 FOREIGN KEY (articulo_id) REFERENCES articulo(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla que detalla los productos incluidos en una factura específica';

-- Tabla de pedido_detalle
CREATE TABLE pedido_detalle (
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                linea INT NOT NULL COMMENT 'Número de línea dentro del pedido',
                                cantidad INT NOT NULL COMMENT 'Cantidad de artículos solicitados en la línea del pedido',
                                articulo_id INT NOT NULL COMMENT 'Identificador del artículo asociado a la línea del pedido',
                                pedido_id INT NOT NULL COMMENT 'Identificador del pedido al que pertenece el detalle',
                                FOREIGN KEY (articulo_id) REFERENCES articulo(id),
                                FOREIGN KEY (pedido_id) REFERENCES pedido(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla que detalla los artículos específicos incluidos en cada pedido';

-- Tabla de estado de pedido
CREATE TABLE usuario (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         nombre VARCHAR(150) NOT NULL COMMENT 'Nombre del usuario',
                         username VARCHAR(100) NOT NULL COMMENT 'Nombre de usuario para acceder al sistema',
                         password VARCHAR(255) NOT NULL COMMENT 'Contraseña del usuario',
                         enabled BIT NOT NULL COMMENT 'Estado del usuario (1: Activo, 0: Inactivo)',
                         apellido VARCHAR(150) NOT NULL COMMENT 'Apellido del usuario',
                         email VARCHAR(255) NOT NULL COMMENT 'Correo electrónico del usuario'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla que almacena la información de los usuarios del sistema';

-- Tabla de rol
CREATE TABLE rol (
                     id INT AUTO_INCREMENT PRIMARY KEY,
                     nombre VARCHAR(150) NOT NULL COMMENT 'Nombre del rol',
                     descripcion VARCHAR(255) NOT NULL COMMENT 'Descripción del rol'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla que define los roles asignados a los usuarios del sistema';

-- Tabla de usuario_rol
CREATE TABLE usuario_rol (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             usuario_id INT NOT NULL COMMENT 'Identificador del usuario al que se le asigna el rol',
                             rol_id INT NOT NULL COMMENT 'Identificador del rol asignado al usuario',
                             FOREIGN KEY (usuario_id) REFERENCES usuario(id),
                             FOREIGN KEY (rol_id) REFERENCES rol(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla que relaciona a los usuarios con sus roles dentro del sistema';