package com.ecommerce.model;

public class Producto{
    //Atributos
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private String imagen;
    private int cantidad;
    //Constructores
    public Producto() {
    }
    //Constructor con parametros
    public Producto(int id, String nombre, String descripcion, double precio, String imagen, int cantidad) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        this.cantidad = cantidad;
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
//*************************************** */
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

//toString _____________________________________________________

    @Override
    public
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
                + ", imagen=" + imagen + ", cantidad=" + cantidad + "]";
    }
    
}