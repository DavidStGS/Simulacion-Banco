create database bankbd;
use bankbd;
select * from usuarios;
delete from usuarios where id=1;
delete from usuarios where id=2;
delete from usuarios where id=3;
delete from usuarios where id=4;
delete from usuarios where id=5;
delete from usuarios where id=6;
delete from cuentas_bancarias where id=7;

select * from cuentas_bancarias;

DELIMITER //

CREATE TRIGGER crear_cuenta_bancaria
AFTER INSERT ON usuarios
FOR EACH ROW
BEGIN
    DECLARE num_cuenta VARCHAR(20);
    DECLARE cod_ciudad INT;

    -- Obtener el código de la ciudad asociada a la sucursal del usuario
    SELECT codigo_sucursal INTO cod_ciudad
    FROM usuarios
    WHERE id = NEW.id LIMIT 1;

    -- Crear el número de cuenta con el identificador de la sucursal
    SET num_cuenta = CONCAT(cod_ciudad, '-', FLOOR(RAND() * 1000000000000000));

    -- Insertar la nueva cuenta bancaria
    INSERT INTO cuentas_bancarias (nombre_titular, apellidos_titular, numero_cuenta, tipo_cuenta, saldo, id_usuario, codigo_sucursal)
    VALUES (NEW.nombre, NEW.apellidos, num_cuenta, 'Cuenta de ahorros', 0, NEW.id, cod_ciudad);
END;

//

DELIMITER ;
drop trigger evitar_duplicados_usuarios

DELIMITER //
CREATE TRIGGER evitar_duplicados_usuarios
BEFORE INSERT ON usuarios
FOR EACH ROW
BEGIN
    DECLARE num_rows INT;

    SELECT COUNT(*) INTO num_rows
    FROM usuarios
    WHERE identificacion = NEW.identificacion OR correo_electronico = NEW.correo_electronico;

    IF num_rows > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No se pueden crear usuarios con cédulas o correos electrónicos duplicados';
    END IF;
END;
//
DELIMITER ;


DELIMITER //

CREATE PROCEDURE depositar_dinero (IN p_numero_cuenta VARCHAR(20), IN p_cantidad DECIMAL(10, 2))
BEGIN
    DECLARE saldo_actual DECIMAL(10, 2);
    
    -- Obtener el saldo actual de la cuenta
    SELECT saldo INTO saldo_actual FROM cuentas_bancarias WHERE numero_cuenta = p_numero_cuenta LIMIT 1;
    
    -- Verificar si la cuenta existe y el saldo no es nulo
    IF saldo_actual IS NOT NULL THEN
        -- Actualizar el saldo de la cuenta especificada
        UPDATE cuentas_bancarias SET saldo = saldo_actual + p_cantidad WHERE numero_cuenta = p_numero_cuenta;
        SELECT 'Depósito exitoso' AS mensaje;
    ELSE
        SELECT 'Error: La cuenta no existe o el saldo es nulo' AS mensaje;
    END IF;
END;
//

DELIMITER ;




DELIMITER //

CREATE PROCEDURE retirar_dinero (IN p_numero_cuenta VARCHAR(20), IN p_cantidad DECIMAL(10, 2))
BEGIN
    DECLARE saldo_actual DECIMAL(10, 2);
    
    -- Obtener el saldo actual de la cuenta
    SELECT saldo INTO saldo_actual FROM cuentas_bancarias WHERE numero_cuenta = p_numero_cuenta LIMIT 1;
    
    -- Verificar si la cuenta existe y el saldo no es nulo
    IF saldo_actual IS NOT NULL THEN
        -- Verificar si hay suficiente saldo para el retiro
        IF saldo_actual >= p_cantidad THEN
            -- Actualizar el saldo de la cuenta especificada
            UPDATE cuentas_bancarias SET saldo = saldo_actual - p_cantidad WHERE numero_cuenta = p_numero_cuenta;
            SELECT 'Retiro exitoso' AS mensaje;
        ELSE
            SELECT 'Error: Saldo insuficiente' AS mensaje;
        END IF;
    ELSE
        SELECT 'Error: La cuenta no existe o el saldo es nulo' AS mensaje;
    END IF;
END;
//

DELIMITER ;



DELIMITER ; drop procedure depositar_dinero


CALL retirar_dinero('9-372583834801412', 1505000.00);
call depositar_dinero('9-372583834801412', 1505000);

CREATE TABLE cuentas_bancarias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_titular VARCHAR(255),
    apellidos_titular VARCHAR(255),
    numero_cuenta VARCHAR(20),
    tipo_cuenta VARCHAR(20),
    saldo DECIMAL(10, 2),
    id_usuario INT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    CHECK (tipo_cuenta IN ('cuenta corriente', 'cuenta de ahorros'))
);

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    identificacion VARCHAR (255),
    nombre VARCHAR(255),
    apellidos VARCHAR(255),
    correo_electronico VARCHAR(255),
    contrasena VARCHAR(255),
    codigo_sucursal INT,  -- Esta es la nueva columna que hará referencia al código de la sucursal
    FOREIGN KEY (codigo_sucursal) REFERENCES sucursales(codigo_ciudad)
);

DROP TABLE sucursales;
DROP TABLE usuarios;
DROP TABLE cuentas_bancarias

CREATE TABLE sucursales (
    codigo_ciudad INT PRIMARY KEY,  -- Esto será la clave primaria
    nombre_ciudad VARCHAR(255) NOT NULL
);

select * from cuentas_bancarias;
select * from usuarios

ALTER TABLE cuentas_bancarias ADD COLUMN codigo_sucursal INT AFTER id_usuario;

INSERT INTO sucursales (codigo_ciudad, nombre_ciudad)
VALUES 
    (1, 'Bogotá'),
    (2, 'Medellín'),
    (3, 'Cali'),
    (4, 'Barranquilla'),
    (5, 'Cartagena'),
    (6, 'Pereira'),
    (7, 'Cúcuta'),
    (8, 'Santa Marta'),
    (9, 'Villavicencio'),
    (10, 'Manizales');
    
    select * from usuarios
INSERT INTO usuarios (nombre, apellidos, correo_electronico, contrasena, codigo_sucursal)
VALUES 
    ('Juan', 'Pérez', 'juanperez@email.com', 'password123', 1),
    ('María', 'López', 'marialopez@email.com', 'securepassword', 2);

    
    



