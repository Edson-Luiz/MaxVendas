public class QuantidadeException extends Exception{
    private int qtde;

    public QuantidadeException(int qtde){
        super();
        this.qtde = qtde;
    }

    @Override
    public String toString() {
        return "A quantidade é menor ou igual a zero!";
    }
}
