package stream_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDupStrings {
    public static void main(String[] args) {
        ArrayList<String> namesList = new ArrayList<>(
                Arrays.asList("Barkat","Aman","Barkat","Aamir","Ana","Aamir","Afan","cabo","Asmaan","Athar","cc","aa","cc")
        );
        namesList.stream()
                .distinct()   // removes duplicates
                .sorted()     // lexigrphicallly
              //  .sorted((a,b)->a.length()-b.length()) // based on length
                .forEach(System.out::println);


    }
}
