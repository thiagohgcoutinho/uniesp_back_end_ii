public class Compras {

    private String descricao;
    private double valor;
    private int quantidade;

    public Compras(String descricao, double valor, int quantidade) {
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }


    public int getQuantidade() {
        return quantidade;
    }


    public double valorTotal(){
        valor = getValor();
        quantidade = getQuantidade();
        return valor * quantidade;
    }

    public static void main(String[] args) {

        Compras compras1 = new Compras("Carro", 35000, 5);

        System.out.println(compras1.valorTotal());

    }
}
