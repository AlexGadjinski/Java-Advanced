package randomarraylist;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> numbers = new RandomArrayList<>();
        numbers.addAll(List.of(1, 13, 9));
        System.out.println(numbers.getRandomElement());
    }
}
