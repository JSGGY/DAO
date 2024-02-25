package BusinessLogic;

import java.util.List;

import DataAcces.DAO.UsuarioSistemDAO;
import DataAcces.DTO.UsuarioSistemaDTO;

public class UsuarioSistemaBL {
    private UsuarioSistemaDTO usuarioSistema;
    private UsuarioSistemDAO usDAO = new UsuarioSistemDAO();

    public UsuarioSistemaBL(){}

    public List<UsuarioSistemaDTO> getAll() throws Exception{
        return usDAO.readAll();
    }
    public UsuarioSistemaDTO getById(int idUsuarioSistema) throws Exception{
        usuarioSistema = usDAO.readBy(idUsuarioSistema);
        return usuarioSistema;
    }
    public boolean create(UsuarioSistemaDTO usuarioSistemaDTO) throws Exception{   
        return usDAO.create(usuarioSistemaDTO);
    }
    public boolean update(UsuarioSistemaDTO UsuarioSistemaDTO) throws Exception{
        return usDAO.update(UsuarioSistemaDTO);
    }
    public boolean delete(int idUsuarioSistema) throws Exception{
        return usDAO.delete(idUsuarioSistema);
    }
}
