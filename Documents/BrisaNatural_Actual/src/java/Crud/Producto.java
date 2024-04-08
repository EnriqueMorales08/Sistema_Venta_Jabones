package Crud;

import java.io.InputStream;


public class Producto {

    private int id;
    private InputStream img;
    private String titulo;
    private String descripción;
    private String gramos;
    private double precio;
    private String tipopiel;
    private String categoria;
    
    public Producto(){
        
    }

    public Producto(int id, InputStream img, String titulo, String descripción, String gramos, double precio, String tipopiel, String categoria) {
        this.id = id;
        this.img = img;
        this.titulo = titulo;
        this.descripción = descripción;
        this.gramos = gramos;
        this.precio = precio;
        this.tipopiel = tipopiel;
        this.categoria = categoria;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the img
     */
    public InputStream getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(InputStream img) {
        this.img = img;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the descripción
     */
    public String getDescripción() {
        return descripción;
    }

    /**
     * @param descripción the descripción to set
     */
    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    /**
     * @return the gramos
     */
    public String getGramos() {
        return gramos;
    }

    /**
     * @param gramos the gramos to set
     */
    public void setGramos(String gramos) {
        this.gramos = gramos;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(String precio) {
        this.precio = Double.parseDouble(precio);
    }

    /**
     * @return the tipopiel
     */
    public String getTipopiel() {
        return tipopiel;
    }

    /**
     * @param tipopiel the tipopiel to set
     */
    public void setTipopiel(String tipopiel) {
        this.tipopiel = tipopiel;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
    
}
