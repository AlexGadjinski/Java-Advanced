package jarOfT;

import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> jarOfElements;

    public Jar() {
        this.jarOfElements = new ArrayDeque<>();
    }

    public void add(T element) {
        jarOfElements.push(element);
    }

    public T remove() {
        return jarOfElements.pop();
    }
}
