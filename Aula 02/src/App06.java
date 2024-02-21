import java.util.Scanner;

public class App06 {
    public static void main(String[] args) {
        int a, b, c;

        double delta, x1, x2;

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o valor de a");
        a = entrada.nextInt();

        System.out.println("Digite o valor de b");
        b = entrada.nextInt();

        System.out.println("Digite o valor de c");
        c = entrada.nextInt();

        delta = (b * b) - (4 * a * c);

        if (delta < 0) {
            System.out.println("A equação não possui raízes reais");
        } else {
            x1 = ((-b) + Math.sqrt(delta)) / (2 * a);
            x2 = ((-b) - Math.sqrt(delta)) / (2 * a);
            System.out.println("O valor de x1 é " + x1);
            System.out.println("O valor de x2 é " + x2);
            if (x1 >= 0 && x2 >= 0) {
                double soma = x1 + x2;
                for (int i = 0; i <= soma; i++) {
                    System.out.print(i);
                }
                System.out.println();
                while (soma > 13) {
                    soma-=5;
                    }
                int resultado = (int) soma;
                switch (resultado) {
                    case (0) -> System.out.println("Não tem mês correspondente");
                    case (1) -> System.out.println("JANEIRO");
                    case (2) -> System.out.println("FEVEREIRO");
                    case (3) -> System.out.println("MARÇO");
                    case (4) -> System.out.println("ABRIL");
                    case (5) -> System.out.println("MAIO");
                    case (6) -> System.out.println("JUNHO");
                    case (7) -> System.out.println("JULHO");
                    case (8) -> System.out.println("AGOSTO");
                    case (9) -> System.out.println("SETEMBRO");
                    case (10) -> System.out.println("OUTUBRO");
                    case (11) -> System.out.println("NOVEMBRO");
                    case (12) -> System.out.println("DEZEMBRO");
                }
            }

        }
    }
}
