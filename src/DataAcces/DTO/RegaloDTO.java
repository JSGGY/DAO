package DataAcces.DTO;

public class RegaloDTO {
    private Integer IdRegalo;
    private Integer IdRelacionTipo;
    private String  Estado;
    private String  Nombre;
    private Integer Stock;
    private Double  Precio;
    private String  FechaCrea;
    private String  FechaModifica;
    
    public RegaloDTO() {}

    public RegaloDTO(Integer idRegalo, Integer idRelacionTipo, String estado,String nombre, Integer stock, Double precio,String fechaCrea, String fechaModifica) {
        IdRegalo = idRegalo;
        IdRelacionTipo = idRelacionTipo;
        Nombre = nombre;
        Stock = stock;
        Precio = precio;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
        Estado = estado;
    }

    public Integer getIdRegalo() {
        return IdRegalo;
    }
    public void setIdRegalo(Integer idRegalo) {
        IdRegalo = idRegalo;
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
    public Integer getStock() {
        return Stock;
    }
    public void setStock(Integer stock) {
        Stock = stock;
    }
    public Double getPrecio() {
        return Precio;
    }
    public void setPrecio(Double precio) {
        Precio = precio;
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
         "\n IdRegalo:"+getIdRegalo()+
         "\n IdRelacionTipo:"+getIdRelacionTipo()+
         "\n Estado:"+getEstado()+
         "\nNombre:"   +getNombre()+
         "\nStock: "+getStock()+
         "\nPrecio: "+getPrecio()+
         "\nFechaCrea:"+getFechaCrea()+
         "\nFechaModifica"+getFechaModifica();
    }
}
