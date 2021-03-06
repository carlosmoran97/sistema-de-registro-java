USE sistema_registro;

SELECT * FROM proveedor;

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

select * from compra;

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

select * from proveedor order by id_proveedor DESC LIMIT 1;

DELETE FROM compra;

SELECT * FROM compra;

SELECT * FROM producto;

SELECT * FROM linea_de_compra;
