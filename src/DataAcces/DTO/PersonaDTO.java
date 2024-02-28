package DataAcces.DTO;

public class PersonaDTO {
    private Integer IdPersona;
    private String Nombre;
    private Integer IdPersonaRol;
    private Integer IdPersonaSexo;
    private String Cedula;
    private String FechaCrea;
    private String FechaModifica;

    public PersonaDTO(Integer idPersona, String nombre, Integer idPersonaRol, Integer idPersonaSexo, String cedula,
            String fechaCrea, String fechaModifica) {
        IdPersona = idPersona;
        Nombre = nombre;
        IdPersonaRol = idPersonaRol;
        IdPersonaSexo = idPersonaSexo;
        Cedula = cedula;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }

    public PersonaDTO() {
    };

    public PersonaDTO(Integer idPersonaRol) {
        IdPersonaRol = idPersonaRol;
    }

    public Integer getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(Integer idPersona) {
        IdPersona = idPersona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Integer getIdPersonaRol() {
        return IdPersonaRol;
    }

    public void setIdPersonaRol(Integer idPersonaRol) {
        IdPersonaRol = idPersonaRol;
    }

    public Integer getIdPersonaSexo() {
        return IdPersonaSexo;
    }

    public void setIdPersonaSexo(Integer idPersonaSexo) {
        IdPersonaSexo = idPersonaSexo;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
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

    public String toStringIdPersonaRol() {
        return "" + IdPersonaRol;
    }

}
