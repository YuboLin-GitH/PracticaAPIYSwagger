DROP DATABASE IF EXISTS hoteles;
CREATE DATABASE hoteles;
USE hoteles;

CREATE TABLE hotel (
                       idhotel INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       nombre VARCHAR(50) DEFAULT NULL,
                       descripcion VARCHAR(100),
                       categoria INT,
                       piscina BOOLEAN DEFAULT FALSE,
                       localidad VARCHAR(50)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

-- Más inserciones para la tabla 'hotel'
INSERT INTO hotel (nombre, descripcion, categoria, piscina, localidad) VALUES
                                                                           ('Hotel 1', 'Un hotel bonito en la playa', 4, TRUE, 'Málaga'),
                                                                           ('Hotel 2', 'Hotel céntrico y moderno', 3, FALSE, 'Madrid'),
                                                                           ('Gran Hotel Sol', 'Lujoso resort con vistas al mar', 5, TRUE, 'Ibiza'),
                                                                           ('Hostal La Luna', 'Alojamiento económico y tranquilo', 2, FALSE, 'Sevilla'),
                                                                           ('Hotel Montaña Viva', 'Retiro en la naturaleza con spa', 4, TRUE, 'Pirineos');

CREATE TABLE habitacion (
                            idhabitacion INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
                            tamaño INT,
                            capacidad INT,
                            precio_noche DECIMAL(7, 2),
                            incluye_desayuno BOOLEAN DEFAULT FALSE,
                            ocupada BOOLEAN DEFAULT FALSE,
                            idhotel INT NOT NULL,
                            FOREIGN KEY (idhotel) REFERENCES hotel(idhotel)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

-- Más inserciones para la tabla 'habitacion' (usando los idhotel de 1 a 5)
INSERT INTO habitacion( tamaño, capacidad, precio_noche, incluye_desayuno, ocupada, idhotel) VALUES
                                                                                                 (20, 2, 80.50, TRUE, FALSE, 2),
                                                                                                 (15, 1, 50.00, FALSE, TRUE, 1),
                                                                                                 (25, 2, 120.00, TRUE, FALSE, 2),
                                                                                                 (30, 4, 150.00, TRUE, FALSE, 3),
                                                                                                 (12, 1, 35.00, FALSE, TRUE, 4),
                                                                                                 (22, 2, 95.00, TRUE, FALSE, 3),
                                                                                                 (18, 2, 75.00, FALSE, FALSE, 5),
                                                                                                 (40, 4, 250.00, TRUE, TRUE, 1);