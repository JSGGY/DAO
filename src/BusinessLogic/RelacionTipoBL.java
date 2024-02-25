package BusinessLogic;

import java.util.List;

import DataAcces.DAO.RelacionTipoDao;
import DataAcces.DTO.RelacionTipoDTO;

public class RelacionTipoBL {
    private RelacionTipoDTO relacionTipo;
    private RelacionTipoDao rtDAO = new RelacionTipoDao();

    public RelacionTipoBL(){}

    public List<RelacionTipoDTO> getAll() throws Exception{
        return rtDAO.readAll();
    }
    public RelacionTipoDTO getById(int idRelacionTipo) throws Exception{
        relacionTipo = rtDAO.readBy(idRelacionTipo);
        return relacionTipo;
    }
    public boolean create(RelacionTipoDTO RelacionTipoDTO) throws Exception{   
        return rtDAO.create(RelacionTipoDTO);
    }
    public boolean update(RelacionTipoDTO RelacionTipoDTO) throws Exception{
        return rtDAO.update(RelacionTipoDTO);
    }
    public boolean delete(int idRelacionTipo) throws Exception{
        return rtDAO.delete(idRelacionTipo);
    }
}
