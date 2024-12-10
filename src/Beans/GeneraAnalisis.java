
package Beans;

//Importacion paquete beans
import java.beans.*;
import java.io.Serializable;
import java.util.Date;

public class GeneraAnalisis implements Serializable, PropertyChangeListener {
    //Atributos de la clase
    private int num_analisis;
    private Paciente paciente;
    private Date fecha;
    private boolean analisis_pendiente;

    //Constructor de la clase
    public GeneraAnalisis() {
        this.num_analisis = 0;
        this.fecha = new Date();
        this.analisis_pendiente = false;
    }

    //Asociacion del metodo
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("ultimo_hierro".equals(evt.getPropertyName())) { 
            int valor_anterior = (int) evt.getOldValue(); //Obtiene el valor antiguo
            int nuevo_valor = (int) evt.getNewValue(); //Obtiene el valor nuevo
            if (Math.abs(nuevo_valor - valor_anterior) > 10) { //Comprobacion 
                //compromacion del valor absoluto de los valores y verificacion si es > a 10
                System.out.println("Variacion de hierro detectada: " + Math.abs(nuevo_valor - valor_anterior));
                System.out.println("Se requiere otro analisis.");
                this.analisis_pendiente = true;
            }
            else {
                System.out.println("Valores normales");
            }
        }
    }

    public boolean isAnalisisPendiente() {
        return analisis_pendiente;
    }
}
