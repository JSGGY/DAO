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
    public boolean create(PersonaSexoDTO personaSexoDTO) throws Exception{   
        return psDAO.create(personaSexoDTO);
    }
    public boolean update(PersonaSexoDTO personaSexoDTO) throws Exception{
        return psDAO.update(personaSexoDTO);
    }
    public boolean delete(int idPersonaSexo) throws Exception{
        return psDAO.delete(idPersonaSexo);
    }
}