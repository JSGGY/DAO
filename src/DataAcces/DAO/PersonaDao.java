package DataAcces.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAcces.IDAO;
import DataAcces.SQLiteDataHelper;
import DataAcces.DTO.PersonaDTO;
import DataAcces.DTO.UsuarioSistemaDTO;

public class PersonaDao extends SQLiteDataHelper implements IDAO<PersonaDTO> {

    @Override
    public PersonaDTO readBy(Integer id) throws Exception {
        PersonaDTO oS = new PersonaDTO();
        String query = " SELECT * FROM Persona WHERE IdPersona =   " + id.toString();
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {

                oS = new PersonaDTO(rs.getInt(1), rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return oS;
    }

    public PersonaDTO obtenerPersonaRol(Integer idPersona) throws Exception {
        PersonaDTO oS = new PersonaDTO();

        String query = " SELECT IdPersonaRol FROM Persona WHERE Estado = 'A' AND IdPersona =   "
                + idPersona.toString();

        try {
            Connection conn = openConnection(); // Conectar a la base de datos
            Statement stmt = conn.createStatement(); // Crear una declaración SQL
            ResultSet rs = stmt.executeQuery(query); // Ejecutar la consulta SQL
            while (rs.next()) {
                // Obtener el identificador de persona de la fila actual
                oS = new PersonaDTO(rs.getInt(1)); // Crear un nuevo objeto
                                                   // PersonaDTO con el
                                                   // identificador de persona
                // Agregar el objeto a la lista
                return oS;
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return oS;
    }

    @Override
    public ArrayList<PersonaDTO> readAll() throws Exception {
        ArrayList<PersonaDTO> lst = new ArrayList<>();
        String query = "SELECT IdPersona, Nombre, IdPersonaRol, IdPersonaSexo, Cedula, FechaCrea, FechaModifica FROM Persona WHERE Estado = 'A'";
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                PersonaDTO s = new PersonaDTO(rs.getInt(1), rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
                lst.add(s);
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return lst;
    }

    @Override
    public boolean create(PersonaDTO entity) throws Exception {
        String query = " INSERT INTO Persona (Nombre) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception();
        }
    }

    @Override
    public boolean update(PersonaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Persona SET Nombre = ?, IdPersonaRol = ?, IdPersonaSexo = ?, Cedula = ?, FechaModifica = ? WHERE IdPersona = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setInt(2, entity.getIdPersonaRol());
            pstmt.setInt(3, entity.getIdPersonaSexo());
            pstmt.setString(4, entity.getCedula());
            pstmt.setString(5, dtf.format(now));
            pstmt.setInt(6, entity.getIdPersona());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception();
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE Persona SET Nombre  = ? WHERE IdPersona = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception();
        }
    }

}
