package BusinessLogic;

import java.util.ArrayList;
import java.util.List;

import DataAcces.DAO.RegaloEnvioDao;
import DataAcces.DTO.RegaloEnvioDTO;

public class RegaloEnvioBL {
    private RegaloEnvioDTO regaloEnvio;
    private static RegaloEnvioDao reDAO = new RegaloEnvioDao();

    public RegaloEnvioBL() {
    }

    public static ArrayList<RegaloEnvioDTO> getAll() throws Exception {
        return reDAO.readAll();
    }

    public RegaloEnvioDTO getById(int idRegaloEnvio) throws Exception {
        regaloEnvio = reDAO.readBy(idRegaloEnvio);
        return regaloEnvio;
    }

    public boolean add(Integer idRegalo, Integer idPersonaEnvia,
            Integer idPersonaRecibe, Integer idPersonaReparte, String nombre, String fechaEnvio) throws Exception {
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
            Integer idPersonaRecibe, Integer idPersonaReparte, String nombre, String fechaEnvio, String fechaModifica)
            throws Exception {
        regaloEnvio = new RegaloEnvioDTO();
        regaloEnvio.setIdRegaloEnvio(idRegaloEnvio);
        regaloEnvio.setIdRegalo(idRegalo);
        regaloEnvio.setIdPersonaEnvia(idPersonaEnvia);
        regaloEnvio.setIdPersonaRecibe(idPersonaRecibe);
        regaloEnvio.setIdPersonaReparte(idPersonaReparte);
        regaloEnvio.setNombre(nombre);
        regaloEnvio.setFechaModifica(fechaModifica);
        regaloEnvio.setFechaEnvio(fechaEnvio);
        return reDAO.update(regaloEnvio);
    }

    public boolean delete(int idRegaloEnvio) throws Exception {
        return reDAO.delete(idRegaloEnvio);
    }

    public Integer getMaxRow() throws Exception {
        // TODO Auto-generated method stub
        return reDAO.getMaxRow();
    }
}
