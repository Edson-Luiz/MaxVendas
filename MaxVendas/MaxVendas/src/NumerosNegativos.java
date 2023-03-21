public class NumerosNegativos extends Exception{
    private Double n1;

    public NumerosNegativos(Double n1){
        super();
        this.n1 = n1;

    }

    @Override
    public String toString() {
        return "Este valor é negativo";
    }
}
