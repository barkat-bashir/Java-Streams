package stream_api;

/*
Q: From a list of strings, filter names starting with "A" and convert them to uppercase.
Learn about : Filter, String Operations , terminal operation
*/

import java.util.ArrayList;
import java.util.Arrays;

public class NameFilter {
    public static void main(String[] args){
        ArrayList<String> namesList = new ArrayList<>(Arrays.asList("Barkat","Aman","Samir","Aamir","Ana","Ashiq","Afan","cabo","Asmaan","Athar"));
        namesList.stream()
                .filter(name->name.startsWith("A") || name.startsWith("a"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }


}
