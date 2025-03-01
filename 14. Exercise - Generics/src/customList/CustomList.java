package customList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CustomList<T extends Comparable<T>> {
    private List<T> elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    public T remove(int index) {
        return elements.remove(index);
    }

    public boolean contains(T element) {
        return elements.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(elements, firstIndex, secondIndex);
    }

    public int countGreaterThan(T element) {
        return elements.stream()
                .filter(e -> e.compareTo(element) > 0)
                .toList().size();
    }

    public T getMax() {
        return Collections.max(elements);
    }

    public T getMin() {
        return Collections.min(elements);
    }

    public void sort() {
        Collections.sort(elements);
    }

    @Override
    public String toString() {
        return elements.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
