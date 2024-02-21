import java.util.Scanner;

public class App01 {
    public static void main(String[] args) {
        int num1, num2, num3;

        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe o primeiro valor");
        num1 = entrada.nextInt();

        System.out.println("Informe o segundo valor");
        num2 = entrada.nextInt();

        System.out.println("Informe o terceiro valor");
        num3 = entrada.nextInt();

        if (num1>num2 && num2>num3){
            System.out.println(num1 + " " + num2 + " " + num3);
        } else if (num2>num1 && num2>num3 && num1>num3) {
            System.out.println(num2 + " " + num1 + " " + num3);
        } else if (num3>num1 && num3>num2 && num1>num2) {
            System.out.println(num3 + " " + num1 + " " + num2);
        } else if (num1>num2 && num1>num3 && num3>num2) {
            System.out.println(num1 + " " + num3 + " " + num2);
        } else if (num2>num1 && num2>num3 && num3>num1) {
            System.out.println(num2 + " " + num3 + " " + num1);
        } else {
            System.out.println(num3 + " " + num2 + " " + num1);
        }

    }

}
