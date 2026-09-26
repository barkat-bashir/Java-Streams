package stream_api;

import java.util.*;
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

//using hashSet .collect(Collectors.toCollection(() -> new TreeSet<>(customComparator)));

        HashSet<String> sortedUniqueNames = namesList.stream()

                .collect(Collectors.toCollection(()->new TreeSet<>((a,b)->a.length() -b.length())));

        sortedUniqueNames.forEach(System.out::println);

    }
}
