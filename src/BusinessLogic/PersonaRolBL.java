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
    public boolean create(PersonaRolDTO personaRolDTO) throws Exception{   
        return prDAO.create(personaRolDTO);
    }
    public boolean update(PersonaRolDTO personaRolDTO) throws Exception{
        return prDAO.update(personaRolDTO);
    }
    public boolean delete(int idPersonaRol) throws Exception{
        return prDAO.delete(idPersonaRol);
    }
}
