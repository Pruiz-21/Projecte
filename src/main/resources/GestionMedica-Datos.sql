INSERT INTO pacientes (nombre, edad, direccion) VALUES
('Juan Pérez', 30, 'Calle Falsa 123'),
('María López', 25, 'Avenida Siempre Viva 742');

INSERT INTO medicos (nombre, especialidad) VALUES
('Dr. Rodríguez', 'Cardiología'),
('Dra. Gómez', 'Pediatría');

INSERT INTO citas (id_paciente, id_medico, fecha) VALUES
(1, 1, '2025-04-10'),
(2, 2, '2025-04-12');
