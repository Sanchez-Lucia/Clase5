public class ItemCarrito {

    private int cantidad;
    private Producto producto = new Producto();
    private Float precioUnitario;

    public Float calcularPrecioTotal() {
        float precio=0;
        precio= this.precioUnitario * this.producto.costoFinal(1);
        return precio;
    }
}
