package tuple;

public class Threeuple<F, S, T> extends Tuple<F, S> {
    private T item3;

    public Threeuple(F item1, S item2, T item3) {
        super(item1, item2);
        this.item3 = item3;
    }

    public void setItem3(T item3) {
        this.item3 = item3;
    }

    public T getItem3() {
        return item3;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", getItem1(), getItem2(), item3);
    }
}
