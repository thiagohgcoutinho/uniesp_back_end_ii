import java.util.Scanner;

interface Calculadora {
    int calculadora(int a, int b);
}

public class Exerc_02 {
    public static void main(String[] args) {
        Calculadora somar = new Calculadora() {
            @Override
            public int calculadora(int a, int b) {
                return a + b;
            }
        };

        Calculadora subtrair = new Calculadora() {
            @Override
            public int calculadora(int a, int b) {
                return a - b;
            }
        };

        Calculadora multiplicar = new Calculadora() {
            @Override
            public int calculadora(int a, int b) {
                return a * b;
            }
        };

        Calculadora dividir = new Calculadora() {
            @Override
            public int calculadora(int a, int b) {
                return a / b;
            }
        };

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o primeiro valor: ");
        int valor1 = scanner.nextInt();

        System.out.print("Informe o segundo valor: ");
        int valor2 = scanner.nextInt();

        int resultadoSomar = somar.calculadora(valor1, valor2);
        int resultadoSubtrair = subtrair.calculadora(valor1, valor2);
        int resultadoMultiplicar = multiplicar.calculadora(valor1, valor2);
        int resultadoDividir = dividir.calculadora(valor1, valor2);

        System.out.println("Soma: " + resultadoSomar);
        System.out.println("Subtração: " + resultadoSubtrair);
        System.out.println("Multiplicação: " + resultadoMultiplicar);
        System.out.println("Divisão: " + resultadoDividir);

        scanner.close();
    }
}
