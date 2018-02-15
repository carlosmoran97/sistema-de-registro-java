CREATE TABLE proveedor
(
	id_proveedor INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(255) NOT NULL,
	nit VARCHAR(14) NOT NULL
);

CREATE TABLE producto
(
	id_producto INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(100) NOT NULL,
	descripcion VARCHAR(255) NOT NULL,
	unidad_de_medida VARCHAR(30) NOT NULL,
	codigo VARCHAR(10) NOT NULL,
	precio_sugerido FLOAT NOT NULL
);

CREATE TABLE compra
(
	id_compra INT PRIMARY KEY AUTO_INCREMENT,
	fecha DATE NOT NULL,
	numero_de_documento VARCHAR(20) NOT NULL,
	id_proveedor INT NOT NULL
);

ALTER TABLE compra ADD CONSTRAINT fk_proveedor_compra
FOREIGN KEY(id_proveedor)
REFERENCES proveedor(id_proveedor);



CREATE TABLE linea_de_compra
(
	id_linea_de_compra INT PRIMARY KEY AUTO_INCREMENT,
	id_compra INT NOT NULL,
	id_producto INT NOT NULL,
	cantidad INT NOT NULL,
	precio_unitario FLOAT NOT NULL
	
);

ALTER TABLE linea_de_compra ADD CONSTRAINT fk_producto_linea_de_compra
FOREIGN KEY(id_producto)
REFERENCES producto(id_producto);

ALTER TABLE linea_de_compra ADD CONSTRAINT fk_compra_linea_de_compra
FOREIGN KEY(id_compra)
REFERENCES compra(id_compra);

CREATE TABLE existencia
(
	id_existencia INT PRIMARY KEY AUTO_INCREMENT,
	id_producto INT NOT NULL,
	cantidad INT NOT NULL
);

ALTER TABLE existencia ADD CONSTRAINT fk_producto_existencia
FOREIGN KEY(id_producto)
REFERENCES producto(id_producto);

CREATE TABLE inventario_inicial_mes
(
	id_inventario_inicial_mes INT PRIMARY KEY AUTO_INCREMENT,
	id_producto INT NOT NULL,
	mes INT NOT NULL,
	año INT NOT NULL,
	cantidad INT NOT NULL
);

ALTER TABLE inventario_inicial_mes ADD CONSTRAINT fk_producto_inventario
FOREIGN KEY(id_producto)
REFERENCES producto(id_producto);

CREATE TABLE venta
(
	id_venta INT PRIMARY KEY AUTO_INCREMENT,
	fecha DATE NOT NULL,
	numero_de_documento VARCHAR(20) NOT NULL,
	id_cliente INT NOT NULL
);

CREATE TABLE cliente
(
	id_cliente INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(255) NOT NULL,
	nit VARCHAR(14) NOT NULL
);

ALTER TABLE venta ADD CONSTRAINT fk_venta_cliente
FOREIGN KEY(id_cliente)
REFERENCES cliente(id_cliente);