package collectionhierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection implements Addable {
    private int maxSize = 100;
    private List<String> items;

    public Collection() {
        this.items = new ArrayList<>();
    }

    protected int size() {
        return items.size();
    }

    protected int addAtTheStart(String item) {
        items.add(0, item);
        return 0;
    }

    protected int addAtTheEnd(String item) {
        items.add(item);
        return items.size() - 1;
    }

    protected String removeAtTheStart() {
        return items.remove(0);
    }

    protected String removeAtTheEnd() {
        return items.remove(items.size() - 1);
    }
}
