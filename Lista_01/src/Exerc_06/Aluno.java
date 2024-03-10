package Exerc_06;

public class Aluno {

    String nome;
    int nota1, nota2, nota3;

    public Aluno(String nome, int nota1, int nota2, int nota3) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public double calcularMedia () {
        return (nota1 + nota2 + nota3) / 3.0;
    }

}
