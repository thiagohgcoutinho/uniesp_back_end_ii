import java.util.Arrays;
import java.util.Scanner;

public class Exerc_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Escreva uma palavra: ");
        String palavra = scanner.nextLine();

        int[] valores = new int[palavra.length()];
        char[] letrasOrdenadas = new char[palavra.length()];

        for (int i = 0; i < palavra.length(); i++) {
            valores[i] = Character.toLowerCase(palavra.charAt(i)) - 'a' + 1;
        }

        System.out.println("Array: " + Arrays.toString(valores));

        Arrays.sort(valores);

        System.out.println("Array Ordenado: " + Arrays.toString(valores));

        for (int i = 0; i < valores.length; i++) {
            letrasOrdenadas[i] = (char) (valores[i] + 'a' - 1);
        }

        System.out.printf("A nova palvra é: " + new String(letrasOrdenadas));
    }
}
