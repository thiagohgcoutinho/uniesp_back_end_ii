import java.util.Scanner;

public class Exerc_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Escreva seu nome completo: ");
        String nome = scanner.nextLine();

        StringBuilder iniciais = new StringBuilder();

        if (Character.isUpperCase(nome.charAt(0))) {
            iniciais.append(nome.charAt(0)).append(".");
        }

        for (int i = 1; i < nome.length(); i++) {
            if (nome.charAt(i-1) == ' ' && Character.isUpperCase(nome.charAt(i))) {
                iniciais.append(nome.charAt(i)).append(".");
            }
        }

        System.out.println("As iniciais do nome informado são: " + iniciais.toString());

        scanner.close();
    }
}
