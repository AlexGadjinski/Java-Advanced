package collectionhierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable {
    @Override
    public String remove() {
        return removeAtTheEnd();
    }

    @Override
    public int add(String item) {
        return addAtTheStart(item);
    }
}
