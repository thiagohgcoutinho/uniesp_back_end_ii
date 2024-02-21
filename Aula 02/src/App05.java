import java.util.Scanner;

public class App05 {
    public static void main(String[] args) {
        int num1;

        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println("MENU");
            System.out.println("1 - CONTINUAR \n0 - SAIR");
            num1 = entrada.nextInt();
        } while (num1 != 0);

    }
}
