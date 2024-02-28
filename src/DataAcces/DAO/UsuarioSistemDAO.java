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
import DataAcces.DTO.RelacionDTO;
import DataAcces.DTO.RelacionTipoDTO;
import DataAcces.DTO.UsuarioSistemaDTO;

public class UsuarioSistemDAO extends SQLiteDataHelper implements IDAO<UsuarioSistemaDTO> {
    @Override
    public UsuarioSistemaDTO readBy(Integer id) throws Exception {
        UsuarioSistemaDTO oS = new UsuarioSistemaDTO();
        String query = " SELECT * FROM UsuarioSistema WHERE IdUsuarioSistema =   " + id.toString();
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {

                oS = new UsuarioSistemaDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6));

            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return oS;
    }

    public List<UsuarioSistemaDTO> readAll() throws Exception {
        List<UsuarioSistemaDTO> lst = new ArrayList<>();
        String query = " SELECT *FROM UsuarioSistema WHERE Estado =  'A'  ";
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                UsuarioSistemaDTO s = new UsuarioSistemaDTO(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
                lst.add(s);
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return lst;
    }

    public ArrayList<UsuarioSistemaDTO> obtenerUsuario() throws Exception {
        ArrayList<UsuarioSistemaDTO> lst = new ArrayList<>();
        String query = "SELECT IdPersona FROM UsuariosSistema WHERE Estado = 'A'";
        try {
            Connection conn = openConnection(); // Conectar a la base de datos
            Statement stmt = conn.createStatement(); // Crear una declaración SQL
            ResultSet rs = stmt.executeQuery(query); // Ejecutar la consulta SQL
            while (rs.next()) {
                // Obtener el identificador de persona de la fila actual
                UsuarioSistemaDTO idPersona = new UsuarioSistemaDTO(rs.getInt(1)); // Crear un nuevo objeto
                                                                                   // UsuarioSistemaDTO con el
                                                                                   // identificador de persona
                // Agregar el objeto a la lista
                lst.add(idPersona);
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return lst;
    }

    public UsuarioSistemaDTO obtenerClave(Integer id) throws Exception {
        UsuarioSistemaDTO oS = new UsuarioSistemaDTO();

        String query = " SELECT Contraseña FROM UsuariosSistema WHERE Estado = 'A' AND IdUsuarioSistema =   "
                + id.toString();

        try {
            Connection conn = openConnection(); // Conectar a la base de datos
            Statement stmt = conn.createStatement(); // Crear una declaración SQL
            ResultSet rs = stmt.executeQuery(query); // Ejecutar la consulta SQL
            while (rs.next()) {
                // Obtener el identificador de persona de la fila actual
                oS = new UsuarioSistemaDTO(rs.getString(1)); // Crear un nuevo objeto
                                                             // UsuarioSistemaDTO con el
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
    public boolean create(UsuarioSistemaDTO entity) throws Exception {
        String query = " INSERT INTO UsuarioSistema (Usuario) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getUsuario());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception();
        }
    }

    @Override
    public boolean update(UsuarioSistemaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE UsuarioSistema SET Usuario = ?, FechaModifica = ? WHERE IdUsuarioSistema = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getUsuario());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdUsuarioSistema());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception();
        }

    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE UsuarioSistema SET Estado  = ? WHERE IdUsuarioSistema = ?";
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
