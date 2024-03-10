import java.util.Random;
import java.util.Scanner;

public class Exerc_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        int randomico = random.nextInt(1000);

        int tentativas = 0;

        System.out.printf("Escolha um número inteiro entre 0 e 1000: ");
        int num = scanner.nextInt();
        tentativas++;

        while (num != randomico) {
            if (num < randomico) {
                System.out.printf("O número sorteado é maior que o informado. Digite outro número: ");

            } else {
                System.out.printf("O número sorteado é menor que o informado. Digite outro número: ");

            }
            num = scanner.nextInt();
            tentativas++;
        }

        System.out.println("Correto! O número sorteado é " + num + ".");
        System.out.println("Você acertou em " + tentativas + " tentativas.");

        scanner.close();
    }
}
