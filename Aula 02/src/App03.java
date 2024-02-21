import java.util.Scanner;

public class App03 {
    public static void main(String[] args) {
        int num1;

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o valor");
        num1 = entrada.nextInt();

        for (int i = 1; i <= num1 ; i++){
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
