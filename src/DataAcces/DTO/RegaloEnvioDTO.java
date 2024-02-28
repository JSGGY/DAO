package DataAcces.DTO;

public class RegaloEnvioDTO {
    private Integer IdRegaloEnvio;
    private Integer IdRegalo;
    private String Estado;
    private Integer IdPersonaEnvia;
    private Integer IdPersonaRecibe;
    private Integer IdPersonaReparte;
    private String Nombre;
    private String FechaCrea;
    private String FechaModifica;
    private String FechaEnvio;

    public RegaloEnvioDTO() {
    };

    public RegaloEnvioDTO(Integer idRegaloEnvio, Integer idRegalo, String estado, Integer idPersonaEnvia,
            Integer idPersonaRecibe, Integer idPersonaReparte, String nombre, String fechaCrea, String fechaModifica,
            String fechaEnvio) {
        IdRegaloEnvio = idRegaloEnvio;
        IdRegalo = idRegalo;
        Estado = estado;
        IdPersonaEnvia = idPersonaEnvia;
        IdPersonaRecibe = idPersonaRecibe;
        IdPersonaReparte = idPersonaReparte;
        Nombre = nombre;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
        FechaEnvio = fechaEnvio;
    }

    public RegaloEnvioDTO(String text) {
        // TODO Auto-generated constructor stub
    }

    public Integer getIdRegaloEnvio() {
        return IdRegaloEnvio;
    }

    public void setIdRegaloEnvio(Integer idRegaloEnvio) {
        IdRegaloEnvio = idRegaloEnvio;
    }

    public Integer getIdRegalo() {
        return IdRegalo;
    }

    public void setIdRegalo(Integer idRegalo) {
        IdRegalo = idRegalo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public Integer getIdPersonaEnvia() {
        return IdPersonaEnvia;
    }

    public void setIdPersonaEnvia(Integer idPersonaEnvia) {
        IdPersonaEnvia = idPersonaEnvia;
    }

    public Integer getIdPersonaRecibe() {
        return IdPersonaRecibe;
    }

    public void setIdPersonaRecibe(Integer idPersonaRecibe) {
        IdPersonaRecibe = idPersonaRecibe;
    }

    public Integer getIdPersonaReparte() {
        return IdPersonaReparte;
    }

    public void setIdPersonaReparte(Integer idPersonaReparte) {
        IdPersonaReparte = idPersonaReparte;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
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

    public String getFechaEnvio() {
        return FechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        FechaEnvio = fechaEnvio;
    }

}
