package ventas;

import empresa.Persona;
import java.time.LocalDateTime;

public class Carrito {

    private Persona persona = new Persona();
    private ItemCarrito item1 = new ItemCarrito();
    private ItemCarrito item2 = new ItemCarrito();
    private ItemCarrito item3 = new ItemCarrito();

    private ItemCarrito item4 = new ItemCarrito();

    private ItemCarrito item5 = new ItemCarrito();
    private LocalDateTime fechaCompra;


    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public ItemCarrito getItem1() {
        return item1;
    }

    public void setItem1(ItemCarrito item1) {
        this.item1 = item1;
    }

    public ItemCarrito getItem2() {
        return item2;
    }

    public void setItem2(ItemCarrito item2) {
        this.item2 = item2;
    }

    public ItemCarrito getItem3() {
        return item3;
    }

    public void setItem3(ItemCarrito item3) {
        this.item3 = item3;
    }

    public ItemCarrito getItem4() {
        return item4;
    }

    public void setItem4(ItemCarrito item4) {
        this.item4 = item4;
    }

    public ItemCarrito getItem5() {
        return item5;
    }

    public void setItem5(ItemCarrito item5) {
        this.item5 = item5;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    // valorDescuento=true es descuento fijo. valorDescuento=false es descuento con porcentaje
    public float precio(float descuento, int tipoDescuento) {

        float precioTotal=0;
        float precioTotalconDescuento = 0;

        precioTotal = getItem1().calcularPrecioTotal() + getItem2().calcularPrecioTotal() + getItem3().calcularPrecioTotal() + getItem4().calcularPrecioTotal() + getItem5().calcularPrecioTotal();


        if (tipoDescuento == 1) {
            Descuento descuentoFijo = new DescuentoFijo();
            descuentoFijo.setValorDesc(descuento);
            precioTotalconDescuento = descuentoFijo.valorFinal(precioTotal);
        } else if (tipoDescuento == 2) {
            Descuento descuentoPorcentaje = new DescuentoPorcentaje();
            descuentoPorcentaje.setValorDesc(descuento);
            precioTotalconDescuento = descuentoPorcentaje.valorFinal(precioTotal);
        } else if (tipoDescuento == 3) {
            Descuento descuentoPorcentajeTope = new DescuentoPorcentajeConTope();
            descuentoPorcentajeTope.setValorDesc(descuento);
            precioTotalconDescuento = descuentoPorcentajeTope.valorFinal(precioTotal);
        }


        return precioTotalconDescuento;
    }

}
