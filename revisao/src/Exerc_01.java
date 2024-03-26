import java.util.Scanner;

public class Exerc_01 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe um valor:");
        int valor = entrada.nextInt();
        int atual = 0;
        int proximo = 1;

        while (atual <= valor) {
            atual = atual + proximo;
            proximo = atual - proximo;
            System.out.print(proximo + ", ");
        }
        entrada.close();
    }

}
