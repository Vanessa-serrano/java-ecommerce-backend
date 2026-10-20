package model;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "ordenes")
public class Orden {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numero;
    private Date fechaCreacion;
    private Date fechaRecibida;

    private double total;

    //Un usuario puede tener muchas ordenes.
    @ManyToOne 
    private Usuario usuario;
    //Una orden puede tener un detalle
    @OneToOne (mappedBy = "orden")
    private DetalleOrden detalle;

    //Constructores
    public Orden() {
    }
    //Constructor con parametros
    public Orden(int id, String numero, Date fechaCreacion, Date fechaRecibida, double total) {
        this.id = id;
        this.numero = numero;
        this.fechaCreacion = fechaCreacion;
        this.fechaRecibida = fechaRecibida;
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
//G & S NUMERO _____________________________________________________
    public String getNumero() {
        return numero;
    }
    //*************************************** */
    public void setNumero(String numero) {
        this.numero = numero;
    }
//G & S FECHA CREACION _____________________________________________________
    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    //*************************************** */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
//G & S FECHA RECIBIDA _____________________________________________________
    public Date getFechaRecibida() {
        return fechaRecibida;
    }
    //*************************************** */
    public void setFechaRecibida(Date fechaRecibida) {
        this.fechaRecibida = fechaRecibida; 
    }
//G & S TOTAL _____________________________________________________
    public double getTotal() {
        return total;
    }
    //*************************************** */
    public void setTotal(double total) {
        this.total = total;
    }    
//G & S USUARIO _____________________________________________________
    public Usuario getUsuario() {
        return usuario;
    }   
    //*************************************** */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
//G & S DETALLES
    public DetalleOrden getDetalle(){
        return detalle;
    }
    //************************************** */
    public void setDetalle(DetalleOrden detalle){
        this.detalle = detalle;
    }

//toString _____________________________________________________
    @Override
    public String toString() {
        return "Orden{" + "id=" + id + ", numero='" + numero + '\'' + ", fechaCreacion=" + fechaCreacion + ", fechaRecibida=" + fechaRecibida + ", total=" + total + '}';
    }
}
