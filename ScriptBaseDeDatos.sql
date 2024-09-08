USE FraterPlus;

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
                         fechaNacimiento TIMESTAMP NULL COMMENT 'Fecha de nacimiento del cliente',
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
                          valorCosto DECIMAL(19,4) NOT NULL COMMENT 'Costo unitario del artículo',
                          valorVenta DECIMAL(19,4) NOT NULL COMMENT 'Precio de venta unitario del artículo'
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
                        proveedorId INT NOT NULL COMMENT 'ID del proveedor al que le compramos',
                        FOREIGN KEY (proveedorId) REFERENCES proveedor(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla que almacena la información de las facturas emitidas';

-- Tabla de pedido
CREATE TABLE pedido (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        fechaCreacion TIMESTAMP NOT NULL COMMENT 'Fecha y hora en que se creó el pedido',
                        Clienteid INT NOT NULL COMMENT 'Identificador del cliente que realizó el pedido',
                        Estadoid INT NOT NULL COMMENT 'Identificador del estado actual del pedido',
                        FOREIGN KEY (Clienteid) REFERENCES cliente(id),
                        FOREIGN KEY (Estadoid) REFERENCES estado(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla que registra los pedidos realizados por los clientes';

-- Tabla de factura
CREATE TABLE factura (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         nitEmisor VARCHAR(40) NOT NULL COMMENT 'Número de Identificación Tributaria del emisor de la factura',
                         nombreEmisor VARCHAR(150) NOT NULL COMMENT 'Nombre del emisor de la factura',
                         montoTotal DECIMAL(19,4) NOT NULL COMMENT 'Monto total de la factura',
                         direccionEmisor VARCHAR(255) NOT NULL COMMENT 'Dirección del emisor de la factura',
                         tipoFactura BIT NOT NULL COMMENT 'Tipo de factura (1: Crédito, 0: Contado)',
                         departamentoReceptor VARCHAR(100) NULL COMMENT 'Departamento al que se envía la factura',
                         Clienteid INT NOT NULL COMMENT 'Identificador del cliente relacionado con la factura',
                         Pedidoid INT NOT NULL COMMENT 'Identificador del pedido relacionado con la factura',
                         FOREIGN KEY (Clienteid) REFERENCES cliente(id),
                         FOREIGN KEY (Pedidoid) REFERENCES pedido(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla que almacena la información de las facturas emitidas';

-- Tabla lote
CREATE TABLE lote (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      fechaVencimiento TIMESTAMP NULL COMMENT 'Fecha de vencimiento de los productos del lote',
                      cantidadInicial INT NOT NULL COMMENT 'Cantidad inicial de artículos en el lote',
                      cantidadDisponible INT NOT NULL COMMENT 'Cantidad disponible de artículos en el lote',
                      Articuloid INT NOT NULL COMMENT 'Identificador del artículo asociado al lote',
                      compraId INT NOT NULL COMMENT 'Identificador para asociacion con compras',
                      FOREIGN KEY (Articuloid) REFERENCES articulo(id),
                      FOREIGN KEY (compraId) REFERENCES compra(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla que almacena la información sobre los lotes de productos';

-- Tabla de movimiento lote
CREATE TABLE movimiento_lote (
                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 tipoMovimiento BIT NOT NULL COMMENT 'Tipo de movimiento (1: Entrada, 0: Salida)',
                                 cantidad INT NOT NULL COMMENT 'Cantidad de artículos afectados por el movimiento',
                                 fechaMovimiento TIMESTAMP NOT NULL COMMENT 'Fecha y hora del movimiento del lote',
                                 referenciaDetalleFactura INT NULL COMMENT 'Referencia al detalle de factura asociado al movimiento (si aplica)',
                                 loteid INT NOT NULL COMMENT 'Identificador del lote al que pertenece el movimiento',
                                 FOREIGN KEY (loteid) REFERENCES lote(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla que registra los movimientos de stock dentro de cada lote';

-- Tabla de Detalle_Factura
CREATE TABLE detalle_Factura (
                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 cantidad INT NOT NULL COMMENT 'Cantidad de artículos incluidos en la línea de la factura',
                                 precioUnitario DECIMAL(19,4) NOT NULL COMMENT 'Precio unitario de cada artículo en la línea de la factura',
                                 noLinea INT NOT NULL COMMENT 'Número de línea dentro de la factura',
                                 Facturaid INT NOT NULL COMMENT 'Identificador de la factura a la que pertenece el detalle',
                                 Articuloid INT NOT NULL COMMENT 'Identificador del artículo asociado a la línea de la factura',
                                 FOREIGN KEY (Facturaid) REFERENCES factura(id),
                                 FOREIGN KEY (Articuloid) REFERENCES articulo(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla que detalla los productos incluidos en una factura específica';

-- Tabla de pedido_detalle
CREATE TABLE pedido_detalle (
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                linea INT NOT NULL COMMENT 'Número de línea dentro del pedido',
                                cantidad INT NOT NULL COMMENT 'Cantidad de artículos solicitados en la línea del pedido',
                                Articuloid INT NOT NULL COMMENT 'Identificador del artículo asociado a la línea del pedido',
                                Pedidoid INT NOT NULL COMMENT 'Identificador del pedido al que pertenece el detalle',
                                FOREIGN KEY (Articuloid) REFERENCES articulo(id),
                                FOREIGN KEY (Pedidoid) REFERENCES pedido(id)
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
                             Usuarioid INT NOT NULL COMMENT 'Identificador del usuario al que se le asigna el rol',
                             Rolid INT NOT NULL COMMENT 'Identificador del rol asignado al usuario',
                             FOREIGN KEY (Usuarioid) REFERENCES usuario(id),
                             FOREIGN KEY (Rolid) REFERENCES rol(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla que relaciona a los usuarios con sus roles dentro del sistema';