package collectionhierarchy;

public class AddCollection extends Collection implements Addable {
    @Override
    public int add(String item) {
        return addAtTheEnd(item);
    }
}
