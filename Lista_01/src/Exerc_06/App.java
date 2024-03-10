package Exerc_06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Aluno> alunos = new ArrayList<>();

        while (true) {
            System.out.print("Digite o nome do aluno ou 'sair' para encerrar: ");
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("sair")) break;

            System.out.print("Digite a primeira nota: ");
            int nota1 = scanner.nextInt();
            System.out.printf("Digite a segunda nota: ");
            int nota2 = scanner.nextInt();
            System.out.printf("Digite a terceira nota: ");
            int nota3 = scanner.nextInt();
            scanner.nextLine();

            alunos.add(new Aluno(nome, nota1, nota2, nota3));
        }

        int totalAprovados = 0;
        int totalReprovados = 0;
        double somaMedias = 0;

        for (Aluno aluno : alunos) {
            double media = aluno.calcularMedia();
            somaMedias += media;
            String resultado;
            if (media >= 6) {
                resultado = "Aprovado";
            } else {
                resultado = "Reprovado";
            }
            System.out.println(aluno.nome + ": Notas: " + aluno.nota1 + ", " + aluno.nota2 + " e " + aluno.nota3 + " e Média: " + String.format("%.2f", media) + ". (" + resultado + ").");

            if (media >= 6) {
                totalAprovados++;
            } else {
                totalReprovados++;
            }
        }

        System.out.println("Média Geral da turma: " + String.format("%.2f", somaMedias / alunos.size()));
        System.out.println("Total de alunos aprovados: " + totalAprovados);
        System.out.println("Total de alunos reprovados: " + totalReprovados);
        System.out.println("Nome dos alunos aprovados: ");
        for (Aluno aluno : alunos) {
            if (aluno.calcularMedia() >= 6) {
                System.out.println(aluno.nome + " ");
            }
        }
        System.out.println("Nome dos alunos reprovados: ");
        for (Aluno aluno : alunos) {
            if (aluno.calcularMedia() < 6) {
                System.out.println(aluno.nome + " ");
            }
        }
        scanner.close();
    }
}
