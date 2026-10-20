package model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.List;



@Entity
@Table(name = "usuarios")

public class Usuario {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Atributos
    private int id;
    private String nombre;
    private String username;
    private String email;
    private String direccion;
    private String telefono;
    private String tipo;
    private String password;
    //Un usuario puede tener muchos productos
    @OneToMany (mappedBy = "usuario") 
    private List<Producto> productos; 
    //Un usuario puede tener muchas ordenes
    @OneToMany (mappedBy = "usuario")
    private List<Orden> ordenes;
    //Constructores
    public Usuario() {
    }
    //Constructor con parametros
    public Usuario(int id, String nombre, String username, String email, String direccion, String telefono, String tipo, String password) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipo = tipo;
        this.password = password;

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
//G & S USERNAME _____________________________________________________
    public String getUsername() {
        return username;
    }
    //*************************************** */
    public void setUsername(String username) {
        this.username = username;
    }
//G & S EMAIL _____________________________________________________
    public String getEmail() {
        return email;
    }
    //*************************************** */
    public void setEmail(String email) {
        this.email = email;
    }
//G & S DIRECCION _____________________________________________________
    public String getDireccion() {
        return direccion;
    }
    //*************************************** */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
//G & S TELEFONO _____________________________________________________
    public String getTelefono() {
        return telefono;
    }
    //*************************************** */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
//G & S TIPO _____________________________________________________
    public String getTipo() {
        return tipo;
    }
    //*************************************** */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
//G & S PASSWORD _____________________________________________________
    public String getPassword() {
        return password;
    }
    //*************************************** */
    public void setPassword(String password) {
        this.password = password;
    }
//G & S PRODUCTOS _____________________________________________________
    public List<Producto> getProductos() {
        return productos;
    }
    //*************************************** */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
//toString _____________________________________________________
    @Override

    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre='" + nombre + '\'' + ", username='" + username + '\'' + ", email='" + email + '\'' + ", direccion='" + direccion + '\'' + ", telefono='" + telefono + '\'' + ", tipo='" + tipo + '\'' + ", password='" + password + '\'' +
                '}';
    }
}
