package ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name ="detalles")
public class DetalleOrden {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    //Atributos
    private int id;
    private String nombre;
    private double precio;
    private int cantidad;   
    private double total;

    @OneToOne 
    private Orden orden;

    @OneToOne 
    private Producto producto;

    //Constructores
    public DetalleOrden() {
    }
    //Constructor con parametros
    public DetalleOrden(int id, String nombre, double precio, int cantidad, double total) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = total;
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
//G & S PRECIO _____________________________________________________
    public double getPrecio() {
        return precio;
    }
    //*************************************** */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
//G & S CANTIDAD _____________________________________________________    
    public int getCantidad() {
        return cantidad;
    }
    //*************************************** */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
//G & S TOTAL _____________________________________________________
    public double getTotal() {
        return total;
    }
    //*************************************** */
    public void setTotal(double total) {
        this.total = total;
    }

//toString _____________________________________________________
    @Override 
    public String toString() {
        return "DetalleOrden [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad
                + ", total=" + total + "]";
    }
}
