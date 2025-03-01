package stackofstrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        data.add(item);
    }

    public String pop() {
        return data.remove(getLastIndex());
    }

    public String peek() {
        return data.get(getLastIndex());
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int getLastIndex() {
        return data.size() - 1;
    }
}
