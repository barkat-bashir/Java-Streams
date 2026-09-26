package stream_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class SumMinMaxAvg {
    public static void main(String [] args){
        int sum ;
        int min ;
        int max ;
        int avg ;
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(
                12, 45, 7, 23, 89, 34, 56, 18, 91, 40
        ));
        sum = numbers.stream().mapToInt(Integer::intValue).sum();  // using mapToInteger
        System.out.println("sum :" + sum);

        sum = numbers.stream().reduce(0,(a,b)-> a+b); // using reduce operation
        System.out.println("sum :" + sum);

//  MINIMUM
       min = numbers.stream()
               .min(Integer::compare).orElse(-1);
        System.out.println("Min using min  : "+ min);


        min = numbers.stream()
                .reduce((a,b)-> a<b ? a: b).orElse(-100);

        System.out.println("Min using reduce : "+ min);


// MAXIMUM
        max = numbers.stream().max(Integer::compare).orElse(Integer.MIN_VALUE);
        System.out.println("MAX using max  : "+ max);


        max = numbers.stream().
                reduce(((num1,num2) -> num1 >num2 ? num1 : num2)).orElse(Integer.MIN_VALUE);
        System.out.println("MAX using reduce  : "+ max);

        // uising math library

        max = numbers.stream()
                 .reduce(Math::max).orElse(Integer.MIN_VALUE);
        System.out.println("MAX using  reduce with Math::max  : "+ max);


        // AVERAGE
        double average = numbers.stream()
                .reduce(0, Integer::sum) / (double) numbers.size();

        System.out.println("Average = " + average);
    }
}
