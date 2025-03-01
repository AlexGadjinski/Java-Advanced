package genericBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Box<T extends Comparable<T>> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(elements, firstIndex, secondIndex);
//        T element = elements.get(firstIndex);
//        elements.set(firstIndex, elements.get(secondIndex));
//        elements.set(secondIndex, element);
    }

    public int countGreaterValues(T valueToCompare) {
        return elements.stream()
                .filter(e -> e.compareTo(valueToCompare) > 0)
                .toList().size();
    }

    @Override
    public String toString() {
        return elements.stream()
                .map(e -> String.format("%s: %s", e.getClass().getName(), e))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
