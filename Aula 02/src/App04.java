import java.util.Scanner;

public class App04 {
    public static void main(String[] args) {
        int num1, i=1;

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite a quantidade de repetições");
        num1 = entrada.nextInt();

        while (i <= num1) {
            System.out.println("Uniesp");
            i++;

            entrada.close();
        }
    }
}
