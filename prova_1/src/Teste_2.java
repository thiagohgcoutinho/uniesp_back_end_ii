import java.util.Arrays;
import java.util.List;

public class Teste_2 {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(5, 2, 8, 3, 1);
        numeros.sort((n1, n2) -> n1.compareTo(n2));
        System.out.println(numeros);
    }

}
