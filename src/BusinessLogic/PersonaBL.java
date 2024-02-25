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
    
    public PersonaDTO getById(int IdPersona) throws Exception{
        persona = pDAO.readBy(IdPersona);
        return persona;
    }
    
    public boolean add(String nombre, Integer IdPersonaRol, Integer IdPersonaSexo, String cedula) throws Exception{  
        persona = new PersonaDTO(); 
        persona.setNombre(nombre);
        persona.setIdPersonaRol(IdPersonaRol);
        persona.setIdPersonaSexo(IdPersonaSexo);
        persona.setCedula(cedula);
        return pDAO.create(persona);
    }
    
    public boolean update(Integer IdPersona, String nombre, Integer IdPersonaRol, Integer IdPersonaSexo, String cedula, String fechaModifica) throws Exception{
        persona = new PersonaDTO(); 
        persona.setIdPersona(IdPersona);
        persona.setNombre(nombre);
        persona.setIdPersonaRol(IdPersonaRol);
        persona.setIdPersonaSexo(IdPersonaSexo);
        persona.setCedula(cedula);
        persona.setFechaModifica(fechaModifica);
        return pDAO.update(persona);
    }
    
    public boolean delete(int IdPersona) throws Exception{
        return pDAO.delete(IdPersona);
    }
}