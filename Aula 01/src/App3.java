import java.util.Scanner;

public class App3 {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        double num1 = num.nextDouble();
        double num2 = num.nextDouble();

        Scanner op = new Scanner(System.in);
        String ope = op.nextLine();

        switch (ope){
            case "+":
                System.out.println(num1 + num2);
            break;
            case "-":
                System.out.println(num1 - num2);
            break;
            case "*":
                System.out.println(num1 * num2);
            break;
            case "/":
                System.out.println(num1 / num2);
            break;
            default:
                System.out.println("Operação não válida");
        }

    }
}
