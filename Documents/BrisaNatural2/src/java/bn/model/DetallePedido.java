package bn.model;

public class DetallePedido {
    private Integer idProd;
    private String tituloProducto;
    private Integer cantidad;
    private Double precio;
    private Double subTotal;

    public DetallePedido(Integer idProd, String tituloProducto, Integer cantidad, Double precio, Double subTotal) {
        this.idProd = idProd;
        this.tituloProducto = tituloProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subTotal = subTotal;
    }

    public DetallePedido() {

    }

    public Integer getIdProd() {
        return idProd;
    }

    public void setIdProd(Integer idProd) {
        this.idProd = idProd;
    }

    public String getTituloProducto() {
        return tituloProducto;
    }

    public void setTituloProducto(String tituloProducto) {
        this.tituloProducto = tituloProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

   
    
}
