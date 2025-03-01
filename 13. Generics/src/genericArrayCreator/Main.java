package genericArrayCreator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Integer[] integers1 = ArrayCreator.create(10 ,13);
        Integer[] integers2 = ArrayCreator.create(Integer.class, 3, 15);

        Arrays.stream(integers1).forEach(System.out::println);
        System.out.println();
        Arrays.stream(integers2).forEach(System.out::println);
    }
}
