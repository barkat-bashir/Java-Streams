package stream_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapPractice {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Java streams are powerful",
                "Streams help process data",
                "Unique words are important"
        );

        sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split((" "))))
                .map(String::toLowerCase)
                .distinct()
                .forEach(System.out::println);

        List<String> uniqueWords = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .distinct()
                .collect(Collectors.toList());

//        System.out.println(uniqueWords);

        // Given a list of lists of integers, flatten into a single list.
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9),
                Arrays.asList(10)
        );

        List<Integer> flatnedList =  numbers.stream()
                .flatMap(numList -> numList.stream())
                .filter(i->i%2==0)
                .toList();

        flatnedList.stream().forEach(System.out::println);


        // Cart Product of 2 Arrays

        List<String> letters = Arrays.asList("A", "B");
        List<Integer> digits = Arrays.asList(1, 2);

        List<String> pairs = letters.stream()
                .flatMap(letter -> digits.stream().map(digit -> letter + digit))
                .collect(Collectors.toList());

        System.out.println(pairs);

    }
}
