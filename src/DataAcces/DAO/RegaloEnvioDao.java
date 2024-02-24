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
import DataAcces.DTO.RegaloDTO;
import DataAcces.DTO.RegaloEnvioDTO;
import DataAcces.DTO.RegaloTipoDTO;

public class RegaloEnvioDao extends SQLiteDataHelper implements IDAO<RegaloEnvioDTO>{

@Override
    public RegaloEnvioDTO readBy(Integer id) throws Exception {
        RegaloEnvioDTO oS = new RegaloEnvioDTO();
        String query =" SELECT IdRegaloEnvio"  
                    + ",IdRegaloEnvio"
                    + ",IdRegalo"
                    + ",Estado"
                    + ",IdPersonaEnvia"
                    + ",IdPersonaRecibe"
                    + ",IdPersonaReparte"
                    + ",Nombre"
                    + ",FechaCrea"
                    + ",FechaModifica"
                    + ", FechaEnvio"
                    +" FROM    RegaloEnvio "
                    + " WHERE   IdRegaloEnvio =   " + id.toString() ;
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                oS = new RegaloEnvioDTO(rs.getInt(1),
                rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)
                ,rs.getString(7),rs.getString(8),rs.getString(9), rs.getString(10));
            }
        } 
        catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return oS;
    }

    public List<RegaloEnvioDTO> readAll() throws Exception {
        List <RegaloEnvioDTO> lst = new ArrayList<>();
         String query =
         " SELECT IdRegaloEnvio"  
                    + ",IdRegaloEnvio"
                    + ",IdRegalo"
                    + ",Estado"
                    + ",IdPersonaEnvia"
                    + ",IdPersonaRecibe"
                    + ",IdPersonaReparte"
                    + ",Nombre"
                    + ",FechaCrea"
                    + ",FechaModifica"
                    + ", FechaEnvio"
                    +" FROM    RegaloEnvio "
                    + " WHERE  Estado = 'A'" ;
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                    RegaloEnvioDTO s = new RegaloEnvioDTO(rs.getInt(1),
                    rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)
                    ,rs.getString(7),rs.getString(8),rs.getString(9), rs.getString(10));
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return lst; 
    }

    @Override
    public boolean create(RegaloEnvioDTO entity) throws Exception {
        String query = " INSERT INTO RegaloEnvio (Nombre) VALUES (?)";
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
    public boolean update(RegaloEnvioDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE RegaloEnvio SET Nombre = ?, FechaModifica = ? WHERE IdRegaloEnvio = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdRegaloEnvio());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new Exception();
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE RegaloEnvio SET Estado  = ? WHERE IdRegaloEnvio = ?";
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
