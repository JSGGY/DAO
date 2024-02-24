package DataAcces.DTO;

public class RegaloTipoDTO {
    private Integer IdRegaloTipo;
    private String  Nombre;
    private String  Estado;
    private String  Observacion;
    private String  FechaCrea;
    private String  FechaModifica;
    
    public RegaloTipoDTO() {}

    public RegaloTipoDTO(Integer idRegaloTipo, String nombre,String estado, String observacion, String fechaCrea,String fechaModifica) {
        IdRegaloTipo = idRegaloTipo;
        Nombre = nombre;
        Observacion = observacion;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
        Estado = estado;
    }

    public Integer getIdRegaloTipo() {
        return IdRegaloTipo;
    }
    public void setIdRegaloTipo(Integer idRegaloTipo) {
        IdRegaloTipo = idRegaloTipo;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getObservacion() {
        return Observacion;
    }
    public void setObservacion(String observacion) {
        Observacion = observacion;
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
         "\n IdRegaloTipo:"+getIdRegaloTipo()+
         "\nNombre:"   +getNombre()+
         "\nEstado:"  +getEstado()+
         "\nObservacion:"   +getObservacion()+
         "\nFechaCrea:"+getFechaCrea()+
         "\nFechaModifica"+getFechaModifica();
    }
}
