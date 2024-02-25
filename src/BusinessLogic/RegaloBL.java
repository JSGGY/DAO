package BusinessLogic;

import java.util.List;

import DataAcces.DAO.RegaloDao;
import DataAcces.DTO.RegaloDTO;

public class RegaloBL {
    private RegaloDTO regalo;
    private RegaloDao rDAO = new RegaloDao();

    public RegaloBL(){}

    public List<RegaloDTO> getAll() throws Exception{
        return rDAO.readAll();
    }
    public RegaloDTO getById(int idRegalo) throws Exception{
        regalo = rDAO.readBy(idRegalo);
        return regalo;
    }
    public boolean add(Integer idRelacionTipo,String nombre, Integer stock, Double precio) throws Exception{  
        regalo = new RegaloDTO();
        regalo.setIdRelacionTipo(idRelacionTipo);
        regalo.setNombre(nombre);
        regalo.setStock(stock);
        regalo.setPrecio(precio);
        return rDAO.create(regalo);
    }
    public boolean update(Integer idRegalo, Integer idRelacionTipo, String nombre, Integer stock, Double precio, String fechaModifica) throws Exception{
        regalo = new RegaloDTO();
        regalo.setIdRegalo(idRegalo);
        regalo.setIdRelacionTipo(idRelacionTipo);
        regalo.setNombre(nombre);
        regalo.setStock(stock);
        regalo.setPrecio(precio);
        regalo.setFechaModifica(fechaModifica);
        return rDAO.update(regalo);
    }
    public boolean delete(int idRegalo) throws Exception{
        return rDAO.delete(idRegalo);
    }
}
