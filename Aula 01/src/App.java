import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        int valor = num.nextInt();
        int i;
        int x;

        for (i=0; i<valor; i++){
            for (x=0; x<i; x++){
                System.out.print("+");
            }
            System.out.println("+");
        }

    }
}
