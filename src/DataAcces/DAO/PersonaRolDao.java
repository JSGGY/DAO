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
import DataAcces.DTO.PersonaRolDTO;



public class PersonaRolDao extends SQLiteDataHelper implements IDAO<PersonaRolDTO> {

    @Override
    public PersonaRolDTO readBy(Integer id) throws Exception {
        PersonaRolDTO oS = new PersonaRolDTO();
        String query =" SELECT * FROM  PersonaRol WHERE  IdPersonaRol=   "+ id.toString() ;
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
            
                oS = new PersonaRolDTO(rs.getInt(1)
                ,rs.getInt(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6));
            }
        } 
        catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return oS;
    }

    public List<PersonaRolDTO> readAll() throws Exception {
        List <PersonaRolDTO> lst = new ArrayList<>();
         String query =" SELECT * FROM  PersonaRol WHERE  Estado = 'A'  ";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                    PersonaRolDTO s = new PersonaRolDTO(rs.getInt(1)
                    ,rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6));
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return lst; 
    }

    @Override
    public boolean create(PersonaRolDTO entity) throws Exception {
        String query = " INSERT INTO PersonaRol (Nombre) VALUES (?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new Exception();
        }
    }

    @Override
    public boolean update(PersonaRolDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE PersonaRol SET Nombre = ?, FechaModifica = ? WHERE IdPersonaRol = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdPersonaRol());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new Exception();
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE PersonaRol SET Estado  = ? WHERE IdPersonaRol = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new Exception();
        }
    }




}
