package DataAcces.DTO;

public class UsuarioSistemaDTO {
    private Integer IdUsuarioSistema;
    private Integer IdPersona;
    private String Contraseña;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;

    public UsuarioSistemaDTO() {
    };

    public UsuarioSistemaDTO(Integer idUsuarioSistema, Integer usuario, String contraseña, String estado,
            String fechaCrea, String fechaModifica) {
        IdUsuarioSistema = idUsuarioSistema;
        IdPersona = usuario;
        Contraseña = contraseña;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }

    public UsuarioSistemaDTO(int idPersona) {
        IdPersona = idPersona;
    }

    public UsuarioSistemaDTO(int idPersona, String nombreUsuario) {
        // TODO Auto-generated constructor stub
    }

    public UsuarioSistemaDTO(String clave) {
        Contraseña = clave;
    }

    public Integer getIdUsuarioSistema() {
        return IdUsuarioSistema;
    }

    public void setIdUsuarioSistema(Integer idUsuarioSistema) {
        IdUsuarioSistema = idUsuarioSistema;
    }

    public Integer getUsuario() {
        return IdPersona;
    }

    public void setUsuario(Integer usuario) {
        IdPersona = usuario;
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

    // Constructor, getters y setters

    public String toStringIdPersona() {
        return "" + IdPersona;
    }

    public String toStringClave() {
        return Contraseña;
    }

};
