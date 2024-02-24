-- database: ../Data/bd.sqlite

DROP TABLE IF EXISTS PersonaEnvio;
DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS PersonaTipo;
DROP TABLE IF EXISTS Relacion;
DROP TABLE IF EXISTS Regalo;
DROP TABLE IF EXISTS RegaloEnvio;
DROP TABLE IF EXISTS RegaloTipo;
DROP TABLE IF EXISTS Cita;
DROP TABLE IF EXISTS RelacionTipo;
DROP TABLE IF EXISTS PersonaRol;
DROP TABLE IF EXISTS PersonaSexo;

CREATE TABLE RegaloTipo (
    IdRegaloTipo INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre TEXT NOT NULL UNIQUE,
    Estado         VARCHAR(1)  NOT NULL DEFAULT('A'),
    Observacion TEXT,
    FechaCrea DATE DEFAULT CURRENT_TIMESTAMP,
    FechaModifica DATE
);

CREATE TABLE PersonaSexo (
    IdPersonaSexo INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre TEXT NOT NULL UNIQUE,
    Estado         VARCHAR(1)  NOT NULL DEFAULT('A'),
    FechaCrea DATE DEFAULT CURRENT_TIMESTAMP,
    FechaModifica DATE
);

CREATE TABLE RelacionTipo (
    IdRelacionTipo INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre TEXT NOT NULL UNIQUE,
    Estado         VARCHAR(1)  NOT NULL DEFAULT('A'),
    FechaCrea DATE DEFAULT CURRENT_TIMESTAMP,
    FechaModifica DATE
);

CREATE TABLE PersonaRol (
    IdPersonaRol INTEGER PRIMARY KEY AUTOINCREMENT,
    IdPersonaRolPadre INTEGER,
    Nombre TEXT NOT NULL UNIQUE,
    Estado         VARCHAR(1)  NOT NULL DEFAULT('A'),
    FechaCrea DATE DEFAULT CURRENT_TIMESTAMP,
    FechaModifica DATE
);

CREATE TABLE Persona (
    IdPersona INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre TEXT NOT NULL,
    Estado         VARCHAR(1)  NOT NULL DEFAULT('A'),
    IdPersonaRol INTEGER REFERENCES PersonaRol (IdPersonaRol),
    IdPersonaSexo INTEGER REFERENCES PersonaSexo (IdPersonaSexo),
    Cedula TEXT,
    FechaCrea DATE DEFAULT CURRENT_TIMESTAMP,
    FechaModifica DATE
);

CREATE TABLE Regalo (
    IdRegalo INTEGER PRIMARY KEY AUTOINCREMENT,
    IdRelacionTipo INTEGER REFERENCES RelacionTipo (IdRelacionTipo),
    Nombre TEXT NOT NULL UNIQUE,
    Estado         VARCHAR(1)  NOT NULL DEFAULT('A'),
    Stock INTEGER,
    Precio DOUBLE,
    FechaCrea DATE DEFAULT CURRENT_TIMESTAMP,
    FechaModifica DATE
);

CREATE TABLE Relacion (
    IdRelacion INTEGER PRIMARY KEY AUTOINCREMENT,
    IdRelacionTipo INTEGER,
    Estado         VARCHAR(1)  NOT NULL DEFAULT('A'),
    IdPersona1 INTEGER REFERENCES Persona (IdPersona),
    IdPersona2 INTEGER REFERENCES Persona (IdPersona),
    FechaCrea DATE DEFAULT CURRENT_TIMESTAMP,
    FechaModifica DATE
);

CREATE TABLE Cita (
    IdCita INTEGER PRIMARY KEY AUTOINCREMENT,
    IdPersona1 INTEGER REFERENCES Persona (IdPersona),
    Estado         VARCHAR(1)  NOT NULL DEFAULT('A'),
    IdPersona2 INTEGER REFERENCES Persona (IdPersona),
    Nombre TEXT NOT NULL UNIQUE,
    FechaCrea DATE DEFAULT CURRENT_TIMESTAMP,
    FechaModifica DATE
);

CREATE TABLE RegaloEnvio (
    IdRegaloEnvio INTEGER PRIMARY KEY AUTOINCREMENT,
    IdRegalo INTEGER REFERENCES Regalo(IdRegalo),
    Estado         VARCHAR(1)  NOT NULL DEFAULT('A'),
    IdPersonaEnvia INTEGER REFERENCES Persona(IdPersona),
    IdPersonaRecibe INTEGER REFERENCES Persona(IdPersona),
    IdPersonaReparte INTEGER REFERENCES Persona(IdPersona),
    Nombre TEXT NOT NULL UNIQUE,
    FechaCrea DATE DEFAULT CURRENT_TIMESTAMP,
    FechaModifica DATE,
    FechaEnvio DATE
);
