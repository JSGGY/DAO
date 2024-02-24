-- database: ../Data/bd.sqlite
-- Insertar datos en la tabla RegaloTipo
INSERT INTO RegaloTipo (Nombre, Observacion, FechaModifica) VALUES 
    ('Virtual', 'Se entrega mediante correo', NULL),
    ('Presencial', 'Se entrega con costo de envío', NULL);

-- Insertar datos en la tabla PersonaSexo
INSERT INTO PersonaSexo (Nombre, FechaModifica) VALUES 
    ('Masculino', NULL),
    ('Femenino', NULL),
    ('Otro', NULL);

-- Insertar datos en la tabla RelacionTipo
INSERT INTO RelacionTipo (Nombre, FechaModifica) VALUES 
    ('Familiar', NULL),
    ('Amistad', NULL),
    ('Sentimental', NULL);

-- Insertar datos en la tabla PersonaRol
INSERT INTO PersonaRol (IdPersonaRolPadre, Nombre, FechaModifica) VALUES 
    (NULL, 'Administrador', NULL),
    (NULL, 'Usuario', NULL),
    (NULL, 'Repartidor', NULL);

-- Insertar datos en la tabla Persona
WITH RECURSIVE cnt(x) AS (
  VALUES(1)
  UNION ALL
  SELECT x+1 FROM cnt WHERE x < 1000
)
INSERT INTO Persona (Nombre, IdPersonaRol, IdPersonaSexo, Cedula, FechaModifica)
SELECT 
    -- Generar nombres aleatorios
    CASE ABS(RANDOM()) % 100
              WHEN 0 THEN 'Juan'
            WHEN 1 THEN 'María'
            WHEN 2 THEN 'José'
            WHEN 3 THEN 'Ana'
            WHEN 4 THEN 'Pedro'
            WHEN 5 THEN 'Isabel'
            WHEN 6 THEN 'Carlos'
            WHEN 7 THEN 'Laura'
            WHEN 8 THEN 'Antonio'
            WHEN 9 THEN 'Elena'
            WHEN 10 THEN 'Manuel'
            WHEN 11 THEN 'Carmen'
            WHEN 12 THEN 'Francisco'
            WHEN 13 THEN 'Sara'
            WHEN 14 THEN 'Luis'
            WHEN 15 THEN 'Lucía'
            WHEN 16 THEN 'Miguel'
            WHEN 17 THEN 'Eva'
            WHEN 18 THEN 'David'
            WHEN 19 THEN 'Raquel'
            WHEN 20 THEN 'Javier'
            WHEN 21 THEN 'Patricia'
            WHEN 22 THEN 'Alejandro'
            WHEN 23 THEN 'Natalia'
            WHEN 24 THEN 'Pablo'
            WHEN 25 THEN 'Teresa'
            WHEN 26 THEN 'Jorge'
            WHEN 27 THEN 'Marta'
            WHEN 28 THEN 'Fernando'
            WHEN 29 THEN 'Cristina'
            WHEN 30 THEN 'Rubén'
            WHEN 31 THEN 'Victoria'
            WHEN 32 THEN 'Ángel'
            WHEN 33 THEN 'Marina'
            WHEN 34 THEN 'Diego'
            WHEN 35 THEN 'Paula'
            WHEN 36 THEN 'Rafael'
            WHEN 37 THEN 'Andrea'
            WHEN 38 THEN 'Juan José'
            WHEN 39 THEN 'Beatriz'
            WHEN 40 THEN 'Juan Carlos'
            WHEN 41 THEN 'Silvia'
            WHEN 42 THEN 'Alberto'
            WHEN 43 THEN 'Inés'
            WHEN 44 THEN 'Manuela'
            WHEN 45 THEN 'Alfonso'
            WHEN 46 THEN 'Rosa'
            WHEN 47 THEN 'Jaime'
            WHEN 48 THEN 'Sofía'
            WHEN 49 THEN 'Gonzalo'
            WHEN 50 THEN 'Julia'
            WHEN 51 THEN 'José Luis'
            WHEN 52 THEN 'Lorena'
            WHEN 53 THEN 'Iván'
            WHEN 54 THEN 'Cristina'
            WHEN 55 THEN 'Roberto'
            WHEN 56 THEN 'Diana'
            WHEN 57 THEN 'Sergio'
            WHEN 58 THEN 'Adriana'
            WHEN 59 THEN 'Pilar'
            WHEN 60 THEN 'Víctor'
            WHEN 61 THEN 'Ángeles'
            WHEN 62 THEN 'Santiago'
            WHEN 63 THEN 'Esther'
            WHEN 64 THEN 'Hugo'
            WHEN 65 THEN 'Marisol'
            WHEN 66 THEN 'Enrique'
            WHEN 67 THEN 'Alicia'
            WHEN 68 THEN 'Vicente'
            WHEN 69 THEN 'Rosa María'
            WHEN 70 THEN 'Mario'
            WHEN 71 THEN 'Rocío'
            WHEN 72 THEN 'Antonia'
            WHEN 73 THEN 'Jesús'
            WHEN 74 THEN 'Catalina'
            WHEN 75 THEN 'Fernanda'
            WHEN 76 THEN 'Ricardo'
            WHEN 77 THEN 'Clara'
            WHEN 78 THEN 'Emilio'
            WHEN 79 THEN 'Verónica'
            WHEN 80 THEN 'Martín'
            WHEN 81 THEN 'Mónica'
            WHEN 82 THEN 'Héctor'
            WHEN 83 THEN 'Gloria'
            WHEN 84 THEN 'Fernando José'
            WHEN 85 THEN 'Beatriz'
            WHEN 86 THEN 'Guillermo'
            WHEN 87 THEN 'Ángela'
            WHEN 88 THEN 'Felipe'
            WHEN 89 THEN 'Lidia'
            WHEN 90 THEN 'Marcos'
            WHEN 91 THEN 'Juana'
            WHEN 92 THEN 'Eduardo'
            WHEN 93 THEN 'Nuria'
            WHEN 94 THEN 'Joaquín'
            WHEN 95 THEN 'María Dolores'
            WHEN 96 THEN 'Gabriel'
            WHEN 97 THEN 'Marisol'
            WHEN 98 THEN 'Ricardo'
            WHEN 99 THEN 'Clara'
    END AS Nombre,
    -- Generar roles aleatorios (entre 1 y 3)
    ABS(RANDOM()) % 3 + 1 AS IdPersonaRol,
    -- Generar géneros aleatorios (entre 1 y 3)
    ABS(RANDOM()) % 3 + 1 AS IdPersonaSexo,
    -- Generar cédulas aleatorias de 9 dígitos
    CAST(ABS(RANDOM() % 900000000) + 100000000 AS TEXT) AS Cedula,
    NULL 
FROM cnt;

-- Insertar datos en la tabla Regalo
INSERT INTO Regalo (IdRelacionTipo, Nombre, Stock, Precio, FechaModifica)
VALUES
    (1, 'Vino ' , 1000, 30.50, NULL),
    (2, 'Peluche ' , 10000, 10.50, NULL),
    (3, 'Rosas ' , 10000, 5.50, NULL),
    (3, 'Chocolates ' , 10000, 7.50, NULL);





-- Insertar datos en la tabla Relacion
INSERT INTO Relacion (IdRelacionTipo, IdPersona1, IdPersona2, FechaModifica)
VALUES (
    3,
    (SELECT IdPersona FROM Persona WHERE IdPersonaRol = 3 ORDER BY RANDOM() LIMIT 1), -- IdPersona1, se selecciona aleatoriamente una persona con IdPersonaRol igual a 3
    (SELECT IdPersona FROM Persona WHERE IdPersonaRol = 3 AND IdPersona <> (SELECT IdPersona FROM Persona WHERE IdPersonaRol = 3 ORDER BY RANDOM() LIMIT 1) ORDER BY RANDOM() LIMIT 1),
    NULL
);

-- Insertar datos en la tabla Cita
INSERT INTO Cita (Nombre, IdPersona1, IdPersona2, FechaModifica) 
SELECT 
    'Cita ' || (SELECT COALESCE(MAX(CAST(SUBSTR(Nombre, 6) AS INTEGER)), 0) + 1 FROM Cita),
    (SELECT IdPersona FROM Persona WHERE IdPersonaRol=3 ORDER BY RANDOM() LIMIT 1),
    (SELECT IdPersona FROM Persona WHERE IdPersonaRol=3 ORDER BY RANDOM() LIMIT 1),
    NULL;

-- Insertar datos en la tabla RegaloEnvio
INSERT INTO RegaloEnvio (Nombre, FechaModifica, FechaEnvio, IdPersonaEnvia, IdPersonaRecibe, IdPersonaReparte, IdRegalo) 
VALUES (
    'Envio ' || (SELECT COALESCE(MAX(CAST(SUBSTR(Nombre, 6) AS INTEGER)), 0) + 1 FROM RegaloEnvio),
    NULL,
    '2024-02-18',
    (SELECT IdPersona FROM Persona WHERE IdPersonaRol = 2 ORDER BY RANDOM() LIMIT 1),
    (SELECT IdPersona FROM Persona WHERE IdPersonaRol = 2 ORDER BY RANDOM() LIMIT 1),
    (SELECT IdPersona FROM Persona WHERE IdPersonaRol = 3 ORDER BY RANDOM() LIMIT 1),
    (SELECT IdRegalo FROM Regalo ORDER BY RANDOM() LIMIT 1)
);

 
