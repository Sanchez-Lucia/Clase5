package empresa;

import ventas.Descuento;
import ventas.DescuentoFijo;
import ventas.DescuentoPorcentaje;

public class Producto {

    private String codigo;
    private String nombre;
    private float precio;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }


    private static float porcentajeEnTresCuotas = 0.10f;

    public float costoFinal(int cantCuotas) {
        float costo=0;
        switch (cantCuotas) {
            case 1: {
                costo= this.getPrecio();
                break;
            }
            case 3: {
                costo = this.getPrecio() + (this.getPrecio() *  porcentajeEnTresCuotas);
                break;
            }
        }

        return costo;
    }
}
