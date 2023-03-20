package empresa;

import java.time.LocalDate;
import java.time.Period;

public class Persona {

    private String apellido;
    private LocalDate fechaDeNacimiento;
    private String nombre;

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer edad() {
        Integer edad=0;
        // Calculamos la edad:
        //Obtenemos la fecha actual:
        LocalDate fechaActual=LocalDate.now();
        //Obtenemos el periodo entre dos fechas:
        Period periodo=Period.between(fechaDeNacimiento, fechaActual);
        //Ahora obtenemos la cantidad de años en ese periodo:
        edad=periodo.getYears();
        //Devolvemos la edad:
        return edad;
    }

}
