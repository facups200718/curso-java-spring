drop database products;
create database products;
use products;

CREATE TABLE  CATEGORIAS (
  id_categoria INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(45) NOT NULL,
  estado TINYINT(1) NOT NULL,
  PRIMARY KEY (id_categoria));


CREATE TABLE PRODUCTOS (
  id_producto INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NULL,
  id_categoria INT NOT NULL,
  codigo_barras VARCHAR(150) NULL,
  precio_venta DECIMAL(16,2) NULL,
  cantidad_stock INT NOT NULL,
  estado TINYINT(1) NULL,
  PRIMARY KEY (id_producto),
  CONSTRAINT fk_PRODUCTOS_CATEGORIAS
    FOREIGN KEY (id_categoria)
    REFERENCES CATEGORIAS (id_categoria)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);


CREATE TABLE  CLIENTES (
  id VARCHAR(20) NOT NULL,
  nombre VARCHAR(40) NULL,
  apellidos VARCHAR(100) NULL,
  celular NUMERIC NULL,
  direccion VARCHAR(80) NULL,
  correo_electronico VARCHAR(70) NULL,
  PRIMARY KEY (id));


CREATE TABLE  COMPRAS (
  id_compra INT NOT NULL AUTO_INCREMENT,
  id_cliente VARCHAR(20) NOT NULL,
  fecha TIMESTAMP NULL,
  medio_pago CHAR(1) NULL,
  comentario VARCHAR(300) NULL,
  estado CHAR(1) NULL,
  PRIMARY KEY (id_compra),
  CONSTRAINT fk_COMPRAS_CLIENTES1
    FOREIGN KEY (id_cliente)
    REFERENCES CLIENTES (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE  COMPRAS_PRODUCTOS (
  id_compra INT NOT NULL,
  id_producto INT NOT NULL,
  cantidad INT NULL,
  total DECIMAL(16,2) NULL,
  estado TINYINT(1) NULL,
  PRIMARY KEY (id_compra, id_producto),
  CONSTRAINT fk_COMPRAS_PRODUCTOS_PRODUCTOS1
    FOREIGN KEY (id_producto)
    REFERENCES PRODUCTOS (id_producto)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_COMPRAS_PRODUCTOS_COMPRAS1
    FOREIGN KEY (id_compra)
    REFERENCES COMPRAS (id_compra)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
