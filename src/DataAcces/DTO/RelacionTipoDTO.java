package DataAcces.DTO;

public class RelacionTipoDTO {
    private Integer IdRelacionTipo;
    private String  Nombre;
    private String  Estado;
    private String  Observacion;
    private String  FechaCrea;
    private String  FechaModifica;
    public RelacionTipoDTO() {}

    public RelacionTipoDTO(Integer idRelacionTipo, String nombre,String estado, String fechaCrea,String fechaModifica) {
        IdRelacionTipo = idRelacionTipo;
        Nombre = nombre;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
        Estado = estado;
    }

    public Integer getIdRelacionTipo() {
        return IdRelacionTipo;
    }
    public void setIdRelacionTipo(Integer idRelacionTipo) {
        IdRelacionTipo = idRelacionTipo;
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
         "\n IdRelacionTipo:"+getIdRelacionTipo()+
         "\nNombre:"   +getNombre()+
         "\nEstado:"  +getEstado()+
         "\nFechaCrea:"+getFechaCrea()+
         "\nFechaModifica"+getFechaModifica();
    }
}
