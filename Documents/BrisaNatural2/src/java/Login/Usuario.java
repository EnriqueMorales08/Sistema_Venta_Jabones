package Login;


public class Usuario {
    
    String correo, nombre, contraseña;
    public Usuario(){
        
    }

    public Usuario(String correo, String nombre, String contraseña) {
        this.correo = correo;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }
    
}
