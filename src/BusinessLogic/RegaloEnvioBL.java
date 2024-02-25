package BusinessLogic;

import java.util.List;

import DataAcces.DAO.RegaloEnvioDao;
import DataAcces.DTO.RegaloEnvioDTO;

public class RegaloEnvioBL {
    private RegaloEnvioDTO regaloEnvio;
    private RegaloEnvioDao reDAO = new RegaloEnvioDao();

    public RegaloEnvioBL(){}

    public List<RegaloEnvioDTO> getAll() throws Exception{
        return reDAO.readAll();
    }
    public RegaloEnvioDTO getById(int idRegaloEnvio) throws Exception{
        regaloEnvio = reDAO.readBy(idRegaloEnvio);
        return regaloEnvio;
    }
    public boolean create(RegaloEnvioDTO RegaloEnvioDTO) throws Exception{   
        return reDAO.create(RegaloEnvioDTO);
    }
    public boolean update(RegaloEnvioDTO RegaloEnvioDTO) throws Exception{
        return reDAO.update(RegaloEnvioDTO);
    }
    public boolean delete(int idRegaloEnvio) throws Exception{
        return reDAO.delete(idRegaloEnvio);
    }
}
