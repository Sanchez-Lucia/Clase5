public class Producto {

    private String codigo;
    private String nombre;
    private Float precio;

    private static float porcentajeEnTresCuotas = 0.10f;

    public Float costoFinal(Integer cantCuotas) {
        float costo=0;
        switch (cantCuotas) {
            case 1: {
                costo=this.precio;
                break;
            }
            case 3: {
                costo = this.precio + (this.precio*porcentajeEnTresCuotas);
                break;
            }
        }
        return costo;
    }

}
