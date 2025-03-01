package collectionhierarchy;

public class MyListImpl extends Collection implements MyList {
    @Override
    public String remove() {
        return removeAtTheStart();
    }

    @Override
    public int add(String item) {
        return addAtTheStart(item);
    }

    @Override
    public int getUsed() {
        return size();
    }
}
