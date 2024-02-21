import java.util.Scanner;

public class App02 {
    public static void main(String[] args) {
        int num1, num2;

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o primeiro valor");
        num1 = entrada.nextInt();

        System.out.println("Digite o segundo valor");
        num2 = entrada.nextInt();

        System.out.println((num1>num2) ? "O maior valor é " + num1 : "O maior valor é " + num2);
    }
}
