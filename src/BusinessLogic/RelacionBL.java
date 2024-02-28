package BusinessLogic;

import java.util.ArrayList;
import java.util.List;

import DataAcces.DAO.RelacionDao;
import DataAcces.DTO.RelacionDTO;

public class RelacionBL {
    private RelacionDTO relacion;
    private static RelacionDao relacionDao = new RelacionDao();

    public RelacionBL() {
    }

    public static ArrayList<RelacionDTO> getAll() throws Exception {
        return relacionDao.readAll();
    }

    public RelacionDTO getBy(int IdRelacion) throws Exception {
        relacion = relacionDao.readBy(IdRelacion);
        return relacion;
    }

    public boolean add(int IdRelacioTipo, int IdPersona1, int IdPersona2) throws Exception {
        relacion = new RelacionDTO();
        relacion.setIdRelacioTipo(IdRelacioTipo);
        relacion.setIdPersona1(IdPersona1);
        relacion.setIdPersona2(IdPersona2);
        return relacionDao.create(relacion);
    }

    public boolean update(int IdRelacion, int IdRelacioTipo, int IdPersona1, int IdPersona2) throws Exception {
        relacion = new RelacionDTO();
        relacion.setIdRelacion(IdRelacion);
        relacion.setIdRelacioTipo(IdRelacioTipo);
        relacion.setIdPersona1(IdPersona1);
        relacion.setIdPersona2(IdPersona2);
        return relacionDao.update(relacion);
    }

    public boolean delete(int IdRelacion) throws Exception {
        return relacionDao.delete(IdRelacion);
    }
}
