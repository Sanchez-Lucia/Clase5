import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

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

    public void edad() {
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaDeNacimiento, ahora);
        System.out.printf("L edad es: %s años, %s meses y %s días",
                periodo.getYears(), periodo.getMonths(), periodo.getDays());
    }

}
