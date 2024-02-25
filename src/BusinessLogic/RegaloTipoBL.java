package BusinessLogic;

import java.util.List;

import DataAcces.DAO.RegaloTipoDao;
import DataAcces.DTO.RegaloTipoDTO;

public class RegaloTipoBL {
    private RegaloTipoDTO regaloTipo;
    private RegaloTipoDao regaloTipoDao = new RegaloTipoDao();

    public RegaloTipoBL(){}

    public List<RegaloTipoDTO> getAll() throws Exception{
        return regaloTipoDao.readAll();
    }
    public RegaloTipoDTO getBy(int IdRegaloTipo) throws Exception{
        regaloTipo = regaloTipoDao.readBy(IdRegaloTipo);
        return regaloTipo;
    }
    public boolean add(String nombre) throws Exception{
        regaloTipo = new RegaloTipoDTO();
        regaloTipo.setNombre(nombre);
        return regaloTipoDao.create(regaloTipo);
    }
    public boolean update(int IdRegaloTipo, String nombre) throws Exception{
        regaloTipo = new RegaloTipoDTO();
        regaloTipo.setIdRegaloTipo(IdRegaloTipo);
        regaloTipo.setNombre(nombre);
        return regaloTipoDao.update(regaloTipo);
    }
    public boolean delete(int IdRegaloTipo) throws Exception{
        return regaloTipoDao.delete(IdRegaloTipo);
    }
}
