
package bn.model;

public class Producto {
    private Integer idProd;
    private String titulo;
    private String descripcion;
    private String gramos;
    private Double precio;
    private Integer tipoPiel;
    private Integer idCategoria;

    public Producto() {
    }

    public Integer getIdProd() {
        return idProd;
    }

    public void setIdProd(Integer idProd) {
        this.idProd = idProd;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGramos() {
        return gramos;
    }

    public void setGramos(String gramos) {
        this.gramos = gramos;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getTipoPiel() {
        return tipoPiel;
    }

    public void setTipoPiel(Integer tipoPiel) {
        this.tipoPiel = tipoPiel;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    
}
