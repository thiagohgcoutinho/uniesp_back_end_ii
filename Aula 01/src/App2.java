import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        Double nota1 = num.nextDouble();
        Double nota2 = num.nextDouble();
        Double nota3 = num.nextDouble();
        double media;

        media = (nota1 + nota2 + nota3)/3;

        if(media<4){
            System.out.println("Sua média é " + media);
            System.out.println("REPROVADO");
        } else if (media>3 && media<7) {
            System.out.println("Sua média é " + media);
            System.out.println("PROVA FINAL");
        } else {
            System.out.println("Sua média é " + media);
            System.out.println("APROVADO");
        }
    }
}
