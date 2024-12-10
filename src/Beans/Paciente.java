
package Beans;

//Importacion paquete beans
import java.beans.*;
import java.io.Serializable;

//Seriable permite guardar los objetos de esta clase y enviarlos
public class Paciente implements Serializable {
    private String nombre;
    private String apellido;
    private int edad;
    private int telefono;
    private int ultimo_hierro;
    private int ultimo_urea;

    //Gestion de eventos relacionados con cambiosn en las propiedades de la clase
    private final PropertyChangeSupport propertySupport;

    //Atributos
    public Paciente(String nombre, String apellido, int edad, int telefono, int ultimo_hierro, int ultimo_urea) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.ultimo_hierro = ultimo_hierro;
        this.ultimo_urea = ultimo_urea;
        this.propertySupport = new PropertyChangeSupport(this);
    }

    //Permite que otros obj escuchen agregando o eliminando
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

    //Metodos para actualizar el hierro
    public void setUltimo_hierro(int nuevo_hierro) {
        int hierro_anterior = this.ultimo_hierro; //guarda el valor del FE
        this.ultimo_hierro = nuevo_hierro; //Actualiza el valor
        propertySupport.firePropertyChange("ultimo_hierro", hierro_anterior, nuevo_hierro); //Notificacion de cambio a los listener
    }

    //Similar al del hierro
    public void setUltimo_urea(int nuevo_urea) {
        int urea_anterior = this.ultimo_urea;
        this.ultimo_urea = nuevo_urea;
        propertySupport.firePropertyChange("ultimo_urea", urea_anterior, nuevo_urea);
    }

    // Getters y setters adicionales
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public int getUltimo_hierro() {
        return ultimo_hierro;
    }

    public int getUltimo_urea() {
        return ultimo_urea;
    }
}
