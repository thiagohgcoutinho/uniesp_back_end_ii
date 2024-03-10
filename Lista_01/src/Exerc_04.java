import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Exerc_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Escreva uma frase: ");
        String frase = scanner.nextLine();

        String fraseInvertida = "";

        for (int i = frase.length() - 1; i >= 0; i--) {
            fraseInvertida += frase.charAt(i);
        }

        System.out.printf("A frase invertida é: " + fraseInvertida);

        scanner.close();
    }
}
