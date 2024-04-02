public class Teste {
    public static void main(String[] args) {
        int valor = 100;
        int cont = 1;
        while (cont < valor) {
            System.out.println(cont);
            cont = cont + (valor/cont);
        }
    }
}
