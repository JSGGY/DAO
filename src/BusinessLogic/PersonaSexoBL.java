package BusinessLogic;

import java.util.List;

import DataAcces.DAO.PersonaSexoDao;
import DataAcces.DTO.PersonaSexoDTO;

public class PersonaSexoBL {
    private PersonaSexoDTO personaSexo;
    private PersonaSexoDao psDAO = new PersonaSexoDao();

    public PersonaSexoBL(){}

    public List<PersonaSexoDTO> getAll() throws Exception{
        return psDAO.readAll();
    }
    public PersonaSexoDTO getByIdSexo(int idPersonaSexo) throws Exception{
        personaSexo = psDAO.readBy(idPersonaSexo);
        return personaSexo;
    }
    public boolean add(String nombre) throws Exception{
        personaSexo=new PersonaSexoDTO();
        personaSexo.setNombre(nombre);
        return psDAO.create(personaSexo);
    }
    public boolean update(Integer idPersonaSexo, String nombre, String fechaModifica) throws Exception{
        personaSexo=new PersonaSexoDTO();
        personaSexo.setIdPersonaSexo(idPersonaSexo);
        personaSexo.setNombre(nombre);
        personaSexo.setFechaModifica(fechaModifica);
        return psDAO.update(personaSexo);
    }
    public boolean delete(int idPersonaSexo) throws Exception{
        return psDAO.delete(idPersonaSexo);
    }
}