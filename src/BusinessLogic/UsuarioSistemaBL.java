package BusinessLogic;

import java.util.List;

import DataAcces.DAO.UsuarioSistemDAO;
import DataAcces.DTO.UsuarioSistemaDTO;

public class UsuarioSistemaBL {
    private UsuarioSistemaDTO usuarioSistema;
    private UsuarioSistemDAO usuarioSistemaDao = new UsuarioSistemDAO();

    public UsuarioSistemaBL(){}

    public List<UsuarioSistemaDTO> getAll() throws Exception{
        return usuarioSistemaDao.readAll();
    }

    public UsuarioSistemaDTO getBy(int IdUsuarioSistema) throws Exception{
        usuarioSistema = usuarioSistemaDao.readBy(IdUsuarioSistema);
        return usuarioSistema;
    }

    public boolean add(String Usuario, String Contraseña) throws Exception{
        usuarioSistema = new UsuarioSistemaDTO();
        usuarioSistema.setUsuario(Usuario);
        usuarioSistema.setContraseña(Contraseña);
        return usuarioSistemaDao.create(usuarioSistema);
    }

    public boolean update(int IdUsuarioSistema,String Usuario, String Contraseña) throws Exception{
        usuarioSistema = new UsuarioSistemaDTO();
        usuarioSistema.setIdUsuarioSistema(IdUsuarioSistema);
        usuarioSistema.setUsuario(Usuario);
        usuarioSistema.setContraseña(Contraseña);
        return usuarioSistemaDao.update(usuarioSistema);
    }

    public boolean delete(int IdUsuarioSistema) throws Exception{
        return usuarioSistemaDao.delete(IdUsuarioSistema);
    }
}
