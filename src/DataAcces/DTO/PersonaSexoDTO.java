package DataAcces.DTO;

public class PersonaSexoDTO {
    private Integer IdPersonaSexo;
    private String  Nombre;
    private String  Estado;
    private String  FechaCrea;
    private String  FechaModifica;
    
    public PersonaSexoDTO() {}

    public PersonaSexoDTO(Integer idPersonaSexo, String nombre,String estado, String fechaCrea, String fechaModifica) {
        IdPersonaSexo = idPersonaSexo;
        Nombre = nombre;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
        Estado = estado;
    }

    public Integer getIdPersonaSexo() {
        return IdPersonaSexo;
    }
    public void setIdPersonaSexo(Integer idPersonaSexo) {
        IdPersonaSexo = idPersonaSexo;
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
         "\n IdPersonaSexo:"+getIdPersonaSexo()+
         "\nNombre:"   +getNombre()+
         "\nEstado:"   +getEstado()+
         "\nFechaCrea:"+getFechaCrea()+
         "\nFechaModifica"+getFechaModifica();
    }
}
