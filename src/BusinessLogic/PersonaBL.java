package BusinessLogic;

import java.util.ArrayList;
import java.util.List;

import DataAcces.DAO.PersonaDao;
import DataAcces.DTO.PersonaDTO;
import DataAcces.DTO.UsuarioSistemaDTO;

public class PersonaBL {
    private static PersonaDTO persona;
    private static PersonaDTO persona2;
    private static PersonaDao pDAO = new PersonaDao();

    public PersonaBL() {
    }

    public static ArrayList<PersonaDTO> getAll() throws Exception {
        return pDAO.readAll();
    }

    public static PersonaDTO getById(int IdPersona) throws Exception {
        persona = pDAO.readBy(IdPersona);
        return persona;
    }

    public static PersonaDTO getPersonaRol(Integer idPersona) throws Exception {
        return pDAO.obtenerPersonaRol(idPersona);
    }

    public boolean add(String nombre, Integer IdPersonaRol, Integer IdPersonaSexo, String cedula) throws Exception {
        persona = new PersonaDTO();
        persona.setNombre(nombre);
        persona.setIdPersonaRol(IdPersonaRol);
        persona.setIdPersonaSexo(IdPersonaSexo);
        persona.setCedula(cedula);
        return pDAO.create(persona);
    }

    public boolean update(Integer IdPersona, String nombre, Integer IdPersonaRol, Integer IdPersonaSexo, String cedula)
            throws Exception {

        persona2 = new PersonaDTO();
        persona2.setIdPersona(IdPersona);
        persona2.setNombre(nombre);
        persona2.setIdPersonaRol(IdPersonaRol);
        persona2.setIdPersonaSexo(IdPersonaSexo);
        persona2.setCedula(cedula);
        return pDAO.update(persona2);
    }

    public boolean delete(int IdPersona) throws Exception {
        return pDAO.delete(IdPersona);
    }
}