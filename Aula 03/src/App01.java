import java.util.Random;
import java.util.Arrays;

public class App01 {
    public static void main(String[] args) {
        int [] arrayA = {12, 3, 5, 68, 9, 6, 73, 44, 456, 65};

        Arrays.sort(arrayA);


       for(int i = 0; i < arrayA.length; i++) {
           System.out.println(arrayA[i]);
       }


    }
}
