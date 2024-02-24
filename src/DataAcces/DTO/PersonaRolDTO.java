package DataAcces.DTO;

public class PersonaRolDTO {
    private Integer IdPersonaRol;
    private Integer IdPersonaRolPadre;
    private String  Estado;
    private String  Nombre;
    private String  FechaCrea;
    private String  FechaModifica;
    
    public PersonaRolDTO() {}

    public PersonaRolDTO(Integer idPersonaRol, Integer idPersonaRolPadre,String estado ,String nombre,String fechaCrea, String fechaModifica) {
        IdPersonaRol = idPersonaRol;
        IdPersonaRolPadre = idPersonaRolPadre;
        Nombre = nombre;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
        Estado = estado;
    }

    public Integer getIdPersonaRol() {
        return IdPersonaRol;
    }
    public void setIdPersonaRol(Integer idPersonaRol) {
        IdPersonaRol = idPersonaRol;
    }
    public Integer getIdPersonaRolPadre() {
        return IdPersonaRolPadre;
    }
    public void setIdPersonaRolPadre(Integer idPersonaRolPadre) {
        IdPersonaRolPadre = idPersonaRolPadre;
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
    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    @Override
    public String toString(){
        return getClass().getName()+
         "\n IdPersonaRol:"+getIdPersonaRol()+
         "\n IdPersonaRolPadre:"+getIdPersonaRolPadre()+
         "\n Estado:"+getEstado()+
         "\nNombre:"   +getNombre()+
         "\nFechaCrea:"+getFechaCrea()+
         "\nFechaModifica"+getFechaModifica();
    }

    

}
