package DataAcces.DTO;
public class UsuarioSistemaDTO {
    private Integer IdUsuarioSistema;
    private String  Usuario         ;
    private String  Contraseña      ;
    private String  Estado          ;
    private String  FechaCrea       ;
    private String  FechaModifica   ;

    public UsuarioSistemaDTO(){};

    public UsuarioSistemaDTO(Integer idUsuarioSistema, String usuario, String contraseña, String estado,
            String fechaCrea, String fechaModifica) {
        IdUsuarioSistema = idUsuarioSistema;
        Usuario = usuario;
        Contraseña = contraseña;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }
    public Integer getIdUsuarioSistema() {
        return IdUsuarioSistema;
    }
    public void setIdUsuarioSistema(Integer idUsuarioSistema) {
        IdUsuarioSistema = idUsuarioSistema;
    }
    public String getUsuario() {
        return Usuario;
    }
    public void setUsuario(String usuario) {
        Usuario = usuario;
    }
    public String getContraseña() {
        return Contraseña;
    }
    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    public String getFechaCrea() {
        return FechaCrea;
    }
    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }
    public String getFechaModifica() {
        return FechaModifica;
    }
    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }
};
