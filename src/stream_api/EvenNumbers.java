package stream_api;

import java.util.*;
import java.util.stream.Collectors;

/*From a list of integers, find all even numbers and return them sorted in descending order.
*/
public class EvenNumbers {
    private static boolean isPrime(int n){
        if(n <2){
            return  false;
        }
        for(int i =2;i <=n/2;i++){
            if(n%i== 0){
                return  false;
            }
        }
        return  true;
    }
    private static ArrayList<Integer> sumOfPrimes(int n){
        for(int i =0;i<n;i++){
            if(isPrime(i)){
                for(int j =0;j<n;j++){
                    if(isPrime(j) && i+j== n){
                        return new ArrayList<>(Arrays.asList(n,i,j));
                    }
                }
            }
        }
        return null;
    }
     public static void main(String[] args) {
         List<Integer> numberList = Arrays.asList(
                 12, 5, 8, 15, 3, 10, 21, 6, 7, 18
         );

        numberList.stream()
                 .filter(num->num %2 ==0 && num > 5)
                .map(num->num*num)
                .sorted((a,b)->Integer.compare(b,a))
                .forEach(System.out::println);
    }
}
