package BusinessLogic;

import java.util.List;

import DataAcces.DAO.PersonaDao;
import DataAcces.DTO.PersonaDTO;

public class PersonaBL {
    private PersonaDTO persona;
    private PersonaDao pDAO = new PersonaDao();

    public PersonaBL(){}

    public List<PersonaDTO> getAll() throws Exception{
        return pDAO.readAll();
    }
    public PersonaDTO getById(int idPersona) throws Exception{
        persona = pDAO.readBy(idPersona);
        return persona;
    }
    public boolean create(PersonaDTO personaDTO) throws Exception{   
        return pDAO.create(personaDTO);
    }
    public boolean update(PersonaDTO personaDTO) throws Exception{
        return pDAO.update(personaDTO);
    }
    public boolean delete(int idPersona) throws Exception{
        return pDAO.delete(idPersona);
    }
}