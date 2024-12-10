
package uf4actividadanalisis;

import Beans.GeneraAnalisis;
import Beans.Paciente;


public class UF4ActividadAnalisis {

   
    public static void main(String[] args) {
        // Crear un paciente
        //Valores Nom, ape, edad, telefono, valor ult FE, Valor ult urea
        Paciente paciente1 = new Paciente("Joe", "Pris", 30, 632023009, 10, 44); 

        // Crear un analisis
        GeneraAnalisis analisis1 = new GeneraAnalisis();

        // Asociar el paciente al análisis
        analisis1.setPaciente(paciente1);

        // Registrar el analisis como listener de cambios en el paciente
        paciente1.addPropertyChangeListener(analisis1);

        // Cambiar el valor de FE, lo que dispara un evento
        paciente1.setUltimo_hierro(30); // Esto genera una variación > 10 y debería activar el análisis
    }
    
}
