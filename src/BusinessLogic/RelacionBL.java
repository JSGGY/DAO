package BusinessLogic;

import java.util.List;

import DataAcces.DAO.RelacionDao;
import DataAcces.DTO.RelacionDTO;

public class RelacionBL {
    private RelacionDTO relacion;
    private RelacionDao rDAO = new RelacionDao();

    public RelacionBL(){}

    public List<RelacionDTO> getAll() throws Exception{
        return rDAO.readAll();
    }
    public RelacionDTO getById(int idRelacion) throws Exception{
        relacion = rDAO.readBy(idRelacion);
        return relacion;
    }
    public boolean create(RelacionDTO RelacionDTO) throws Exception{   
        return rDAO.create(RelacionDTO);
    }
    public boolean update(RelacionDTO RelacionDTO) throws Exception{
        return rDAO.update(RelacionDTO);
    }
    public boolean delete(int idRelacion) throws Exception{
        return rDAO.delete(idRelacion);
    }
}
