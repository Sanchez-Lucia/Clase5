package ventas;

public class DescuentoPorcentajeConTope extends Descuento {

    private float tope;

    @Override
    public float valorFinal(float valorInicial) {
        if ((valorInicial * this.getValorDesc()/100) >= tope) {
            valorInicial = valorInicial - tope;
        } else {
            valorInicial = valorInicial - (valorInicial * this.getValorDesc()/100);
        }
        return valorInicial;
    }

    public float getTope() {
        return tope;
    }

    public void setTope(float tope) {
        this.tope = tope;
    }
}
