package DataAcces.DTO;
public class RelacionDTO {

    private Integer IdRelacion ;
    private Integer IdRelacioTipo;
    private String Estado;
    private Integer IdPersona1;
    private Integer IdPersona2;
    private String FechaCrea;
    private String FechaModifica;

    public RelacionDTO(){};
    
    public RelacionDTO(Integer idRelacion, Integer idRelacioTipo, String estado, Integer idPersona1, Integer idPersona2,
            String fechaCrea, String fechaModifica) {
        IdRelacion = idRelacion;
        IdRelacioTipo = idRelacioTipo;
        Estado = estado;
        IdPersona1 = idPersona1;
        IdPersona2 = idPersona2;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }
    public Integer getIdRelacion() {
        return IdRelacion;
    }
    public void setIdRelacion(Integer idRelacion) {
        IdRelacion = idRelacion;
    }
    public Integer getIdRelacioTipo() {
        return IdRelacioTipo;
    }
    public void setIdRelacioTipo(Integer idRelacioTipo) {
        IdRelacioTipo = idRelacioTipo;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    public Integer getIdPersona1() {
        return IdPersona1;
    }
    public void setIdPersona1(Integer idPersona1) {
        IdPersona1 = idPersona1;
    }
    public Integer getIdPersona2() {
        return IdPersona2;
    }
    public void setIdPersona2(Integer idPersona2) {
        IdPersona2 = idPersona2;
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


    
}
