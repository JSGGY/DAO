package BusinessLogic;

import java.util.List;

import DataAcces.DAO.RelacionTipoDao;
import DataAcces.DTO.RelacionTipoDTO;

public class RelacionTipoBL {
    private RelacionTipoDTO relacionTipo;
    private RelacionTipoDao relacionTipoDao = new RelacionTipoDao();

    public RelacionTipoBL(){}

    public List<RelacionTipoDTO> getAll() throws Exception{
        return relacionTipoDao.readAll();
    }

    public RelacionTipoDTO getBy(int IdRelacionTipo) throws Exception{
        relacionTipo = relacionTipoDao.readBy(IdRelacionTipo);
        return relacionTipo;
    }

    public boolean add(String Nombre) throws Exception{
        relacionTipo = new RelacionTipoDTO();
        relacionTipo.setNombre(Nombre);
        return relacionTipoDao.create(relacionTipo);
    }

    public boolean update(int IdRelacionTipo,String Nombre) throws Exception{
        relacionTipo = new RelacionTipoDTO();
        relacionTipo.setIdRelacionTipo(IdRelacionTipo);
        relacionTipo.setNombre(Nombre);
        return relacionTipoDao.update(relacionTipo);
    }

    public boolean delete(int IdRelacionTipo) throws Exception{
        return relacionTipoDao.delete(IdRelacionTipo);
    } 
}
