public class Produto {

    private Double preco_compra;
    private Double preco_venda;
    private int qtde;

    public Produto(){

    }

    public Double getPreco_compra() {
        return preco_compra;
    }

    public Double getPreco_venda() {
        return preco_venda;
    }

    public int getQtde() {
        return qtde;
    }

    public void setPreco_compra(Double preco_compra) {
        this.preco_compra = preco_compra;
    }

    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public void setQtde(int qtde) {
            this.qtde = qtde;

    }


}
