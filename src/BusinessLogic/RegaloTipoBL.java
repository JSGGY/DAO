package BusinessLogic;

import java.util.List;

import DataAcces.DAO.RegaloTipoDao;
import DataAcces.DTO.RegaloTipoDTO;

public class RegaloTipoBL {
    private RegaloTipoDTO regaloTipo;
    private RegaloTipoDao rtDAO = new RegaloTipoDao();

    public RegaloTipoBL(){}

    public List<RegaloTipoDTO> getAll() throws Exception{
        return rtDAO.readAll();
    }
    public RegaloTipoDTO getById(int idRegaloTipo) throws Exception{
        regaloTipo = rtDAO.readBy(idRegaloTipo);
        return regaloTipo;
    }
    public boolean create(RegaloTipoDTO RegaloTipoDTO) throws Exception{   
        return rtDAO.create(RegaloTipoDTO);
    }
    public boolean update(RegaloTipoDTO RegaloTipoDTO) throws Exception{
        return rtDAO.update(RegaloTipoDTO);
    }
    public boolean delete(int idRegaloTipo) throws Exception{
        return rtDAO.delete(idRegaloTipo);
    }
}
