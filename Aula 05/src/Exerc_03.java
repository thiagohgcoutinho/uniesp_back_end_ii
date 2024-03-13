import java.util.ArrayList;
import java.util.List;

public class Exerc_03 {
    public static void main(String[] args) {
        List<String> nomes = List.of("Carlos", "José", "Thiago", "Maria", "Manuel", "Felipe", "Marta", "Rayana", "Daniel", "Demetrius");

        List<String> nomesM = new ArrayList<>();

        for (int i = 0; i < nomes.size(); i++) {
            String word = nomes.get(i);
            if(word.startsWith("M")) {
                nomesM.add(word);
            }
        }


        System.out.println(nomesM);
    }

}
