package Exerc_07;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("CADASTRO DO CLIENTE");
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o cpf: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite a data de nascimento: ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();
        System.out.println();

        Cliente cliente1 = new Cliente(nome, cpf, dataNascimento, telefone);

        System.out.println("CADASTRO DO LIVRO");
        System.out.print("Digite o nome do livro: ");
        String nomeLivro = scanner.nextLine();
        System.out.print("Digite o autor: ");
        String autor = scanner.nextLine();
        System.out.print("Digite a editora: ");
        String editora = scanner.nextLine();
        System.out.print("Digite a quantidade de páginas: ");
        int quantidadePagina = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        Livro livro1 = new Livro(nomeLivro, autor, quantidadePagina, editora);

        System.out.println("EMPRÉSTIMO DE LIVRO");
        System.out.print("Digite a data do empréstimo: ");
        String dataEmprestimo = scanner.nextLine();
        System.out.print("Digite a data da devolução: ");
        String dataDevolucao = scanner.nextLine();

        EmprestimoDTO emprestimo1 = new EmprestimoDTO(cliente1.nome, livro1.nomeLivro, dataEmprestimo, dataDevolucao);

        System.out.println();
        System.out.println("DADOS DO EMPRÉSTIMO");
        emprestimo1.exibirEmprestimo();

        scanner.close();

    }
}
