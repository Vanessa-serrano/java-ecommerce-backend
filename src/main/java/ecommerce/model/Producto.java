package ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
@Table(name = "productos")
public class Producto{
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    //Atributos
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private String imagen;
    private int cantidad;
    //Un usuario puede tener muchos productos
    @ManyToOne 
    private Usuario usuario;

    //Constructores
    public Producto() {
    }
    //Constructor con parametros
    public Producto(int id, String nombre, String descripcion, double precio, String imagen, int cantidad, Usuario usuario) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        this.cantidad = cantidad;
        this.usuario = usuario;
    }
//G & S ID _____________________________________________________
    public int getId() {
        return id;
    }
    //*************************************** */
    public void setId(int id) {
        this.id = id;
    }
//G & S NOMBRE _____________________________________________________
    public String getNombre() {
        return nombre;
    }
    //*************************************** */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
//G & S DESCRIPCION _____________________________________________________
    public String getDescripcion() {
        return descripcion;
    }
    //*************************************** */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
//G & S PRECIO _____________________________________________________
    public double getPrecio() {
        return precio;
    }
    //*************************************** */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
//G & S IMAGEN _____________________________________________________
    public String getImagen() {
        return imagen;
    }
    /*************************************** */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
//G & S CANTIDAD _____________________________________________________
    public int getCantidad() {
        return cantidad;
    }
    //*************************************** */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
//G & S USUARIO _____________________________________________________
    public Usuario getUsuario() {
        return usuario;
    }
    //*************************************** */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
//toString _____________________________________________________

    @Override

    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
                + ", imagen=" + imagen + ", cantidad=" + cantidad + "]";
    }
    
}