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
    public boolean add(Integer idRegalo, Integer idPersonaEnvia,
    Integer idPersonaRecibe, Integer idPersonaReparte, String nombre, String fechaEnvio) throws Exception{ 
        regaloEnvio = new RegaloEnvioDTO();
        regaloEnvio.setIdRegalo(idRegalo);
        regaloEnvio.setIdPersonaEnvia(idPersonaEnvia);
        regaloEnvio.setIdPersonaRecibe(idPersonaRecibe);
        regaloEnvio.setIdPersonaReparte(idPersonaReparte);
        regaloEnvio.setNombre(nombre);
        regaloEnvio.setFechaEnvio(fechaEnvio);
        return reDAO.create(regaloEnvio);
    }
    public boolean update(Integer idRegaloEnvio, Integer idRegalo, Integer idPersonaEnvia,
    Integer idPersonaRecibe, Integer idPersonaReparte, String nombre, String fechaEnvio, String fechaModifica) throws Exception{
        regaloEnvio = new RegaloEnvioDTO();
        regaloEnvio.setIdRegaloEnvio(idRegaloEnvio);
        regaloEnvio.setIdRegalo(idRegalo);
        regaloEnvio.setIdPersonaEnvia(idPersonaEnvia);
        regaloEnvio.setIdPersonaRecibe(idPersonaRecibe);
        regaloEnvio.setIdPersonaReparte(idPersonaReparte);
        regaloEnvio.setNombre(nombre);
        regaloEnvio.setFechaEnvio(fechaEnvio);
        regaloEnvio.setFechaModifica(fechaModifica);
        return reDAO.update(regaloEnvio);
    }
    public boolean delete(int idRegaloEnvio) throws Exception{
        return reDAO.delete(idRegaloEnvio);
    }
}
