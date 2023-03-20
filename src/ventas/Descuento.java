package ventas;

public abstract class Descuento {

    private float valorDesc;


    public float getValorDesc() {
        return valorDesc;
    }

    public void setValorDesc(float valorDesc) {
        this.valorDesc = valorDesc;
    }

    public abstract float valorFinal(float valorInicial);

}
