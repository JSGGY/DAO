package BusinessLogic;

import java.util.List;

import DataAcces.DAO.PersonaRolDao;
import DataAcces.DTO.PersonaRolDTO;

public class PersonaRolBL {
    private PersonaRolDTO personaRol;
    private PersonaRolDao prDAO = new PersonaRolDao();

    public PersonaRolBL(){}

    public List<PersonaRolDTO> getAll() throws Exception{
        return prDAO.readAll();
    }
    public PersonaRolDTO getById(int idPersonaRol) throws Exception{
        personaRol = prDAO.readBy(idPersonaRol);
        return personaRol;
    }
    public boolean add(Integer idPersonaRolPadre, String nombre) throws Exception{   
        personaRol = new PersonaRolDTO();
        personaRol.setIdPersonaRolPadre(idPersonaRolPadre);
        personaRol.setNombre(nombre);
        return prDAO.create(personaRol);
    }
    public boolean update(Integer idPersonaRol, Integer idPersonaRolPadre, String nombre, String fechaModifica) throws Exception{
        personaRol = new PersonaRolDTO();
        personaRol.setIdPersonaRol(idPersonaRol);
        personaRol.setIdPersonaRolPadre(idPersonaRolPadre);
        personaRol.setNombre(nombre);
        personaRol.setFechaModifica(fechaModifica);
        return prDAO.update(personaRol);
    }
    public boolean delete(int idPersonaRol) throws Exception{
        return prDAO.delete(idPersonaRol);
    }
}
