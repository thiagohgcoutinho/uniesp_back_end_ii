package Exerc_07;

public class EmprestimoDTO {
    String nomeCliente;
    String nomeLivro;
    String dataEmprestimo;
    String dataDevolucao;

    public EmprestimoDTO(String nomeCliente, String nomeLivro, String dataEmprestimo, String dataDevolucao) {
        this.nomeCliente = nomeCliente;
        this.nomeLivro = nomeLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public void exibirEmprestimo() {
        System.out.println("Nome do cliente: " + nomeCliente);
        System.out.println("Nome do livro: " + nomeLivro);
        System.out.println("Data do empréstimo: " + dataEmprestimo);
        System.out.println("Data da devolução: " + dataDevolucao);
    }
}
