import java.util.Arrays;
import java.util.List;

public class Exerc_01 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //função lambida
        list.forEach(n -> System.out.println(n));
    }
}
