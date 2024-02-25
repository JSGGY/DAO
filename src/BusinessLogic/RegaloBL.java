package BusinessLogic;

import java.util.List;

import DataAcces.DAO.RegaloDao;
import DataAcces.DTO.RegaloDTO;

public class RegaloBL {
    private RegaloDTO regalo;
    private RegaloDao rDAO = new RegaloDao();

    public RegaloBL(){}

    public List<RegaloDTO> getAll() throws Exception{
        return rDAO.readAll();
    }
    public RegaloDTO getById(int idRegalo) throws Exception{
        regalo = rDAO.readBy(idRegalo);
        return regalo;
    }
    public boolean create(RegaloDTO RegaloDTO) throws Exception{   
        return rDAO.create(RegaloDTO);
    }
    public boolean update(RegaloDTO RegaloDTO) throws Exception{
        return rDAO.update(RegaloDTO);
    }
    public boolean delete(int idRegalo) throws Exception{
        return rDAO.delete(idRegalo);
    }
}
