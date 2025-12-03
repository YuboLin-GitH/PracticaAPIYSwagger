DROP DATABASE IF EXISTS hoteles;
CREATE DATABASE hoteles;
USE hoteles;
CREATE TABLE hotel (
                       idhotel int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       nombre varchar(50) DEFAULT NULL,
                       descripcion varchar(100),
                       categoria int(1),
                       piscina boolean DEFAULT FALSE,
                       localidad varchar(50)

)  ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

INSERT INTO hotel (nombre, descripcion, categoria, piscina, localidad) VALUES
                                                                           ('Hotel 1', 'Un hotel bonito en la playa', 4, TRUE, 'Málaga'),
                                                                           ('Hotel 2', 'Hotel céntrico y moderno', 3, FALSE, 'Madrid');



CREATE TABLE habitacion (
                            idhabitacion int unsigned NOT NULL AUTO_INCREMENT  PRIMARY KEY,
                            tamaño int,
                            capacidad int(1),
                            precio_noche decimal(7, 2) ,
                            incluye_desayuno boolean DEFAULT FALSE,
                            ocupada boolean DEFAULT FALSE,
                            idhotel int NOT NULL,
                            FOREIGN KEY (idhotel) REFERENCES hotel(idhotel)

) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;


INSERT INTO habitacion(idhabitacion, tamaño, capacidad, precio_noche, incluye_desayuno, ocupada, idhotel) VALUES
                                                                                                              (1, 20, 2, 80.50, TRUE, FALSE,2),
                                                                                                              (2, 15, 1,50.00, FALSE, TRUE,1),
                                                                                                              (3, 25, 2,120.00, TRUE, FALSE,2);                          ;