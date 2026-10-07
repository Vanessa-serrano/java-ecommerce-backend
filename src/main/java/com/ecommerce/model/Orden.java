package com.ecommerce.model;
import java.util.Date;

public class Orden {
    //Atributos
    private int id;
    private String numero;
    private Date fechaCreacion;
    private Date fechaRecibida;

    private double total;
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
}
