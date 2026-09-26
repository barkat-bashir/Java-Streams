package stream_api;

import java.util.ArrayList;
import java.util.Arrays;

//Count how many strings in a list have length greater than 4.
public class StringLengthCount {
    public static void main(String[] args) {
        ArrayList<String> namesList = new ArrayList<>(Arrays.asList("Barkat","Aman","Samir","Aamir","Ana","Ashiq","Afan","cabo","Asmaan","Athar","abc","fd"));

         long num = namesList.stream()
                .filter(name ->name.length() >4)
                .count();
         System.out.println(num);
    }
}
